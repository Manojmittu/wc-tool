
command line option -c : outputs the number of bytes in a file.
ccwc -c test.txt
 342190 test.txt

command line option -l that outputs the number of lines in a file.
ccwc -l test.txt
7145 test.txt

command line option -w that outputs the number of words in a file

ccwc -w test.txt
58164 test.txt

command line option -m that outputs the number of characters in a file. If the current locale does not support multibyte characters this will match the -c option.

wc -m test.txt
339292 test.txt

ccwc -m test.txt
339292 test.txt

your goal is to support being able to read from standard input if no filename is specified

cat test.txt | ccwc -l
7145

