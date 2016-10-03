<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="application/xhtml+xml;charset=UTF-8" />
<meta name="robots" content="noindex, nofollow" />
<link rel="stylesheet" title="common" type="text/css" href="stylesheet.css" />
<title>ChurchCal Main Page</title>
</head>
<body>
<!-- format="html, lang3="deu", variant="tr", month1="1, year="1947 -->
<h2>Church Calendar Generator</h2>
<form action="servlet" method="post" enctype="multipart/form-data">
<input name="view" type="hidden" value="show" />
<table>
<tr>
<td width="1*" class="nbord4"><strong>Language</strong></td>
<td width="3*" class="nbord4"><strong>Variant</strong></td>
<td width="1*" class="nbord4"><strong>Year</strong></td>
<td width="1*" class="nbord4"><strong>Format</strong></td>
</tr>
<tr valign="top">
<td class="nbord4">
<select name="lang3" size="3">
<option value="deu" selected>Deutsch</option>
<option value="eng">English</option>
<option value="fra">Fran&ccedil;ais</option>
</select>
</td>
<td class="nbord4">
<select name="variant" size="5">
<option value="pol">German Calendar</option>
<option value="ev">German Church Calendar - evangelic</option>
<option value="tr" selected>German Church Calendar - ev. + Trin.</option>
<option value="rk">German Church Calendar - catholic</option>
<option value="target">TARGET2 Calendar</option>
</select>
</td>
<td class="nbord4">
<input name="year" maxsize="4" size="4" value="1947"/>
<br />
1583..4099
<br />
<strong>1st Month</strong>
<br />
<input name="month1" maxsize="2" size="2" value="1"/>
</td>
<td class="nbord4">
<select name="format" size="7">
<option value="html" selected>HTML</option>
<option value="ical">iCalendar</option>
<option value="java">Java</option>
<option value="sql">SQL</option>
<option value="table">Table</option>
<option value="tsv">TSV</option>
<option value="xml">XML</option>
</select>
</td>
</tr>
<tr>
<td class="nbord4" colspan="2">
<strong>Customization file</strong>
<br />
<input name="infile" type="file" style="font-family: Courier, monospace" maxsize="512" size="52" value=""/>
</td>
<td class="nbord4" colspan="2" align="left">
<input type="submit" value="Submit">
</td>
</tr>
<tr>
<td class="nbord4" colspan="4">
<a title="bach"        href="bach/index.html">Sundays</a> in the lifetime of J.S. Bach (*1685, &dagger; 1750)<br />
<a title="wiki"        href="http://www.teherba.org/index.php/ChurchCal" target="_new">Wiki</a><br />
<a title="github"      href="https://github.com/gfis/churchcal" target="_new">Git Repository</a><br />
<a title="api"         href="docs/api/index.html">Java API</a>, <a title="manifest"    href="servlet?view=manifest">Manifest</a>, <a title="license"     href="servlet?view=license">License</a> <a title="notice"      href="servlet?view=notice">References</a><br />
</td>
</tr>
</table>
</form>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" [
]>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html" />
<meta name="robots" content="noindex, nofollow" />
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<style>
.blk {  color:white ; background-color: black        }
.wht {  color:black ; background-color: white        }
.grn {  color:white ; background-color: forestgreen  }
.hli {  color:white ; background-color: tomato       }
.sat {  color:black ; background-color: wheat        }
.lea {  color:black ; background-color: lightblue    }
.und {  color:black ; background-color: white        }
.sun {  color:black ; background-color: gold	 	   }
.red {  color:white ; background-color: crimson      }
.wrk {  color:black ; background-color: ghostwhite   }
.hly {  color:white ; background-color: crimson      }
.vac {  color:black ; background-color: gainsboro    }
.hwk {  color:black ; background-color: khaki        }
.vio {  color:white ; background-color: darkviolet   }
</style>
<title>1947</title>
</head>
<body>
<h2 class="">Liturgischer Kalender (ev./trin.) 1947</h2>
<table><!--year-->
<tr><td class="bord"><table><!--month--><tr>
<th width="340">Januar</th></tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">01</td><td  width="13%" class="nbord4 hli">Mi</td><td  width="75%" class="nbord4 hli" colspan="2">Neujahr</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">02</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">03</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">04</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">05</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">2.So.n.Weihn.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">06</td><td  width="13%" class="nbord4 hly">Mo</td><td  width="75%" class="nbord4 hly" colspan="2">Epiphanias</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">07</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">08</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">09</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">10</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">11</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">12</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">1.So.n.Epiph.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">13</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">14</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">15</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">16</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">17</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">18</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">19</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">2.So.n.Epiph.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">20</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">21</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">22</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">23</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">24</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">25</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">26</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Letzter So.n.Epiph.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">27</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">28</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">29</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">30</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">31</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
</table><!--month--></td>
<td class="bord"><table><!--month--><tr>
<th width="340">Februar</th></tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">01</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">02</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Septuagesimae</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">03</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">04</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">05</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">06</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">07</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">08</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">09</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Sexagesimae</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">10</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">11</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">12</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">13</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">14</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">15</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">16</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Estomihi</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">17</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">Rosenmontag</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">18</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">Fastnacht</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">19</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">Aschermittwoch</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">20</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">21</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">22</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">23</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Invokavit</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">24</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">25</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">26</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">27</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">28</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
</table><!--month--></td>
<td class="bord"><table><!--month--><tr>
<th width="340">März</th></tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">01</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">02</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Reminiszere</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">03</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">04</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">05</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">06</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">07</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">08</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">09</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Okuli</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">10</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">11</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">12</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">13</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">14</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">15</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">16</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Laetare</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">17</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">18</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">19</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">20</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">21</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">22</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">23</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Judika</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">24</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">25</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">26</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">27</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">28</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">29</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">30</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Palmsonntag</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">31</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
</table><!--month--></td>
<td class="bord"><table><!--month--><tr>
<th width="340">April</th></tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">01</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">02</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">03</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">Gründonnerstag</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 blk">04</td><td  width="13%" class="nbord4 hly">Fr</td><td  width="75%" class="nbord4 hly" colspan="2">Karfreitag</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 blk">05</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">Karsamstag</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">06</td><td  width="13%" class="nbord4 hly">So</td><td  width="75%" class="nbord4 hly" colspan="2">Ostersonntag</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">07</td><td  width="13%" class="nbord4 hly">Mo</td><td  width="75%" class="nbord4 hly" colspan="2">Ostermontag</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">08</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">09</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">10</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">11</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">12</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">13</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Quasimodogeniti</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">14</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">15</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">16</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">17</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">18</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">19</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">20</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Misericordias Dom.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">21</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">22</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">23</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">24</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">25</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">26</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">27</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Jubilate</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">28</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">29</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">30</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
</table><!--month--></td>
<td class="bord"><table><!--month--><tr>
<th width="340">Mai</th></tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">01</td><td  width="13%" class="nbord4 hli">Do</td><td  width="75%" class="nbord4 hli" colspan="2">Maifeiertag</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">02</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">03</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">04</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Kantate</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">05</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">06</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">07</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">08</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">09</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">10</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">11</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Rogate</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">12</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">13</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">14</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">15</td><td  width="13%" class="nbord4 hly">Do</td><td  width="75%" class="nbord4 hly" colspan="2">Christi Himmelf.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">16</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">17</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">18</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Exaudi</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">19</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">20</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">21</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">22</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">23</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">24</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 red">25</td><td  width="13%" class="nbord4 hly">So</td><td  width="75%" class="nbord4 hly" colspan="2">Pfingsten</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 red">26</td><td  width="13%" class="nbord4 hly">Mo</td><td  width="75%" class="nbord4 hly" colspan="2">Pfingstmontag</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 red">27</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 red">28</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 red">29</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 red">30</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 red">31</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
</table><!--month--></td>
<td class="bord"><table><!--month--><tr>
<th width="340">Juni</th></tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">01</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">Trinitatis</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">02</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">03</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">04</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">05</td><td  width="13%" class="nbord4 hly">Do</td><td  width="75%" class="nbord4 hly" colspan="2">Fronleichnam</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">06</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">07</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">08</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">1.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">09</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">10</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">11</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">12</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">13</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">14</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">15</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">2.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">16</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">17</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">18</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">19</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">20</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">21</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">22</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">3.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">23</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">24</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">Johannis</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">25</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">26</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">27</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">28</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">29</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">4.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">30</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
</table><!--month--></td>
</tr>
</table><!--year-->
<p style="page-break-before:always">
<h2 class="">Liturgischer Kalender (ev./trin.) 1947</h2>
<table><!--year-->
<tr><td class="bord"><table><!--month--><tr>
<th width="340">Juli</th></tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">01</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">02</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">03</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">04</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">05</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">06</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">5.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">07</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">08</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">09</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">10</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">11</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">12</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">13</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">6.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">14</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">15</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">16</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">17</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">18</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">19</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">20</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">7.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">21</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">22</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">23</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">24</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">25</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">26</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">27</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">8.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">28</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">29</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">30</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">31</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
</table><!--month--></td>
<td class="bord"><table><!--month--><tr>
<th width="340">August</th></tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">01</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">02</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">03</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">9.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">04</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">05</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">06</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">07</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">08</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">09</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">10</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">10.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">11</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">12</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">13</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">14</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">15</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">16</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">17</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">11.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">18</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">19</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">20</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">21</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">22</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">23</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">24</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">12.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">25</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">26</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">27</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">28</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">29</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">30</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">31</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">13.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
</table><!--month--></td>
<td class="bord"><table><!--month--><tr>
<th width="340">September</th></tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">01</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">02</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">03</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">04</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">05</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">06</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">07</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">14.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">08</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">09</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">10</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">11</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">12</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">13</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">14</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">15.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">15</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">16</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">17</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">18</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">19</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">20</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">21</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">16.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">22</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">23</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">24</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">25</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">26</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">27</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">28</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">17.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">29</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">Michaelis</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">30</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
</table><!--month--></td>
<td class="bord"><table><!--month--><tr>
<th width="340">Oktober</th></tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">01</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">02</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">03</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">04</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">05</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">18.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">06</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">07</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">08</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">09</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">10</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">11</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">12</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">19.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">13</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">14</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">15</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">16</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">17</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">18</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">19</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">20.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">20</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">21</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">22</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">23</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">24</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">25</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">26</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">21.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">27</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">28</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">29</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">30</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 red">31</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">Reformationsfest</td></tr></table><!--day--></td>
</tr>
</table><!--month--></td>
<td class="bord"><table><!--month--><tr>
<th width="340">November</th></tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">01</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">02</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">22.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">03</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">04</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">05</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">06</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">07</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">08</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">09</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">23.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">10</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">11</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">12</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">13</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">14</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">15</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">16</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">24.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">17</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 grn">18</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">19</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">Buß- und Bettag</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">20</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">21</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">22</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">23</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">25.So.n.Trin.</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">24</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">25</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">26</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">27</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">28</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">29</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">30</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">1. Advent</td></tr></table><!--day--></td>
</tr>
</table><!--month--></td>
<td class="bord"><table><!--month--><tr>
<th width="340">Dezember</th></tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">01</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">02</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">03</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">04</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">05</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">06</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">Nikolaus</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">07</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">2. Advent</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">08</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">09</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">10</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">11</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">12</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">13</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">14</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">3. Advent</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">15</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">16</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">17</td><td  width="13%" class="nbord4 wrk">Mi</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">18</td><td  width="13%" class="nbord4 wrk">Do</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">19</td><td  width="13%" class="nbord4 wrk">Fr</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">20</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">21</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">4. Advent</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">22</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">23</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 vio">24</td><td  width="13%" class="nbord4 hwk">Mi</td><td  width="75%" class="nbord4 hwk" colspan="2">Heiliger Abend</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">25</td><td  width="13%" class="nbord4 hly">Do</td><td  width="75%" class="nbord4 hly" colspan="2">1. Weihnachtstag</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">26</td><td  width="13%" class="nbord4 hly">Fr</td><td  width="75%" class="nbord4 hly" colspan="2">2. Weihnachtstag</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">27</td><td  width="13%" class="nbord4 sat">Sa</td><td  width="75%" class="nbord4 sat" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">28</td><td  width="13%" class="nbord4 sun">So</td><td  width="75%" class="nbord4 sun" colspan="2">So.n.Weihnachten</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">29</td><td  width="13%" class="nbord4 wrk">Mo</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">30</td><td  width="13%" class="nbord4 wrk">Di</td><td  width="75%" class="nbord4 wrk" colspan="2">&#xa0;</td></tr></table><!--day--></td>
</tr>
<tr><td class="bord"><table width="100%"><!--day-->
<tr><td   width="12%" class="nbord4 wht">31</td><td  width="13%" class="nbord4 hwk">Mi</td><td  width="75%" class="nbord4 hwk" colspan="2">Silvester</td></tr></table><!--day--></td>
</tr>
</table><!--month--></td>
</tr>
</table><!--year-->
</<body>
</html>
<!-- language="en", features="quest" -->
<p><span style="font-size:small">
Questions, remarks: email to  <a href="mailto:punctum@punctum.com?&subject=ChurchCal">Dr. Georg Fischer</a></span></p>
</body></html>
