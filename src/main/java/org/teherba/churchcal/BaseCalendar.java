/*  Class for the properties of a specific calendar year.
    @(#) $Id: BaseCalendar.java 974 2013-01-23 11:38:57Z gfis $   
    2017-05-29: javadoc 1.8
    2016-10-13: less imports
    2012-02-03: getOption
    2012-01-12: HashMap styleMap, and more processing codes
    2012-01-03: table borders in stylesheet
    2011-09-12: addAttributes -> orAttributes
    2008-04-09: splitted into BaseCalendar and EasterCalendar

    Caution, this file needs UTF-8 encoding (äöüÄÖÜß)!
*/
/*
 * Copyright 2008 Dr. Georg Fischer <punctum at punctum dot kom>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.teherba.churchcal;
import  org.teherba.churchcal.Customizer;
import  org.teherba.churchcal.Day;
import  org.teherba.churchcal.DayMap;
import  org.teherba.numword.BaseSpeller;
import  org.teherba.numword.SpellerFactory;
import  java.io.Writer;
import  java.text.SimpleDateFormat;
import  java.util.Calendar;
import  java.util.Date;
import  java.util.GregorianCalendar;
import  java.util.HashMap;
import  java.util.Iterator;
import  java.util.regex.Matcher;
import  java.util.regex.Pattern;
import  org.apache.log4j.Logger;

/** Class storing the properties of a specific calendar year,
 *  The years of this calendar are derived from the earth's rotation
 *  around the sun, and therefore have 365 or 366 days.
 *  The class is not fitted for calendars oriented towards moon months,
 *  like the islamic or hebrew calendars.
 *  @author Dr. Georg Fischer
 */
public class BaseCalendar extends GregorianCalendar {
    public final static String CVSID = "@(#) $Id: BaseCalendar.java 974 2013-01-23 11:38:57Z gfis $";

    /** switch for test output */
    private static final boolean DEBUG = false;
    /** log4j logger (category) */
    protected Logger log;

    /** Calculate the calendar for this year */
    protected int baseYear;
    /** baseYear - 1 */
    protected int prevYear;
    /** Calculate the calendar for this year */
    protected int nextYear;
    /** Array of calendar days, [0] is not used, last index is [365] or [366] */
    public Day[] days;

    /** Map for Sundays and holy days */
    protected DayMap holyDayMap;
    /** current day (index in <em>days</em>, 1-366) for attribute switching */
    protected int currentDay;
    /** last day for which an attribute was set (used by <em>switchAttribute</em>) */
    protected int lastDay;
    /** last attribute which was set (used by <em>switchAttribute</em>) */
    protected int lastAttr;

    /** Anchor days for variable holy days and day names
     *  (index into <em>days</em>):
     *  <ul>
     *  <li>[0] - EPIPHAN1: 1st Sunday after Epiphanias (Jan. 6th)
     *  <li>[1] - EASTER:   Easter Sunday
     *  <li>[2] - ADVENT1:  1st Advent</li>
     *  <li>[...]</li>
     *  </ul>
     */
    protected int anchors[] = new int[16];

    /* codes for calendar variants: confessions */
    /** (Lutheran) Evangelic sunday names */
    public static final int EVANGELIC    = 1;
    /** similiar to <code>EVANGELIC</code>, but with nth Trinitatis up to 1st Advent */
    public static final int TRINITATIS   = 2;
    /** Roman Catholic, German sunday names (nth Sonntag im Jahreskreis) */
    public static final int CATHOLIC     = 3;

    /** number speller for month names and weekday abbreviations in different languages */
    protected BaseSpeller speller;

    /** newline string (CR/LF or LF only) */
    private static final String nl = System.getProperty("line.separator");
    /** CR/LF for ICalendat */
    private static final String crlf = "\r\n";

    //----------------------------------
    // Construction and Initialization
    //----------------------------------
    /** No-args Constructor for current year after Christ's birth
     */
    public BaseCalendar() {
        this(0);
    } // constructor (0)

    /** Constructor for a specified year after Christ's birth
     *  @param year sun year with 365/366 days; 0 = current year
     */
    public BaseCalendar(int year) {
        super(); // 'this' starts with a GregorianCalendar for current date/time
        log = Logger.getLogger(BaseCalendar.class.getName());
        options = new HashMap<String, String>(32);
        if (year != 0) {
            this.set(Calendar.YEAR,         year);
            this.set(Calendar.MONTH,        1);
            this.set(Calendar.DAY_OF_MONTH, 1);
            baseYear = year;
        } else {
            baseYear = this.get(Calendar.YEAR);
        }
        customization = null;
    } // constructor (1)

    /** Initializes the {@link #days} table and other properties with defaults.
     *  Styles may be overridden by the customization file.
     *  The CSS classnames must correspond to the values returned by {@link Day#getCellClass} and
     *  {@link Day#getCol1Class}.
     */
    public void initialize() {
        styles  = new String[4];
        int maxDay = this.getActualMaximum(Calendar.DAY_OF_YEAR) + 1;
        days   = new Day[maxDay + 1];
        int yday = 1;
        while (yday < maxDay) {
            this.set(Calendar.DAY_OF_YEAR, yday);
            days[yday] = new Day(this); // default properties
            yday ++;
        } // while yday
        // add a fictitious day for month 13 (needed by printHTML)
        days[yday] = new Day(this);
        days[yday].setMonth(13);
        days[yday].setAttributes(Day.UNDEF);

        computeAnchorDays();
        holyDayMap = new DayMap();
        currentDay = 1;
        lastDay    = 1;
        lastAttr   = Day.UNDEF;
        setSpecialDays();

        /* Style defaults; by convention, they are 3 letters, in order to keep the HTML output smaller.
         * All changes here must correnspond to the methods in class 'Day'.
         */
        styleMap = new HashMap<String, String>(32);
        Customizer customizer = new Customizer();
        customizer.initialize(this);
        customizer.readCustomization(this, customization);
    } // initialize

