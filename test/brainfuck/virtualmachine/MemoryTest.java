package brainfuck.virtualmachine;

import org.junit.Assert;

public class MemoryTest extends TestCase{
	@Test
	public void memoryConstructor(){
		Memory mem = new Memory();
		assertNotNull(mem);
	}
}
