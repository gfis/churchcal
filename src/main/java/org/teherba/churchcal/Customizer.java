/*  Read styles and descriptions for the customization of a calendar
    @(#) $Id: Customizer.java 969 2012-10-03 19:31:41Z gfis $
    2012-02-01, Georg Fischer

    Caution, this file must use UTF-8 encoding (äöüÄÖÜß)!
*/
/*
 * Copyright 2012 Dr. Georg Fischer <punctum at punctum dot kom>
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
import  org.teherba.churchcal.BaseCalendar;
import  org.apache.log4j.Logger;

/** Read styles and descriptions for the customization of a calendar
 *	from a text file, and attach them to the days array
 *	of a standard calendar.
 *  @author Dr. Georg Fischer
 */
public class Customizer {
    public final static String CVSID = "@(#) $Id: Customizer.java 969 2012-10-03 19:31:41Z gfis $";

    /** log4j logger (category) */
    private Logger log;

    /** No-args Constructor
     */
    public Customizer() {
        log = Logger.getLogger(Customizer.class.getName());
    } // constructor (0)

    /** Initializes some customizable properties of a calendar: styles, explanation
     *	@param calendar attach descriptions to days of this calendar
     */
    public void initialize(BaseCalendar calendar) {                                   
    	// the leading space in the following CSS property strings declares these styles as system defined
		calendar.setStyle("hli", " color:white ; background-color: tomato      ");
		calendar.setStyle("hly", " color:white ; background-color: crimson     ");
		calendar.setStyle("hwk", " color:black ; background-color: khaki       ");
		calendar.setStyle("lea", " color:black ; background-color: lightblue   ");
		calendar.setStyle("sat", " color:black ; background-color: wheat       ");
		calendar.setStyle("sun", " color:black ; background-color: gold	 	  ");
		calendar.setStyle("vac", " color:black ; background-color: gainsboro   ");
		calendar.setStyle("und", " color:black ; background-color: white       ");
		calendar.setStyle("wrk", " color:black ; background-color: ghostwhite  ");
                                                             
		calendar.setStyle("red", " color:white ; background-color: crimson     ");
		calendar.setStyle("vio", " color:white ; background-color: darkviolet  ");
		calendar.setStyle("blk", " color:white ; background-color: black       ");
		calendar.setStyle("wht", " color:black ; background-color: white       ");
		calendar.setStyle("grn", " color:white ; background-color: forestgreen ");
		
		calendar.setOption("explainMonth" , "02"); 
		calendar.setOption("explainHeader", "Farbschema:");
    } // initialize
    
