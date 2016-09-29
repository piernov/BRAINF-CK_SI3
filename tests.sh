#!/bin/bash
java -cp "./hamcrest-core-1.3.jar:/usr/share/java/junit.jar:./bin" org.junit.runner.JUnitCore test.brainfuck.virtualmachine.MemoryTest

