package brainfuck;

import java.util.HashMap;
import brainfuck.instructions.*;

/**
 * Container for all the instructions supported by the Brainfuck language.
 * For efficiency, an internal HashMap is used to map between each representations (keyword, symbol, color) and the corresponding Instruction.
 *
 * @author Pierre-Emmanuel Novac
 * @see Instruction
 */
public class InstructionSet {
	/**
	 * Lists all Instruction objects (instantiated from their respective classes).
	 */
	private final static Instruction[] instructions = {new Incr(), new Decr(), new Right(), new Left(), new In(), new Out(), new Jump(), new Back()};

	/**
	 * Maps between the instruction's keyword and the instruction object for easy fetching.
	 */
	private HashMap<String, Instruction> names;

	/**
	 * Maps between the instruction's symbol and the instruction object for easy fetching.
	 */
	private HashMap<Character, Instruction> symbols;

	/**
	 * Maps between the instruction's color and the instruction object for easy fetching.
	 */
	private HashMap<Integer, Instruction> colors;

	/**
	 * Constructs the instruction set and populates the HashMaps.
	 */
	public InstructionSet() {
		names = new HashMap<>();
		symbols = new HashMap<>();
		colors = new HashMap<>();
		for (Instruction instruction: instructions) {
			names.put(instruction.getName(), instruction);
			symbols.put(instruction.getSymbol(), instruction);
			colors.put(instruction.getColor(), instruction);
		}
	}

	/**
	 * Gets the instruction's object by its keyword.
	 *
	 * @param name	Instruction's name.
	 * @return	Corresponding Instruction object.
	 */
	public Instruction getOp(String name) {
		return names.get(name);
	}

	/**
	 * Gets the instruction's object by its symbol.
	 *
	 * @param symbol	Instruction's symbol.
	 * @return 	Corresponding Instruction object.
	 */
	public Instruction getOp(char symbol) {
		return symbols.get(symbol);
	}

	/**
	 * Gets the instruction's object by its color.
	 *
	 * @param color	Instruction's symbol.
	 * @return 	Corresponding Instruction object.
	 */
	public Instruction getOp(int color) {
		return colors.get(color);
	}
}