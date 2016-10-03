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
/*  Maps from names of days to <em>Day</em>s (with their formulas).
    @(#) $Id: holydays.pl 976 2013-02-02 16:44:18Z gfis $
    
    Caution, this file is generated by ../org/teherba/gramword/dict/bible/perikope/holydays.pl
    DO NOT EDIT HERE!
*/

package org.teherba.churchcal;
import  org.teherba.churchcal.EasterCalendar;
import  org.teherba.churchcal.Day;
import  java.io.BufferedReader;
import  java.io.FileInputStream;
import  java.io.InputStreamReader;
import  java.nio.channels.Channels;
import  java.util.HashMap;
import  java.util.Iterator;
import  java.util.TreeMap;
import  java.util.regex.Matcher;
import  java.util.regex.Pattern;
import  org.apache.log4j.Logger;

/** Maps from names of days to {@link Day}s (with their formulas),
 *  and provides some testing methods.
 *  @author Dr. Georg Fischer
 */
public class DayMap extends HashMap/*<1.5*/<String, Day>/*1.5>*/ {
    public final static String CVSID = "@(#) $Id: holydays.pl 976 2013-02-02 16:44:18Z gfis $";
    /** log4j logger (category) */
    private Logger log;

    /** No-args Constructor - stores the properties of all holy days.
     *  The holy day codes are mapped to <em>Day</em>s which
     *  have their <em>name</em> and <em>formula</em> properties set.
     *  The formulas take the following forms:
     *  <ul>
     *  <li><em><strong>anc</strong>i+-dist</em> - day distance to anchor day i</li>
     *  <li><em><strong>fix=</strong>mm-dd</em> - fixed date: month and day in month</li>
     *  <li><em><strong>var</strong></em> - the date is locally defined 
     *      and cannot be determined from the year</li>
     *  <li><em><strong>wrm</strong>w.mm</em> - first weekday w in month mm, where January = 01,
     *      and Sunday = 1 (as in Java), 8 = 2nd Sunday in month, 16 = 3rd Monday etc.</li>
     *  </ul>
     */
    public DayMap() {
        super(128);
        log = Logger.getLogger(DayMap.class.getName());
		this.put("adv1"     , new Day("adv1"     , "anc2+0"));
		this.put("adv2"     , new Day("adv2"     , "anc2+7"));
		this.put("adv3"     , new Day("adv3"     , "anc2+14"));
		this.put("adv4"     , new Day("adv4"     , "anc2+21"));
		this.put("xmas0"    , new Day("xmas0"    , "fix=12-24"));
		this.put("xmas0Z18" , new Day("xmas0Z18" , "fix=12-24"));
		this.put("xmas0Z22" , new Day("xmas0Z22" , "fix=12-24"));
		this.put("xmasP1"   , new Day("xmasP1"   , "fix=12-25"));
		this.put("xmasP2"   , new Day("xmasP2"   , "fix=12-26"));
		this.put("xmasP3"   , new Day("xmasP3"   , "fix=12-27"));
		this.put("xmasS1"   , new Day("xmasS1"   , "anc2+28"));
		this.put("silv"     , new Day("silv"     , "fix=12-31"));
		this.put("circ"     , new Day("circ"     , "fix=01-01"));
		this.put("circP1"   , new Day("circP1"   , "fix=01-02"));
		this.put("xmasS2"   , new Day("xmasS2"   , "anc0-7"));
		this.put("epi"      , new Day("epi"      , "fix=01-06"));
		this.put("3koen"    , new Day("3koen"    , "fix=01-06"));
		this.put("epi1"     , new Day("epi1"     , "anc0+0"));
		this.put("epi2"     , new Day("epi2"     , "anc0+7"));
		this.put("epi3"     , new Day("epi3"     , "anc0+14"));
		this.put("epi4"     , new Day("epi4"     , "anc0+21"));
		this.put("epi5"     , new Day("epi5"     , "anc0+28"));
		this.put("epi9"     , new Day("epi9"     , "anc1-70"));
		this.put("septu"    , new Day("septu"    , "anc1-63"));
		this.put("sexag"    , new Day("sexag"    , "anc1-56"));
		this.put("estom"    , new Day("estom"    , "anc1-49"));
		this.put("fast0"    , new Day("fast0"    , "anc1-48"));
		this.put("fast1"    , new Day("fast1"    , "anc1-47"));
		this.put("fast2"    , new Day("fast2"    , "anc1-46"));
		this.put("invoc"    , new Day("invoc"    , "anc1-42"));
		this.put("remin"    , new Day("remin"    , "anc1-35"));
		this.put("oculi"    , new Day("oculi"    , "anc1-28"));
		this.put("laeta"    , new Day("laeta"    , "anc1-21"));
		this.put("judic"    , new Day("judic"    , "anc1-14"));
		this.put("palma"    , new Day("palma"    , "anc1-7"));
		this.put("eastM3"   , new Day("eastM3"   , "anc1-3"));
		this.put("eastM2"   , new Day("eastM2"   , "anc1-2"));
		this.put("eastM1"   , new Day("eastM1"   , "anc1-1"));
		this.put("east0"    , new Day("east0"    , "anc1+0"));
		this.put("eastP1"   , new Day("eastP1"   , "anc1+1"));
		this.put("eastP2"   , new Day("eastP2"   , "anc1+2"));
		this.put("quasi"    , new Day("quasi"    , "anc1+7"));
		this.put("quasi"    , new Day("quasi"    , "anc1+7"));
		this.put("miser"    , new Day("miser"    , "anc1+14"));
		this.put("jubil"    , new Day("jubil"    , "anc1+21"));
		this.put("canta"    , new Day("canta"    , "anc1+28"));
		this.put("rogat"    , new Day("rogat"    , "anc1+35"));
		this.put("chrasc"   , new Day("chrasc"   , "anc1+39"));
		this.put("exaud"    , new Day("exaud"    , "anc1+42"));
		this.put("pent0"    , new Day("pent0"    , "anc1+49"));
		this.put("pentP1"   , new Day("pentP1"   , "anc1+50"));
		this.put("pentP2"   , new Day("pentP2"   , "anc1+51"));
		this.put("trin0"    , new Day("trin0"    , "anc1+56"));
		this.put("trin1"    , new Day("trin1"    , "anc1+63"));
		this.put("fronl"    , new Day("fronl"    , "anc1+60"));
		this.put("marasc"   , new Day("marasc"   , "fix=08-15"));
		this.put("trin2"    , new Day("trin2"    , "anc1+70"));
		this.put("trin3"    , new Day("trin3"    , "anc1+77"));
		this.put("trin4"    , new Day("trin4"    , "anc1+84"));
		this.put("trin5"    , new Day("trin5"    , "anc1+91"));
		this.put("trin6"    , new Day("trin6"    , "anc1+98"));
		this.put("trin7"    , new Day("trin7"    , "anc1+105"));
		this.put("trin8"    , new Day("trin8"    , "anc1+112"));
		this.put("trin9"    , new Day("trin9"    , "anc1+119"));
		this.put("trin10"   , new Day("trin10"   , "anc1+126"));
		this.put("trin11"   , new Day("trin11"   , "anc1+133"));
		this.put("trin12"   , new Day("trin12"   , "anc1+140"));
		this.put("trin13"   , new Day("trin13"   , "anc1+147"));
		this.put("trin14"   , new Day("trin14"   , "anc1+154"));
		this.put("trin15"   , new Day("trin15"   , "anc1+161"));
		this.put("trin16"   , new Day("trin16"   , "anc1+168"));
		this.put("trin17"   , new Day("trin17"   , "anc1+175"));
		this.put("trin18"   , new Day("trin18"   , "anc1+182"));
		this.put("trin19"   , new Day("trin19"   , "anc1+189"));
		this.put("trin20"   , new Day("trin20"   , "anc1+196"));
		this.put("trin21"   , new Day("trin21"   , "anc1+203"));
		this.put("trin22"   , new Day("trin22"   , "anc1+210"));
		this.put("trin23"   , new Day("trin23"   , "anc1+217"));
		this.put("trin24"   , new Day("trin24"   , "anc1+224"));
		this.put("trin25"   , new Day("trin25"   , "anc1+231"));
		this.put("trin26"   , new Day("trin26"   , "anc1+238"));
		this.put("trin27"   , new Day("trin27"   , "anc1+245"));
		this.put("martin"   , new Day("martin"   , "fix=11-11"));
		this.put("nikol"    , new Day("nikol"    , "fix=12-06"));
		this.put("trin97"   , new Day("trin97"   , "anc2-21"));
		this.put("trin98"   , new Day("trin98"   , "anc2-14"));
		this.put("busbet"   , new Day("busbet"   , "anc2-11"));
		this.put("trin99"   , new Day("trin99"   , "anc2-7"));
		this.put("trin99"   , new Day("trin99"   , "anc2-7"));
		this.put("erndank"  , new Day("erndank"  , "wrm1.10"));
		this.put("reform"   , new Day("reform"   , "fix=10-31"));
		this.put("augsb"    , new Day("augsb"    , "fix=06-26"));
		this.put("konfir"   , new Day("konfir"   , "var"));
		this.put("kirchw"   , new Day("kirchw"   , "var"));
		this.put("keinht"   , new Day("keinht"   , "var"));
		this.put("evangm"   , new Day("evangm"   , "var"));
		this.put("friede"   , new Day("friede"   , "var"));
		this.put("steph"    , new Day("steph"    , "fix=12-26"));
		this.put("kinder"   , new Day("kinder"   , "fix=12-28"));
		this.put("marpur"   , new Day("marpur"   , "fix=02-02"));
		this.put("marpur"   , new Day("marpur"   , "fix=02-02"));
		this.put("marann"   , new Day("marann"   , "fix=03-25"));
		this.put("marasc"   , new Day("marasc"   , "fix=08-15"));
		this.put("joabapt"  , new Day("joabapt"  , "fix=06-24"));
		this.put("pepaul"   , new Day("pepaul"   , "fix=06-29"));
		this.put("marvis"   , new Day("marvis"   , "fix=07-02"));
		this.put("michael"  , new Day("michael"  , "fix=09-29"));
		this.put("hallow"   , new Day("hallow"   , "fix=11-01"));
		this.put("hallos"   , new Day("hallos"   , "fix=11-02"));
		this.put("wverein"  , new Day("wverein"  , "fix=10-03"));
		this.put("may1"     , new Day("may1"     , "fix=05-01"));
		this.put("nyear"    , new Day("nyear"    , "fix=01-01"));
    }

