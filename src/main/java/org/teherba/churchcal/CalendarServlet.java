/*  Servlet interface to class WorkCalendar
    @(#) $Id: CalendarServlet.java 901 2012-03-10 18:13:36Z gfis $
    2012-03-08: uploaded files go to java.io.tmpdir
    2012-02-10: all JSPs replaced by View*.java
	2012-02-06: BaseCalendar, read customization file's name from form fields
    2008-03-31: call XML
    2007-02-12: renamed from calwork
    2007-01-12: TRINITATIS
    2005-12-02, Georg Fischer: copied from numword
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
import  org.teherba.churchcal.ViewIndex;
import  org.teherba.churchcal.ViewMessage;
import  org.teherba.churchcal.ViewMetaInf;
import  java.io.BufferedReader;
import  java.io.File;
import  java.io.IOException;
import  java.util.Calendar;
import  java.util.Iterator;
import  java.util.List;
import  javax.servlet.RequestDispatcher;
import  javax.servlet.ServletConfig;
import  javax.servlet.ServletContext;
import  javax.servlet.ServletException;
import  javax.servlet.http.HttpServlet;
import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;
import  javax.servlet.http.HttpSession;
import  org.apache.commons.fileupload.FileItem;
import  org.apache.commons.fileupload.FileItemFactory;
import  org.apache.commons.fileupload.disk.DiskFileItemFactory;
import  org.apache.commons.fileupload.servlet.ServletFileUpload;
import	org.apache.commons.fileupload.servlet.ServletRequestContext; // for request's length
import  org.apache.commons.io.output.DeferredFileOutputStream;
import  org.apache.log4j.Logger;

/** Calculate a specialized calendar with holidays for some year.
 *  This class is the servlet interface to <em>WorkCalendar</em>,
 *  and ressembles the functionality of the commandline interface
 *  in that class.
 *  @author Dr. Georg Fischer
 */
public class CalendarServlet extends HttpServlet {
    public final static String CVSID = "@(#) $Id: CalendarServlet.java 901 2012-03-10 18:13:36Z gfis $";
    // public final static long serialVersionUID = 19470629;
    /** log4j logger (category) */
    private Logger log;

    /** Called by the servlet container to indicate to a servlet
     *  that the servlet is being placed into service.
     *  @param config object containing the servlet's configuration and initialization parameters
     *  @throws ServletException
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // ???
        log = Logger.getLogger(CalendarServlet.class.getName());
    } // init

    /** Processes an http GET request
     *  @param request request with header fields
     *  @param response response with writer
     *  @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        generateResponse(request, response);
    } // doGet

    /** Processes an http POST request
     *  @param request request with header fields
     *  @param response response with writer
     *  @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        generateResponse(request, response);
    } // doPost

	/** Maximum reasonable length of all input fields */
	private static final int MAX_INPUT = 256;
	
    /** Gets the value of an HTML input field, maybe as empty string
     *  @param request request for the HTML form
     *  @param name name of the input field
     *  @return non-null (but possibly empty) string value of the input field
     */
    private String getInputField(HttpServletRequest request, String name) {
        String value = request.getParameter(name);
        if (value == null || value.length() == 0) {
            value = "";
        } else if (value.length() > MAX_INPUT) { // sufficient for this application
            value = value.substring(0, MAX_INPUT);
        }
        return value;
    } // getInputField

    /** Gets the string value of an HTML input (parameter) field, and if it is not set, pass some default value
     *  @param request request for the HTML form
     *  @param name name of the input field
     *  @param defaultValue default value of the parameter
     *  @return non-null (but possibly empty) string value of the input field
     */
    private String getInputField(HttpServletRequest request, String name, String defaultValue) {
        String value = request.getParameter(name);
        if (value == null || value.length() == 0) {
            value = defaultValue;
        } else if (value.length() > MAX_INPUT) { // sufficient for this application
            value = value.substring(0, MAX_INPUT);
        }
        return value;
    } // getInputField

    /** Gets the integer value of an HTML input (parameter) field, and if it is not set, pass some default value
     *  @param request request for the HTML form
     *  @param name name of the input field
     *  @param defaultValue default value of the parameter
     *  @return non-null (but possibly empty) string value of the input field
     */
    private int getInputField(HttpServletRequest request, String name, int defaultValue) {
        String value = request.getParameter(name);
        int result = defaultValue;
        if (value != null) {
	        if (value.length() > MAX_INPUT) { // sufficient for this application
    	        value = value.substring(0, MAX_INPUT);
        	}
        	try {
            	result = Integer.parseInt(value);
            } catch (Exception exc) {
            	// take the default for NumberFormatExceptions
            }
        }
        return result;
    } // getInputField

	/** maximum length of HTTP request, and thus customization file */
	private static final int MAX_SIZE = 65535;

