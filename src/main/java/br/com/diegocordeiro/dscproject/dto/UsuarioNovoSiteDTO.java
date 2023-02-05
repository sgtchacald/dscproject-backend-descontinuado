package br.com.diegocordeiro.dscproject.dto;

import br.com.diegocordeiro.dscproject.domain.Auditoria;
import br.com.diegocordeiro.dscproject.enums.TipoPerfil;
import br.com.diegocordeiro.dscproject.validation.constraints.UsuarioNovo;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;

@UsuarioNovo
public class UsuarioNovoSiteDTO extends Auditoria implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer tipoPerfil;

	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(max=11, message="Este campo deve ter no máximo 11 caracteres.")
	@CPF(message="Este campo deve conter um CPF válido.")
	private String 	cpf;

	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(max=100, message="Este campo deve ter no máximo 100 caracteres.")
	private String 	nome;

	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(max=512, message="Este campo deve ter no máximo 512 caracteres.")
	@Email(message="Este campo deve ter um e-mail válido.")
	private String email;

	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=4, max=40, message="Este campo deve ter no no mínimo 4 e no máximo 40 caracteres.")
	private String login;

	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(max=60, message="Este campo deve ter no máximo 60 caracteres.")
	private String senha;

	public UsuarioNovoSiteDTO() {
	}

	public UsuarioNovoSiteDTO(br.com.diegocordeiro.dscproject.domain.Usuario obj) {
		this.id = obj.getId();
		this.tipoPerfil = TipoPerfil.ADMIN.getCodigo();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
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