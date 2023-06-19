package br.com.diegocordeiro.dscproject.services.exceptions;

public class MailSendException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MailSendException(String msg) {
		super(msg);
	}

	public MailSendException(String msg, Throwable causa) {
		super(msg, causa);
	}

}
