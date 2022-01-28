/*  List (array) of days for the current calendar year plus some surrounding months
    @(#) $Id: DayList.java 969 2012-10-03 19:31:41Z gfis $
    2012-01-04: parmYear -> year
    2008-04-11, Georg Fischer: copied from DayMap
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
import  java.util.Calendar;
import  java.util.GregorianCalendar;
import  org.apache.logging.log4j.Logger;
import  org.apache.logging.log4j.LogManager;

/** List (array) of days for the current calendar year plus some surrounding months.
 *  @author Dr. Georg Fischer
 */
public class DayList {
    public final static String CVSID = "@(#) $Id: DayList.java 969 2012-10-03 19:31:41Z gfis $";
    /** log4j logger (category) */
    private Logger log;

    /** Calculate the calendar for this year */
    protected int baseYear;
    /** Array of calendar days, [0] is not used, last index is [365] or [366] */
    protected Day[] days;
    /** Index of array element for January 0 of the base year */
    protected int baseJan0;
    /** Index of the current day during iteration through the base year */
    protected int ibase;
    /** number of array elements (days) for one year, with special elements (all three set to <em>null</em>):
     *  <ul>
     *  <li>January 0, before the real year</li>
     *  <li>February 29th, following Dec. 31st if no leap year</li>
     *  <li>December 32nd, behind the year, needed by <em>printHMTL</em> 
     *  </ul>
     */
    private static final int MAX_SEGMENT = 368;
    /** total number of array elements (days) */
    private static final int MAX_LIST = 3 * MAX_SEGMENT;

    /** No-args Constructor 
     */
    public DayList() {
        log = LogManager.getLogger(DayList.class.getName());
        days = new Day[MAX_LIST];
        baseJan0 = MAX_SEGMENT;
        reset();
    } // constructor (0)

    /** Constructor for a specific year
     *  @param year create list for this year
     */
    public DayList(int year) {
        this();
        initialize(year, ibase);
    } // constructor (1)

    /** Initializes some segment of the list (array) with the days 
     *  either for the base year, the year before or the year after.
     *  @param year initialize for this year
     *  @param ijan0 index pointing to the element for January 0 (= null) of the segment year
     */
    public void initialize(int year, int ijan0) {
        GregorianCalendar calendar = new GregorianCalendar();
        if (year != 0) {
            calendar.set(Calendar.YEAR,         year);
            calendar.set(Calendar.MONTH,        1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
        }
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_YEAR) + 1;
        int iday = 1;
        while (iday < maxDay) {
            calendar.set(Calendar.DAY_OF_YEAR, iday);
            days[ijan0 + iday] = new Day(calendar); // default properties
            iday ++;
        } // while iday
    } // initialize

    /** Resets the iteration through the base year.
     */
    public void reset() {
        ibase = baseJan0 + 1;
    } // reset

    /** Tests whether there is another day in the base year.
     *  @return whether there is another day in the base year
     */
    public boolean hasNext() {
        return days[ibase] != null;
    } // hasNext

    /** Gets the next day during the iteration through the base year.
     *  @return next day
     */
    public Day next() {
        return days[ibase ++];
    } // next

    /** Dumps all elements in the list (array).
     */
    public void dumpAll() {
        String sep = ", ";
        int iday = 0;
        while (iday < MAX_LIST) {
            System.out.print("days[" + iday + "] = ");
            Day day = days[iday];
            if (day == null) {
                System.out.println("null");
            } else {
                System.out.println(day.getYear()
                        + sep +    day.getMonth()
                        + sep +    day.getDay()
                        + sep +    day.getWeek()
                        + sep +    day.getWeekDay()
                        );
            } 
            iday ++;
        } // while iday
    } // initialize

    /** Main program, dumps the whole list (array). Usage:
     *  <pre>
     *    java org.teherba.churchcal.DayList [year]
     *  </pre>
     *  @param args commandline arguments
     */
    public static void main(String args[]) {
        DayList dlist = null;
        int mainYear = 0; // current year
        int iarg = 0;
        if (iarg >= args.length) {
        } else {
            try {
                mainYear = Integer.parseInt(args[iarg ++]);
            } catch (Exception exc) {
                // take current year
            }
        }
        dlist = new DayList();
        dlist.initialize(mainYear + 0, 0 * MAX_SEGMENT);
        dlist.dumpAll();
        dlist.next();
        dlist.initialize(mainYear - 1, 0 * MAX_SEGMENT);
        dlist.initialize(mainYear + 1, 2 * MAX_SEGMENT);        
        dlist.dumpAll();
    } // main
    
} // DayList
