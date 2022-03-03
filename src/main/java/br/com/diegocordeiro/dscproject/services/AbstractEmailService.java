package br.com.diegocordeiro.dscproject.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.com.diegocordeiro.dscproject.domain.Usuario;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.email.remetente}")
	private String remetente;
	
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
}
