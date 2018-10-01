package br.com.fiap.aula4.exceptions;

public class CommitException extends Exception {

	private static final long serialVersionUID = 3949679038539874137L;

	public CommitException() {

	}

	public CommitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommitException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommitException(String message) {
		super(message);
	}

	public CommitException(Throwable cause) {
		super(cause);
	}
	
}
