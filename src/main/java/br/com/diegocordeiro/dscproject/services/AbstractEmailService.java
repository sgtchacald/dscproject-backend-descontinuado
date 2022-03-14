package br.com.diegocordeiro.dscproject.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import br.com.diegocordeiro.dscproject.domain.Usuario;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.email.remetente}")
	private String remetente;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void enviaConfirmacaoCadastroUsuario(Usuario obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromUsuario(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromUsuario(Usuario obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(remetente);
		sm.setSubject("Usuário Cadastrado com Sucesso: \n " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
	
	
	protected String htmlFromTemplateNovoUsuario(Usuario usuario) {
		Context context = new Context();
		context.setVariable("usuario", usuario);
		return templateEngine.process("email/confirmacaoUsuario", context);
	};
	
	@Override
	public void enviaConfirmacaoHtmlCadastroUsuario(Usuario obj) {
		try {
			MimeMessage mm = prepareMimeMessageFromUsuario(obj);
			sendHtmlEmail(mm);
		} catch (MessagingException e) {
			enviaConfirmacaoCadastroUsuario(obj);
		}
		
		
	}

	private MimeMessage prepareMimeMessageFromUsuario(Usuario obj) throws MessagingException {
		MimeMessage mm = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mm, true); 
		mmh.setTo(obj.getEmail());
		mmh.setFrom(remetente);
		mmh.setSubject("Usuário Cadastrado com Sucesso: \n " + obj.getId());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateNovoUsuario(obj),true);
		return mm;
	}

}