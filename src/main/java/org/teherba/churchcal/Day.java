/*  Properties of a single day in a calendar year
    @(#) $Id: Day.java 974 2013-01-23 11:38:57Z gfis $
    2012-01-04: TreeMap appointments
    2011-09-12: addAttributes -> orAttributes
    2008-03-31: abbreviation    
    2007-03-09: properties 'name' and 'formula' with getters/setters
    2007-02-12: renamed from calwork
    2007-02-09: no tabs; *Ilse Ritter
    2005-12-07: attributes totally revised, color removed
    2005-11-28: copied from numword
*/
/*
 * Copyright 2006 Dr. Georg Fischer <punctum at punctum dot kom>
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
import  java.util.Calendar;
import  java.util.GregorianCalendar;
import  java.util.Iterator;
import  java.util.TreeMap;

/** Stores all properties of a single day in a calendar year.
 *  Citation from http://de.wikipedia.org/wiki/Woche#Z.C3.A4hlweise_nach_DIN_1355.2FISO_8601 
 *  <pre>
Zählweise nach DIN 1355/ISO 8601 [Bearbeiten]

Die deutschsprachige Kalender-Industrie hält sich ausnahmslos an die internationale Norm ISO 8601 (1973), 
die als letzten Tag der Woche den Sonntag bestimmt, statt des Samstags/Sonnabends/Sabbats, 
wie es in der jüdisch-christlich-islamischen Tradition üblich ist.

Im Geltungsbereich der Normen des DIN Deutschen Instituts für Normung e. V. 
werden seit 1976 durch Normung folgende Regeln empfohlen:

    Jeden Montag und nur montags beginnt eine neue Kalenderwoche.
    Die erste Kalenderwoche ist diejenige, die mindestens vier Tage des neuen Jahres enthält.

Aus diesen Punkten ergeben sich folgende Eigenschaften:
    Es gibt keine unvollständigen Kalenderwochen, ausnahmslos jede KW enthält genau sieben Tage.
    Jedes Jahr hat entweder 52 oder 53 Kalenderwochen.
    Ein Jahr hat genau dann 53 Kalenderwochen, wenn es mit einem Donnerstag beginnt oder endet:
        Ein Normaljahr mit 53 Wochen beginnt und endet an einem Donnerstag.
        Ein Schaltjahr mit 53 Wochen beginnt entweder an einem Mittwoch und endet somit 
        mit Donnerstag oder beginnt an einem Donnerstag und endet an einem Freitag.
    Der 4. Januar liegt immer in Kalenderwoche 1.
    Der 29., 30. und 31. Dezember können schon zur ersten Kalenderwoche des Folgejahres gehören.
    Der 1., 2. und 3. Januar können noch in der letzten Kalenderwoche des Vorjahres liegen.
    Der Donnerstag ist ausschlaggebend, zu welchem Jahr die Woche gezählt wird. 
    Liegt er im neuen Jahr, ist es die Kalenderwoche 1.
 *  </pre>
 *  @author Dr. Georg Fischer
 */
public class Day {
    public final static String CVSID = "@(#) $Id: Day.java 974 2013-01-23 11:38:57Z gfis $";

    /** No-args Constructor - properties of the current day
     */
    public Day() {
        this(new GregorianCalendar());
    } // Constructor(0)

    /** Constructor which sets default calendar properties
     *  @param calendar calendar with year, month, day set
     */
    public Day(Calendar calendar) {
        year        = calendar.get(Calendar.YEAR        );
        month       = calendar.get(Calendar.MONTH       ) + 1;
        day         = calendar.get(Calendar.DAY_OF_MONTH);
        weekDay     = calendar.get(Calendar.DAY_OF_WEEK );
        weekNumber  = calendar.get(Calendar.WEEK_OF_YEAR);
    /*
        description = (weekDay == Calendar.MONDAY && calendar instanceof DeuChurchCalendar 
                    || weekDay == Calendar.SUNDAY)
                ? "KW " + Integer.toString(weekNumber)
                : "";
    */
        description = "";
        appointments = new TreeMap<String, String>();
        orderCode = 'A'; // belongs to 'appointments'
        switch (weekDay) {
            case Calendar.SUNDAY:
                attributes = Day.SUNDAY;
                break;
            case Calendar.SATURDAY:
                attributes = Day.SATURDAY;
                break;
            default:
                attributes = Day.WORKING;
                break;
        } // switch weekDay
    } // Constructor(1)

    /** Constructor which sets calendar properties
     *  @param month month in year: 1-12
     *  @param day day in month: 1-31
     */
    public Day(int year, int month, int day) {
        this(new GregorianCalendar(year, month - 1, day));
    } // Constructor(3)

