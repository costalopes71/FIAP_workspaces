package br.com.fiap.ead.exercicio1.exceptions;

public class NoResultsException extends Exception {

	private static final long serialVersionUID = -5353979427041066755L;

	public NoResultsException() {

	}

	public NoResultsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoResultsException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoResultsException(String message) {
		super(message);
	}

	public NoResultsException(Throwable cause) {
		super(cause);
	}
	
}
