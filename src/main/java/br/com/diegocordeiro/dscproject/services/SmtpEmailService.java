package br.com.diegocordeiro.dscproject.services;

import br.com.diegocordeiro.dscproject.domain.Ativo;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;
import jakarta.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Enviando e-mail...");
		try {
			mailSender.send(msg);
		}catch (MailSendException exception){
			LOG.error("Problema no envio do e-mail.");
			throw new br.com.diegocordeiro.dscproject.services.exceptions.MailSendException(
				"Problema no envio do e-mail.", exception
			);
		}
		LOG.info("E-mail enviado com sucesso.");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Enviando email html...");
		javaMailSender.send(msg);
		LOG.info("Email enviado");
		
	}
}
