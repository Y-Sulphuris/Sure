package one.asm;

public class AssemblyException extends RuntimeException {
	public AssemblyException() {
		super();
	}

	public AssemblyException(String message) {
		super(message);
	}

	public AssemblyException(String message, Throwable cause) {
		super(message, cause);
	}

	public AssemblyException(Throwable cause) {
		super(cause);
	}

	protected AssemblyException(String message, Throwable cause,
				    boolean enableSuppression,
				    boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
