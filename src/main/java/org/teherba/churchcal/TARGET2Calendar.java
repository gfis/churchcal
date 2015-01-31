/*  Class for the computation of TARGET2 calendars
    @(#) $Id: TARGET2Calendar.java 872 2012-02-06 22:14:14Z gfis $
    2008-04-03, Georg Fischer: copied from DeuCalendar

    Caution, file has UTF-8 encoding (äöüÄÖÜß)
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
import  org.teherba.churchcal.Day;
import  org.teherba.churchcal.EasterCalendar;

/**	Class defining a TARGET2 calendar for some year
 *  with 6 holidays.
 *	TARGET2 is a RTGS (Real Time Gross Settlement) system used in Europe.
 *  @author Dr. Georg Fischer
 */
public class TARGET2Calendar extends EasterCalendar {
    public final static String CVSID = "@(#) $Id: TARGET2Calendar.java 872 2012-02-06 22:14:14Z gfis $";

    /** No-args Constructor
     */
    public TARGET2Calendar() {
        this(0);
    } // constructor (0)

    /** Constructor for a specified year after Christ's birth
     *  @param year year between 1583 and 4099
     */
    public TARGET2Calendar(int year) {
        super(year);
        setLanguage("eng");
   } // constructor (1)

    /** Initializes the <em>days</em> table with default properties
     */
    public void initialize() {
		super.initialize();
    } // initialize
    
    /** Sets the names of special days in the year and their properties.
     */
    protected void setSpecialDays() {
            // only 6 holidays
            setDay( 1, 1                     , "Neujahr"                 , Day.HOLIDAY   );
            setDay(anchors[EASTER  ]     -  2, "Karfreitag"              , Day.HOLYDAY + Day.HOLIDAY );
            setDay(anchors[EASTER  ]         , "Ostersonntag"            , Day.HOLYDAY   );
            setDay(anchors[EASTER  ]     +  1, "Ostermontag"             , Day.HOLYDAY + Day.HOLIDAY );
            setDay( 5, 1                     , "Maifeiertag"             , Day.HOLIDAY   );
            setDay(12, 25                    , "1. Weihnachtstag"        , Day.HOLYDAY + Day.HOLIDAY );
            setDay(12, 26                    , "2. Weihnachtstag"        , Day.HOLYDAY + Day.HOLIDAY );
    } // setSpecialDays

} // TARGET2Calendar
