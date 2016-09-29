#!/bin/bash
# build script

javac -d bin/ -cp bin/:/usr/share/java/junit.jar `find src -name \*.java`
cd bin/
# See https://docs.oracle.com/javase/tutorial/deployment/jar/appman.html
jar vcfe ../Bfck.jar brainfuck.Main brainfuck/
cd ..
