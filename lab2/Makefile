# Joseph Chanin-Meiers Janson Chiu 
# jchaninm jaachiu
# 12M
# Makefile
# Compiles and runs FileReverse program
# Makefile for FileReverse.c

FileReverse : FileReverse.o
	gcc -o FileReverse FileReverse.o

FileReverse.o : FileReverse.c
	gcc -c -std=c99 -Wall FileReverse.c

clean : 
	rm -f FileReverse FileReverse.o
