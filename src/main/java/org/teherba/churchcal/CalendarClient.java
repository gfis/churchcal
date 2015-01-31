/*  SOAP Client which calls CalendarService
    @(#) $Id: CalendarClient.java 83 2009-02-12 19:23:13Z gfis $
	2008-12-10: use service.properties
    2008-04-09: 4th parameter 'language'
    2007-02-12: renamed from calwork
    2005-12-02, Dr. Georg Fischer
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
import  org.apache.axis.client.Call;
import  org.apache.axis.client.Service;
import  java.io.File;
import  java.io.FileInputStream;
import  java.util.Properties;
import  javax.xml.namespace.QName;

/** Calculates a specialized calendar with holidays for some year.
 *  This class uses the SOAP service interface to <em>ChurchCalendar</em>,
 *  and ressembles the functionality of the commandline interface
 *  in that class.
 *  @author Dr. Georg Fischer
 */
public class CalendarClient {
    public final static String CVSID = "@(#) $Id: CalendarClient.java 83 2009-02-12 19:23:13Z gfis $";

    /**	Activates the {@link CalendarService} via SOAP
     *  @param args arguments on the commandline:
     *  <ul>
     *  <li>ISO language code and variant: deu, eng, fra</li>
     *	<li>variant: ev, rk, tar</li>
     *  <li>year</li>
     *  <li>format: table, html, sql, xml</li>
     *  </ul>
     */
    public static void main(String [] args) {
        try {
	        Properties props = new Properties();
    	    String propsName = "service.properties";
    	    props.load(CalendarClient.class.getClassLoader().getResourceAsStream(propsName)); // (1) load from classpath (jar)
    	    File propsFile = new File(propsName);
    	    if (propsFile.exists()) {
    	        props.load(new FileInputStream(propsFile)); // (2) add any properties from a file in the current directory
    	    }
        	String axisURL = props.getProperty("axis_url", "http://localhost:8180/axis");

            String   endpoint = axisURL + "/services/CalendarService";
            Service  service  = new Service();
            Call     call     = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName(new QName(axisURL, "getResponse"));
            call.addParameter("language", org.apache.axis.Constants.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            call.addParameter("variant" , org.apache.axis.Constants.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            call.addParameter("year"    , org.apache.axis.Constants.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            call.addParameter("format"  , org.apache.axis.Constants.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            call.setReturnType(org.apache.axis.Constants.XSD_STRING);
			String language = "deu";
            String variant  = "ev";
            String year     = "0";
            String format   = "xml";
            int iargs = 0;
            if (iargs < args.length) {
                language = args[iargs ++];
	            if (iargs < args.length) {
	                variant  = args[iargs ++];
	                if (iargs < args.length) {
	                    year    = args[iargs ++];
	                    if (iargs < args.length) {
	                        format  = args[iargs ++];
	                    } // with format
	                } // with year
	            } // with variant
            } // with language
            if (format.equals("xml") || format.equals("html")) {
	            call.setReturnType(org.apache.axis.Constants.XSD_ANYTYPE);
	        }
            String ret = (String) call.invoke( new Object[] { language, variant, year, format } );
            System.out.println(ret);
        } catch (Exception exc) {
            System.err.println(exc.getMessage());
            exc.printStackTrace();
        }
    } // main
    
} // CalendarClient
