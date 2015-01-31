/*  Class for the computation of German church calendars
    @(#) $Id: DeuChurchCalendar.java 853 2012-01-06 20:59:01Z gfis $
    2008-04-10: Palmsonntag also for variant="rk"
    2007-04-10: start with WHITE in first week
    2007-02-12: renamed from calwork
    2007-01-15: TRINITATIS; caution, file has UTF-8 encoding (äöüÄÖÜß)
    2005-11-30, Georg Fischer
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
import  org.teherba.churchcal.DeuCalendar;
import  org.teherba.churchcal.Day;
import  java.util.Calendar;
import  java.util.Date;
import  java.util.GregorianCalendar;
import  java.io.StringWriter;

/** Class defining a German church calendar for some year
 *  with holy days relative to Easter, Advent 1st and Epiphanias,
 *  and parament colors for each day.
 *  @author Dr. Georg Fischer
 */
public class DeuChurchCalendar extends DeuCalendar {
    public final static String CVSID = "@(#) $Id: DeuChurchCalendar.java 853 2012-01-06 20:59:01Z gfis $";

    /** No-args Constructor
     */
    public DeuChurchCalendar() {
        super();
    } // constructor(0)

    /** Constructor for a specified year after Christ's birth
     *  @param parmYear year between 1583 and 4099
     */
    public DeuChurchCalendar(int parmYear) {
        super(parmYear);
    } // constructor(1)

    /** Constructor for a specified year after Christ's birth
     *  @param parmYear year between 1583 and 4099
     *  @param variant church or other calendat variation,
     *  influences the names of special days
     */
    public DeuChurchCalendar(int parmYear, int variant) {
        super(parmYear, variant);
    } // constructor(2)

    /** Initializes the <em>days</em> table with default properties
     */
    public void initialize() {
		super.initialize();
    } // initialize
    
    /** Sets the names of special days in the year and their properties,
     *  sometimes depending on the current confession (variant).
     */
    protected void setSpecialDays() {
        int saveVariant = getVariant();
        if (saveVariant == TRINITATIS) {
            setVariant(EVANGELIC); // differs in last 3 Trinitatis Sundays only
        }
        // political/common holidays
            setDay( 1, 1                     , "Neujahr"                 , Day.HOLIDAY   );
            switchAttributes(Day.WHITE, Day.WHITE);
        if (anchors[EPIPHAN1] >= 8) {
            setDay(anchors[EPIPHAN1]  - 1 * 7, "2.So.n.Weihn."           , Day.SUNDAY    , EVANGELIC);
        }
            setDay( 1, 6                     , "Epiphanias"              , Day.HOLYDAY   , EVANGELIC);
            setDay( 1, 6                     , "Hl. 3 Könige"            , Day.HOLYDAY   , CATHOLIC );
            switchAttributes(Day.WHITE, Day.GREEN);
        for (int week = 1; week <= 5; week ++) {
            setDay(anchors[EPIPHAN1] -7 + week * 7, week + ".So.n.Epiph.", Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EPIPHAN1] -7 + week * 7, week + ".So.i.Jkrs." , Day.SUNDAY    , CATHOLIC );
        } // for Sundays after Epiphanias

