package br.com.fiap.ead.exercicio1.exceptions;

public class CommitException extends Exception {

	private static final long serialVersionUID = 1558969296508146633L;

	public CommitException() {

	}

	public CommitException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CommitException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CommitException(String arg0) {
		super(arg0);
	}

	public CommitException(Throwable arg0) {
		super(arg0);
	}
	
}
