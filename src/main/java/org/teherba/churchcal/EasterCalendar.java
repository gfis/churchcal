/*  Class for the properties of a specific calendar year,
    with 4 methods for the calculation of Easter Sunday.
    @(#) $Id: EasterCalendar.java 969 2012-10-03 19:31:41Z gfis $
 *  2016-10-13: less imports, no try..catch
    2012-10-03: without import DayMap
    2008-04-09: splitted into BaseCalendar and EasterCalendar
    2008-04-03: year 1583..4099, renamed from BaseCalendar
    2008-04-02: computeEasterASSA, extends GregorianCalendar
    2007-10-14: printXML
    2007-03-14: Osterstreit correction for 1724 and 1744
    2007-02-12: renamed from calwork
    2007-01-15: TRINITATIS variant;
    2005-11-28: copied from numword

    Caution, this file needs UTF-8 encoding (äöüÄÖÜß)!
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
import  org.teherba.churchcal.BaseCalendar;
import  java.util.Calendar;
import  org.apache.log4j.Logger;

/** Class storing the properties of a specific sun (christian) calendar year,
 *  with 4 methods for the calculation of Easter Sunday.
 *  The years of this calendar are derived from the earth's rotation
 *  around the sun, and therefore have 365 or 366 days.
 *  The class is not fitted for calendars oriented towards moon months,
 *  like the islamic or hebrew calendars.
 *  @author Dr. Georg Fischer (adapted from Donald E. Knuth, Carl Friedrich Gauß, Ronald W. Mallen (ASSA))
 */
public class EasterCalendar extends BaseCalendar {
    public final static String CVSID = "@(#) $Id: EasterCalendar.java 969 2012-10-03 19:31:41Z gfis $";
    private static final boolean DEBUG = false;
    /** log4j logger (category) */
    protected Logger log;

    /** index of number of day in year for 1st Sunday after Epiphanias
        (Holy 3 Kings)
    */
    protected static final int EPIPHAN1 = 0;
    /** index of number of day in year for Easter Sunday
        (first Sunday after first full moon after spring equinox)
    */
    protected static final int EASTER   = 1;
    /** index of number of day in year for 1st of Advent
        (4th of Advent is last Sunday before or on Dec. 24th)
    */
    protected static final int ADVENT1  = 2;

    /* codes for calendar variants: confessions */
    /** (Lutheran) Evangelic sunday names */
    public static final int EVANGELIC    = 1;
    /** similiar to <code>EVANGELIC</code>, but with nth Trinitatis up to 1st Advent */
    public static final int TRINITATIS   = 2;
    /** Roman Catholic, German sunday names (nth Sonntag im Jahreskreis) */
    public static final int CATHOLIC     = 3;

    /** No-args Constructor = current year after Christ's birth, e.g. 2007
     */
    public EasterCalendar() {
        this(0, EVANGELIC);
    } // constructor ()

    /** Constructor for a specified year after Christ's birth
     *  @param parmYear year between 1583 and 4099
     */
    public EasterCalendar(int parmYear) {
        this(parmYear, EVANGELIC);
    } // constructor (1)

    /** Constructor for a specified year after Christ's birth
     *  @param parmYear year between 1583 and 4099, or 0 for current year
     *  @param variant church or other calendat variation
     */
    public EasterCalendar(int parmYear, int variant) {
        super(parmYear);
        log = Logger.getLogger(EasterCalendar.class.getName());
        setVariant(variant);
        // initialize();
    } // constructor (2)

    /** Initializes the <em>days</em> table with default properties
     */
    public void initialize() {
        super.initialize();
    } // initialize

    /** Sets the names of special days in the year and their properties,
     *  sometimes depending on the current confession.
     *  This method is pseudo-abstract and will be overwritten by subclasses.
     */
    protected void setSpecialDays() {
    } // setSpecialDays

    /** resulting month of Easter Sunday for the 4 Easter methods below */
    private int emonth; /* month of Easter sunday*/
    /** resulting day in month of Easter Sunday for the 4 Easter methods below */
    private int eday;   /* day   of Easter sunday */

