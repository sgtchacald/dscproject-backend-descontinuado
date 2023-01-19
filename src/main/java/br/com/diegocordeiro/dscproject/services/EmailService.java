package br.com.diegocordeiro.dscproject.services;

import jakarta.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import br.com.diegocordeiro.dscproject.domain.Usuario;

public interface EmailService {

	void enviaConfirmacaoCadastroUsuario(Usuario obj);
	
	void enviaConfirmacaoHtmlCadastroUsuario(Usuario obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendHtmlEmail(MimeMessage msg);

	void sendNewPasswordEmail(Usuario usuario, String newPass);
	
	//void sendNewPasswordEmail(Cliente cliente, String newPass);
}
