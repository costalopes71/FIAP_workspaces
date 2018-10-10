package br.com.fiap.spring.exception;

public class RegistroNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1693332258628486567L;

	public RegistroNaoEncontradoException() {
		super();
	}

	public RegistroNaoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RegistroNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public RegistroNaoEncontradoException(String message) {
		super(message);
	}

	public RegistroNaoEncontradoException(Throwable cause) {
		super(cause);
	}

}
