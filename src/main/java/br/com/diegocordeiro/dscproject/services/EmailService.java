package br.com.diegocordeiro.dscproject.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.diegocordeiro.dscproject.domain.Usuario;

public interface EmailService {

	void enviaConfirmacaoCadastroUsuario(Usuario obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	//void sendNewPasswordEmail(Cliente cliente, String newPass);
}
