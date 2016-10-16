package test.brainfuck.instructions;

import test.brainfuck.TestSuite;

import brainfuck.instructions.Instruction;
import brainfuck.instructions.Incr;
import brainfuck.virtualmachine.Machine;
import brainfuck.virtualmachine.Memory;
import brainfuck.exceptions.OverflowException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.Class;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class IncrTest{
	@Test
	public void incrConstructorAllocation() {
		Instruction incr = new Incr();
		assertNotNull(incr);
	}

	@Test
	public void incrOne() {
		Instruction incr = new Incr();
		Machine machine = new Machine();
		int val = machine.readMemory();
		incr.accept(machine);
		assertEquals(val+1, machine.readMemory());
	}

	@Test
	public void incrMax() throws Throwable {
		Instruction incr = new Incr();
		Machine machine = new Machine();
		int value = machine.readMemory();
		int count = Byte.MAX_VALUE - Byte.MIN_VALUE;

		for (int i = 0; i < count; i++) incr.accept(machine);

		assertEquals(value+count, machine.readMemory());
	}

	@Test(expected = OverflowException.class)
	public void incrOverflow() throws Throwable {
		Instruction incr = new Incr();
		Machine machine = new Machine();
		int count = Byte.MAX_VALUE - Byte.MIN_VALUE + 1;

		for (int i = 0; i < count; i++) incr.accept(machine);
	}
}
