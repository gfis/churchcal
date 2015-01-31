/*  Calculates a specialized calendar with holidays for some year.
    @(#) $Id: CalendarService.java 869 2012-02-01 07:12:36Z gfis $
	2011-01-28: rename ChurchCalendar to MainCalendar
    2008-04-09: 4th parameter 'language'
    2007-02-12: renamed from calwork
    2005-12-02: copied from checkdig

    Service to be called via SOAP, offering the functions of ChurchCalendar
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
import  org.teherba.churchcal.MainCalendar;
/**
 *  Calculates a specialized calendar with holidays for some year.
 *  This class is the SOAP service interface to <em>ChurchCalendar</em>,
 *  and ressembles the functionality of the commandline interface
 *  in that class.
 *  @author Dr. Georg Fischer
 */
public class CalendarService {
    public final static String CVSID = "@(#) $Id: CalendarService.java 869 2012-02-01 07:12:36Z gfis $";

    /** initialize a calendar object */
    private static MainCalendar calendar = new MainCalendar();   

    /**	Returns the results of an activation of <em>ChurchCalendar</em>
     *  to a SOAP client.
     *  @param language ISO language code
     *  @param variant code for example for a confession/church.
     *  @param year calculate the calendar table for this year
     *  @param format one of "table", "html", "sql", "xml"
     *  @return
     *  string table with 365(366) lines and the following columns:
     *  <ul>
     *  <li>year</li>
     *  <li>day number in year(1-366)</li>
     *  <li>month (1-12)</li>
     *  <li>day number in month(1-31)</li>
     *  <li>day number in week(1 = Sunday, 7 = Saturday)</li>
     *  <li>week number</li>
     *  <li>work day code</li>
     *  <li>color(RGB in 6 hex digits)</li>
     *  <li>description of the (holi-)day</li>
     *  </ul>
     */
    public String getResponse(String language, String variant, String year, String format)  {
        String response = "";
        try {
            String newPage = "index";
            if (false) {
            } else if   (true) {
            	// no parameter checking
            } else { // invalid variant
                response = "001 - invalid variant";
                newPage = "message";
            }
            if (newPage.equals("index")) {
                response = calendar.process(new String[] { language, variant, year, format });
            }
            else {
                response = "error " + response;
            }
        } catch (Exception exc) {
            System.err.println(exc.getMessage());
            exc.printStackTrace();
        }
        return response;
    } // getResponse
    
} // CalendarService
