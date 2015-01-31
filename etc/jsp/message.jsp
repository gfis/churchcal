<%-- 
    JSP for the output of some numbered system message
    @(#) $Id: message.jsp 882 2012-02-12 21:09:04Z gfis $
    2012-02-07: message 007
    2008-04-03: 1583..4099
    2005-08-18, Georg Fischer
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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

<html xmlns="http://www.w3.org/1999/xhtml">
<%
final String [] msgText = new String [] 
    { /* 000 */ "unspecified system error"
    , /* 001 */ "invalid variant"
    , /* 002 */ "invalid message number"
    , /* 003 */ "invalid year"
    , /* 004 */ "year < 1583 or year > 4099"
    , /* 005 */ "invalid format"
    , /* 006 */ "invalid URI schema"
    , /* 007 */ "customization file too long (&gt; 16 kB)"
    } ;
%>
<head>
    <title>churchcal Message</title>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
</head>

<body>
<%
    String msg      = (String) session.getAttribute("messno");
    String variant  = (String) session.getAttribute("variant");
    String year     = (String) session.getAttribute("year");
    String format   = (String) session.getAttribute("format");
    int msgNo = 000;
    try {
        msgNo = Integer.parseInt(msg);
        if (msgNo < 1 || msgNo >= msgText.length) {
            msgNo = 002;
        }
    } catch (Exception exc) {
    }
    
%>
<p>
Message No. <%= msg %>
</p>
<h2><%= msgText[msgNo] %></h2>
<p>
variant = "<%= variant %>", year = "<%= year %>", format = "<%= format %>"
</body>
</html>
