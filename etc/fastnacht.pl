#!/usr/bin/perl

# Berechne Fastnacht-Dienstage im Maerz
# fuer Barbara Rein
# @(#) $Id$
# 2011-03-07, Dr. Georg Fischer

use strict;
	for my $year (1900..2099) {
		my @fastnacht = grep { m/Fastnacht/ }
			split(/\r?\n/, `java -jar dist/churchcal.jar de rk -s $year table`);
		my ($dummy, $yday, $month, $mday, @rest) = split(/\s+/, $fastnacht[0]);
		if ($month == 3) {
			print "$year: $mday.$month.\n";
		}
	} # for $year
__DATA__
1948	41	2	10	3	7	129	'Fastnacht'
1949	60	3	1	3	10	129	'Fastnacht'
1950	52	2	21	3	8	129	'Fastnacht'
1951	37	2	6	3	6	129	'Fastnacht'
1952	57	2	26	3	9	129	'Fastnacht'

