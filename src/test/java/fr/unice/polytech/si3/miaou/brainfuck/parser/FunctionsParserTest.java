package fr.unice.polytech.si3.miaou.brainfuck.parser;

import fr.unice.polytech.si3.miaou.brainfuck.InstructionSet;
import fr.unice.polytech.si3.miaou.brainfuck.JumpTable;
import fr.unice.polytech.si3.miaou.brainfuck.instructions.Instruction;
import fr.unice.polytech.si3.miaou.brainfuck.instructions.ProcedureCall;
import fr.unice.polytech.si3.miaou.brainfuck.virtualmachine.Machine;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import fr.unice.polytech.si3.miaou.brainfuck.exceptions.SyntaxFunctionException;
import fr.unice.polytech.si3.miaou.brainfuck.virtualmachine.Machine;
import fr.unice.polytech.si3.miaou.brainfuck.JumpTable;

public class FunctionsParserTest {
	private FunctionsParser parser;
	private InstructionSet instructionSet;

	@Before
	public void defineContext() {
		instructionSet = new InstructionSet();
		parser = new FunctionsParser(instructionSet);
		parser.apply("FUNC Miaou");
		parser.apply("++");
		parser.apply("RET");
		parser.apply("FUNC Nyan");
		parser.apply("-");
		parser.apply("RET");
	}

	@Test
	public void testExists() {
		assertNotNull(instructionSet.getProc("Miaou"));
		assertNotNull(instructionSet.getProc("Nyan"));
	}

	@Test
	public void testCounter() {
		assertEquals(5, parser.getCounter());
	}

	@Test
	public void testParseCall() {
		List<Instruction> instr = new ArrayList<>();
		parser.parseCall(new String[]{"Miaou"}, instr);
		parser.parseCall(new String[]{"Nyan"}, instr);
		assertEquals(2, instr.size());
		assertEquals(ProcedureCall.class, instr.get(0).getClass());
		assertEquals(ProcedureCall.class, instr.get(1).getClass());
	}

	@Test
	public void testParseCallParameter() {
		List<Instruction> instr = new ArrayList<>();
		parser.parseCall(new String[]{"Miaou", "13"}, instr);
		assertEquals(ProcedureCall.class, instr.get(0).getClass());
	}

	@Test
	public void declareTest() {
		parser.apply("FUNC MIAOU");
		parser.apply("RET");
		assertEquals("MIAOU", instructionSet.getProc("MIAOU").getName());
		assertEquals(1, parser.getCounter());
	}

	@Test
	public void declareShortSyntaxTest() {
		parser.apply("FUNC MIAOU");
		parser.apply("+++");
		parser.apply("+++");
		parser.apply("RET");
		parser.apply("FUNC NYAN");
		parser.apply("MIAOU");
		parser.apply("RET");
		parser.apply("NYAN");

		assertEquals(9, parser.getCounter());

		assertEquals("MIAOU", instructionSet.getProc("MIAOU").getName());

		Machine machine = new Machine(10, new JumpTable());
		machine.executeOp(instructionSet.getProc("NYAN"));
		assertEquals(7, machine.getInstrPointer());
		machine.executeOp(instructionSet.getProc("MIAOU"));
		assertEquals(0, machine.getInstrPointer());
	}

	@Test(expected=SyntaxFunctionException.class)
	public void retSyntaxErrorTest() {
		parser.apply("RET");
	}

	@Test(expected=SyntaxFunctionException.class)
	public void doubledeclareFuncErrorTest() {
		parser.apply("FUNC MIAOU");
		parser.apply("FUNC NYAN");
	}

	@Test(expected=SyntaxFunctionException.class)
	public void noNameTest() {
		parser.apply("FUNC");
	}
}