    /** Constructor which sets name and formula only.
     *  @param name code for the name like "trin4", "east0"
     *  @param formula code for the calculation of the day like "anc1+49", "fix=06-29"
     */
    public Day(String name, String formula) {
        this.name           = name;
        this.formula        = formula;
    } // Constructor(2)

    /** Constructor which sets name, formula, abbreviation and description.
     *  @param name code for the name like "trin4", "east0"
     *  @param formula code for the calculation of the day like "anc1+49", "fix=06-29"
     *  @param abbr abbreviation of the description of the day
     *  @param descr (full) description of the day
     */
    public Day(String name, String formula, String abbr, String descr) {
        this.name           = name;
        this.formula        = formula;
        this.abbreviation   = abbr;
        this.description    = descr;
    } // Constructor(4)
    /*------------------------------*/
    /** display text of the (holy-, sun-) day, in abbreviated form */
    private String abbreviation;

    /** Sets the abbreviation of the day
     *  @param abbreviation name of the day to be set
     */
    protected void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    } // setAbbreviation
    
    /** Gets the abbreviation of the day
     *  @return abbreviation name of the day to be set
     */
    public String getAbbreviation() {
        return abbreviation;
    } // getAbbreviation
    /*------------------------------*/
    /** zero or more appointment times and descriptive texts, in lexicographical = chronological order; 
     *  <ul>
     *  <li>time = "hh:mm" => time with leading zeroes; 
     *          multiple times must be distinguished by minutes "01", "02" or "06", "07"</li>
     *  <li>time = " X"    => untimed appointment;
     *      multiple events must be distinguished by uppercase letters 'A', 'B' (see {@link #orderCode})</li>
     *  </ul>
     */
    private TreeMap<String, String> appointments;
    /** Letter which determines the ordering of untimed appointments */
    private char orderCode;

    /** Adds one appointment to the day
     *  @param time in the form
     *  <ul>
     *  <li>time = "hh:mm" => time with leading zeroes; 
     *          multiple times must be distinguished by minutes "01", "02" or "06", "07"</li>
     *  <li>time = " X"    => untimed appointment;
     *      multiple events must be distinguished by uppercase letters 'A', 'B' (see {@link #orderCode})</li>
     *  </ul>
     *  @param purpose text describing the purpose of the appointment
     */
    protected void addAppointment(String time, String purpose) {
        if (false) {
        } else if (time.matches(" [A-Z]")) { // untimed, but specified, higher order
            char newCode = time.charAt(1);
            if (newCode > orderCode) {
                orderCode = newCode;
            }
        } else if (time.matches(" ?")) { // untimed: append behind last
            orderCode ++;
            time = " " + String.valueOf(orderCode);
        }
        this.appointments.put(time, purpose);
    } // addAppointment

    /** Sets one appointment to the day; any existing setting is overwritten
     *  @param time in the form
     *  <ul>
     *  <li>time = "hh:mm" => time with leading zeroes; 
     *      multiple times must be distinguished by minutes "00", "01", "02" or "05", "06", "07"</li>
     *  <li>time = " X"    => untimed appointment;
     *      multiple events must be distinguished by uppercase letters 'A', 'B' (see {@link #orderCode})</li>
     *  </ul>
     *  @param purpose text describing the purpose of the appointment
     */
    protected void setAppointment(String time, String purpose) {
        this.appointments.put(time, purpose);
    } // setAppointment

    /** Gets all appointments of the day, ordered by time, as tuples
     *  (time, purpose) in a linear string array. 
     *  The times are rounded down to 5 minute precision.
     *  Any untimed appointments appear before the timed ones,
     *  and for the untimed ones the key returned is the empty string.
     *  @return array (t1, p1, t2, p2 ...)
     */
    public String[] getAppointments() {
        String[] result = null;
        int alen = appointments.size();
        if (alen == 0) {
            result = new String[] { " ", "&#xa0;" };
        } else {
            result = new String[alen * 2];
            Iterator<String> iter = appointments.keySet().iterator();
            int ires = 0; // index in result[]
            while (iter.hasNext()) {
                String key  = iter.next(); 
                String time = key;
                if (time.startsWith(" ")) {
                    time = " ";
                } else if (time.length() == 5) { // "hh:mm"
                    char last = time.charAt(4);
                    if (false) {
                    } else if (last >= '5') {
                        time = time.substring(0,4) + String.valueOf('5');
                    } else if (last > '0') {
                        time = time.substring(0,4) + String.valueOf('0');
                    }
                }
                result[ires ++] = time;
                result[ires ++] = appointments.get(key);
            } // while iter
        } // more than 0 appointments
        return result;
    } // getAppointments

    /** Returns the number of appointments, or 0 if there are none
     *  @return number of entries in tree map
     */
    public int size() {
        return appointments.size();
    } // size
    /*------------------------------*/
    /** Attribute(s) of the day, whether it is:
     *  <ul>
     *  <li>a normal working day,</li>
     *  <li>a Saturday</li>
     *  <li>a day with half working time, for example Christmas eve or Silvester,</li>
     *  <li>a non-christian (common, political) holiday,</li>
     *  <li>a Sunday</li>
     *  <li>a Christian feast ("holy day"), like Ascension</li>
     *  <li>a school vacancy</li>
     *  <li>a business leave / furlough / vacancy</li>
     *  </ul>
     *  and additional attributes like altair parament colors 
     *  (see http://de.wikipedia.org/wiki/Datei:Kirchenjahrev.png).
     *  The individual attributes must be a power of 2, they
     *  are ORed to a bit pattern.                    
     *  From these attributes the ultimate color(s) of the entry 
     *  for the day are determined by {@link #getCellClass} and
     *  by {@link #getCol1Class}
     */
    private int attributes;
    // enumerated bits for working class of this day
    public static final int UNDEF    =   0; // day does not exist (e.g. Feb 31st)
    public static final int WORKING  =   1; // Monday thru Friday, not at Saturdays
    public static final int HALFWORK =   2; // e.g. Dec. 24th, Dec. 31st
    public static final int SATURDAY =   4; // 
    public static final int SUNDAY   =   8; // 
    public static final int HOLIDAY  =  16; // political
    public static final int HOLYDAY  =  32; // christian
    public static final int VACANCY  =  64; // no school
    public static final int LEAVE    = 128; // (personal) business holiday
    // Caution, the bit shifting must be continued below        
    // bits for altair parament colors
    public static final int RED      = LEAVE   * 2; // c.f. above
    public static final int GREEN    = RED     * 2;
    public static final int WHITE    = GREEN   * 2;
    public static final int BLACK    = WHITE   * 2;
    public static final int VIOLET   = BLACK   * 2;

    /** Sets the attribute(s) of this day
     *  @param attr attribute(s) as a bit pattern
     */
    protected void setAttributes(int attr) {
        attributes = attr;
    } // setAttributes

    /** ORs some attribute(s) to the existing attributes of this day
     *  @param attr attribute(s) to be ORed as a bit pattern
     */
    protected void orAttributes(int attr) {
        attributes |= attr;
    } // addAttributes

    /** Gets the attribute(s) of this day
     *  @return attribute(s) as a bit pattern
     */
    public int getAttributes() {
        return attributes;
    } // getAttributes

    /** Tests whether a set of attributes is all set for this day
     *  @param mask attribute(s) to be tested as a bit pattern
     *  @return true if all attributes (bits) are set
     */
    protected boolean hasAttributes(int mask) {
        return (attributes & mask) == mask;  // 101000  & 001000 == 001000
    } // hasAttributes

    /** Returns the stylesheet class for the working type / background color of this day.
     *  These attributes have a hierarchy which is implemented here since there are no "else" constructions.
     *  @return one of "wrk", "sun" etc.
     */
    public String getCellClass() {
        String result = "und";
        if (this.hasAttributes(Day.WORKING )) {
            result = "wrk";
        }
        if (this.hasAttributes(Day.HALFWORK)) {
            result = "hwk";
        }
        if (this.hasAttributes(Day.VACANCY)) {
            result = "vac";
        }
        if (this.hasAttributes(Day.LEAVE)) {
            result = "lea";
        }
        if (this.hasAttributes(Day.SATURDAY)) {
            result = "sat";
        }
        if (this.hasAttributes(Day.SUNDAY)) {
            result = "sun";
        }
        if (this.hasAttributes(Day.HOLIDAY)) {
            result = "hli";
        }
        if (this.hasAttributes(Day.HOLYDAY)) {
            result = "hly";
        }
        return result;
    } // getCellClass

    /** Returns the stylesheet class for the first subcolumn in a cell,
    *   for example for the altair parament color of this day 
     *  @return one of "red", "vio" etc.
     */
    public String getCol1Class(String defaultColor) {
        String result = defaultColor;
        if (false) {
        } else if (this.hasAttributes(Day.RED     )) {
            result = "red";
        } else if (this.hasAttributes(Day.VIOLET  )) {
            result = "vio";
        } else if (this.hasAttributes(Day.BLACK   )) {
            result = "blk";
        } else if (this.hasAttributes(Day.WHITE   )) {
            result = "wht";
        } else if (this.hasAttributes(Day.GREEN   )) {
            result = "grn";
        }                       
        return result;
    } // getCol1Class
    /*------------------------------*/
    /** day in month, 1-31 */
    private int day;

    /** Gets the day's number in the month
     *  @return day of month
     */
    protected int getDay() {
        return day;
    } // getDay
    /*------------------------------*/
    /** display text of the (holy-, sun-) day corresponding to the {@link #name}, maybe empty */
    private String description;

    /** Sets the description of the day
     *  @param description name of the day to be set
     */
    protected void setDescription(String description) {
        this.description = description;
        setAppointment(" A", description);
    } // setDescription

    /** Gets the description of the day
     *  @return description name of the day to be set
     */
    public String getDescription() {
        return description;
    } // getDescription
    /*------------------------------*/
    /** String encoding the formula for the calculation of the day:
     *  <ul>
     *  <li><em><strong>anc</strong>i+-dist</em> - day distance to anchor day i</li>
     *  <li><em><strong>fix=</strong>mm-dd</em> - fixed date: month and day in month</li>
     *  <li><em><strong>var</strong></em> - the date is locally defined 
     *      and cannot be determined from the year</li>
     *  <li><em><strong>wrm</strong>w.mm</em> - first weekday w in month mm, where January = 01,
     *      and Sunday = 1 (as in Java), 8 = 2nd Sunday in month, 16 = 3rd Monday etc.</li>
     *  </ul>
     */
    private String formula;

    /** Sets the formula for the calculation of the day
     *  @param formula a code like "east0+49", "fix=06-29"
     */
    public void setFormula(String formula) {
        this.formula = formula;
    } // setFormula

    /** Gets the formula for the calculation of the day
     *  @return a code like "east0+49", "fix=06-29"
     */
    public String getFormula() {
        return formula;
    } // getFormula
    /*------------------------------*/
    /** month in year, 1-12 */
    private int month;

    /** Gets the ordinary month number (1-12) for the day
     *  @return month (1-12)
     */
    public int getMonth() {
        return month;
    } // getMonth

    /** sets the ordinary month number (1-12, or 13) for the day
     *  @param month (1-13)
     */
    public void setMonth(int month) {
        this.month = month;
    } // setMonth
    /*------------------------------*/
    /** name of the (holy-, sun-) day, key, short code: trin13, xmas2 and so on */
    private String name;
    
    /** Sets the internal, language-independant name of the day
     *  @param name a code like "trin4", "canta"
     */
    public void setName(String name) {
        this.name = name;
    } // setName

    /** Gets the internal, language-independant name of the day
     *  @return a code like "trin4", "canta"
     */
    public String getName() {
        return name;
    } // getName
    /*------------------------------*/
    /** text appearing when the mouse is placed over the day */
    private String toolTip;
    
    /** Sets text appearing when the mouse is placed over the day
     *  @param toolTip some text
     */
    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    } // setToolTip

    /** Gets text appearing when the mouse is placed over the day
     *  @return some text
     */
    public String getToolTip() {
        return toolTip;
    } // getToolTip
    /*------------------------------*/
    /** URL on the description */
    private String url;

    /** Gets the URL for the day
     *  @return Universal Resource Locator of the form http://... or ftp://...
     */
    public String getURL() {
        return url;
    } // getURL

    /** Sets the URL for the description
     *  @param url Universal Resource Locator of the form http://... or ftp://...
     */
    public void setURL(String url) {
        this.url = url;
    } // setURL
    /*------------------------------*/
    /** number of week in year: 1-53 */
    private int weekNumber;

    /** Gets the week number in the year
     *  @return week number in year
     */
    public int getWeek() {
        return weekNumber;
    } // getWeek
    /*------------------------------*/
    /** number of day in week: Sunday = 1, Saturday = 7 as in class java.util.Calendar */
    private int weekDay;

    /** Gets the day's number in the week
     *  @return day of week: Sunday = 1, Saturday = 7
     */
    protected int getWeekDay() {
        return weekDay;
    } // getWeekDay
    /*------------------------------*/
    /** year */
    private int year;

    /** Gets the year for the day
     *  @return year after Christ's birth (15xx - 22xx)
     */
    public int getYear() {
        return year;
    } // getYear
    /*------------------------------*/
    /** Gets a date suitable for ICalendar (RFC 5545)
     *  @return date of the form YYYYMMDD 
     */
    public String getIcalDate() {
        return    String.valueOf(getYear ())
                + String.valueOf(getMonth() + 100).substring(1)
                + String.valueOf(getDay  () + 100).substring(1)
                ;
    } // getIcalDate
   
} // Day
