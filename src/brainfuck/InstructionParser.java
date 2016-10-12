package brainfuck;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.IntStream;

import brainfuck.Instruction;
import brainfuck.InstructionSet;

public class InstructionParser {
	private List<Instruction> instructions;
	private InstructionSet iset;

	private InstructionParser() {
		instructions = new ArrayList<Instruction>();
		iset = new InstructionSet();
	}

/*	private InstructionParser(Stream<String> stream, Consumer<?> onError) {
		this();
		stream.forEachOrdered(e -> {
			Instruction instr = iset.getOp(e);
			if (instr != null) instructions.add(instr);
			else onError(e);
		});
	}
*/

	public InstructionParser(Stream<String> stream) {
		this();


		stream.filter(l -> !"".equals(l)) // Filter out empty lines
			.forEachOrdered(line -> {
				Instruction instr = iset.getOp(line); // Tries to parse the whole line (ie. long format)
				if (instr != null) {
					instructions.add(instr);
				} else {


/*		this(stream, line -> {*/
					for (int i = 0; i < line.length(); i++) { // Tries to executes the instructions with the short format
						instr = iset.getOp(line.charAt(i));
						if (instr != null) instructions.add(instr);
						else {
							onError();
						}
					}
/*		});*/

			}
		});

	}

	public InstructionParser(IntStream stream) {
		this();
		stream.forEachOrdered(colour -> {
			Instruction instr = iset.getOp(colour);
			if (instr != null) instructions.add(instr);
			else {
				onError();
			}
		});
//		this(stream, onError);
	}

	public List<Instruction> get() {
		return instructions;
	}

	private void onError() {
		System.err.println("Invalid instruction");
		System.exit(38);
	}
}