    /** Calculates Easter sunday for a year after A.D. 463.
     *  @param eyear year for which the date of Easter sunday should be computed.
     *  Algorithm by Donald E. Knuth, Comm. ACM 5, April 1962, pp. 206 - 210
     *  <p>
     *  This procedure computes the day and month of easter given
     *  the year. It gives the actual date of WESTERN easter (not the
     *  EASTERN easter of the eastern orthodox churches) after A.D. 463.
     *  <p>
     *  'epact' specifies when full moon occurs.
     *  <p>
     *  Easter is the first sunday following the first full moon which
     *  occurs on or after March 21 (= equinox, start of spring).
     *  <p>
     *  Reference: A. de Morgan, A Budget of Paradoxes.
     */
    private void computeEasterKnuth(int eyear) {
        /*  number of the year in the metonic cycle,
            used to determine the position of the calendar moon */
        int goldenNumber;
        int century;
        /*  number of preceeding years like 1700, 1800, 1900
            when leap year was not held */
        int gregorianCorrection;
        /* correction for the metonic cycle of about 8 days every 2500 years */
        int clavianCorrection;
        int extraDays; /* specifies when sunday occurs in march */
        int epact; /* age of the calendar moon at the beginning of the year */

        goldenNumber = eyear % 19 + 1;
        if (eyear > 1582) {
            century             = eyear / 100 + 1;
            gregorianCorrection = (3 * century) / 4 - 12;
            clavianCorrection   = (century - 16 - (century - 18) / 25) / 3;
            extraDays           = (5 * eyear) / 4 - gregorianCorrection - 10;
            epact               = (11 * goldenNumber + 19 + clavianCorrection - gregorianCorrection) % 30 + 1;
            if ((epact == 25 && goldenNumber > 11) || epact == 24) {
                epact = epact + 1;
            }
        } else {
            extraDays = (5 * eyear) / 4;
            epact  = (11 * goldenNumber - 4) % 30 + 1;
        }

        eday  = 44 - epact;
        if (eday < 21) {
            eday = eday + 30;
        }
        eday  = eday + 7 - ((extraDays + eday) % 7);

        if (eday <= 31) {
            emonth = 3;
        } else {
            emonth = 4;
            eday   = eday - 31;
        }
    } // computeEasterKnuth

    /** Calculates Easter sunday for a year between 1583 and 2299 AC.
     *  @param eyear year for which the date of Easter sunday should be computed.
     *  Algorithm from Fischer Lexikon Astronomie, p. 50:
     *  Algorithm of Carl Friedrich Gauß (1777-1855),
     *  for 1583 <= eyear <= 2299.
     *  <p>
     *  This seems to be the most concise algorithm, but it fails for years >= 2300.
     */
    private void computeEasterGauss(int eyear) {
        int m, n, p, q, r, x, y, a, b, c, d, e;

        if (false) {
        } else if (eyear <= 1699)  { m = 22; n = 2;
        } else if (eyear <= 1799)  { m = 23; n = 3;
        } else if (eyear <= 1899)  { m = 23; n = 4;
        } else if (eyear <= 2099)  { m = 24; n = 5;
        } else if (eyear <= 2199)  { m = 24; n = 6;
        } else if (eyear <= 2299)  { m = 25; n = 0;
        } else                     { m = 25; n = 0;
        } // but out of range
        a  = eyear % 19;
        b  = eyear %  4;
        c  = eyear %  7;
        d  = (19 * a + m) % 30;
        e  = (2 * b + 4 * c + 6 * d + n) % 7;

        eday   = 22 + d + e;
        emonth =  4;

        if (false) {
        } else if (eday <= 31) {
            emonth =  3;
        } else if ((d == 28) && (e == 6) && (a > 10)) {
            eday = 18;
        } else if ((d == 29) && (e == 6)) {
            eday = 19;
        } else {
          eday = d + e - 9;
        }
    } // computeEasterGauss

    /** Calculates Easter sunday for a year between 1583 and 4099 AC.
     *  @param eyear year for which the date of Easter sunday should be computed.
     *  Algorithm from CHIP magazine, July 1986, p. 127
     *  for BASIC, all expressions (a / b) must be written as INT(A/B)
     *  <p>
     *  This is similiar to Gauss' algorithm, but it works up to year 4099.
     */
    private void computeEasterBasic(int eyear) {
        int p, q, r, x, y, a, b, c, d, e;

        p = eyear / 100;
        q = p / 3;
        r = p / 4;
        x = 15 + p - q - r;
        x = x - ((x / 30) * 30);
        y = p + 4 - r;
        y = y - ((y /  7) *  7);
        /* x = m, y = n in 'easter3' */
        a = eyear - ((eyear / 19) * 19);
        b = eyear - ((eyear /  4) *  4);
        c = eyear - ((eyear /  7) *  7);
        d = 19 * a + x;
        d = d - ((d / 30) * 30);
        e = 2 * b + 4 * c + 6 * d + y;
        e = e - ((e /  7) *  7);
        if (false) {
        } else if (22 + d + e <= 31) {
            eday   = 22 + d + e;
            emonth = 3;
        } else if (d == 28 && e == 6 && a > 10) {
            eday   = 18;
            emonth =  4;
        } else if (d == 29 && e == 6) {
            eday   = 19;
            emonth =  4;
        } else {
            eday   = d + e - 9;
            emonth = 4;
        }
    } // computeEasterBasic