    /** Pattern for (ISO date, separator, name) */
    private static Pattern ISO_NAME_PATTERN 
            = Pattern.compile("\\A(\\d{4})\\-(\\d\\d)\\-(\\d\\d)\\W+(\\w+)");
            /*                      1         2          3          4   */

    /** Parses a text file, and tries to recognize
     *  number words in the lines.
     *  Print
     *  @param fileName name of the file to be parsed,
     *  or read from STDIN if null or empty
     */
    public void parseFile(String fileName) {
        int year = 0;
        EasterCalendar calendar = new EasterCalendar(year);
        try {
            BufferedReader reader = new BufferedReader
                    ((fileName != null && fileName.length() <= 0)
                    ? new InputStreamReader(System.in, "UTF-8")
                    : Channels.newReader((new FileInputStream (fileName)).getChannel(), "UTF-8"));
            String line = null; // current line from text file
            while ((line = reader.readLine()) != null) { 
                System.out.print(line);
                Matcher matcher = ISO_NAME_PATTERN.matcher(line);
                if (matcher.lookingAt()) {
                    int myear = Integer.parseInt(matcher.group(1));
                    int mmon  = Integer.parseInt(matcher.group(2));
                    int mday  = Integer.parseInt(matcher.group(3));
                    String mname = (matcher.group(4));
                    if (myear != year) {
                        calendar = new EasterCalendar(myear);
                        year = myear;
                    }
                    Day day = calendar.computeHolyDay(mname);
                    if (day != null) {
                        String isoDate = day.getYear()
                                + "-" + Integer.toString(day.getMonth() + 100).substring(1)
                                + "-" + Integer.toString(day.getDay  () + 100).substring(1)
                                ;
                        if (myear == day.getYear() && mmon == day.getMonth() && mday == day.getDay()) {
                            System.out.print(" -> ok");
                        } else {
                            System.out.print(" <> " + isoDate);
                        }   
                    } else if (! mname.equals("profan")) {
                        System.out.print(" ?? no formula or not recognized");
                    }
                } else { // doesn't match
                    // System.out.print(" ?? no proper input format: ISO_DATE SEP NAME");               
                }
                System.out.println();
            } // while ! eof
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
            exc.printStackTrace();
        } 
    } // parseFile