        // indexed by distance in weeks to Easter sunday, +10
            setDay(anchors[EASTER  ] - 10 * 7, "Letzter So.n.Epiph."     , Day.SUNDAY    , EVANGELIC);
            switchAttributes(Day.WHITE, Day.GREEN);
            setDay(anchors[EASTER  ]  - 9 * 7, "Septuagesimae"           , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]  - 8 * 7, "Sexagesimae"             , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]  - 7 * 7, "Estomihi"                , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]     - 48, "Rosenmontag"             , Day.WORKING   );
            setDay(anchors[EASTER  ]     - 47, "Fastnacht"               , Day.WORKING   );
            setDay(anchors[EASTER  ]     - 46, "Aschermittwoch"          , Day.WORKING   );
            switchAttributes(Day.VIOLET, Day.VIOLET);
            setDay(anchors[EASTER  ]  - 6 * 7, "Invokavit"               , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]  - 5 * 7, "Reminiszere"             , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]  - 4 * 7, "Okuli"                   , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]  - 3 * 7, "Laetare"                 , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]  - 2 * 7, "Judika"                  , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]  - 1 * 7, "Palmsonntag"             , Day.SUNDAY    );
            setDay(anchors[EASTER  ]     -  3, "Gründonnerstag"          , Day.WORKING   );
            switchAttributes(Day.WHITE, Day.BLACK);
            setDay(anchors[EASTER  ]     -  2, "Karfreitag"              , Day.HOLYDAY   );
            switchAttributes(Day.BLACK, Day.BLACK);
            setDay(anchors[EASTER  ]     -  1, "Karsamstag"              , Day.SATURDAY);
            setDay(anchors[EASTER  ]         , "Ostersonntag"            , Day.SUNDAY | Day.HOLYDAY  );
            switchAttributes(Day.WHITE, Day.WHITE);
            setDay(anchors[EASTER  ]     +  1, "Ostermontag"             , Day.HOLYDAY   );
            setDay(anchors[EASTER  ]  + 1 * 7, "Quasimodogeniti"         , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]  + 1 * 7, "Weißer Sonntag"          , Day.SUNDAY    , CATHOLIC );
            setDay( 5, 1                     , "Maifeiertag"             , Day.HOLIDAY   );
            setDay(anchors[EASTER  ]  + 2 * 7, "Misericordias Dom."      , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]  + 3 * 7, "Jubilate"                , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]  + 4 * 7, "Kantate"                 , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]  + 5 * 7, "Rogate"                  , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]     + 39, "Christi Himmelf."        , Day.HOLYDAY   );
            setDay(anchors[EASTER  ]  + 6 * 7, "Exaudi"                  , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[EASTER  ]  + 7 * 7, "Pfingsten"               , Day.SUNDAY | Day.HOLYDAY);
            switchAttributes(Day.RED, Day.RED);
            setDay(anchors[EASTER  ]     + 50, "Pfingstmontag"           , Day.HOLYDAY   );
            setDay(anchors[EASTER  ]  + 8 * 7, "Trinitatis"              , Day.SUNDAY    );
            switchAttributes(Day.WHITE, Day.GREEN);
        for (int week = 1; week <= 27; week ++) { // 27th sunday after Trinitatis is rather rare, e.g. in 1731
            setDay(anchors[EASTER  ]  + 8*7 + week * 7, week + ".So.n.Trin.", Day.SUNDAY );
        } // for Sundays after Trinitatis
            setDay(anchors[EASTER  ]     + 60, "Fronleichnam"            , Day.HOLYDAY   );
            setDay( 6, 24                    , "Johannis"                , Day.WORKING   );
            setDay( 8, 15                    , "Mariä Himmelf."          , Day.WORKING   , CATHOLIC );
            setDay( 9, 29                    , "Michaelis"               , Day.WORKING   );

        this.set(Calendar.MONTH, 10 - 1);
        this.set(Calendar.DAY_OF_MONTH, 1);
        int octDay = this.get(Calendar.DAY_OF_YEAR);
        while (! days[octDay].hasAttributes(Day.SUNDAY)) {
            octDay ++;
        }
        if (saveVariant != TRINITATIS) {
            setDay(10, 3                     , "T.d.Wiedervereinig."     , Day.HOLIDAY   );
            setDay(octDay                    , "Erntedankfest"           , Day.SUNDAY    );
        }
        if (variant == EVANGELIC) {
            setDay(10, 31                    , "Reformationsfest"        , Day.WORKING   , EVANGELIC);
            switchAttributes(Day.RED, Day.GREEN);
        }
        if (saveVariant != TRINITATIS) {
            setDay(11,  1                    , "Allerheiligen"           , Day.HOLYDAY   );
            setDay(11,  2                    , "Allerseelen"             , Day.WORKING   , CATHOLIC );
            setDay(11, 11                    , "Martini"                 , Day.WORKING   );
            setDay(anchors[ADVENT1 ]  - 3 * 7, "3.letzter So.im Kj."     , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[ADVENT1 ]  - 2 * 7, "Volkstrauertag"          , Day.SUNDAY    );
        }
            setDay(anchors[ADVENT1 ]     - 11, "Buß- und Bettag"         , Day.WORKING   , EVANGELIC);
            switchAttributes(Day.VIOLET, Day.GREEN);
        if (saveVariant != TRINITATIS) {
            setDay(anchors[ADVENT1 ]  - 1 * 7, "Ewigkeitssonntag"        , Day.SUNDAY    , EVANGELIC);
            setDay(anchors[ADVENT1 ]  - 1 * 7, "Totensonntag"            , Day.SUNDAY    , CATHOLIC );
        }
            switchAttributes(Day.GREEN, Day.VIOLET);
            setDay(12,  6                    , "Nikolaus"                , Day.WORKING   );
            setDay(12,  8                    , "Mariä Emfängnis"         , Day.WORKING   , CATHOLIC );
            setDay(anchors[ADVENT1 ]  + 0 * 7, "1. Advent"               , Day.SUNDAY    );
            setDay(anchors[ADVENT1 ]  + 1 * 7, "2. Advent"               , Day.SUNDAY    );
            setDay(anchors[ADVENT1 ]  + 2 * 7, "3. Advent"               , Day.SUNDAY    );
            setDay(anchors[ADVENT1 ]  + 3 * 7, "4. Advent"               , Day.SUNDAY    );
        if (       anchors[ADVENT1 ]  + 4 * 7 <= this.getActualMaximum(Calendar.DAY_OF_YEAR)) {
            setDay(anchors[ADVENT1 ]  + 4 * 7, "So.n.Weihnachten"        , Day.SUNDAY    );
        }
            setDay(12, 24                    , "Heiliger Abend"          , Day.HALFWORK  );
            setDay(12, 25                    , "1. Weihnachtstag"        , Day.HOLYDAY   );
            switchAttributes(Day.WHITE, Day.WHITE);
            setDay(12, 26                    , "2. Weihnachtstag"        , Day.HOLYDAY   );
            setDay(12, 31                    , "Silvester"               , Day.HALFWORK  );
            switchAttributes(Day.WHITE, Day.UNDEF);
    } // setSpecialDays

} // DeuChurchCalendar