    /** Calculates Easter sunday for a year between 1583 and 4099 AC.
     *  Algorithm from the Astronomical Society of South Australia,
     *  Ronald W. Mallen, c.f.
     *  <a href="http://www.assa.org.au/edm.html#Computer">his article</a>.</br />
     *  For BASIC, all expressions (a \ b) must be written as INT(A/B)
    <pre>
        Sub EasterDate (d, m, y)

        ' EASTER DATE CALCULATION FOR YEARS 1583 TO 4099

        ' y is a 4 digit year 1583 to 4099
        ' d returns the day of the month of Easter
        ' m returns the month of Easter

        ' Easter Sunday is the Sunday following the Paschal Full Moon
        ' (PFM) date for the year

        ' This algorithm is an arithmetic interpretation of the 3 step
        ' Easter Dating Method developed by Ron Mallen 1985, as a vast
        ' improvement on the method described in the Common Prayer Book

        ' Because this algorithm is a direct translation of the
        ' official tables, it can be easily proved to be 100% correct

        ' This algorithm derives values by sequential inter-dependent
        ' calculations, so ... DO NOT MODIFY THE ORDER OF CALCULATIONS!

        ' The \ operator may be unfamiliar - it means integer division
        ' for example, 30 \ 7 = 4 (the remainder is ignored)

        ' All variables are integer data types

        ' It's free!  Please do not modify code or comments!
        ' ==========================================================

           Dim FirstDig, Remain19, temp    'intermediate results
           Dim tA, tB, tC, tD, tE          'table A to E results

           FirstDig = y \ 100              'first 2 digits of year
           Remain19 = y Mod 19             'remainder of year / 19

        ' calculate PFM date
           temp = (FirstDig - 15) \ 2 + 202 - 11 * Remain19

           Select Case FirstDig
              Case 21, 24, 25, 27 To 32, 34, 35, 38
                 temp = temp - 1
              Case 33, 36, 37, 39, 40
                 temp = temp - 2
           End Select
           temp = temp Mod 30

           tA = temp + 21
           If temp = 29 Then tA = tA - 1
           If (temp = 28 And Remain19 > 10) Then tA = tA - 1

        'find the next Sunday
           tB = (tA - 19) Mod 7

           tC = (40 - FirstDig) Mod 4
           If tC = 3 Then tC = tC + 1
           If tC &gt; 1 Then tC = tC + 1

           temp = y Mod 100
           tD = (temp + temp \ 4) Mod 7

           tE = ((20 - tB - tC - tD) Mod 7) + 1
           eday = tA + tE

        'return the date
           If d &gt; 31 Then
              d = d - 31
              m = 4
           Else
              m = 3
           End If

        End Sub
    </pre>
    *  @param eyear year for which the date of Easter sunday should be computed.
    */
    private void computeEasterASSA(int eyear) {
        int firstDig, remain19, temp;    // intermediate results
        int tA, tB, tC, tD, tE;          // table A to E results
        int y = eyear;

        firstDig = y / 100;              // first 2 digits of year
        remain19 = y % 19;               // remainder of year / 19

        //  calculate PFM date
        temp = (firstDig - 15) / 2 + 202 - 11 * remain19;

        switch (firstDig) {
            case 21:
            case 24:
            case 25:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 35:
            case 38:
               temp = temp - 1;
               break;
            case 33:
            case 36:
            case 37:
            case 39:
            case 40:
               temp = temp - 2;
               break;
            default:
                break;
        } // switch firstDig
        temp = temp % 30;

        tA = temp + 21;
        if (temp == 29) {
            tA = tA - 1;
        }
        if ((temp == 28 && remain19 > 10)) {
            tA = tA - 1;
        }
        // find the next Sunday
        tB = (tA - 19) % 7;

        tC = (40 - firstDig) % 4;
        if (tC == 3) {
            tC = tC + 1;
        }
        if (tC > 1) {
            tC = tC + 1;
        }

        temp = y % 100;
        tD = (temp + temp / 4) % 7;

        tE = ((20 - tB - tC - tD) % 7) + 1;
        eday = tA + tE;

        // return the date
        if (eday > 31) {
            eday = eday - 31;
            emonth = 4;
        } else {
            emonth = 3;
        }
    } // computeEasterASSA

