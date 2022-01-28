/*  Output a Table of Calendar Days
    @(#) $Id: MainCalendar.java 882 2012-02-12 21:09:04Z gfis $
    2012-01-14: renamed from MainCalendar
	2008-04-09: splitted into BaseCalendar and EasterCalendar
	2008-04-03: year 1583..4099; CalendarFactory
    2007-02-12: renamed from calwork
    2007-01-15: TRINITATIS
    2005-11-25: copied from checkdig
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
import  org.teherba.churchcal.CalendarFactory;
import  org.teherba.churchcal.BaseCalendar;
import  java.io.StringWriter;
import  org.apache.logging.log4j.Logger;
import  org.apache.logging.log4j.LogManager;

/** Implements the commandline interface to various calendar output classes.
 *  @author Dr. Georg Fischer
 */

public class MainCalendar {
    public final static String CVSID = "@(#) $Id: MainCalendar.java 882 2012-02-12 21:09:04Z gfis $";

    /** log4j logger (category) */
    private Logger log;
    /** newline string (CR/LF or LF only) */
    private String nl = null;

    /** No-args Constructor
     */
    public MainCalendar() {
        log = LogManager.getLogger(MainCalendar.class.getName());
    } // MainCalendar

    /** Convenience overlay method with a single string argument instead
     *  of an array of strings.
     *  @param commandLine all parameters of the commandline in one string
     *  @return output of the call depending on the function: a digit sequence,
     *  a number word, a month name etc.
     */
    public String process(String commandLine) {
        return process(commandLine.split("\\s+"));
    } // process (String)

    /** Evaluates the arguments of the command line, and processes them.
     *  @param args Arguments; if missing, print the following:
     *  <pre>
     *  usage:\tjava org.teherba.churchcal.MainCalendar language variant [-s] year format
     *        \tlanguage = deu, eng, fra ...
     *        \tvariant = ev, rk ...
     *        \-s : Sundays and Holidays only
     *		  \tyear 1583..4099
     *        \tformat = html, table, sql, ical/ics ...
     *  </pre>
     *  @return
     *  string table with 365(366) lines and the following columns:
     *  <ul>
     *  <li>year</li>
     *  <li>day number in year(1-366)</li>
     *  <li>month (1-12)</li>
     *  <li>day number in month(1-31)</li>
     *  <li>day number in week(1 = Sunday, 7 = Saturday)</li>
     *  <li>week number</li>
     *  <li>attributes for the day as a bit pattern</li>
     *  <li>description of the (holi-)day</li>
     *  </ul>
     */
    public String process(String args[]) {
        nl = System.getProperty("line.separator");
        /** internal buffer for the string to be output */
        StringWriter out = new StringWriter(16384);
        try {
            int iarg = 0; // index for command line arguments
            if (iarg >= args.length) { // usage
                out.write("usage:\tjava org.teherba.churchcal.MainCalendar"
                		+" [language [variant [-s] [year [format]]]]" + nl);
                out.write("      \tlanguage = deu, eng, fra ..." + nl);
                out.write("      \tvariant = ev, rk, tr ..." + nl);
                out.write("      \t-s : Sundays and Holidays only" + nl);
                out.write("      \tyear 1583..4099" + nl);
                out.write("      \tformat = html, java, sql, table, xml ..." + nl);
            } else { // >= 1 argument
                String 	language 	= "deu";
                String 	variant  	= "ev";
                boolean sundaysOnly	= false;
                int 	year 		= 0; // assume current year
                String 	format 		= "xml";
                if (iarg < args.length) {
                	language = args[iarg ++];
	                if (iarg < args.length) {
	                	variant  = args[iarg ++];
		                if (iarg < args.length) { // another argument is present
		                    if (args[iarg].equals("-s")) {
		                        sundaysOnly = true;
		                        iarg ++;
		                    }
			                if (iarg < args.length) { // year argument is present
			                    try {
			                        year = Integer.parseInt(args[iarg ++]);
			                    } catch (NumberFormatException exc) {
			                        out.write("invalid year");
			                    }
				                if (iarg < args.length) { // format argument is present
				                    format = args[iarg ++];
				                } // with format
			                } // with year
		                } // with -s
	                } // with variant
                } /* with language */
				String uri = null;
				
                BaseCalendar calendar = (new CalendarFactory()).getCalendar(language, variant, year, uri);
                if (calendar != null) { // a calendar was found
                    if (sundaysOnly) {
                        calendar.setSubset("sunday");
                    }
					calendar.printFormatted(out, format);
                } // factory found a calendar 
            } // args.length >= 1
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
        return out.toString();
    } // process (String[])

    /** Main program, processes the commandline arguments
     *  @param args Arguments; if missing, print the following:
     *  <pre>
     *  usage:\tjava org.teherba.churchcal.MainCalendar iso_variant [-s] year format
     *        \tiso = de, en, fr 
     *        \tvariant = ev, rk, tar 
	 *		  \tyear 1583..4099
     *        \-s : Sundays and Holidays only
     *        \tformat = html, java, sql, table, xml
     *  </pre>
     */
    public static void main(String args[]) {
        MainCalendar calendar = new MainCalendar();
        System.out.print(calendar.process(args));
    } // main

} // MainCalendar
