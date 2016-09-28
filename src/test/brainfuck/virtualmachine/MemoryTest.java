package test.brainfuck.virtualmachine;

import brainfuck.virtualmachine.Memory;

import static org.junit.Assert.*;
import org.junit.Test;

public class MemoryTest{
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
}
