/*  ViewMessage.java - show the language specific message text
 *  @(#) $Id: ViewMessage.java 882 2012-02-12 21:09:04Z gfis $
 *  2016-09-03: use BasePage
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
package org.teherba.churchcal.web;
import  org.teherba.common.web.BasePage;
import  java.io.Serializable;

/** Language specific message texts and formatting for the web user interface.
 *  Currently implemented natural languages (denoted by 2-letter ISO <em>country</em> codes) are:
 *  <ul>
 *  <li>en - English</li>
 *  <li>de - German</li>
 *  </ul>
 *  <p />
 *  @author Dr. Georg Fischer
 */
public class Messages implements Serializable {
    public final static String CVSID = "@(#) $Id: 57d01d0860aef0c2f2783647be70c3c381710c86 $";

    /** No-args Constructor
     */
    public Messages() {
    } // Constructor
    
    /** Sets the application-specific error message texts
     *  @param basePage reference to the hash for message texts
     */
    public static void addMessageTexts(BasePage basePage) {
        String appLink = "<a href=\"servlet?view=index\">" + basePage.getAppName() + "</a>";
        //--------
        basePage.add("en", "001", appLink);
        //--------
        String laux = basePage.LANG_AUX;  // pseudo language code for links to auxiliary information
        int imess   = basePage.START_AUX; // start of messages    for links to auxiliary information
        String smess = null;
        smess = String.format("%03d", imess ++);
        basePage.add(laux, smess, "<a title=\"main\"        href=\"servlet?view=index\">");
        basePage.add("en", smess, "{parm}ChurchCal</a> Main Page");
        basePage.add("de", smess, "{parm}ChurchCal</a>-Startseite");
        smess = String.format("%03d", imess ++);
        basePage.add(laux, smess, "<a title=\"bach\"        href=\"bach/index.html\">");
        basePage.add("en", smess, "{parm}Sundays</a> in the lifetime of J.S. Bach (*1685, &dagger; 1750)");
        smess = String.format("%03d", imess ++);
        basePage.add(laux, smess, "<a title=\"wiki\"        href=\"http://www.teherba.org/index.php/ChurchCal\" target=\"_new\">");
        basePage.add("en", smess, "{parm}Wiki</a>");
        basePage.add("de", smess, "{parm}Wiki</a>");
        smess = String.format("%03d", imess ++);
        basePage.add(laux, smess, "<a title=\"github\"      href=\"https://github.com/gfis/churchcal\" target=\"_new\">");
        basePage.add("en", smess, "{parm}Git Repository</a>");
        basePage.add("de", smess, "{parm}Git Repository</a>");
        smess = String.format("%03d", imess ++);
        basePage.add(laux, smess, "<a title=\"api\"         href=\"docs/api/index.html\">");
        basePage.add("en", smess, "{parm}Java API</a>, ");
        basePage.add("de", smess, "{parm}Java API</a>, ");
        smess = String.format("%03d", imess ++);
        basePage.add(laux, smess, "<a title=\"manifest\"    href=\"servlet?view=manifest\">");
        basePage.add("en", smess, "{parm}Manifest</a>, ");
        basePage.add("de", smess, "{parm}Manifest</a>, ");
        smess = String.format("%03d", imess ++);
        basePage.add(laux, smess, "<a title=\"license\"     href=\"servlet?view=license\">");
        basePage.add("en", smess, "{parm}License</a> ");
        basePage.add("de", smess, "{parm}Lizenz</a> ");
        smess = String.format("%03d", imess ++);
        basePage.add(laux, smess, "<a title=\"notice\"      href=\"servlet?view=notice\">");
        basePage.add("en", smess, "{parm}References</a>");
        basePage.add("de", smess, "{parm}Referenzen</a>");
        //--------
        basePage.add("en", "402", "Unknown variant <em>{parm}</em> for language <em>{par2}</em>");
        basePage.add("de", "402", "Unbekannte Variante <em>{parm}</em> f&uuml;r Sprache <em>{par2}</em>");
        //--------
        basePage.add("en", "404", "Year <em>{parm}</em> not in the range 1583..4099");
        basePage.add("de", "404", "Jahr <em>{parm}</em> nicht im Bereich 1583..4099");
        //--------
        basePage.add("en", "405", "Unknown format <em>{parm}</em>"); 
        basePage.add("de", "405", "Unbekanntes Format <em>{parm}</em>");
        //--------
        basePage.add("en", "406", "Request without a file upload field");
        basePage.add("de", "406", "Aufruf ohne Upload-Datei-Feld");
        //--------
        basePage.add("en", "407", "Customization file too long (&gt; 16 kB)");
        basePage.add("de", "407", "Parametrisierungsdatei zu gro&szlig; (&gt; 16 kB)");
        //--------
    } // addMessageTexts

    //================
    // Main method
    //================

    /** Test driver 
     *  @param args language code: "en", "de"
     */
    public static void main(String[] args) {
        Messages help = new Messages();
        System.out.println("no messages");
    } // main
    
} // Messages