    //--------------------------------
    // Bean Setters and Getters
    //--------------------------------
    /** string of lines separated by newlines containing styles and custom event descriptions */
    protected String customization;

    /** Gets the customization.
     *  @return string of lines separated by newlines
     *  containing styles and custom event descriptions
     */
    public String getCustomization() {
        return customization;
    } // getCustomization

    /** Sets the customization.
     *  @param customization string of lines separated by newlines
     *  containing styles and custom event descriptions
     */
    public void setCustomization(String customization) {
        this.customization = customization;
    } // setCustomization
    /*------------------------------*/
    /** natural language to be used (ISO 639 code) */
    protected String language;

    /** Sets the language for the calendar
     *  @param language ISO 639 code for the language to be set
     */
    public void setLanguage(String language) {
        this.language = language;
        speller = (new SpellerFactory()).getSpeller(language);
    } // setLanguage

    /** Gets the language for the calendar
     *  @return ISO 639 code for the language
     */
    public String getLanguage() {
        return language;
    } // getLanguage
    //---------------
    /** Options (properties) set for this calendar.
     *  The following options are currently used:
     *  <table><caption>List of Optins</caption>
     *  <tr><td>explainHeader</td><td>Header text above the color explanation</td></tr>
     *  <tr><td>explainMonth</td><td>(numeric) where to place the color explanation below this month, default 02</td></tr>
     *  <tr><td>title</td><td>Title text for the calendar</td></tr>
     *  <tr><td>subset</td><td>subset of days to be output</td></tr>
     *  <tr><td></td><td></td></tr>
     *  </table>
     */
    private HashMap<String, String> options;

    /** Gets a string option, or its default.
     *  @param name name of the option (case sensitive)
     *  @param defaultValue value if the option was not set
     *  @return value of the option
     */
    public String getOption(String name, String defaultValue) {
        String result = options.get(name);
        if (result == null) {
            result = defaultValue;
        }
        return result;
    } // getOption

    /** Gets a numeric option, or its default.
     *  @param name name of the option (case sensitive)
     *  @param defaultValue value if the option was not set
     *  @return value of the option
     */
    public int getIntOption(String name, int defaultValue) {
        int result = defaultValue;
        String value = options.get(name);
        if (value != null && value.length() > 0) {
            try {
                result = Integer.parseInt(value.trim());
            } catch (Exception exc) {
                // ignore, set above
            }
        }
        return result;
    } // getIntOption

    /** Sets an option for this calendar.
     *  @param name name of the option (case sensitive)
     *  @param value value to be set for the option, or null
     */
    public void setOption(String name, String value) {
        options.put(name, value);
    } // setOption
    /*------------------------------*/
    /** currently active styles (up to 4), as set by {@link #extractStyles} */
    private String[] styles;

    /** Names of CSS classes to be used for this calendar */
    private HashMap<String, String> styleMap;

    /** Sets one definition of a CSS class.
     *  Any previous setting is overwritten.
     *  @param className name of the CSS class
     *  @param cssProperties for example "color:white; background-color:red";
     *  a leading space declares the property as system defined
     */
    protected void setStyle(String className, String cssProperties) {
        styleMap.put(className, cssProperties);
    } // setStyle

    /** Gets the definition of a CSS class
     *  @param className name of the CSS class
     *  @return string of CSS properties, for example "color:white; background-color:red"
     */
    public String getStyle(String className) {
        String result = styleMap.get(className);
        if (result == null) {
            result = "";
        }
        return result;
    } // getStyle

    /** Gets the definition of a CSS class
     *  @return an iterator over all style definitions
     */
    public Iterator<String> getStyleIterator() {
        return styleMap.keySet().iterator();
    } // getStyleIterator

    /** Finds any bracket "{st1,st2,,}" in the purpose of an appointment,
     *  stores it in the parameter <em>styles</em> array, removes it
     *  and returns the rest of the string as <em>purpose</em>.
     *  As a side effect, the array of currently active {@link #styles} is overwritten
     *  with the style names (up to 4) found in the bracket.
     *  Successive commas indicate an array element which is left unchanged.
     *  @param text text which optionally contains a bracket with style names
     *  separated by commas.
     *  @return purpose
     */
    private String extractStyles(String text) {
        String result = text;
        int open = text.indexOf("{");
        if (open >= 0) {
            int close = text.indexOf("}");
            if (close > open) {
                String[] names = text.substring(open + 1, close).split("\\,\\s*"); // the names of the styles in "{ ... }"
                int nnam = names.length;
                int inam = 0;
                if (nnam > 0) { // at least 1 name
                    String name = names[inam].trim();
                    while (inam < nnam) {
                        if (name.length() > 0) {
                            styles[inam] = name;
                        }
                        inam ++;
                    } // while inam
                } // nnam > 0
                result = result.substring(0, open) + result.substring(close + 1);
            } // close > open
        } // open >= 0;
        return result;
    } // extractStyles

