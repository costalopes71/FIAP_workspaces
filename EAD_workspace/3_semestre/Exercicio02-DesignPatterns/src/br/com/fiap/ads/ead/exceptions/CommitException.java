package br.com.fiap.ads.ead.exceptions;

import java.io.Serializable;

public class CommitException extends Exception implements Serializable {

	private static final long serialVersionUID = -8624130743345244801L;

	public CommitException() {
		super();
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
