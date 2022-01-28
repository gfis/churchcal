/*  Servlet interface to class WorkCalendar
 *  @(#) $Id: ChurchcalServlet.java 901 2012-03-10 18:13:36Z gfis $
 *  2017-05-29: javadoc 1.8
 *  2016-10-13: less imports, no try..catch
 *  2016-10-03: getContentLength was deprecated
 *  2016-09-03: with BasePage; without session
 *  2012-03-08: uploaded files go to java.io.tmpdir
 *  2012-02-10: all JSPs replaced by View*.java
 *  2012-02-06: BaseCalendar, read customization file's name from form fields
 *  2008-03-31: call XML
 *  2007-02-12: renamed from calwork
 *  2007-01-12: TRINITATIS
 *  2005-12-02, Georg Fischer: copied from numword
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

package org.teherba.churchcal.web;
import  org.teherba.churchcal.CalendarFactory;
import  org.teherba.churchcal.BaseCalendar;
import  org.teherba.churchcal.web.IndexPage;
import  org.teherba.churchcal.web.Messages;
import  org.teherba.common.web.BasePage;
import  org.teherba.common.web.MetaInfPage;
import  java.io.File;
import  java.io.IOException;
import  java.util.Calendar;
import  java.util.Iterator;
import  java.util.List;
import  javax.servlet.ServletConfig;
import  javax.servlet.ServletException;
import  javax.servlet.http.HttpServlet;
import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;
import  org.apache.commons.fileupload.FileItem;
import  org.apache.commons.fileupload.disk.DiskFileItemFactory;
import  org.apache.commons.fileupload.servlet.ServletFileUpload;
import  org.apache.commons.fileupload.servlet.ServletRequestContext; // for request's length
import  org.apache.logging.log4j.Logger;
import  org.apache.logging.log4j.LogManager;

/** Calculate a specialized calendar with holidays for some year.
 *  This class is the servlet interface to <em>WorkCalendar</em>,
 *  and ressembles the functionality of the commandline interface
 *  in that class.
 *  @author Dr. Georg Fischer
 */
public class ChurchcalServlet extends HttpServlet {
    public final static String CVSID = "@(#) $Id: ChurchcalServlet.java 901 2012-03-10 18:13:36Z gfis $";
    // public final static long serialVersionUID = 19470629;

    /** URL path to this application */
    private String applPath;
    /** log4j logger (category) */
    private Logger log;
    /** common code and messages for auxiliary web pages */
    private BasePage basePage;
    /** name of this application */
    private static final String APP_NAME = "ChurchCal";

    /** Called by the servlet container to indicate to a servlet
     *  that the servlet is being placed into service.
     *  @param config object containing the servlet's configuration and initialization parameters
     *  @throws ServletException for servlet errors
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // ???
        log = LogManager.getLogger(ChurchcalServlet.class.getName());
        basePage = new BasePage(APP_NAME);
        Messages.addMessageTexts(basePage);
    } // init

    /** Processes an http GET request
     *  @param request request with header fields
     *  @param response response with writer
     *  @throws IOException for IO errors
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        generateResponse(request, response);
    } // doGet

    /** Processes an http POST request
     *  @param request request with header fields
     *  @param response response with writer
     *  @throws IOException for IO errors
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        generateResponse(request, response);
    } // doPost

    /** maximum length of HTTP request, and thus of the customization file */
    private static final int MAX_SIZE = 65535;

    /** Generates the response (HTML page) for an http request
     *  @param request request with header fields
     *  @param response response with writer
     *  @throws IOException for IO errors
     */
    public void generateResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sourceEncoding = "ISO-8859-1";
        String targetEncoding = "UTF-8";
        String view           = null;
        String language       = "en";
        String newPage        = "index";
        String format         = "html";
        String lang3          = "deu";
        String variant        = "pol";
        String formYear       = "0";
        String month1         = "1";
        String customization  = null; // all lines of the customization file, length is limited to MAX_SIZE
        String infile         = "";
        int    tabYear        = 0;

