package test.levels.one;

import test.levels.ComplianceSuite;

import brainfuck.Main;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.Class;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public class ZeroTest {
	@Test
	public void emptyProgram() throws IOException, FileNotFoundException {
		String path = ComplianceSuite.createTmpFile("empty.bf");
		ComplianceSuite.writeToFile(path, "");

		try {
			Main.main(new String[] { "-p", path });
		} catch (SecurityException se) {
		}

		assertEquals(0, ComplianceSuite.outContent.size());
		assertEquals(0, ComplianceSuite.errContent.size());
		assertEquals(0, ComplianceSuite.exitCode);
	}
}
