package test.brainfuck.virtualmachine;

import brainfuck.ReadFile;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.Class;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public class ReadFileTest{
	/* http://stackoverflow.com/a/34818800 */
	static void assertStreamEquals(Stream<?> s1, Stream<?> s2)
	{
		Iterator<?> iter1 = s1.iterator(), iter2 = s2.iterator();
		while(iter1.hasNext() && iter2.hasNext())
			assertEquals(iter1.next(), iter2.next());
		assertTrue(!iter1.hasNext() && !iter2.hasNext());
	}

	@Rule
	public TemporaryFolder testFolder = new TemporaryFolder();

	@Test
	public void readFileConstructorAllocation() throws IOException, FileNotFoundException {
		String filename = testFolder.newFile("validFile.txt").toString();
		ReadFile rf = new ReadFile(filename);
		assertNotNull(rf);
	}

	@Test(expected = FileNotFoundException.class)
	public void readFileConstructorNotFound() throws FileNotFoundException {
		ReadFile rf = new ReadFile(testFolder.getRoot().toString() + "/invalidFile.txt");
	}

	@Test
	public void readFileCheckContent() throws IOException, FileNotFoundException {
		String filename = testFolder.newFile("validFile.txt").getPath();
		Path filepath = Paths.get(filename);
		try (BufferedWriter writer = Files.newBufferedWriter(filepath)) {
			writer.write("+++\n<<<\n>"); // Test content
		}
		Stream<String> stream = Files.lines(filepath);
		ReadFile rf = new ReadFile(filename);
		assertStreamEquals(stream, rf.getLines());
	}
}
