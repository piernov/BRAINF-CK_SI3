package brainfuck;

import java.util.List;

/**
 * Translate an instruction in an other form.
 * @author Miaou
 * @see Instruction
 */

 public class Translator {
   /**
 	 * Write the instruction with the long syntax.
   *
   * @param instr	instruction to translate.
 	 */
   public void toLongSyntax(Instruction instr) {
     System.out.print(instr.getName());
   }

   /**
 	 * Write the instruction with the long syntax.
   *
   * @param instructions list of instructions to translate.
 	 */
   public void toLongSyntax(List<Instruction> instructions) {
     for (int i = 0; i < instructions.size(); i++) {
       System.out.println(instructions.get(i).getName());
     }
   }

   /**
 	 * Write the instruction in the short syntax.
 	 *
 	 * @param instr	instruction to translate.
 	 */
   public void toShortSyntax(Instruction instr) {
     System.out.print(instr.getSymbol());
   }

   /**
 	 * Write the instruction in the short syntax.
 	 *
 	 * @param instructions list of instructions to translate.
 	 */
   public void toShortSyntax(List<Instruction> instructions) {
     for (int i = 0; i < instructions.size(); i++) {
       System.out.print(instructions.get(i).getSymbol());
     }
   }

   /**
 	 * Write the instruction in a sequence of hexadecimal numbers.
 	 *
 	 * @param instr	instruction to translate.
 	 */
   public void toColor(Instruction instr) {
     System.out.print(String.format("FF%02X%02X%02X", instr.getColor()[0], instr.getColor()[1], instr.getColor()[2]));
   }

   /**
 	 * Write the instruction in a sequence of hexadecimal numbers.
 	 *
 	 * @param instructions list of instructions to translate.
 	 */
   public void toColor(List<Instruction> instructions) {
     for (int i = 0; i < instructions.size(); i++) {
       System.out.print(String.format("FF%02X%02X%02X", instructions.get(i).getColor()[0], instructions.get(i).getColor()[1], instructions.get(i).getColor()[2]));
     }
   }
 }