    //---------------
    /** Sets the subset of days to be shown
     *  @param subset to be set
     */
    public void setSubset(String subset) {
        setOption("subset", subset);
    } // setSubset

    /** Gets the subset of days to be shown
     *  @return subset
     */
    public String getSubset() {
        return getOption("subset", "sunday");
    } // getSubset
    //---------------
    /** Gets the title for this calendar.
     *  @return title of the calendar
     */
    public String getTitle() {
        return getOption("title", "Calendar " + String.valueOf(this.get(Calendar.YEAR)));
    } // getTitle

    /** Sets the title for this calendar.
     *  @param title of the calendar
     */
    protected void setTitle(String title) {
        setOption("title", title);
    } // setTitle
    //---------------
    /** URI for the customization file */
    protected String uri;

    /** Gets the URI for the customization file.
     *  @return universal ressource identifier: URN or URL
     */
    public String getURI() {
        return uri;
    } // getURI

    /** Sets the URI for the customization file.
     *  @param uri universal ressource identifier: URN or URL
     */
    public void setURI(String uri) {
        this.uri = uri;
    } // setURI
    //---------------
    /** variant of the calendar, for example confession/church which influences the names of Sundays */
    protected int variant;

    /** Sets the variant which influences the names of special days
     *  @param variant to be set
     */
    public void setVariant(int variant) {
        this.variant = variant;
    } // setVariant

    /** Gets the variant which influences the names of special days
     *  @return variant which was set for this <em>BaseCalendar</em>.
     */
    public int getVariant() {
        return variant;
    } // getVariant

    /** Gets the base year of this calendar
     *  @return year of the first day
     */
    public int getYear() {
        return this.get(Calendar.YEAR);
    } // getYear

    //----------------------------------------
    // Combined setting of properties of days
    //----------------------------------------
    /** Gets the number of the day in the year
     *  @param month number of month (1-12)
     *  @param day   number of day in month (1-31)
     *  @return 1-366
     */
    public int getDayOfYear(int month, int day) {
        this.set(Calendar.MONTH         , month - 1);
        this.set(Calendar.DAY_OF_MONTH  , day);
        return this.get(Calendar.DAY_OF_YEAR);
    } // getDayOfYear

    /** Sets the properties of a single day
     *  @param dayOfYear index in <em>days</em> array, 1-366
     *  @param description name of the day
     *  @param attr attributes to be set for the day
     *  @return day of year
     */
    protected int setDay(int dayOfYear, String description, int attr) {
        currentDay = dayOfYear;
        setDay(dayOfYear, description);
        days[dayOfYear].orAttributes    (attr);
        return dayOfYear;
    } // setDay (isi)

    /** Sets the attribute(s) of a single day
     *  @param month ordinary month number (1-12)
     *  @param day day number in month (1-31)
     *  @param attr attributes to be set for the day
     *  @return day of year
     */
    protected int setDay(int month, int day, int attr) {
        this.set(Calendar.MONTH         , month - 1);
        this.set(Calendar.DAY_OF_MONTH  , day);
        int dayOfYear = this.get(Calendar.DAY_OF_YEAR);
        days[dayOfYear].orAttributes(attr);
        return dayOfYear;
    } // setDay (iii)

    /** Sets the properties of a single day if the proper variant is set for this year
     *  @param dayOfYear index in <em>days</em> array, 1-366
     *  @param description name of the day
     *  @param attr attributes to be set for the day
     *  @param variant which variant of the description should be used
     *  @return day of year
     */
    protected int setDay(int dayOfYear, String description, int attr, int variant) {
        if (variant == this.variant) {
            setDay(dayOfYear, description, attr);
        }
        return dayOfYear;
    } // setDay (isii)

    /** Sets the properties of a single day
     *  @param month ordinary month number (1-12)
     *  @param day day number in month (1-31)
     *  @param description name of the day
     *  @param attr attributes to be set for the day
     *  @return day of year
     */
    protected int setDay(int month, int day, String description, int attr) {
        this.set(Calendar.MONTH         , month - 1);
        this.set(Calendar.DAY_OF_MONTH  , day);
        int dayOfYear = this.get(Calendar.DAY_OF_YEAR);
        setDay(dayOfYear, description, attr);
        return dayOfYear;
    } // setDay (iisi)

    /** Sets the properties of a single day if the proper variant is set for this year
     *  @param month ordinary month number (1-12)
     *  @param day day number in month (1-31)
     *  @param description name of the day
     *  @param attr attributes to be set for the day
     *  @param variant which variant of the description should be used
     *  @return day of year
     */
    protected int setDay(int month, int day, String description, int attr, int variant) {
        int dayOfYear = this.get(Calendar.DAY_OF_YEAR);
        if (variant == this.variant) {
            setDay(month, day, description, attr);
        }
        return dayOfYear;
    } // setDay (iisii)

    /** Sets only the description of a single day
     *  @param dayOfYear index in <em>days</em> array, 1-366
     *  @param description name of the day
     *  @return day of year
     */
    protected int setDay(int dayOfYear, String description) {
        currentDay = dayOfYear;
        days[dayOfYear].setDescription(description);
        return dayOfYear;
    } // setDay (is)

