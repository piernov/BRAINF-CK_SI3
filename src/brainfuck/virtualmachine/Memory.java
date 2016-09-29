package brainfuck.virtualmachine;

import java.util.Arrays;

/**
 * Memory container which is basically an interface for an array of bytes.
 *
 * @author Pierre-Emmanuel Novac
 * @see OutOfMemoryException
 */
public class Memory {
	/**
	 * Default memory size, 30,000 bytes.
	 */
	private static final int DEFAULT_SIZE = 30000;

	/**
	 * Actual memory capacity.
	 */
	private int size;

	/**
	 * Memory block allocated for the virtual machine.
	 */
	private byte[] memory;

	/**
	 * Constructs a new Memory with given size.
	 *
	 * @param size	wanted memory size.
	 */
	public Memory(int size) {
		this.size = size;
		memory = new byte[size];
		Arrays.fill(memory, Byte.MIN_VALUE);
	}

	/**
	 * Constructs a new Memory with the default size.
	 */
	public Memory() {
		this(DEFAULT_SIZE);
	}

	public int getSize(){
		return this.size;
	}

	/**
	 * Throws an OutOfMemoryException exception if the given index is outside the memory block.
	 *
	 * @param i	index to check.
	 * @throws OutOfMemoryException when an invalid index is supplied.
	 */
	public void checkBounds(int i) throws OutOfMemoryException {
		if (i < 0 || i >= size) throw new OutOfMemoryException(i, size);
	}

	/**
	 * Returns the value in memory at the specified index.
	 *
	 * @param i	index in memory.
	 * @return current value at index i.
	 * @throws OutOfMemoryException	if the index is outside the memory block.
	 */
	public byte get(int i) throws OutOfMemoryException {
		checkBounds(i);
		return memory[i];
	}

	/**
	 * Change the value in memory at the specified index.
	 *
	 * @param i	index in memory.
	 * @param value	new value.
	 * @throws OutOfMemoryException if the index is outside the memory block.
	 */
	public void set(int i, byte value) throws OutOfMemoryException {
		checkBounds(i);
		memory[i] = value;
	}

	/**
	 * Returns the memory content in a String.
	 * Each byte is printed next to the other with a newline after 16 bytes.
	 *
	 * @return memory content.
	 */
	@Override
	public String toString() {
		StringBuilder tmp = new StringBuilder(size+size/16); // roughly preallocate the needed capacity
		for (int i = 0; i < size; i++) {
			tmp.append(memory[i]);
			if ((i+1)%16 == 0) {
				tmp.append('\n');
			}
		}
		return tmp.toString();
	}
}
