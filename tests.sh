#!/bin/bash
java -Djava.security.manager -Djava.security.policy=java.policy -cp "./hamcrest-core-1.3.jar:./junit-4.12.jar:./bin" org.junit.runner.JUnitCore test.brainfuck.TestSuite
java -Djava.security.manager -Djava.security.policy=java.policy -cp "./hamcrest-core-1.3.jar:./junit-4.12.jar:./bin" org.junit.runner.JUnitCore test.levels.ComplianceSuite