    /** Calls all 4 Easter calculation methods and compares the results.
     */
    public void testEaster() {
        int eday1, emonth1;
        int eday2, emonth2;
        int eday3, emonth3;
        int eday4, emonth4;

        for (int eyear = 1583; eyear <= 4099 /* 2299 */; eyear ++) {
            computeEasterKnuth (eyear);     eday1 = eday; emonth1 = emonth;
            System.out.print(eyear + ": " + eday1 + "." + emonth1 + ".  ");
            computeEasterGauss (eyear);     eday2 = eday; emonth2 = emonth;
            System.out.print(               eday2 + "." + emonth2 + ".  ");
            computeEasterBasic (eyear);     eday3 = eday; emonth3 = emonth;
            System.out.print(               eday3 + "." + emonth3 + ".  ");
            computeEasterASSA  (eyear);     eday4 = eday; emonth4 = emonth;
            System.out.print(               eday4 + "." + emonth4 + ".  ");

            if  (   emonth1 != emonth2 && false
                ||  emonth1 != emonth3
                ||  emonth1 != emonth4
                ||  eday1   != eday2   && false
                ||  eday1   != eday3
                ||  eday1   != eday4
                )
            {
                System.out.print("-------> error");
            }
            System.out.println();
        } // for eyear
    } // testEaster

    /** Sets the index (into <em>days</em>) of Epiphanias,
     *  Easter sunday and 1st Advent in
     *  this year; assumes that the year is already set.
     */
    protected void computeAnchorDays() {
        // Java defines SUNDAY = 1, SATURDAY = 7 and MONTHS STARTING AT 0!

        // 1st sunday after Jan. 6th (Holy 3 Kings)
        /*  for Monday = 1 and Sunday = 7:
            epi1 = 13 - week_day (6, 1, year);
            if (epi1 == 6) epi1 += 7;
        */
        this.set(Calendar.MONTH       , 1 - 1);
        this.set(Calendar.DAY_OF_MONTH, 6);
        int epi1 = 13 - (this.get(Calendar.DAY_OF_WEEK) - 1) % 7;
        if (epi1 == 6) {
            epi1 += 7;
        }
        /* 1st Sunday after (but not on) Epiphanias (January 6th) */

        // Easter is the 1st Sunday on or after the 1st full moon after Mar. 21st (Equinox)
        computeEasterASSA(baseYear);
        this.set(Calendar.MONTH       , emonth - 1);
        this.set(Calendar.DAY_OF_MONTH, eday);
        int east0 = this.get(Calendar.DAY_OF_YEAR); // sunday
        if ((baseYear == 1724 || baseYear == 1744) && (variant == EVANGELIC || variant == TRINITATIS)) {
            east0 -= 7; // c.f. "Osterstreit", Johann Leonhard Rost in de.wikipedia.org
        }
        /* Easter sunday = first Sunday after the first full moon after the beginning of spring (equinox) */

        /*  for Monday = 1 and Sunday = 7:
            4th Advent is the Sunday before or on Dec. 24th
            day_31_12 = day_in_year (31, 12, baseYear);
            he24 = day_31_12 - 7;
            adv1 = he24 - (week_day (24, 12, baseYear) % 7) - 21;
        */
        this.set(Calendar.MONTH       , 12 - 1);
        this.set(Calendar.DAY_OF_MONTH, 24);
        int weekDay = this.get(Calendar.DAY_OF_WEEK);
        int adv1    = this.get(Calendar.DAY_OF_YEAR) - (weekDay - 1) % 7 - 21;
        /* first advent - 4th advent is the last Sunday before or on December 24th */

        if (DEBUG) {
            log.debug(this.get(Calendar.YEAR) + ": "
                    + "epi1 = " +  epi1 + ", east0 = " + east0 + ", adv1 = " + adv1);
        }
        anchors[EPIPHAN1] = epi1;
        anchors[EASTER  ] = east0;
        anchors[ADVENT1 ] = adv1;
    } // computeAnchorDays

    /** Test program, compares Easter algorithms.
     *  @param args commandline arguments (empty)
     */
    public static void main(String[] args) {
        EasterCalendar easterCalendar = new EasterCalendar();
        easterCalendar.testEaster();
    } // main

} // EasterCalendar
