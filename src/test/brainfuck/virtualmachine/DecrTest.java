package test.brainfuck.virtualmachine;

import brainfuck.instructions.Instruction;
import brainfuck.instructions.Decr;
import brainfuck.virtualmachine.Machine;
import brainfuck.virtualmachine.Memory;
import brainfuck.virtualmachine.OverflowException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.Class;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class DecrTest{
	@Test
	public void decrConstructorAllocation() {
		Instruction decr = new Decr();
		assertNotNull(decr);
	}

	@Test
	public void decrOne() {
		Instruction decr = new Decr();
		Machine machine = new Machine();
		byte val = Byte.MAX_VALUE;
		machine.writeMemory(val);
		decr.accept(machine);
		assertEquals(val-1, machine.readMemory());
	}

	@Test
	public void decrMax() throws Throwable {
		Instruction decr = new Decr();
		Machine machine = new Machine();
		byte val = Byte.MAX_VALUE;
		machine.writeMemory(val);
		int count = Byte.MAX_VALUE - Byte.MIN_VALUE;

		for (int i = 0; i < count; i++) decr.accept(machine);

		assertEquals(val-count, machine.readMemory());
	}

	@Test(expected = OverflowException.class)
	public void decrOverflow() throws Throwable {
		Instruction decr = new Decr();
		Machine machine = new Machine();

		decr.accept(machine);
	}

}
