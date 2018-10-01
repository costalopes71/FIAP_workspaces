package br.com.fiap.exceptions;

public class IdNotFoundException extends Exception {

	private static final long serialVersionUID = 6688620110928562013L;

	public IdNotFoundException() {
		super();
	}

	public IdNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public IdNotFoundException(String arg0) {
		super(arg0);
	}
	
}
