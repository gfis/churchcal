#!/usr/bin/make

# Build a Winstone container for churchcal
# @(#) $Id: makefile 974 2013-01-23 11:38:57Z gfis $
# 2012-02-13, Dr. Georg Fischer
#
all: evkal
evkal:
	cd test ; perl txt_cal.pl > evkal2013.cal
ws_container:
	mkdir -p tmp
	rm -rf tmp/*
	cd tmp ; unzip ../lib2/winstone-1.0.3-boot.jar
	cp -v dist/churchcal.war tmp/embedded.war
	rm -f dist/ws_churchcal.jar
	cd tmp ; zip -r ../dist/ws_churchcal.jar *
	cp -v etc/start_up etc/shut_down dist
	echo now distribute 3 files from dist/ : "ws_*.jar", start_up, shut_down
gweb:
	xmllint --nonet --schema /home/gfis/download/geronimo/schema/geronimo-web-2.0.1.xsd etc/WEB-INF/geronimo-web.xml

