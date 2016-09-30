package test.brainfuck.virtualmachine;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	IncrTest.class,
	DecrTest.class,
	MemoryTest.class
})

public class TestSuite {
  // the class remains empty,
  // used only as a holder for the above annotations
}
