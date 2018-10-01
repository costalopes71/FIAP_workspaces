package br.com.fiap.aula4.exceptions;

public class CarNotFoundException extends Exception {

	private static final long serialVersionUID = -7043589729885085330L;

	public CarNotFoundException() {
		super();
	}

	public CarNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CarNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CarNotFoundException(String message) {
		super(message);
	}

	public CarNotFoundException(Throwable cause) {
		super(cause);
	}

}
