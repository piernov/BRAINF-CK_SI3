#!/bin/bash
# build script

# Build classes
javac -d bin/ -cp bin/:./junit-4.12.jar `find src -name \*.java`

# Builds the jar archive
# See https://docs.oracle.com/javase/tutorial/deployment/jar/appman.html
cd bin
jar vcfe ../Bfck.jar brainfuck.Main brainfuck/
cd ..

# Builds the JavaDoc
javadoc -d doc -sourcepath src -subpackages brainfuck -private
