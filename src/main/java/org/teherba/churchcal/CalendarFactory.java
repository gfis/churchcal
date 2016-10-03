/*  Selects the applicable calendar
    @(#) $Id: CalendarFactory.java 882 2012-02-12 21:09:04Z gfis $
    2016-10-03: Locale.setDefault
    2012-02-06: append year to title, remove array of calendars
    2012-01-06: CustomCalendar
    2008-04-03, Georg Fischer: copied from xtrans/XtransFactory.java

    Caution, this file has UTF-8 encoding (äöüÄÖÜß)!
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
import  org.teherba.churchcal.BaseCalendar;
import  org.teherba.churchcal.DeuCalendar;
import  org.teherba.churchcal.DeuChurchCalendar;
import  org.teherba.churchcal.TARGET2Calendar;
import  java.io.File;
import  java.io.PrintWriter;
import  java.util.Arrays; // asList
import  java.util.ArrayList; // asList
import  java.util.Iterator;
import  java.util.Locale;
import  java.util.StringTokenizer;
import  org.apache.log4j.Logger;

/** Determines and instantiates a specialized type of calendar,
 *  initializes all days in it, and sets its description.
 *  @author Dr. Georg Fischer
 */
public class CalendarFactory {
    public final static String CVSID = "@(#) $Id: CalendarFactory.java 882 2012-02-12 21:09:04Z gfis $";

    /** log4j logger (category) */
    private Logger log;

    /** No-args Constructor. Used for generation and serialization.
     *  Constructs all known calendars. Their constructors should
     *  not contain any heavy-weight initialization code, since they are
     *  all instantiated here, even if only two of them are really used.
     */
    public CalendarFactory() {
        log = Logger.getLogger(CalendarFactory.class.getName());
    } // Constructor

    /** Gets the applicable calendar for a specified format code.
     *  @param language language code (ISO 636) for the calendar
     *  @param variant abbreviation for the variant according to ISO 639
     *  @param year create a calendar for this year
     *  @param customization concatenated lines with styles and custom event descriptions,
     *  or <em>null</em> if not customized
     *  @return the calendar for that variant,
     *  or <em>null</em> if the variant was not found
     */
    public BaseCalendar getCalendar(String language, String variant, int year, String customization) {
        BaseCalendar calendar = null; // default: variant not found
        // System.out.println("language=\"" + language + "\", variant=\"" + variant + "\", year=\"" + year + "\"");
        Locale.setDefault(new Locale(language));
        if (false) {
        } else if (language.startsWith("en")) {
            if (false) {
            } else if (variant.startsWith("tar")) {
                calendar = new TARGET2Calendar(year);
                calendar.setTitle("TARGET2 Calendar for "               + calendar.getYear());
            } else {
                calendar = new DeuCalendar(year);
                calendar.setTitle("German Calendar for "                + calendar.getYear());
            }
        } else if (language.startsWith("fr")) {
            if (false) {
            } else if (variant.startsWith("tar")) {
                calendar = new TARGET2Calendar(year);
                calendar.setTitle("Calendrier TARGET2 "                 + calendar.getYear());
            } else {
                calendar = new DeuCalendar(year);
                calendar.setTitle("Calendrier allemand "                + calendar.getYear());
            }
        } else /* if (language.startsWith("de")) */ {
            if (false) {
            } else if (variant.contains("ev")) {
                calendar = new DeuChurchCalendar(year, DeuChurchCalendar.EVANGELIC );
                calendar.setTitle("Liturgischer Kalender (ev.) "        + calendar.getYear());
            } else if (variant.contains("rk")) {
                calendar = new DeuChurchCalendar(year, DeuChurchCalendar.CATHOLIC  );
                calendar.setTitle("Liturgischer Kalender (rk.) "        + calendar.getYear());
            } else if (variant.contains("tr")) {
                calendar = new DeuChurchCalendar(year, DeuChurchCalendar.TRINITATIS);
                calendar.setTitle("Liturgischer Kalender (ev./trin.) "  + calendar.getYear());
            } else if (variant.startsWith("tar")) {
                calendar = new TARGET2Calendar(year);
                calendar.setTitle("TARGET2-Kalender "                   + calendar.getYear());
            } else {
                calendar = new DeuCalendar(year);
                calendar.setTitle("Kalender "                           + calendar.getYear());
            }
        }
        calendar.setLanguage(language);
        calendar.setCustomization(customization);
        calendar.initialize();
        return calendar;
    } // getCalendar

} // CalendarFactory
