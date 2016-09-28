# Miaou

# How to compile

## With JUnit (Example)
>javac -d bin/ -cp junit-4.12.jar src/brainfuck/\*.java src/brainfuck/instructions/\*.java src/brainfuck/virtualmachine/\*.java src/test/brainfuck/virtualmachine/MemoryTest.java

## Without JUnit
>javac -d bin/ src/brainfuck/\*.java src/brainfuck/instructions/\*.java src/brainfuck/virtualmachine/\*.java

# How to run

## JUnit (Example)
>java -cp "./hamcrest-core-1.3.jar:./junit-4.12.jar:./bin" org.junit.runner.JUnitCore test.brainfuck.virtualmachine.MemoryTest

## The program
>java -cp "./bin/" brainfuck.Main
