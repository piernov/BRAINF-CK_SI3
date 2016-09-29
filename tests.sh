#!/bin/bash
java -cp "./hamcrest-core-1.3.jar:./junit-4.12.jar:./bin" org.junit.runner.JUnitCore test.brainfuck.virtualmachine.TestSuite
