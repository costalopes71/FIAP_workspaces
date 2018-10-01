package br.com.fiap.springjpa.exceptions;

public class KeyNotFoundException extends Exception {

	private static final long serialVersionUID = 8595671325622070195L;

	public KeyNotFoundException() {
		super();
	}

	public KeyNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public KeyNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public KeyNotFoundException(String arg0) {
		super(arg0);
	}

	public KeyNotFoundException(Throwable arg0) {
		super(arg0);
	}

}