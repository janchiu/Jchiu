#! /usr/bin/env python
import os.path
from subprocess import call
import sys

student = sys.argv[1]
score = 0

if (not os.path.isdir(student)):
    print student,"not a directory"
    sys.exit(1)

os.chdir(student)

if (os.path.isdir("lab4")):
    os.chdir("lab4")

if (not os.path.isfile('Makefile')):
    print "No Makefile"
else:
    print "Makefile exists"
    score = score + 1

call(["rm","BlockchainClient","*.o","testout.txt"])

if (call(["make"]) == 0):
    print "make did something"
    if (os.path.isfile('BlockchainClient')): score = score + 1
    else: print "no BlockchainClient created"
else:
    print "make failed"

if (call(["BlockchainClient","testin.txt","testout.txt"],stdout=open("testout.txt","w+"))==0):
    print "BlockchainClient ran with output:"
    call(["cat","testout.txt"])
    print "*********End of output********\n"
    score = score + 1
else:
    print "BlockchainClient failed"

if (not os.path.isfile('testout.txt')):
    print "No testout.txt generated"
else:
#    if (call(["diff","-b", "-B", "/Users/charlie/grading/12b/s18/lab4/BlockOut.txt", "testout.txt"]) == 0):
    if (call(["diff","-b", "-B", "BlockOut", "testout.txt"]) == 0):
        print "correct testout.txt"
        score = score + 4
    else: print "wrong testout.txt"


if (call(["valgrind","-v","--leak-check=full","--error-exitcode=33","BlockchainClient"])==0):
    print "valgrind passed"
    score = score + 1
else:
    print "valgrind failed"

if (os.path.isfile('log.txt')): score = score + 1
else: print "no log.txt"

if (os.path.isfile('README')): score = score + 1
else: print "no README"

print student, "score is ", score
