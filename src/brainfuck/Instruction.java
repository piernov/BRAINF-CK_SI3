package brainfuck;

import java.util.function.Consumer;

import brainfuck.virtualmachine.Machine;
import brainfuck.virtualmachine.OverflowException;

/**
 * Superclass for all the instructions supported by the Brainfuck language.
 * All instructions have a name (keyword), a symbol and a color which must be unique.
 * An instruction can perform a single Consumer-like operation on the Machine.
 *
 * @author Pierre-Emmanuel Novac
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html">Consumer</a>
 * @see Machine
 */
public abstract class Instruction implements Consumer<Machine> {
	/**
	 * Instruction's name, ie. keyword for the long syntax.
	 */
	private String name;

	/**
	 * Instruction's symbol, ie. character for the short syntax.
	 */
	private char symbol;

	/**
	 * Instruction's color used in images.
	 */
	private String color;

	/**
	 * Constructs an instruction with the given name, symbol and color.
	 *
	 * @param name		Instruction's keyword.
	 * @param symbol	Instruction's symbol.
	 * @param color		Instruction's color.
	 */
	public Instruction(String name, char symbol, String color) {
		this.name = name;
		this.symbol = symbol;
		this.color = color;
	}

	/**
	 * @return Instruction's {@link Instruction#name}.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Instruction's {@link Instruction#symbol}.
	 */
	public char getSymbol() {
		return symbol;
	}

	/**
	 * @return Instruction's {@link Instruction#color}.
	 */
	public String getColor() {
		return color;
	}
}
