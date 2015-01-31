/*  Class for the computation of German calendars
    @(#) $Id: DeuCalendar.java 853 2012-01-06 20:59:01Z gfis $
    2008-04-04: uniform constructors
    2007-02-12: renamed from calwork
    2005-11-30, Georg Fischer

    Caution, this file has UTF-8 encoding (äöüÄÖÜß)!
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
import  org.teherba.churchcal.Day;
import  org.teherba.churchcal.EasterCalendar;

/**
 *  Class defining a German calendar for some year
 *  with holidays.
 *  @author Dr. Georg Fischer
 */
public class DeuCalendar extends EasterCalendar {
    public final static String CVSID = "@(#) $Id: DeuCalendar.java 853 2012-01-06 20:59:01Z gfis $";

    /** No-args Constructor
     */
    public DeuCalendar() {
        this(0);
    } // constructor (0)

    /** Constructor for a specified year after Christ's birth
     *  @param parmYear year between 1583 and 4099
     */
    public DeuCalendar(int parmYear) {
        super(parmYear);
        setLanguage("deu");
    } // constructor (1)

    /** Constructor for a specified year after Christ's birth
     *  @param parmYear year between 1583 and 4099
     *  @param variant church or other calendat variation
     */
    public DeuCalendar(int parmYear, int variant) {
        super(parmYear, variant);
        setLanguage("deu");
    } // constructor(2)

    /** Initializes the <em>days</em> table with default properties
     */
    public void initialize() {
		super.initialize();
    } // initialize
    
    /** Sets the names of special days in the year and their properties,
     *  sometimes depending on the current confession.
     */
    protected void setSpecialDays() {
            // political/common holidays
            setDay( 1, 1                     , "Neujahr"                 , Day.HOLIDAY   );
            setDay( 1, 6                     , "Hl. 3 Könige"            , Day.HOLYDAY   );
            setDay(anchors[EASTER  ]     - 48, "Rosenmontag"             , Day.WORKING   );
            setDay(anchors[EASTER  ]     - 47, "Fastnacht"               , Day.WORKING   );
            setDay(anchors[EASTER  ]     - 46, "Aschermittwoch"          , Day.WORKING   );
            setDay(anchors[EASTER  ]     -  3, "Gründonnerstag"          , Day.HOLYDAY   );
            setDay(anchors[EASTER  ]     -  2, "Karfreitag"              , Day.HOLYDAY + Day.HOLIDAY );
            setDay(anchors[EASTER  ]         , "Ostersonntag"            , Day.HOLYDAY   );
            setDay(anchors[EASTER  ]     +  1, "Ostermontag"             , Day.HOLYDAY + Day.HOLIDAY );
            setDay( 5, 1                     , "Maifeiertag"             , Day.HOLIDAY   );
            setDay(anchors[EASTER  ]     + 39, "Christi Himmelf."        , Day.HOLYDAY + Day.HOLIDAY );
            setDay(anchors[EASTER  ]     + 49, "Pfingsten"               , Day.HOLYDAY   );
            setDay(anchors[EASTER  ]     + 50, "Pfingstmontag"           , Day.HOLYDAY + Day.HOLIDAY );
            setDay(anchors[EASTER  ]     + 60, "Fronleichnam"            , Day.HOLYDAY + Day.HOLIDAY );
            setDay( 8, 15                    , "Mariä Himmelfahrt"       , Day.HOLYDAY   );
            setDay(10, 3                     , "T.d.Wiedervereinig."     , Day.HOLIDAY   );
            setDay(10, 31                    , "Reformationsfest"        , Day.HOLYDAY   );
            setDay(11,  1                    , "Allerheiligen"           , Day.HOLYDAY   );
            setDay(anchors[ADVENT1 ]     - 11, "Buß- und Bettag"         , Day.HOLYDAY   );
            setDay(anchors[ADVENT1 ]     -  7, "Totensonntag"            , Day.SUNDAY    );
            setDay(12, 24                    , "Heiliger Abend"          , Day.HALFWORK  );
            setDay(12, 25                    , "1. Weihnachtstag"        , Day.HOLYDAY + Day.HOLIDAY );
            setDay(12, 26                    , "2. Weihnachtstag"        , Day.HOLYDAY + Day.HOLIDAY );
            setDay(12, 31                    , "Silvester"               , Day.HALFWORK  );
    } // setSpecialDays

} // DeuCalendar