    /** Prints all Sundays and holy days in a year
     *  @param year list holy days for this year 
     *  (or for the current year if = 0)
     */
    public void printDays(int year) {
        try {
            EasterCalendar calendar = new EasterCalendar(year);
            TreeMap/*1.5*/<String, String>/*1.5*/ sortedDays = new TreeMap/*1.5*/<String, String>/*1.5*/();
            Iterator iter = this.keySet().iterator();
            while (iter.hasNext()) {
                String name = (String) iter.next();
                Object obj = this.get(name);
                if (obj != null) {
                    Day day = (Day) obj;
                    String formula = day.getFormula();
                    Day holyDay = calendar.computeHolyDay(day.getName());
                    if (holyDay != null) {
                        String isoDate = holyDay.getYear()
                                + "-" + Integer.toString(holyDay.getMonth() + 100).substring(1)
                                + "-" + Integer.toString(holyDay.getDay  () + 100).substring(1)
                                ;
                        sortedDays.put(isoDate, name + "\t" + formula);
                    }
                }
            } // while hasNext
            
            // now print sorted dates and names 
            iter = sortedDays.keySet().iterator();
            while (iter.hasNext()) {
                String isoDate = (String) iter.next();
                String name    = (String) sortedDays.get(isoDate);
                System.out.println(isoDate +  "\t" + name);
            } // while printing
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
            exc.printStackTrace();
        } 
    } // parseFile

