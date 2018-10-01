package br.com.fiap.exceptions;

public class IdNotFoundException extends Exception {

	private static final long serialVersionUID = 8908888738626024951L;

	public IdNotFoundException() {
		super();
	}

	public IdNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public IdNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public IdNotFoundException(String arg0) {
		super(arg0);
	}

	public IdNotFoundException(Throwable arg0) {
		super(arg0);
	}
	
}
