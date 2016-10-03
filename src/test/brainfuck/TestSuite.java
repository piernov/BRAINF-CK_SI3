package test.brainfuck;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.rules.ExternalResource;

import test.brainfuck.virtualmachine.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	IncrTest.class,
	DecrTest.class,
	MemoryTest.class,
	ReadFileTest.class
})

public class TestSuite {
	static SecurityManager securityManager;

	static public class OutOfMemoryException extends RuntimeException {};
	static public class OverflowException extends RuntimeException {};
	static public class UnexpectedExitCodeException extends RuntimeException {};

	@BeforeClass
	public static void setUp() {
		securityManager = System.getSecurityManager();
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				super.checkExit(status); // This is IMPORTANT!
				switch (status) {
					case 1: throw new OverflowException();
					case 2: throw new OutOfMemoryException();
					default: throw new UnexpectedExitCodeException();
				}
			}
		});
	}

	@AfterClass
	public static void tearDown() {
		System.setSecurityManager(securityManager);
	}
}