    /** Adds one appointment to a day
     *  @param dayOfYear index in {@link #days} array, 1-366
     *  @param time in the form
     *  <ul>
     *  <li>"hh:mm" with leading zeroes, or</li>
     *  <li>" " for appointment applicable to the whole day, or</li>
     *  <li>" nn" for week number</li>
     *  </ul>
     *  @param purpose text describing the purpose of the appointment
     *  @return day of year
     */
    protected int setDay(int dayOfYear, String time, String purpose) {
        currentDay = dayOfYear;
        days[dayOfYear].addAppointment(time, purpose);
        return dayOfYear;
    } // setDay (iss)

    /** Sets the properties of a single day
     *  @param month ordinary month number (1-12)
     *  @param day day number in month (1-31)
     *  @param time in the form
     *  <ul>
     *  <li>"hh:mm" with leading zeroes, or</li>
     *  <li>" " for appointment applicable to the whole day, or</li>
     *  <li>" nn" for week number</li>
     *  </ul>
     *  @param purpose text describing the purpose of the appointment
     *  @return day of year
     */
    protected int setDay(int month, int day, String time, String purpose) {
        this.set(Calendar.MONTH         , month - 1);
        this.set(Calendar.DAY_OF_MONTH  , day);
        int dayOfYear = this.get(Calendar.DAY_OF_YEAR);
        setDay(dayOfYear, time, purpose);
        return dayOfYear;
    } // setDay (iiss)

    //---------------------
    // Auxilliary Methods
    //---------------------
    /** Determines the leap year property
     *  @return whether this year is a leap year
     *  (with February 29th and 366 days)
     */
    public boolean isLeapYear() {
        return (baseYear % 4 == 0 && baseYear % 100 != 0) || baseYear % 1000 == 0;
    } // isLEapYear

    /** Sets the names of special days in the year and their properties,
     *  sometimes depending on the current confession.
     *  This method is pseudo-abstract and will be overwritten by subclasses.
     */
    protected void setSpecialDays() {
    } // setSpecialDays

    /** Add some attribute(s) for the current day and the following day,
     *  after "sweeping" the attribute for the previous days
     *  @param thisAttr color for the current day
     *  @param nextAttr color for the next day
     */
    protected void switchAttributes(int thisAttr, int nextAttr) {
        lastDay ++;
        while (lastDay < currentDay) {
            days[lastDay].orAttributes(lastAttr);
            lastDay ++;
        }
        days[currentDay    ].orAttributes(thisAttr);
        days[currentDay + 1].orAttributes(nextAttr);
        lastDay = currentDay + 1;
        lastAttr = nextAttr;
    } // switchAttributes

    /** Gets the maximum value of a field in the calendar;
     *  for field YEAR, this is the maximum year for which this calender can be computed.
     *  @param field code for a {@link Calendar} field
     *  @return maximum year (inclusive)
     */
    public int getMaximum(int field) {
        int result;
        if (field == Calendar.YEAR) {
            result = 4099;
        } else {
            result = super.getMaximum(field);
        }
        return result;
    } // getMaximum

    /** Gets the minimum value of a field in the calendar;
     *  for field YEAR, this is the minimum year for which this calender can be computed.
     *  @param field code for a {@link Calendar} field
     *  @return minimum year (inclusive)
     */
    public int getMinimum(int field) {
        int result;
        if (field == Calendar.YEAR) {
            result = 1583;
        } else {
            result = super.getMinimum(field);
        }
        return result;
    } // getMinimum

    //--------------------------------
    // anchor days
    //--------------------------------
    /** Pseudo-abstract method to be overwritten by subclasses.
     */
    protected void computeAnchorDays() {
    } // computeAnchorDays

    /** Pattern for an anchor formula */
    private static Pattern ANC_PATTERN = Pattern.compile("anc(\\d+)([\\+\\-])(\\d+)");
    /** Pattern for a  fixed  formula */
    private static Pattern FIX_PATTERN = Pattern.compile("fix\\=(\\d+)\\-(\\d+)");
    /** Pattern for a  weekday-relative-to-month formula */
    private static Pattern WRM_PATTERN = Pattern.compile("wrm(\\d+)\\.(\\d+)");
    /** Pattern for a  variable formula */
    private static Pattern VAR_PATTERN = Pattern.compile("var");

