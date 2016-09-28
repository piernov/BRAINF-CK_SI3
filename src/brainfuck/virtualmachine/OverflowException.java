package brainfuck.virtualmachine;

public class OverflowException extends RuntimeException {
	public OverflowException() {
		super();
	}

	public OverflowException(String s){
		super(s);
	}

	public OverflowException(String s, Throwable throwable){
		super(s, throwable);
	}

	public OverflowException(Throwable throwable){
		super(throwable);
	}
}
