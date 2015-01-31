#!/usr/bin/perl
#
#  Copyright 2006 Dr. Georg Fischer <punctum at punctum dot kom>
# 
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
# 
#       http://www.apache.org/licenses/LICENSE-2.0
# 
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.
#
#------------------------------------------------------------------ 
# example client - short perl program 
# for SOAP access to Calendar service
# @(#) $Id: client.pl 42 2008-09-08 06:57:56Z gfis $
# 2005-11-23: copied from checkdig/etc/client.pl
#
# Usage: 
#   perl client.pl language [variant [year [format]]]
#		language = deu, eng, fra
#       variant  = ev, rk, tar
#       year     0 = current year (default)
#       format   = table, html, sql, xml (default)
#
# The essential 4 lines in the program below are marked with # <===
#------------------------------------------------------------------ 

use strict;
use SOAP::Lite; # <===
     
    # take up to 3 parameters from the command line
    my $language = "deu";
    my $variant = "ev";
    my $year = "0";
    my $format = "xml";
    if (scalar (@ARGV) > 0) {
        $language = shift @ARGV;
	    if (scalar (@ARGV) > 0) {
	        $variant = shift @ARGV;
	        if (scalar (@ARGV) > 0) {
	            $year = shift @ARGV;
	            if (scalar (@ARGV) > 0) {
	                $format = shift @ARGV;
	            }
	        }
	    }
    } else {
        print   "usage: perl client.pl variant [year [format]]\n"
            .   "\tvariant = de, de_ev, de_rk\n\tyear defaults to current year\n\tformat = table, html, sql"
            ;
    }
         
    # create a new SOAP::Lite instance from the WSDL
    my $path = $0;
    $path =~ s[client\.pl][churchcal.wsdl];
    # print "Path: \"$path\"\n";
    my $service = SOAP::Lite->service("file:$path"); # <===
    # print "Error1: $@, $!, $?\n";

    # call CheckService
    my $results = $service->getResponse ($language, $variant, $year, $format); # <===
    # print "Error2: $@, $!, $?\n";
    print $results, "\n"; # <===

# finis
