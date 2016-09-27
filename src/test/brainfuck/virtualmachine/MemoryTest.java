package test.brainfuck.virtualmachine;

import brainfuck.virtualmachine.Memory;

//import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Test;

public class MemoryTest{
	@Test
	public void memoryConstructor(){
		Memory mem = new Memory();
		assertNotNull(true);
	}
}
