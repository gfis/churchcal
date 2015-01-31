<%--
    Display a form for calendar tables
    @(#) $Id: index.jsp 882 2012-02-12 21:09:04Z gfis $
    2012-02-06: month1
    2012-01-28: ChurchCalendar renamed to MainCalendar
    2012-01-03: more formats, Espanol
    2008-03-31: call XML
    2006-12-11: better start values for the 3 input fields
    2005-12-02: copied from numword

    Caution, this file has UTF-8 encoding (äöüÄÖÜß)!

--%>
<%--
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
--%>
<%@page import="org.teherba.churchcal.MainCalendar"%>
<%
    String CVSID = "@(#) $Id: index.jsp 882 2012-02-12 21:09:04Z gfis $";
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
    field = session.getAttribute("format");     String format   = (field != null) ? (String) field : optFormat  [1];
    field = session.getAttribute("language");   String language = (field != null) ? (String) field : optLanguage[1];
    field = session.getAttribute("variant");    String variant  = (field != null) ? (String) field : optVariant [2];
    field = session.getAttribute("year");	    String year     = (field != null && ! field.equals("")) ? (String) field : "0";
    field = session.getAttribute("month1");		String month1   = (field != null && ! field.equals("")) ? (String) field : "1";
    field = session.getAttribute("infile");		String infile   = (field != null) ? (String) field : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Calendar for <%= year %></title>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
    <link rel="shortcut icon" href="/favicon.ico" type="image/vnd.microsoft.icon" />
</head>
<body>
    <!--
    format="<%= format %>, language="<%= language %>", variant="<%= variant %>", month1="<%= month1 %>, year="<%= year %>""
    -->
    <h2>Church Calendar Generator</h2>
    <form action="servlet" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td width="1*" class="nbord4"><strong>Language</strong></td>
                <td width="3*" class="nbord4"><strong>Variant</strong></td>
                <td width="1*" class="nbord4"><strong>Year</strong></td>
                <td width="1*" class="nbord4"><strong>Format</strong></td>
            </tr>
            <tr valign="top">
                <td class="nbord4">
                    <select name="language" size="<%= optLanguage.length - 1 %>">
                    <%
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
                    %>
                    </select>
                </td>
                <td class="nbord4">
                    <select name="variant" size="<%= optVariant.length - 1 %>">
                    <%
                        ind = 1;
                        while (ind < optVariant.length) {
                            out.write("<option value=\""
                                    + optVariant[ind] + "\""
                                    + (optVariant[ind].equals(variant) ? " selected" : "")
                                    + ">"
                                    + enVariant[ind] + "</option>\n");
                            ind ++;
                        } // while ind
                    %>
                    </select>
                </td>
                <td class="nbord4">
                    <input name="year" maxsize="4" size="4" value="<%= year  %>"/>
                    <br />
                    1583..4099
                    <br />
					<strong>1st Month</strong>
                    <br />
                    <input name="month1" maxsize="2" size="2" value="<%= month1 %>"/>
                 </td>
                <td class="nbord4">
                    <select name="format" size="<%= optFormat.length - 1 %>">
                    <%
                        ind = 1;
                        while (ind < optFormat.length) {
                            out.write("<option value=\""
                                    + optFormat[ind] + "\""
                                    + (optFormat[ind].equals(format) ? " selected" : "")
                                    + ">"
                                    + enFormat[ind] + "</option>\n");
                            ind ++;
                        } // while ind
                    %>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="nbord4" colspan="4">
					<strong>Customization file</strong>
					<br />
                    <input name="infile" type="file" style="font-family: Courier, monospace" maxsize="512" size="52" value="<%= infile %>"/>
                </td>
            </tr>
            <tr>
                <td class="nbord4" colspan="4" align="right">
                    <input type="submit" value="Submit">
                </td>
            </tr>
            <tr>
                <td class="nbord4" colspan="4">
                    <strong><a href="docs/api/index.html">API</a></strong>
                    <br />
                    <a href="bach/index.html">Sundays in the lifetime of<br />
                    Johann Sebastian Bach</a> (*1685, &dagger;1750)
                    <br /><a href="metaInf.jsp?view=manifest">Manifest</a>,
                          <a href="metaInf.jsp?view=license" >License</a>,
                          <a href="metaInf.jsp?view=notice"  >References</a>
                </td>
            </tr>
        </table>
    </form>
    <!--
    language="<%= language %>", variant="<%= variant %>", year="<%= year %>", month1="<%= month1 %>", format="<%= format %>"
    -->
    <%
        if (year.equals("")) {
            year = "0"; // => current year
        }
        out.write(calendar.process(new String[] { language, variant, year, "html" }));
    %>
    <p>
    <font size="-1">
    Questions, remarks to: <a href="mailto:punctum@punctum.com">Dr. Georg Fischer</a>
    </font>
    </p>                   
</body>
</html>
