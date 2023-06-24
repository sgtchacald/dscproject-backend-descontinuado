package br.com.diegocordeiro.dscproject.services.exceptions;

public class RuntimeException extends java.lang.RuntimeException {

	private static final long serialVersionUID = 1L;

	public RuntimeException(String msg) {
		super(msg);
	}

	public RuntimeException(String msg, Throwable causa) {
		super(msg, causa);

	}

}
