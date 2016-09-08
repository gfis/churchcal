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
#-------------------------------------------------------------------------------
# Generate sundays in Bach's lifetime
# 2007-01-31: List of Sundays
# 2007-01-21: copied from tool/prenatl.pl
#-------------------------------------------------------------------------------

use strict;

    my ($sec, $min, $hour, $mday, $mon, $year, $wday, $yday, $isdst) = localtime (time);
    $year += 1900; # Y2K okay, $year counts 99, 100, 101 ...
    $mon  += 1;
    my $moddate = sprintf("%04d-%02d-%02d", $year, $mon, $mday);
    my $usdate = $mday . "-" . ("   ", "Jan", "Feb", "Mar", "Apr", "May", "Jun"
            , "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")[$mon] . "-" . $year;
    my $dochead = <<'GFis';
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
GFis
      my $docfoot = <<"GFis";
<p><font size=\"-1\">
<a href=\"index.html\">Back to index</a>
<br />
Last modification: $moddate
<br />
Please direct any questions or comments to:
<a href=\"mailto:punctum\@punctum.com\">Dr. Georg Fischer</a>
</p>
<font size=\"+1\"></p>
GFis
    my $iso = <<'GFis';
<p>All dates are in ISO 8601 format: <strong>YYYY-MM-DD</strong>.<br />
Abbreviations of German weekdays: 
<strong>So</strong>nntag, 
<strong>Mo</strong>ntag, 
<strong>Di</strong>enstag, 
<strong>Mi</strong>ttwoch, 
<strong>Do</strong>nnerstag, 
<strong>Fr</strong>eitag, 
<strong>Sa</strong>mstag.
</p>
GFis
    my $CHURCHCAL = "java -jar ../../dist/churchcal.jar de_tr -s ";
    my %hash = ();

    my $year_list = "";
    my $sunday_list = "";
    
    my $byear = 1685; # year in Bach's lifetime
    while ($byear <= 1750) { # 1750) {
        & bach_year ($byear);
        $year_list .= "<a href=\"$byear.html\">$byear</a> ";
        $byear ++;
    } # while $byear
    
    foreach my $sunday (sort keys %hash) {
        & bach_sunday($sunday);
        $sunday_list .= "<a href=\"$sunday.html\">$sunday</a> ";
    }
    
    & bach_index($year_list);

sub bach_index {
    my ($year_list) = @_;
    open (OUT, ">", "index.html") || die "cannot write index.html";
    print OUT <<"GFis";
$dochead
    <title>Sundays and Holidays in Bach\'s Lifetime</title>
</head>
<body>
<h2>Sundays and Holidays in the Lifetime of Johann Sebastian Bach</h2>
<p>
Select any of the following years in Bach\'s lifetime to
see a list of the dates of all Sundays and holidays in that year:<br />
$year_list
</p>
<p>
Select any of the following days to
see a list of the dates in the years 1685-1750 where that day occurred:<br />
$sunday_list
</p>
<p>
c.f. also <a href="http://de.wikipedia.org/wiki/Bestimmungen_der_Bachkantaten">Bestimmungen der Bachkantaten</a> (in German)
</p>
$iso
$docfoot
GFis
    close OUT;
}