    /** Main program:
     *  <ul>
     *  <li>prints all Sundays and holy days in a specified year
     *  (current year if missing), or<li>
     *  <li>checks a file (or System.in if missing) 
     *  with dates and named holy days.</li>
     *  </ul>
     *  @param args commandline arguments; if missing, print the following:
     *  <pre>
     *  usage:\tjava org.teherba.churchcal.DayMap [-year [nnnn] | -parse [filename]]
     *  </pre>
     */
    public static void main(String args[]) {
        int iarg = 0;
        if (iarg >= args.length) {
            System.err.println("usage:\tjava org.teherba.churchcal.DayMap"
                    + " [-year nnnn | -parse [filename]]\n"
                    );
        } else {
            String action = args[iarg ++];
            DayMap holyDayMap = new DayMap();
            if (false) {
            } else if (action.startsWith("-p")) {
                String fileName = null;
                if (iarg < args.length) {
                    fileName = args[iarg ++];
                }
                holyDayMap.parseFile(fileName);
            } else if (action.startsWith("-y")) {
                int year = 0;
                if (iarg < args.length) {
                    year = Integer.parseInt(args[iarg ++]);
                }
                holyDayMap.printDays(year);
            } else {
                System.err.println("invalid action \"" + action + "\"");
            }
        }
    } // main
    
} // DayMap (generated)
