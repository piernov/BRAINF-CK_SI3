package test.brainfuck.virtualmachine;

import brainfuck.virtualmachine.Memory;
import brainfuck.virtualmachine.OverflowException;

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
/*
	@Test//(expected = OverflowException.class)
	public void checkBoundsUnderflow(){
		Memory mem = new Memory();
		thrown.except((Throwable)OverflowException.class);
		try{
			Method method = Memory.class.getDeclaredMethod("checkBounds",Integer.TYPE);
			method.setAccessible(true);
			method.invoke(mem,-1);
			//thrown.except(OverflowException.class);
			//thrown.except(NullPointerException.class);java -cp "./hamcrest-core-1.3.jar:./junit-4.12.jar:./bin" org.junit.runner.JUnitCore test.brainfuck.virtualmachine.MemoryTest

		}catch(Exception e){
			e.printStackTrace();
//			e.getTargetException();
		}
	}
*/
	@Test(expected = NullPointerException.class)
	public void testExcep(){
		Memory mem = null;
		mem.getSize();
	}
}
