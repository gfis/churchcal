rem stop Winstone web server for churchcal
rem @(#) $Id: shut_down.cmd 901 2012-03-10 18:13:36Z gfis $
java -cp ws_churchcal.jar winstone.tools.WinstoneControl --port=8089 --host=localhost shutdown
