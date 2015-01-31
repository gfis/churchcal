/*  ViewIndex.java - replacement for index.jsp
 *  @(#) $Id: ViewIndex.java 882 2012-02-12 21:09:04Z gfis $
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
package org.teherba.churchcal;
import  java.io.PrintWriter;
import  java.util.HashMap;
import	java.util.Iterator;
import  java.util.Map;
import  java.util.regex.Pattern;
import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;
import  javax.servlet.http.HttpSession;
import  org.apache.log4j.Logger;

/** This class stores the language-specific message texts,
 *	and prints the text for some numbered message.
 *	The code is extracted from the former <em>index.jsp</em>.
 *  @author Dr. Georg Fischer
 */
public class ViewIndex {
	public final static String CVSID = "@(#) $Id: ViewIndex.java 882 2012-02-12 21:09:04Z gfis $";
	public final static long serialVersionUID = 19470629;

	/** log4j logger (category) */
	private Logger log;

	/** No-argument constructor
	 */
	public ViewIndex() {
		log = Logger.getLogger(ViewIndex.class.getName());
	} // constructor()
	
	/** Processes an http GET request
	 *  @param request request with header fields
	 *  @param response response with writer
	 *  @throws IOException
	 */
	public void forward(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
		try {
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
            out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n");
            out.write("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
            out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
            out.write("<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
            out.write("<title>Church Calendar Generator</title>\n");
            out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\" />\n");
            out.write("<script src=\"script.js\" type=\"text/javascript\">\n</script>\n</head>\n");
            MainCalendar calendar = new MainCalendar();
            // 2 parallel arrays for 'language' listbox
            String[] optLanguage = new String [] { "dummy"
            		, "deu"
            		, "eng"
            		, "fra"
            		//        , "spa"
            } ;
            String[] enLanguage = new String [] { "dummy"
                    , "Deutsch"
                    , "English"
                    , "Fran&ccedil;ais"
                    //        , "Espa&ntilde;ol"
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
            Object
            field = session.getAttribute("format");
            String format   = (field != null) ? (String) field : optFormat  [1];
            field = session.getAttribute("language");
            String language = (field != null) ? (String) field : optLanguage[1];
            field = session.getAttribute("variant");
            String variant  = (field != null) ? (String) field : optVariant [2];
            field = session.getAttribute("year");
            String year     = (field != null && ! field.equals("")) ? (String) field : "0";
            field = session.getAttribute("month1");
            String month1   = (field != null && ! field.equals("")) ? (String) field : "1";
            field = session.getAttribute("infile");
            String infile   = (field != null) ? (String) field : "";
            
            out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n");
            out.write("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
            out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n<title>Calendar for ");
            out.write(year);
            out.write("</title>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\">\n");
            out.write("<link rel=\"shortcut icon\" href=\"/favicon.ico\" type=\"image/vnd.microsoft.icon\" />\n");
            out.write("</head>\n<body>\n<!--\nformat=\"");
            out.write(format);
            out.write(", language=\"");
            out.write(language);
            out.write("\", variant=\"");
            out.write(variant);
            out.write("\", month1=\"");
            out.write(month1);
            out.write(", year=\"");
            out.write(year);
            out.write(" -->\n<h2>Church Calendar Generator</h2>\n");
            out.write("<form action=\"servlet\" method=\"post\" enctype=\"multipart/form-data\">\n");
            out.write("<input name=\"view\" type=\"hidden\" value=\"show\" />\n");
            out.write("<table>\n<tr>\n<td width=\"1*\" class=\"nbord4\"><strong>Language</strong></td>\n");
            out.write("<td width=\"3*\" class=\"nbord4\"><strong>Variant</strong></td>\n");
            out.write("<td width=\"1*\" class=\"nbord4\"><strong>Year</strong></td>\n");
            out.write("<td width=\"1*\" class=\"nbord4\"><strong>Format</strong></td>\n");
            out.write("</tr>\n<tr valign=\"top\">\n");
            out.write("<td class=\"nbord4\">\n<select name=\"language\" size=\"");
            out.write(String.valueOf(optLanguage.length - 1));
            out.write("\">\n");
            int 
            ind = 1;
            while (ind < optLanguage.length) {
                out.write("<option value=\""
                          + optLanguage[ind] + "\""
                          + (optLanguage[ind].equals(language) ? " selected" : "")
                          + ">"
                          + enLanguage[ind] + "</option>\n");
                ind ++;
            } // while ind
            out.write("\n</select>\n</td>\n<td class=\"nbord4\">\n<select name=\"variant\" size=\"");
            out.write(String.valueOf(optVariant.length - 1));
            out.write("\">\n");
            ind = 1;
            while (ind < optVariant.length) {
                out.write("<option value=\""
                          + optVariant[ind] + "\""
                          + (optVariant[ind].equals(variant) ? " selected" : "")
                          + ">"
                          + enVariant[ind] + "</option>\n");
                ind ++;
            } // while ind
            out.write("\n</select>\n</td>\n<td class=\"nbord4\">\n<input name=\"year\" maxsize=\"4\" size=\"4\" value=\"");
            out.write(year );
            out.write("\"/>\n<br />\n1583..4099\n<br />\n");
            out.write("<strong>1st Month</strong>\n<br />\n<input name=\"month1\" maxsize=\"2\" size=\"2\" value=\"");
            out.write(month1);
            out.write("\"/>\n</td>\n<td class=\"nbord4\">\n<select name=\"format\" size=\"");
            out.write(String.valueOf(optFormat.length - 1));
            out.write("\">\n");
            ind = 1;
            while (ind < optFormat.length) {
                out.write("<option value=\""
                          + optFormat[ind] + "\""
                          + (optFormat[ind].equals(format) ? " selected" : "")
                          + ">"
                          + enFormat[ind] + "</option>\n");
                ind ++;
            } // while ind
            out.write("\n</select>\n</td>\n</tr>\n<tr>\n<td class=\"nbord4\" colspan=\"4\">\n");
            out.write("<strong>Customization file</strong>\n");
            out.write("<br />\n");
            out.write("<input name=\"infile\" type=\"file\" style=\"font-family: Courier, monospace\" maxsize=\"512\" size=\"52\" value=\"");
            out.write(infile);
            out.write("\"/>\n</td>\n</tr>\n<tr>\n<td class=\"nbord4\" colspan=\"4\" align=\"right\">\n");
            out.write("<input type=\"submit\" value=\"Submit\">\n</td>\n</tr>\n<tr>\n");
            out.write("<td class=\"nbord4\" colspan=\"4\">\n<strong><a href=\"docs/api/index.html\">API</a></strong>\n");
            out.write("<br />\n<a href=\"bach/index.html\">Sundays in the lifetime of<br />\n");
            out.write("Johann Sebastian Bach</a> (*1685, &dagger;1750)<br />\n");
            out.write("<a href=\"servlet?view=manifest\">Manifest</a>,\n");
            out.write("<a href=\"servlet?view=license\" >License</a>,\n");
            out.write("<a href=\"servlet?view=notice\"  >References</a>\n</td>\n");
            out.write("</tr>\n</table>\n</form>\n<!--\nlanguage=\"");
            out.write(language);
            out.write("\", variant=\"");
            out.write(variant);
            out.write("\", year=\"");
            out.write(year);
            out.write("\", month1=\"");
            out.write(month1);
            out.write("\", format=\"");
            out.write(format);
            out.write("\"\n-->\n");
            if (year.equals("")) {
                year = "0"; // => current year
            }
            out.write(calendar.process(new String[] { language, variant, year, "html" }));
            out.write("\n<p>\n<font size=\"-1\">\nQuestions, remarks to: <a href=\"mailto:punctum@punctum.com\">Dr. Georg Fischer</a>\n</font>\n</p>                   \n</body>\n</html>\n");
		} catch (Exception exc) {
			log.error(exc.getMessage(), exc);
		} finally {
		}
	} // forward

} // ViewIndex
