package br.com.diegocordeiro.dscproject.dto;

import br.com.diegocordeiro.dscproject.domain.Auditoria;
import br.com.diegocordeiro.dscproject.validation.constraints.Usuario;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Usuario
public class UsuarioSiteNovoDTO extends Auditoria implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer tipoPerfil;
	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres.")
	private String 	cpf;
	@NotEmpty(message="Preenchimento Obrigatório.")
	private String 	nome;
	@NotEmpty(message="Preenchimento Obrigatório.")
	private String login;
	@Email
	@NotEmpty(message="Preenchimento Obrigatório.")
	private String email;

	@NotEmpty(message="Preenchimento Obrigatório.")

	private String senha;

	public UsuarioSiteNovoDTO() {
	}

	public UsuarioSiteNovoDTO(br.com.diegocordeiro.dscproject.domain.Usuario obj) {
		this.id = obj.getId();
		this.tipoPerfil = 1;
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.login = obj.getLogin();
		this.senha = obj.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(Integer tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}