        try {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (! isMultipart) {
                view        = basePage.getInputField(request, "view"    , "index");
                format      = basePage.getInputField(request, "format"  , "html");
                lang3       = basePage.getInputField(request, "lang3"   , "deu");
                variant     = basePage.getInputField(request, "variant" , "pol");
                formYear    = basePage.getInputField(request, "year"    , "0");
                month1      = basePage.getInputField(request, "month1"  , "1");
            } else { // isMultipart
                ServletRequestContext context = new ServletRequestContext(request);
                if (context.contentLength() <= MAX_SIZE) {
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
                            if (false) {
                            } else if (name.equals("view"       )) { view       = value;
                            } else if (name.equals("format"     )) { format     = value;
                            } else if (name.equals("lang3"      )) { lang3      = value;
                            } else if (name.equals("variant"    )) { variant    = value;
                            } else if (name.equals("year"       )) { formYear   = value;
                            } else if (name.equals("month1"     )) { month1     = value;
                            } else { // unknown field name
                            }
                        } else { // no formField - uploaded fileItem
                            fileItem = item;
                            customization = fileItem.getString(sourceEncoding);
                        }
                    } // while uploaded items
                    tabYear = 0;
                    try {
                        tabYear = Integer.parseInt(formYear);
                    } catch (Exception exc) { // ignore
                    }
                } else { // "customization file too long (&gt; 8 kB)"
                    newPage = "message";
                    basePage.writeMessage(request, response, language, new String[] { "407", String.valueOf(MAX_SIZE) });
                }
                // isMultipart
            }
            /*--------------------------------------------------------------*/
            if (false) {
            } else if (view == null || view.length() == 0 || view.equals("index")) {
                (new IndexPage()).forward(request, response, basePage, language
                        , format, lang3, variant, formYear, month1, infile);

            } else if (view.equals("show")) { // 2nd request
                BaseCalendar calendar = (new CalendarFactory()).getCalendar(lang3
                        , variant, tabYear, customization);
                calendar.setOption("month1", month1);
                tabYear  = calendar.getYear();

                if (false) {
                } else if (calendar == null) { // invalid variant
                    newPage = "message";
                    basePage.writeMessage(request, response, language, new String[] { "402", variant, lang3 });
                } else {
                    tabYear = calendar.getYear();
                    if  (tabYear != 0 && (
                                tabYear < calendar.getMinimum(Calendar.YEAR)
                            ||  tabYear > calendar.getMaximum(Calendar.YEAR)
                            )) { // not 0 and not in 1583..4099 - year not in range
                        newPage = "message";
                        basePage.writeMessage(request, response, language, new String[] { "404", String.valueOf(tabYear) });
                        tabYear  = 0;
                    } else {
                    }
                } // check input form fields

                if (! newPage.equals("message")) {
                    if (false) {
                    } else if (format.startsWith    ("htm"  )) {
                        response.setContentType("text/html;charset=UTF-8");
                        calendar.printHTML(response.getWriter(), 6);
                    } else if (format.startsWith    ("ic"   )) {
                        response.setContentType("text/plain");
                        calendar.printICalendar(response.getWriter());
                    } else if (format.startsWith    ("jav"  )) {
                        response.setContentType("text/plain");
                        calendar.printJava(response.getWriter());
                    } else if (format.equals        ("sql"  )) {
                        response.setContentType("text/plain");
                        calendar.printSQL(response.getWriter());
                    } else if (format.startsWith    ("tab"  )) {
                        response.setContentType("text/plain");
                        calendar.printTSV(response.getWriter());
                    } else if (format.equals        ("tsv"  )) {
                        response.setContentType("text/plain");
                        calendar.printTSV(response.getWriter());
                    } else if (format.equals        ("xml"  )) {
                        response.setContentType("text/xml;charset=UTF-8");
                        calendar.printXML(response.getWriter());
                    } else { // invalid format
                        newPage = "message";
                        basePage.writeMessage(request, response, language, new String[] { "401", "format", format });
                    }

                } // no error

            } else if (view.equals("license")
                    || view.equals("manifest")
                    || view.equals("notice")
                    ) {
                (new MetaInfPage    ()).showMetaInf (request, response, basePage, language, view, this);

            } else { // invalid view
                basePage.writeMessage(request, response, language, new String[] { "401", "view", view });
            }
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
        }
    } // generateResponse

} // ChurchcalServlet
