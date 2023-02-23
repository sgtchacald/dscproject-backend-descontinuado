package br.com.diegocordeiro.dscproject.dto;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Preenchimento obrigatório")
	private String login;

	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	public CredenciaisDTO() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