    /** Calculates a named holy <em>Day</em> with day in month, month and week
     *  from the current calendar, under the following preconditions:
     *  <ol>
     *  <li>the calendar must have its <em>baseYear</em> set,</li>
     *  <li>the <em>anchor</em> days must have been computed previously.</li>
     *  </ol>
     *  @param name name of the holy day
     *  @return Day object
     */
    public Day computeHolyDay(String name) {
        Day result = null;
        try {
            Object obj = holyDayMap.get(name);
            if (obj != null) {
                String formula = ((Day) obj).getFormula();
                Matcher matcher = null; //  = Pattern.compile("").matcher("aaaaab");
                if (false) {
                } else if (formula.startsWith("anc")) { // "anc" + index + "[+\\-]" + offset
                    matcher = ANC_PATTERN.matcher(formula);
                    if (matcher.matches()) {
                        int ianc = Integer.parseInt(matcher.group(1));
                        int sign = matcher.group(2).equals("-") ? -1 : 1;
                        int dist = Integer.parseInt(matcher.group(3));
                        int dayOfYear = anchors[ianc] + sign * dist;
                        if (dayOfYear >= 1 && dayOfYear <= this.getActualMaximum(Calendar.DAY_OF_YEAR)) {
                            this.set(Calendar.DAY_OF_YEAR, dayOfYear);
                            result = new Day(this); // default properties
                        }
                        if (DEBUG) {
                            log.debug(this.get(Calendar.YEAR) + "," + name + "\t: "
                                    + "anchors[" + ianc + "]=" + anchors[ianc]
                                    + (sign >= 0 ? "+" : "-") + " " + dist);
                        }
                    }
                } else if (formula.startsWith("fix")) { // "fix=" + mm + "-" + dd
                    matcher = FIX_PATTERN.matcher(formula);
                    if (matcher.matches()) {
                        int mmon = Integer.parseInt(matcher.group(1));
                        int mday = Integer.parseInt(matcher.group(2));
                        this.set(Calendar.MONTH       , mmon - 1);
                        this.set(Calendar.DAY_OF_MONTH, mday);
                        result = new Day(this); // default properties
                        if (DEBUG) {
                            log.debug(this.get(Calendar.YEAR) + "," + name + "\t: "
                                    + "fix " + mmon + "-" + mday);
                        }
                    }
                } else if (formula.startsWith("wrm")) { // "wrm" + wd + "." + mm
                } else if (formula.startsWith("var")) { // "var"
                } else {
                    log.error("unknown formula \"" + formula + "\"");
                }
                if (result != null) {
                    result.setFormula(formula);
                    result.setName   (name   );
                }
            } // mpa != null
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
        return result;
    } // computeHolyDay

    //--------------------------------------------------
    // formatted output methods: HTML, iCalendar ...
    //--------------------------------------------------
    /** maximum length of all months */
    protected static final int MONTH_LEN = 32; // [0] is not used

    /** Prints an HTML representation of a calendar year
     *  with n months per page
     *  @param out where to write the resulting HTML string
     *  @param monthsPerPage number of columns on 1 page
     */
    public void printHTML(Writer out, int monthsPerPage) {
        String width = Integer.toString(270/monthsPerPage) + "mm";
        width = "340";
        int tabYear = this.get(Calendar.YEAR);
        try {
            out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            out.write("\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\""
                    + "\n\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\" [");
            out.write("\n]>");
            out.write("\n<html xmlns=\"http://www.w3.org/1999/xhtml\">");
            out.write("\n<head>");
            out.write("\n<meta http-equiv=\"Content-Type\" content=\"text/html\" />");
            out.write("\n<meta name=\"robots\" content=\"noindex, nofollow\" />");
            out.write("\n<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\">");
            out.write("\n<style>");
            Iterator<String> kiter = getStyleIterator();
            while (kiter.hasNext()) {
                String className = kiter.next();
                out.write("\n." + className + " { " + getStyle(className) + " }");
            } // while kiter
            out.write("\n</style>");
            out.write("\n<title>" + tabYear + "</title>");
            out.write("\n</head>\n<body>\n");
            styles[0] = "";
            String title = extractStyles(getTitle());
            String yearHeading = "<h2 class=\"" + styles[0] + "\">" + title + "</h2>\n";
            int page = 0;
            int month = getIntOption("month1", 1); // default: start at January
            int yday   = this.getDayOfYear(month, 1);
            int maxDay = this.getActualMaximum(Calendar.DAY_OF_YEAR) + 1;
            int row = 1; // index for day number in month, [1-31], [0] is not used
            int column = 0; // [0-5] for months 1-6 in a 2-page calendar
            Day [][] table = new Day[MONTH_LEN][monthsPerPage]; // indexed by [row][column]
            int monDays[]   = new int[12];
            while (yday < maxDay) {
                if (row   != days[yday].getDay()) {
                    System.err.println("Month: " + month + ", Day: " + row   + " <> " + days[yday].getDay());
                }
                table[row][column] = days[yday];
                row  ++;
                yday ++;

                if (days[yday].getMonth() != month) { // new month reached, maybe 13 in [366/367]
                    // finish the old month - fill it with undefined days
                    monDays[column] = row; // number of days in this column
                    column ++;
                    if (column >= monthsPerPage) { // output the page
                        if (page > 0) {
                            out.write("<p style=\"page-break-before:always\">\n");
                        }
                        out.write(yearHeading);
                        out.write("<table><!--year-->\n");
                        out.write("<tr>");
                        int icol = 0;
                        while (icol < monthsPerPage) { // print headers for months names
                            out.write("<td class=\"bord\"><table><!--month--><tr>\n");
                            printMonthHTML(out, month + 1 - monthsPerPage + icol, width);
                            out.write("</tr>\n");
                            row = 1;
                            while (row < monDays[icol]) {
                                out.write("<tr>");
                                printDayHTML(out, table[row][icol]);
                                out.write("</tr>\n");
                                row ++;
                            } // while rows
                            out.write("</table><!--month--></td>\n");
                            icol ++;
                        } // while columns
                        out.write("</tr>\n");
                        out.write("</table><!--year-->\n");
                        page ++;
                        column = 0;
                    } // output page
                    month = days[yday].getMonth();
                    row = 1;
                } // new month
            } // while yday
            out.write("</<body>\n</html>\n");
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
    } // printHTML

    /** Prints an HTML representation of a single day
     *  (one &lt;td&gt; element)
     *  @param out writer where to write the element
     *  @param currentDay stores all properties of a single day
     */
    protected void printDayHTML(Writer out, Day currentDay) {
        try {
            String workingClass  = currentDay.getCellClass();
            String[] apps = currentDay.getAppointments();
            int napps = apps.length; // number of appointments * 2
            if (napps == 0) {
                apps = new String[] { " ", "&#xa0;" }; // hard space
                napps = apps.length;
            }
            out.write("<td class=\"bord\"><table width=\"100%\"><!--day-->");
            int weekday = currentDay.getWeekDay(); // 1 = Sunday
            weekday = (weekday == 1) ? 7 : weekday - 1;
            String wdStr  = speller.spellWeekDay(weekday, 2);
            String dayStr = Integer.toString(100 + currentDay.getDay()).substring(1);
            int iapps = 0;
            while (iapps < napps) {
                styles[0] = currentDay.getCol1Class(workingClass);
                styles[1] = workingClass;
                styles[2] = workingClass;
                styles[3] = workingClass;
                String time    = apps[iapps + 0];
                String purpose = extractStyles(apps[iapps + 1]); // side effect: sets 'styles' from "{...}" brackets
                out.write("\n");
                out.write    ("<tr><td   width=\"12%\" class=\"nbord4 " + styles[0] + "\">");
                out.write(dayStr);
                out.write    ("</td><td  width=\"13%\" class=\"nbord4 " + styles[1] + "\">");
                out.write(wdStr);
                if (time.startsWith(" ")) {
                    out.write("</td><td  width=\"75%\" class=\"nbord4 " + styles[2] + "\" colspan=\"2\">");
                    out.write(purpose);
                } else {
                    out.write("</td><td  width=\"60%\" class=\"nbord4 " + styles[2] + "\">");
                    out.write(purpose);
                    out.write("</td><td  width=\"15%\" class=\"nbord4 " + styles[3] + "\" align=\"right\">");
                    out.write(time);
                }
                out.write("</td></tr>");
                dayStr = ""; // for continued appointments
                wdStr  = "";
                iapps += 2;
            } // while iapps
            out.write("</table><!--day--></td>\n");
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
    } // printDayHTML

    /** Prints an HTML representation for a month column header
     *  (1 &lt;th&gt; element)
     *  @param out writer where to write the element
     *  @param month normal month number [1-12]
     *  @param width width percentage or pixels for all TH elements
     */
    protected void printMonthHTML(Writer out, int month, String width) {
        try {
            out.write("<th width=\"" + width + "\">");
            out.write(speller.spellMonth(month));
            out.write("</th>");
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
    } // printMonthHTML

    /** Iterates over all days in the year and
     *  prints a calendar in iCalendar format (RFC 2455) for the holy days.
     *  iCalendar is an ASCII-based format for the description of entries in
     *  a calendar or schedule, and is described in
     *  <a href="http://www.ietf.org/rfc/rfc2445.txt">RFC 2445</a> and later in
     *  <a href="http://tools.ietf.org/html/rfc5545">RFC5545</a>.
     *  Each line starts with a key, a colon, and the value.
     *  Examples:
     *  <pre>
BEGIN:VCALENDAR
VERSION:2.0
PRODID:-//hacksw/handcal//NONSGML v1.0//EN
BEGIN:VEVENT
DTSTART:19970714T170000Z
DTEND:19970715T035959Z
SUMMARY:Bastille Day Party
END:VEVENT
END:VCALENDAR

BEGIN:VCALENDAR
PRODID:-//RDU Software//NONSGML HandCal//EN
VERSION:2.0
BEGIN:VTIMEZONE
TZID:US-Eastern
BEGIN:STANDARD
DTSTART:19981025T020000
RDATE:19981025T020000
TZOFFSETFROM:-0400
TZOFFSETTO:-0500
TZNAME:EST
END:STANDARD
BEGIN:DAYLIGHT
DTSTART:19990404T020000
RDATE:19990404T020000
TZOFFSETFROM:-0500
TZOFFSETTO:-0400
TZNAME:EDT
END:DAYLIGHT
END:VTIMEZONE
BEGIN:VEVENT
DTSTAMP:19980309T231000Z
UID:guid-1.host1.com
ORGANIZER;ROLE=CHAIR:MAILTO:mrbig@host.com
ATTENDEE;RSVP=TRUE;ROLE=REQ-PARTICIPANT;CUTYPE=GROUP:
 MAILTO:employee-A@host.com
DESCRIPTION:Project XYZ Review Meeting
CATEGORIES:MEETING
CLASS:PUBLIC
CREATED:19980309T130000Z
SUMMARY:XYZ Project Review
DTSTART;TZID=US-Eastern:19980312T083000
DTEND;TZID=US-Eastern:19980312T093000
LOCATION:1CP Conference Room 4350
END:VEVENT
END:VCALENDAR
     *  </pre>
     *  @param out writer where to print the table
     */
    public void printICalendar(Writer out) {
        int tabYear = this.get(Calendar.YEAR);
        int maxDay = this.getActualMaximum(Calendar.DAY_OF_YEAR) + 1;
        String sep = "\t";
        try {
            out.write("BEGIN:VCALENDAR" + crlf);
            int yday = 1;
            while (yday < maxDay) {
                Day currentDay = days[yday];
                String description = currentDay.getDescription();
                if (description != null && description.length() > 0) {
                    out.write("BEGIN:VEVENT"                            + crlf);
                    out.write("DTSTART:" + currentDay    .getIcalDate() + crlf);
                    out.write("DTEND:"   + days[yday + 1].getIcalDate() + crlf);
                    out.write("SUMMARY:" + currentDay.getDescription()  + crlf);
                    out.write("END:VEVENT"                              + crlf);
                } // HOLYDAY
                if (currentDay.size() > 0) { // there are appointments
                    String[] apps = currentDay.getAppointments();
                    int iapp = 0;
                    while (iapp < apps.length) {
                        String time = apps[iapp + 0].replaceAll("\\D", ""); // remove non-digits
                        out.write("BEGIN:VEVENT"                            + crlf);
                        if (time.startsWith(" " )) { // untimed
                            out.write("DTSTART:" + currentDay    .getIcalDate() + crlf);
                            out.write("DTEND:"   + days[yday + 1].getIcalDate() + crlf);
                        } else { // timed
                            out.write("DTSTART:" + currentDay    .getIcalDate() + "T" + time + "00" + crlf);
                            out.write("DTEND:"   + currentDay    .getIcalDate() + "T" + time + "00" + crlf);
                        } // date+time
                        out.write("SUMMARY:" + apps[iapp + 1]               + crlf);
                        out.write("END:VEVENT"                              + crlf);
                        iapp += 2;
                    } // while iapp
                } // with appointments
                yday ++;
            } // while yday
            out.write("END:VCALENDAR" + crlf);
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
    } // printICalendar

    /** Iterates over all days in the year and
     *  prints the month, day_of_month, day_of_week and week number.
     *  This is a pure Java test and does not use the specific calendar
     *  features of this class.
     *  @param out writer where to print the table
     */
    public void printJava(Writer out) {
        int weekDay; // Java defines SUNDAY = 1, SATURDAY = 7
        int tabYear = this.get(Calendar.YEAR);
        int maxDay = this.getActualMaximum(Calendar.DAY_OF_YEAR) + 1;
        String sep = "\t";
        try {
            int iday = 1;
            while (iday < maxDay) {
                this.set(Calendar.DAY_OF_YEAR, iday);
                out.write(tabYear
                        + sep +  iday
                        + sep + (this.get(Calendar.MONTH) + 1)
                        + sep +  this.get(Calendar.DAY_OF_MONTH)
                        + sep +  this.get(Calendar.DAY_OF_WEEK)
                        + sep +  this.get(Calendar.WEEK_OF_YEAR)
                        + nl
                        );
                iday ++;
            } // while iday
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
    } // printJava

    /** Iterates over all days in the year and prints
     *  the SQL CREATE statement and
     *  365 or 366 SQL INSERT statements
     *  for a table with name "calwork_table"
     *  @param out writer where to print the table
     */
    public void printSQL(Writer out) {
        printCreateSQL(out, "calwork_temp");
        printInsertSQL(out, "calwork_temp");
    } // printSQL

    /** Prints the SQL CREATE statement for a table
     *  with the following columns:
     *  <ul>
     *  <li>year</li>
     *  <li>day_of_year (1-366)</li>
     *  <li>month (1-12)</li>
     *  <li>day_of_month (1-31)</li>
     *  <li>day_of_week (1 = Sunday, 7 = Saturday)</li>
     *  <li>week_of_year (1-53)</li>
     *  <li>attributes (bit map)</li>
     *  <li>description (string)</li>
     *  </ul>
     *  @param out writer where to print the table
     *  @param tableName name of the SQL table
     */
    public void printCreateSQL(Writer out, String tableName) {
        java.util.Date now = new java.util.Date();
        SimpleDateFormat isoTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sep = "\t, ";
        try {
            out.write("-- generated by org.teherba.churchcal.BaseCalendar, do not edit here!" + nl);
            out.write("-- " + isoTime.format(now)   + nl);
            out.write("-- @(#) $Id: BaseCalendar.java 974 2013-01-23 11:38:57Z gfis $"                + nl); // CVS id
            out.write("CREATE TABLE " + tableName   + nl);
            out.write(  "\t( year  \tINT"           + nl);
            out.write(sep + "day_of_year\tINT"      + nl);
            out.write(sep + "month \tINT"           + nl);
            out.write(sep + "day_of_month\tINT"     + nl);
            out.write(sep + "day_of_week\tINT"      + nl);
            out.write(sep + "week_of_year\tINT"     + nl);
            out.write(sep + "attributes\tINT"       + nl);
            out.write(sep + "description\tVARCHAR(64)" + nl);
            out.write(sep + "PRIMARY KEY (year, day_of_year)" + nl);
            out.write(   "\t);"                     + nl);
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
    } // printCreateSQL

    /** Iterates over all days in the year and prints
     *  365 or 366 SQL INSERT statements for the following columns:
     *  <ul>
     *  <li>year</li>
     *  <li>day number in year(1-366)</li>
     *  <li>month (1-12)</li>
     *  <li>day number in month(1-31)</li>
     *  <li>day number in week(1 = Sunday, 7 = Saturday)</li>
     *  <li>week number</li>
     *  <li>work day code</li>
     *  <li>color(RGB in 6 hex digits)</li>
     *  <li>description of the (holi-)day</li>
     *  </ul>
     *  @param out writer where to print the table
     *  @param tableName name of the SQL table
     */
    public void printInsertSQL(Writer out, String tableName) {
        int maxDay = this.getActualMaximum(Calendar.DAY_OF_YEAR) + 1;
        int tabYear = this.get(Calendar.YEAR);
        String sep = ", ";
        try {
            out.write("-- " + getTitle() + tabYear + nl);
            int yday = 1;
            while (yday < maxDay) {
                Day currentDay = days[yday];
                out.write ("INSERT INTO " + tableName + " VALUES (" + tabYear
                        + sep   + yday
                        + sep   + currentDay.getMonth()
                        + sep   + currentDay.getDay()
                        + sep   + currentDay.getWeekDay()
                        + sep   + currentDay.getWeek()
                        + sep   + currentDay.getAttributes()
                        + sep   + "\'"  + currentDay.getDescription()   + "\'"
                        + ");"  + nl
                        );
                yday ++;
            } // for yday
            out.write("COMMIT;" + nl);
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
    } // printInsertSQL

    /** Iterates over all days in the year and prints
     *  a string table; columns are separated by tabs.
     *  @param out writer where to print the table
     */
    public void printTSV(Writer out) {
        printTable(out, "\t");
    } // printTSV

    /** Iterates over all days in the year and prints
     *  a string table with 365 or 366 lines and the following columns:
     *  <ul>
     *  <li>year</li>
     *  <li>day number in year(1-366)</li>
     *  <li>month (1-12)</li>
     *  <li>day number in month(1-31)</li>
     *  <li>day number in week(1 = Sunday, 7 = Saturday)</li>
     *  <li>week number</li>
     *  <li>attributes (bit map), e.g. work days, parament colors
     *  <li>description of the (holi-)day</li>
     *  </ul>
     *  @param out writer where to print the table
     *  @param sep column separator (string)
     */
    public void printTable(Writer out, String sep) {
        int maxDay = this.getActualMaximum(Calendar.DAY_OF_YEAR) + 1;
        int tabYear = this.get(Calendar.YEAR);
        try {
            int yday = 1;
            while (yday < maxDay) {
                Day currentDay = days[yday];
                out.write (tabYear
                        + sep   + yday
                        + sep   + currentDay.getMonth()
                        + sep   + currentDay.getDay()
                        + sep   + currentDay.getWeekDay()
                        + sep   + currentDay.getWeek()
                        + sep   + currentDay.getAttributes()
                        + sep   + "\'"  + currentDay.getDescription()   + "\'"
                        + nl
                        );
                yday ++;
            } // for yday
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
    } // printTable

    /** Iterates over all days in the year and prints
     *  365 or 366 XML rows for the following columns:
     *  <ul>
     *  <li>year</li>
     *  <li>month (1-12)</li>
     *  <li>day number in month(1-31)</li>
     *  <li>day number in year(1-366)</li>
     *  <li>day number in week(1 = Sunday, 7 = Saturday)</li>
     *  <li>week number</li>
     *  <li>work day code</li>
     *  <li>color(RGB in 6 hex digits)</li>
     *  <li>description of the (holi-)day</li>
     *  </ul>
     *  @param out writer where to print the table
     */
    public void printXML(Writer out) {
        int maxDay = this.getActualMaximum(Calendar.DAY_OF_YEAR) + 1;
        int tabYear = this.get(Calendar.YEAR);
        String sep = ", ";
        try {
            out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + nl);
            out.write("<!-- " + getTitle() + " " + tabYear + " -->" + nl);
            out.write("<table>" + nl);
            int yday = 1;
            while (yday < maxDay) {
                Day currentDay = days[yday];
                out.write ("<tr>"
                        + "<year>" + tabYear                         + "</year>"
                        + "<mon>"  + currentDay.getMonth()       + "</mon>"
                        + "<day>"  + currentDay.getDay()         + "</day>"
                        + "<yday>" + yday                        + "</yday>"
                        + "<wday>" + currentDay.getWeekDay()     + "</wday>"
                        + "<week>" + currentDay.getWeek()        + "</week>"
                        + "<attr>" + currentDay.getAttributes()  + "</attr>"
                        + "<name>" + currentDay.getDescription() + "</name>"
                        + "</tr>"  + nl
                        );
                yday ++;
            } // for yday
            out.write("</table>" + nl);
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
    } // printXML

    /** Prints a year in the specified format
     *  @param out writer where to print the table
     *  @param format one of "html", "ical", "java", "sql", "table", "tsv", "xml"
     */
    public void printFormatted(Writer out, String format) {
        try {
            if (false) {
            } else if (format.startsWith    ("htm"  )) {
                printHTML(out, 6); // 6 months per landscape page
            } else if (format.startsWith    ("ic"   )) {
                printICalendar(out);
            } else if (format.startsWith    ("jav" )) {
                printJava(out);
            } else if (format.equals        ("sql"  )) {
                printSQL(out);
            } else if (format.startsWith    ("tab"  )) {
                printTSV(out);
            } else if (format.equals        ("tsv"  )) {
                printTSV(out);
            } else if (format.equals        ("xml"  )) {
                printXML(out);
            } else {
                out.write("invalid format \"" + format + "\"" + nl);
            }
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
    } // printFormatted

} // BaseCalendar
