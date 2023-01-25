package br.com.diegocordeiro.dscproject.dto;

import br.com.diegocordeiro.dscproject.domain.Auditoria;
import br.com.diegocordeiro.dscproject.enums.TipoPerfil;
import br.com.diegocordeiro.dscproject.validation.constraints.Usuario;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;

@Usuario
public class UsuarioSiteNovoDTO extends Auditoria implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer tipoPerfil;

	@CPF
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(max=11, message="O Campo CPF tem que ter no máximo 11 caracteres")
	private String 	cpf;

	private String 	nome;

	private String email;

	private String login;

	private String senha;

	public UsuarioSiteNovoDTO() {
	}

	public UsuarioSiteNovoDTO(br.com.diegocordeiro.dscproject.domain.Usuario obj) {
		this.id = obj.getId();
		this.tipoPerfil = TipoPerfil.ADMIN.getCodigo();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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