sub bach_year {
    my ($byear) = @_;
    open (OUT, ">", "$byear.html") || die "cannot write $byear.html";
    print OUT <<"GFis";
$dochead
    <title>Sundays and Holidays in Year $byear</title>
</head>
<body>
<h2>Sundays and Holidays in Year $byear</h2>
$iso
<pre>
GFis
    my @weekday = ( '', 'So', 'Mo', 'Di', 'Mi', 'Do', 'Fr', 'Sa' );
    foreach my $line (split (/\r?\n/, `$CHURCHCAL $byear table`)) {
        my ($syear, $syday, $smonth, $sday, $swday, $sweek, $sattr, $text) = split (/\t/, $line);
        if ($swday == 1 or (length($text) > 2 && ($text !~ m/^\'KW /))) { # select Sundays and Holidays only
            $text =~ s/\s+\Z//; # remove trailing whitespace
            $text =~ s/\'//g; # remove all apostrophes
            my $sundate = sprintf("%04d-%02d-%02d %s", $syear, $smonth, $sday, $weekday[$swday]);
            print OUT "$sundate <a href=\"$text.html\">$text</a>\n";
            $hash{$text} .= "\n<a href=\"$syear.html\">" . substr($sundate, 0, 4) . "</a>" . substr($sundate, 4);
        }
    } # foreach
    print OUT <<"GFis";
</pre>
$docfoot
GFis
    close OUT;
} # 

sub bach_sunday {
    my ($bsunday) = @_;
    open (OUT, ">", "$bsunday.html") || die "cannot write $bsunday.html";
    print OUT <<"GFis";
$dochead
    <title>Dates of \"$bsunday\"</title>
</head>
<body>
    <h2>Dates of \"$bsunday\"</h2>
$iso
<pre>
GFis
    print OUT $hash{$bsunday};
    print OUT <<"GFis";
</pre>
$docfoot
GFis
    close OUT;
}
# 1685    1       1       1       2       1       273     'Neujahr'
# 1685    2       1       2       3       1       129     ''
# 1685    3       1       3       4       1       129     ''
# 1685    4       1       4       5       1       129     ''
# 1685    5       1       5       6       1       129     ''
# 1685    6       1       6       7       1       421     'Epiphanias'
# 1685    7       1       7       1       1       136     '1.So.n.Epiph.'
# 1685    8       1       8       2       2       129     'KW 2'
# 1685    9       1       9       3       2       129     ''
# 1685    10      1       10      4       2       129     ''
# 1685    11      1       11      5       2       129     ''
# 1685    12      1       12      6       2       129     ''
# 1685    13      1       13      7       2       133     ''
# 1685    14      1       14      1       2       136     '2.So.n.Epiph.'
# 1685    15      1       15      2       3       129     'KW 3'
# 1685    16      1       16      3       3       129     ''
# 1685    17      1       17      4       3       129     ''
# 1685    18      1       18      5       3       129     ''
# 1685    19      1       19      6       3       129     ''
# 1685    20      1       20      7       3       133     ''
# 1685    21      1       21      1       3       136     '3.So.n.Epiph.'
# 1685    22      1       22      2       4       129     'KW 4'
# 1685    23      1       23      3       4       129     ''
# 1685    24      1       24      4       4       129     ''
# 1685    25      1       25      5       4       129     ''
# 1685    26      1       26      6       4       129     ''
# 1685    27      1       27      7       4       133     ''
# 1685    28      1       28      1       4       136     '4.So.n.Epiph.'
# 1685    29      1       29      2       5       129     'KW 5'
# 1685    30      1       30      3       5       129     ''
# 1685    31      1       31      4       5       129     ''
# 1685    32      2       1       5       5       129     ''
# 1685    33      2       2       6       5       129     ''
# 1685    34      2       3       7       5       133     ''
# 1685    35      2       4       1       5       136     ''
# 1685    36      2       5       2       6       129     'KW 6'
__DATA__
=1. Advent
=1. Weihnachtstag
e Christmas Day, December 25th
d Weihnachten, 25. Dezember
=1.So.n.Epiph.
=1.So.n.Trin. 
=10.So.n.Trin. 
=11.So.n.Trin.
=12.So.n.Trin.
=13.So.n.Trin.
=14.So.n.Trin.
=15.So.n.Trin.
=16.So.n.Trin.
=17.So.n.Trin.
=18.So.n.Trin.
=19.So.n.Trin.
=2. Advent
=2. Weihnachtstag
e Day after Christmas, December 26th
d 26. Dezember
=2.So.n.Epiph.
=2.So.n.Trin.
=2.So.n.Weihn.
=20.So.n.Trin.
=21.So.n.Trin.
=22.So.n.Trin.
=23.So.n.Trin.
=24.So.n.Trin.
=25.So.n.Trin.
=26.So.n.Trin.
=27.So.n.Trin.
=3. Advent
=3.So.n.Epiph.
=3.So.n.Trin.
=4. Advent
e 4th of Advent is the last Sunday on or before December 24th.
d Der 4. Advent ist der letzte Sonntag vor dem 24. Dezember, oder am 24.12.
=4.So.n.Epiph.
=4.So.n.Trin.
=5.So.n.Epiph.
=5.So.n.Trin.
=6.So.n.Trin.
=7.So.n.Trin.
=8.So.n.Trin.
=9.So.n.Trin.
=Allerheiligen
=Aschermittwoch
=Buß- und Bettag
=Christi Himmelf.
=Epiphanias
=Estomihi
=Exaudi
=Fastnacht
=Fronleichnam
=Gründonnerstag
e Thursday before <a href="Ostersonntag.html">Easter</a>, Last Supper
=Heiliger Abend
e Christmas Eve, December 24th, Birth of Christ
=Invokavit
=Johannis
=Jubilate
=Judika
=Kantate
=Karfreitag
e Good Friday, Friday before <a href="Ostersonntag.html">Easter</a>, Cruxifixion of Christ
=Karsamstag
e Saturday before <a href="Ostersonntag.html">Easter</a>
=Laetare
=Letzter
=So.n.Epiph.
=Maifeiertag
e Workers Day, May 1st
=Martini
e St. Martin who shared his clothes, November 11th
=Michaelis
=Misericordias
=Dom.
=Neujahr
=Nikolaus
e St. Nikolaus
=Okuli
=Ostermontag
=Ostersonntag
=Palmsonntag
e Sunday before <a href="Ostersonntag.html">Easter</a>, Jesus entered Jerusalem on palm leaves
=Pfingsten
e Pentecoste, 7 weeks after <a href="Ostersonntag.html">Easter</a>, the holy ghost was poured on to the apostles
=Pfingstmontag
=Quasimodogeniti
=Reformationsfest
=Reminiszere
=Rogate
=Rosenmontag
=Septuagesimae
=Sexagesimae
=Silvester
=So.n.Weihnachten
=T.d.Wiedervereinig.
=Trinitatis
