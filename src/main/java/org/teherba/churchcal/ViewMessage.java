/*  ViewMessage.java - show the language specific message text
 *  @(#) $Id: ViewMessage.java 882 2012-02-12 21:09:04Z gfis $
 *  2012-02-11: copied from message.jsp    
 *  2012-02-07: message 007
 *  2008-04-03: 1583..4099
 *  2005-08-18, Georg Fischer
 */
/*
 * Copyright 2005 Dr. Georg Fischer <punctum at punctum dot kom>
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
import  java.util.regex.Pattern;
import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;
import  javax.servlet.http.HttpSession;
import  org.apache.log4j.Logger;

/** This class stores the language-specific message texts,
 *	and prints the text for some numbered message.
 *	The code is extracted from the former <em>help.jsp</em>.
 *  @author Dr. Georg Fischer
 */
public class ViewMessage {
	public final static String CVSID = "@(#) $Id: ViewMessage.java 882 2012-02-12 21:09:04Z gfis $";
	public final static long serialVersionUID = 19470629;

	/** log4j logger (category) */
	private Logger log;

	/** Map which stores the language-specific message text patterns.
	 *	The texts are stored under keys of the form ll.nnn, with a 
	 *	2-letter language code, and 3 digits for the message number.
	 *	The texts may contain patterns "{parm}" and "{par2}" which are
	 *	replaced by the values of up to 2 parameters.
	 */
	private HashMap<String, String> hash;

	/** No-argument constructor
	 */
	public ViewMessage() {
		log = Logger.getLogger(ViewMessage.class.getName());
		initialize();
	} // constructor()
	
	/** Initializes the hashmap for message texts
	 */
	public void initialize() {
        HashMap<String, String> hash = new HashMap<String, String>();
        hash.put("en.001", "unspecified system error");
        hash.put("de.001", "Systemfehler");
        hash.put("en.002", "unknown variant <em>{parm}</em> for language <em>{par2}</em>");
        hash.put("de.002", "unbekannte Variante <em>{parm}</em> f&uuml;r Sprache <em>{par2}</em>");
        hash.put("en.004", "year <em>{parm}</em> not in range 1583..4099");
        hash.put("de.004", "Jahr <em>{parm}</em> nicht im Bereich 1583..4099");
        hash.put("en.005", "unknown format <em>{parm}</em>"); 
        hash.put("de.005", "unbekanntes Format <em>{parm}</em>");
        hash.put("en.006", "request without a file upload field");
        hash.put("de.006", "Aufruf ohne Upload-Datei-Feld");
        hash.put("en.007", "customization file too long (&gt; 16 kB)");
        hash.put("de.007", "Parametrisierungsdatei zu gro&szlig; (&gt; 16 kB)");
        hash.put("en.505", "System error: invalid message number <em>{parm}</em>");
        hash.put("de.505", "Systemfehler: Ung&uuml;ltige Meldungsnummer <em>{parm}</em>");
	} // initialize
	
	/** Processes an http GET request
	 *  @param request request with header fields
	 *  @param response response with writer
	 *  @throws IOException
	 */
	public void forward(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String lang		= (String) session.getAttribute("lang");
        if (lang == null) {
            lang = "en";
        } // invalid language
        String messno   = (String) session.getAttribute("messno");
        if (messno == null) {
        	messno = "505";
        }
        String parm		= (String) session.getAttribute("parm");
        if (parm == null) {
        	parm = "";
        }
        String par2		= (String) session.getAttribute("par2");
        if (par2 == null) {
        	par2 = "";
        }
        String text = hash.get(lang + "." + messno);
        if (text == null) { // invalid messno
            text = hash.get(lang + "." + "505");
            text = text.replaceAll(Pattern.quote("{parm}"), messno);
            messno = "505";
        } else {
            text = text.replaceAll(Pattern.quote("{parm}"), parm);
            text = text.replaceAll(Pattern.quote("{par2}"), par2);
        }

		try {
			PrintWriter out = response.getWriter();
 			response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
            out.write("\n<head>\n<title>Message ");
            out.write(messno);
            out.write("</title>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\">\n");
            out.write("</head>\n<body>\n<!--lang=");
            out.write(lang);
            out.write(", messno=");
            out.write(messno);
            out.write(", text=");
            out.write(text);
            out.write(", parm=");
            out.write(parm);
            out.write(", par2=");
            out.write(par2);
            out.write("-->\n<h3>");
            out.write(messno);
            out.write(": ");
            out.write(text);
            out.write("</h3>\n</body>\n</html>\n");
		} catch (Exception exc) {
			log.error(exc.getMessage(), exc);
		} finally {
		}
	} // forward

} // ViewMessage
