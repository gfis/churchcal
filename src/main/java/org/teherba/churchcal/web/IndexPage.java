/*  IndexPage.java - replacement for index.jsp
 *  @(#) $Id: IndexPage.java 882 2012-02-12 21:09:04Z gfis $
 *  2017-05-29: javadoc 1.8
 *  2016-10-13: less imports; throw exception
 *  2012-02-11, Georg Fischer: copied from index.jsp
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
package org.teherba.churchcal.web;
import  org.teherba.churchcal.MainCalendar;
import  org.teherba.common.web.BasePage;
import  java.io.IOException;
import  java.io.PrintWriter;
import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;
import  org.apache.log4j.Logger;

/** This class stores the language-specific message texts,
 *  and prints the text for some numbered message.
 *  The code is extracted from the former <em>index.jsp</em>.
 *  @author Dr. Georg Fischer
 */
public class IndexPage {
    public final static String CVSID = "@(#) $Id: IndexPage.java 882 2012-02-12 21:09:04Z gfis $";
    public final static long serialVersionUID = 19470629;

    /** log4j logger (category) */
    private Logger log;

    /** No-argument constructor
     */
    public IndexPage() {
        log = Logger.getLogger(IndexPage.class.getName());
    } // constructor()

    /** Processes an http GET request
     *  @param request request with header fields
     *  @param response response with writer
     *  @param basePage refrence to common methods and error messages
     *  @param language 2-letter code en, de etc.
     *  @param format html, ical, java, sql etc.
     *  @param lang3  language of calendar to be shown
     *  @param variant pol, ev, tr, rk etc.
     *  @param year base year of calendar to be shown
     *  @param month1 starting month
     *  @param infile configuration file
     *  @throws IOException for IO errors
     */
    public void forward(HttpServletRequest request, HttpServletResponse response
            , BasePage basePage
            , String language
            , String format
            , String lang3
            , String variant
            , String year
            , String month1
            , String infile
            ) throws IOException {
        if (true) { // try {
            PrintWriter out = basePage.writeHeader(request, response, language);
            out.write("<title>" + basePage.getAppName() + " Main Page</title>\n");
            out.write("</head>\n<body>\n");
            MainCalendar calendar = new MainCalendar();
            // 2 parallel arrays for 'lang3' listbox
            String[] optLang3 = new String [] { "dummy"
                    , "deu"
                    , "eng"
                    , "fra"
            //      , "spa"
            } ;
            String[] enLang3 = new String [] { "dummy"
                    , "Deutsch"
                    , "English"
                    , "Fran&ccedil;ais"
            //      , "Espa&ntilde;ol"
                    } ;
            // 2 parallel arrays for 'variant' listbox
            String[] optVariant = new String [] { "dummy"
                    , "pol"
                    , "ev"
                    , "tr"
                    , "rk"
                    , "target"
                    } ;
            String[] enVariant = new String [] { "dummy"
                    , "German Calendar"
                    , "German Church Calendar - evangelic"
                    , "German Church Calendar - ev. + Trin."
                    , "German Church Calendar - catholic"
                    , "TARGET2 Calendar"
                    } ;
            // 2 parallel arrays for 'format' listbox
            String[] optFormat = new String [] { "dummy"
                    , "html"
                    , "ical"
                    , "java"
                    , "sql"
                    , "table"
                    , "tsv"
                    , "xml"
                    } ;
            String[] enFormat = new String [] { "dummy"
                    , "HTML"
                    , "iCalendar"
                    , "Java"
                    , "SQL"
                    , "Table"
                    , "TSV"
                    , "XML"
                    } ;
            out.write("<!-- format=\"" + format + ", lang3=\"" + lang3);
            out.write("\", variant=\"" + variant + "\", month1=\"" + month1 + ", year=\"" + year + " -->\n");
            out.write("<h2>Church Calendar Generator</h2>\n");
            out.write("<form action=\"servlet\" method=\"post\" enctype=\"multipart/form-data\">\n");
            out.write("<input name=\"view\" type=\"hidden\" value=\"show\" />\n");
            out.write("<table>\n<tr>\n<td width=\"1*\" class=\"nbord4\"><strong>Language</strong></td>\n");
            out.write("<td width=\"3*\" class=\"nbord4\"><strong>Variant</strong></td>\n");
            out.write("<td width=\"1*\" class=\"nbord4\"><strong>Year</strong></td>\n");
            out.write("<td width=\"1*\" class=\"nbord4\"><strong>Format</strong></td>\n");
            out.write("</tr>\n<tr valign=\"top\">\n");
            out.write("<td class=\"nbord4\">\n");
            out.write("<select name=\"lang3\" size=\"" + String.valueOf(optLang3.length - 1) + "\">\n");
            int
            ind = 1;
            while (ind < optLang3.length) {
                out.write("<option value=\""
                          + optLang3[ind] + "\""
                          + (optLang3[ind].equals(lang3) ? " selected" : "")
                          + ">"
                          + enLang3[ind] + "</option>\n");
                ind ++;
            } // while ind
            out.write("</select>\n</td>\n");
            out.write("<td class=\"nbord4\">\n<select name=\"variant\" size=\"" + String.valueOf(optVariant.length - 1) + "\">\n");
            ind = 1;
            while (ind < optVariant.length) {
                out.write("<option value=\""
                          + optVariant[ind] + "\""
                          + (optVariant[ind].equals(variant) ? " selected" : "")
                          + ">"
                          + enVariant[ind] + "</option>\n");
                ind ++;
            } // while ind
            out.write("</select>\n</td>\n");
            out.write("<td class=\"nbord4\">\n");
            out.write("<input name=\"year\" maxsize=\"4\" size=\"4\" value=\"" + year + "\"/>\n");
            out.write("<br />\n1583..4099\n<br />\n");
            out.write("<strong>1st Month</strong>\n<br />\n");
            out.write("<input name=\"month1\" maxsize=\"2\" size=\"2\" value=\"" + month1 + "\"/>\n</td>\n");
            out.write("<td class=\"nbord4\">\n<select name=\"format\" size=\"" + String.valueOf(optFormat.length - 1) + "\">\n");
            ind = 1;
            while (ind < optFormat.length) {
                out.write("<option value=\""
                          + optFormat[ind] + "\""
                          + (optFormat[ind].equals(format) ? " selected" : "")
                          + ">"
                          + enFormat[ind] + "</option>\n");
                ind ++;
            } // while ind
            out.write("</select>\n</td>\n</tr>\n");
            out.write("<tr>\n<td class=\"nbord4\" colspan=\"2\">\n");
            out.write("<strong>Customization file</strong>\n<br />\n");
            out.write("<input name=\"infile\" type=\"file\" style=\"font-family: Courier, monospace\" maxsize=\"512\" size=\"52\" value=\"");
            out.write(infile);
            out.write("\"/>\n</td>\n");
            out.write("<td class=\"nbord4\" colspan=\"2\" align=\"left\">\n");
            out.write("<input type=\"submit\" value=\"Submit\">\n</td>\n</tr>\n");
            out.write("<tr>\n<td class=\"nbord4\" colspan=\"4\">\n");
            basePage.writeAuxiliaryLinks(language, "main");
            out.write("</td>\n</tr>\n");
            out.write("</table>\n</form>\n");
            if (year.equals("")) {
                year = "0"; // => current year
            }
            out.write(calendar.process(new String[] { lang3, variant, year, "html" }));
            basePage.writeTrailer(language, "quest");
    /*
        } catch (Exception exc) {
            log.error(exc.getMessage(), exc);
    */
        }
    } // forward

} // IndexPage