    /** Processes the definition of an appointment series, 
     *	and sets the appointment of the corresponding day(s)
     *	@param calendar attach descriptions to days of this calendar
     *	@param fields definition with keyword, day(s), week(day(s)), month(s),
     *	time and purpose of the appointment(s)
     */
    protected void processFields(BaseCalendar calendar, String[] fields) {
    	int ifld = 0;
    	int flen = fields.length;
   		int[] numbers = new int[flen];
    	while (ifld < flen) { // try to convert all fields to integers
	        try {
	    		numbers[ifld] = Integer.parseInt(fields[ifld].trim());
    	    } catch (Exception exc) {
    	    	numbers[ifld] = -1;
        	}
        	ifld ++;
        } // while ifld
        int dayOfYear = 0;
        int endDay    = 0;
		ifld = 0;
    	if (flen >= 1) { // at least a keyword ist present
	    	String keyword = fields[ifld ++].trim();
			if (false) {
	    	} else if (keyword.startsWith("exp") && fields.length >= 3) { // explain|02|Farbschema:
	    		calendar.setOption("explainMonth",  fields[ifld].trim());
	    		calendar.setOption("explainHeader", fields[ifld + 1].trim());
	    		
	    	} else if (keyword.startsWith("fer") && fields.length >= 5) { // Ferien t1,m1 bis t2,m2
				dayOfYear = calendar.getDayOfYear(numbers[ifld + 1], numbers[ifld + 0]); ifld += 2;
				endDay    = calendar.getDayOfYear(numbers[ifld + 1], numbers[ifld + 0]); ifld += 2;
				while (dayOfYear <= endDay) {
					if (calendar.days[dayOfYear].getAttributes() == Day.WORKING) {
	    				calendar.days[dayOfYear].orAttributes(Day.VIOLET);
    				}
    				dayOfYear ++;
				} // while dayOfYear
				ifld ++;
				// fer = Ferien t1,m1 bis t2,m2

	    	} else if (keyword.matches("(gtag|fix)") && flen >= 3) { // Geburtstag
	    		// gtag|28|09|Erika|1955 in Freiburg|http://gfis.eu
				dayOfYear = calendar.getDayOfYear(numbers[ifld + 1], numbers[ifld + 0]); ifld += 2;
				calendar.days[dayOfYear].addAppointment(" "
					, (keyword.equals("gtag") ? "* " : "") + fields[ifld ++].trim());
				if (ifld < flen) { // with toolTip
					calendar.days[dayOfYear].setToolTip(fields[ifld ++]);
				} // with toolTip
				if (ifld < flen) { // with URL
					calendar.days[dayOfYear].setURL(fields[ifld ++]);
				} // with URL
				// gtag = Geburtstag
				
	    	} else if (keyword.matches("(term)") && flen >= 3) { // Termin mit optionaler Zeit
	    		// term|28|09|19:00|Gottesdienst
				dayOfYear = calendar.getDayOfYear(numbers[ifld + 1], numbers[ifld + 0]); ifld += 2;
				calendar.days[dayOfYear].addAppointment(fields[ifld + 0], fields[ifld + 1].trim());
				if (ifld < flen) { // with toolTip
					calendar.days[dayOfYear].setToolTip(fields[ifld ++]);
				} // with toolTip
				if (ifld < flen) { // with URL
					calendar.days[dayOfYear].setURL(fields[ifld ++]);
				} // with URL
				// gtag = Geburtstag
				
	    	} else if (keyword.startsWith("raw") && fields.length >= 5) { // Range of working days
				dayOfYear = calendar.getDayOfYear(numbers[ifld + 1], numbers[ifld + 0]); ifld += 2;
				endDay    = calendar.getDayOfYear(numbers[ifld + 1], numbers[ifld + 0]); ifld += 2;
				while (dayOfYear <= endDay) {
					if (calendar.days[dayOfYear].getAttributes() == Day.WORKING) {
						calendar.days[dayOfYear].addAppointment(" ", fields[ifld].trim());
    				}
    				dayOfYear ++;
				} // while dayOfYear
				ifld ++;
				// raw t1,m1 to t2,m2

	    	} else if (keyword.startsWith("style") && fields.length >= 3) { // CSS Style|class|properties
				String className     = fields[ifld ++].trim();
				String cssProperties = fields[ifld ++].trim(); // system defined properties start with a space
				calendar.setStyle(className, cssProperties);
		
	    	} else if (keyword.startsWith("title") && fields.length >= 2) { // title of calender
				calendar.setTitle(fields[ifld ++]);

	    	} else if (keyword.startsWith("wmon") && fields.length >= 4) { // m. Tag der n. Woche im Monat
				// int week  = Integer.parseInt(fields[ifld ++].trim());
				// String wdayAbbr  =              fields[ifld ++].trim();
				int month = 1;
				int day = 1;
				while (month <= 12) {
    				calendar.setDay(month, day, " ", "* " + fields[ifld ++].trim());
					month ++;
				} // while month
				// wmon = m. Tag der n. Woche im Monat

			}
		} // at least a keyword
    } // processFields

    /** Reads the settings for customized appointments from a string
     *  consisting of lines separated by newlines; 
     *	do nothing if the string is null.
     *	@param calendar attach descriptions to days of this calendar
     *	@param customization read from this string
     */
    protected void readCustomization(BaseCalendar calendar, String customization) {
    	if (customization != null) {
	    	String[] lines = customization.split("[\r\n]+");
			int iline = 0;
			while (iline < lines.length) {
				processFields(calendar, lines[iline ++].split("\\|"));
			} // while reading
		} // if customization != null
    } // readCustomization

    /** Reads the settings for customized appointments from an URI
     *	@param calendar attach descriptions to days of this calendar
     *	@param uri read from this Universal Resource Identifier (URL or URN)
     */
/*
    protected void readURI(BaseCalendar calendar, String uri, String deprecated) {
        if (uri != null && uri.length() > 0 && ! uri.startsWith("data:")) { // maybe we redefine those styles  	
	        try {
	        	// System.err.println("URI=" + getURI() + ", log=" + log.toString());
				URIReader in = new URIReader(calendar.getURI());
				if (in == null) { // assume some default uri
					in = new URIReader("file:///home/gfis/test2.tmp");
				} // default uri
				String line = "";
				int day = 1;
				int iline = 0;
				while ((line = in.readLine()) != null) {
					processFields(calendar, line.split("\\|"));
				} // while reading
				in.close();
	        } catch (Exception exc) {
	            log.error(exc.getMessage(), exc);
	        }
		} // if uri is set
    } // readURI
*/
} // Customizer
