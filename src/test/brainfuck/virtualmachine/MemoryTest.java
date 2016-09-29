package test.brainfuck.virtualmachine;

import brainfuck.virtualmachine.Memory;
import brainfuck.virtualmachine.OutOfMemoryException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.Class;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class MemoryTest{
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void memoryConstructorAllocation(){
		Memory mem = new Memory();
		assertNotNull(mem);
	}

	@Test
	public void memoryConstructorDefaultSize(){
		Memory mem = new Memory();
		assertEquals(30000, mem.getSize());
	}

	@Test
	public void memoryConstructorSize(){
		Memory mem = new Memory(21432);
		assertEquals(21432, mem.getSize());
	}

	@Test(expected = OutOfMemoryException.class)
	public void checkBoundsUnderflow() throws Throwable {
		Memory mem = new Memory();
		try{
			Method method = Memory.class.getDeclaredMethod("checkBounds",Integer.TYPE);
			method.setAccessible(true);
			method.invoke(mem,-1);

		} catch (InvocationTargetException ite) {
			throw ite.getCause();
		}
	}

	@Test(expected = NullPointerException.class)
	public void testExcep(){
		Memory mem = null;
		mem.getSize();
	}

}
