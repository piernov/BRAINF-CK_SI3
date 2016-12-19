package fr.unice.polytech.si3.miaou.brainfuck.io;

import java.util.*;
import java.io.*;
import java.nio.file.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;

import org.junit.rules.TemporaryFolder;


public class IoTest {
	Io io;

	ByteArrayOutputStream outStream;

	@Rule
	public TemporaryFolder testFolder = new TemporaryFolder();

	@Before
	public void setUp() {
		outStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outStream));
	}

	@Test
	public void writeSystemOutTest() throws FileNotFoundException {
		io = new Io(null, null);
		io.write('a');
		assertEquals("a", outStream.toString());
	}

	@Test
	public void writeFileOutTest() throws IOException, FileNotFoundException {
		String filename = testFolder.newFile().getPath();
		io = new Io(null, filename);
		io.write('a');
		assertEquals("a", new String(Files.readAllBytes(Paths.get(filename))));
	}
}
