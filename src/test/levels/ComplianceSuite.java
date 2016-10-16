package test.levels;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;

import test.levels.one.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ZeroTest.class,
//	One.class,
//	Two.class,
//	Three.class
})

public class ComplianceSuite {
	static SecurityManager securityManager;
	@ClassRule
	public static TemporaryFolder testFolder = new TemporaryFolder();;
	public static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	public static ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	public static int exitCode = 0;

	@BeforeClass
	public static void setUp() {
		securityManager = System.getSecurityManager();
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				super.checkExit(status); // This is IMPORTANT!
				exitCode = status;
				throw new SecurityException();
			}
		});

		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@AfterClass
	public static void tearDown() {
		System.setSecurityManager(securityManager);

		System.setOut(null);
		System.setErr(null);
	}

	public static String createTmpFile(String name) throws IOException {
		return testFolder.newFile(name).getPath();
	}

	public static void writeToFile(String filename, String content) throws IOException, FileNotFoundException {
		Path filepath = Paths.get(filename);
		try (BufferedWriter writer = Files.newBufferedWriter(filepath)) {
			writer.write(content);
		}
	}
}
