package br.com.diegocordeiro.dscproject.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.diegocordeiro.dscproject.domain.Auditoria;
import br.com.diegocordeiro.dscproject.domain.Telefone;
import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarEstadoCivil;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarGenero;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarIndicador;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarStatus;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarTipoPerfil;
import br.com.diegocordeiro.dscproject.validation.constraints.ValidarUsuario;

@ValidarUsuario
public class UsuarioDTO  extends Auditoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@ValidarTipoPerfil
	private Integer tipoPerfil;
	
	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres.")
	private String 	nome;
	
	@CPF
	private String cpf;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss",timezone = "America/Sao_Paulo")
	private Date dtNascimento;
	
	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(min=1, max=1, message="O tamanho deve ser 1 caracter.")
	@ValidarEstadoCivil
	private String estadoCivil;
	
	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(min=1, max=1, message="O tamanho deve ser 1 caracter.")
	@ValidarGenero
	private String genero;
	
	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(min=1, max=1, message="O tamanho deve ser 1 caracter.")
	@ValidarIndicador
	private String indPortadorDeficiencia;
	
	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(min=1, max=1, message="O tamanho deve ser 1 caracter.")
	@ValidarIndicador
	private String indDisponivelViajar;
	
	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(min=1, max=1, message="O tamanho deve ser 1 caracter.")
	@ValidarIndicador
	private String indDisponivelMudarCidade;
	
	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(min=5, max=7000, message="O tamanho deve ser entre 5 e 7000 caracteres.")	
	private String resumoProfissional;
	
	@URL(protocol = "http", message="O valor digitado deve ser uma url válida.")
	private String urlBlogSite;
	
	private String urlImagemPerfil;
	
	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(min=1, max=1, message="O tamanho deve ser 1 caracter.")
	@ValidarStatus
	private String indStatus;
	
	@NotEmpty(message="Preenchimento obrigatório.")
	@Email(message="Email inválido.")
	private String email;
	
//	@NotEmpty(message="Preenchimento Obrigatório.")
//	@Length(min=5, max=60, message="O tamanho deve ser entre 5 e 60 caracteres.")
	private String login;
	
	@NotEmpty(message="Preenchimento Obrigatório.")
	@Length(min=6, max=25, message="O tamanho deve ser entre 6 e 10 caracteres.")
	private String senha;
	
	@NotEmpty(message="O usuário deverá ter pelo menos 1 telefone.")
	private List<Telefone> telefones = new ArrayList<>();
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Usuario obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.dtNascimento = obj.getDtNascimento();
		this.estadoCivil = obj.getEstadoCivil();
		this.genero = obj.getGenero();
		this.indPortadorDeficiencia = obj.getIndPortadorDeficiencia();
		this.indDisponivelViajar = obj.getIndDisponivelViajar();
		this.indDisponivelMudarCidade = obj.getIndDisponivelMudarCidade();
		this.resumoProfissional = obj.getResumoProfissional();
		this.urlBlogSite = obj.getUrlBlogSite();
		this.urlImagemPerfil = obj.getUrlImagemPerfil();
		this.indStatus = obj.getIndStatus();
		this.email = obj.getEmail();
		this.login = obj.getLogin();
		this.senha = obj.getSenha();
		this.telefones = obj.getTelefones();
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

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIndPortadorDeficiencia() {
		return indPortadorDeficiencia;
	}

	public void setIndPortadorDeficiencia(String indPortadorDeficiencia) {
		this.indPortadorDeficiencia = indPortadorDeficiencia;
	}

	public String getIndDisponivelViajar() {
		return indDisponivelViajar;
	}

	public void setIndDisponivelViajar(String indDisponivelViajar) {
		this.indDisponivelViajar = indDisponivelViajar;
	}

	public String getIndDisponivelMudarCidade() {
		return indDisponivelMudarCidade;
	}

	public void setIndDisponivelMudarCidade(String indDisponivelMudarCidade) {
		this.indDisponivelMudarCidade = indDisponivelMudarCidade;
	}

	public String getResumoProfissional() {
		return resumoProfissional;
	}

	public void setResumoProfissional(String resumoProfissional) {
		this.resumoProfissional = resumoProfissional;
	}

	public String getUrlBlogSite() {
		return urlBlogSite;
	}

	public void setUrlBlogSite(String urlBlogSite) {
		this.urlBlogSite = urlBlogSite;
	}

	public String getUrlImagemPerfil() {
		return urlImagemPerfil;
	}

	public void setUrlImagemPerfil(String urlImagemPerfil) {
		this.urlImagemPerfil = urlImagemPerfil;
	}

	public String getIndStatus() {
		return indStatus;
	}

	public void setIndStatus(String indStatus) {
		this.indStatus = indStatus;
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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}	
	
}