    /** Generates the response (HTML page) for an http request
     *  @param request request with header fields
     *  @param response response with writer
     *  @throws IOException
     */
    public void generateResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	request.setCharacterEncoding("UTF-8");  
        HttpSession session = request.getSession();
		String newPage 		= "index";
		String language 	= "deu";
		String variant 		= "pol";
		String format       = "html";
		String formYear    	= "0";
		String month1       = "1";
		String customization= null; // all lines of the customization, length is limited to MAX_SIZE
		int    tabYear      = 0;
    	String view 		= null;
   		ServletRequestContext context = new ServletRequestContext(request);
    	try {
    		String contentType = context.getContentType(); 
    		if (contentType == null) {
    			view = "index";
    		} else if (! contentType.startsWith("multipart/")) {
		    	newPage = "message";
		        session.setAttribute("messno"  , "006"); //  "request without a file upload field"
			} else if (context.getContentLength() <= MAX_SIZE ) {
			    DiskFileItemFactory fuFactory = new DiskFileItemFactory(); // Create a factory for disk-based file items
			    fuFactory.setSizeThreshold(MAX_SIZE);
			    fuFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			    ServletFileUpload upload  = new ServletFileUpload(fuFactory); // Create a new file upload handler
			    upload.setSizeMax(MAX_SIZE);
			    List items = upload.parseRequest(request); // Parse the request
			    FileItem fileItem = null; // no uploaded file seen so far
			    Iterator iter = items.iterator();
			    while (iter.hasNext()) { // process the uploaded items
			        FileItem item = (FileItem) iter.next();
			        if (item.isFormField()) {
			            String name  = item.getFieldName();
			            String value = item.getString();
			            session.setAttribute(name, value);
			            if (false) {
			            } else if (name.equals("view"		)) { view		= value;
			            } else if (name.equals("language"	)) { language	= value;
			            } else if (name.equals("variant"	)) { variant	= value;
			            } else if (name.equals("format" 	)) { format		= value;
			            } else if (name.equals("year"		)) { formYear	= value;
			            } else if (name.equals("month1" 	)) { month1		= value;
			            } else { // unknown field name
			            }
			        } else { // no formField - uploaded fileItem
			            fileItem = item;
			            customization = fileItem.getString("ISO-8859-1");
			        }
			    } // while uploaded items
			    tabYear = 0;
			    try {
			    	tabYear = Integer.parseInt(formYear);
			    } catch (Exception exc) { // ignore
				}
		    } else {
		    	newPage = "message";
		        session.setAttribute("messno"  , "007"); //  "customization file too long (&gt; 8 kB)"
			}
        } catch (Exception exc) {
            response.setContentType("text/plain");
            response.getWriter().write(exc.getMessage() + ", content-type=" + context.getContentType());
        }
		/*--------------------------------------------------------------*/
        if (view == null || view.length() == 0 || view.equals("index")) {
			(new ViewIndex		()).forward(request, response);
		} else if (view.equals("show")) {
	        try {
				BaseCalendar calendar = null;
			    calendar = (new CalendarFactory()).getCalendar(language, variant, tabYear, customization);
			    calendar.setOption("month1", month1);
			    tabYear  = calendar.getYear();
			    session.setAttribute("year", String.valueOf(tabYear));
	            if (newPage.equals("message")) { 
	            	// error code set above
	            } else if (calendar == null) { // invalid variant
	                newPage = "message";
	                session.setAttribute("messno"  , "002"); // invalid variant
	                session.setAttribute("parm"    , variant);
	                session.setAttribute("par2"    , language);
	            } else {
	                tabYear = calendar.getYear();
		            if  (tabYear != 0 && (
		            	  		tabYear < calendar.getMinimum(Calendar.YEAR)  
	                    	||  tabYear > calendar.getMaximum(Calendar.YEAR) 
		                	)) { // not 0 and not in 1583..4099
		                newPage = "message";
		                session.setAttribute("messno"  , "004"); // year not in range
		                session.setAttribute("parm"    , String.valueOf(tabYear));
		                tabYear  = 0;
		            } else {
		    		}
	            } // check input form fields
	
	            if (newPage.equals("message")) {
	                // message set above
	        	} else if (format.startsWith	("htm"	)) {
	                response.setContentType("text/html;charset=UTF-8");
	                calendar.printHTML(response.getWriter(), 6);
	        	} else if (format.startsWith	("ic" 	)) {
	                response.setContentType("text/plain");
	                calendar.printICalendar(response.getWriter());
	        	} else if (format.startsWith	("jav"  )) {
	                response.setContentType("text/plain");
	                calendar.printJava(response.getWriter());
	        	} else if (format.equals		("sql"  )) {
	                response.setContentType("text/plain");
	                calendar.printSQL(response.getWriter());
	        	} else if (format.startsWith	("tab"	)) {
	                response.setContentType("text/plain");
	                calendar.printTSV(response.getWriter());
	        	} else if (format.equals		("tsv"  )) {
	                response.setContentType("text/plain");
	                calendar.printTSV(response.getWriter());
	        	} else if (format.equals		("xml"  )) {
	                response.setContentType("text/xml;charset=UTF-8");
	                calendar.printXML(response.getWriter());
	            } else { // invalid format
	                newPage = "message";
	                session.setAttribute("messno"  , "005"); // invalid format
	                session.setAttribute("parm"    , format);
	            }
	
	            if (! newPage.equals("message")) { // valid input field values
	                session.setAttribute("calendar" , calendar);
	                session.setAttribute("format"   , format);
	                session.setAttribute("variant"  , variant);
	                session.setAttribute("year"     , String.valueOf(tabYear));
	                session.setAttribute("month1"   , String.valueOf(month1));
	            } else {
	   				(new ViewMessage	()).forward(request, response);
				/*
	                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + newPage + ".jsp");
	                dispatcher.forward(request, response);
	            */
	            }
	        } catch (Exception exc) {
	            response.setContentType("text/plain");
	            response.getWriter().write(exc.getMessage());
	        }
		} else if (view.equals("license")
				|| view.equals("manifest")
				|| view.equals("notice")
				) {
			(new ViewMetaInf	()).forward(request, response);
		} else {
			// unknown view
		}		
    } // generateResponse

} // CalendarServlet
