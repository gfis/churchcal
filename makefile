#!/usr/bin/make

# makefile for churchcal
# @(#) $Id: makefile 974 2013-01-23 11:38:57Z gfis $
# 2016-09-11: regression
# 2012-02-13, Dr. Georg Fischer
#
APPL=churchcal
JAVA=java -cp dist/$(APPL).jar
DIFF=diff -y --suppress-common-lines --width=160
DIFF=diff -w -rs -C0
SRC=src/main/java/org/teherba/$(APPL)
TOM=c:/var/lib/tomcat/
TOMC=$(TOM)/webapps/$(APPL)
TESTDIR=test
# the following can be overriden outside for single or subset tests,
# for example make regression TEST=U%
TEST="%"
# for Windows, SUDO should be empty
SUDO=

all: regression
#-------------------------------------------------------------------
# Perform a regression test 
regression: 
	java -cp dist/$(APPL).jar org.teherba.common.RegressionTester $(TESTDIR)/all.tests $(TEST) 2>&1 \
	| tee $(TESTDIR)/regression.log
	grep FAILED $(TESTDIR)/regression.log
#
# Recreate all testcases which failed (i.e. remove xxx.prev.tst)
# Handle with care!
# Failing testcases are turned into "passed" and are manifested by this target!
recreate: recr1 regr2
recr0:
	grep -E '> FAILED' $(TESTDIR)/regression*.log | cut -f 3 -d ' ' | xargs -l -ißß echo rm -v test/ßß.prev.tst
recr1:
	grep -E '> FAILED' $(TESTDIR)/regression*.log | cut -f 3 -d ' ' | xargs -l -ißß rm -v test/ßß.prev.tst
regr2:
	make regression TEST=$(TEST) > x.tmp
# test whether all defined tests in common.tests have *.prev.tst results and vice versa
check_tests:
	grep -E "^TEST" $(TESTDIR)/all.tests   | cut -b 6-8 | sort | uniq -c > $(TESTDIR)/tests_formal.tmp
	ls -1 $(TESTDIR)/*.prev.tst            | cut -b 6-8 | sort | uniq -c > $(TESTDIR)/tests_actual.tmp
	diff -y --suppress-common-lines --width=32 $(TESTDIR)/tests_formal.tmp $(TESTDIR)/tests_actual.tmp
#---------------------------------------------------
jfind:
	find src -iname "*.java" | xargs -l grep -H $(JF)
rmbak:
	find src -iname "*.bak"  | xargs -l rm -v
#---------------------------------------------------
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

