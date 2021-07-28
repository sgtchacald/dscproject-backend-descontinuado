package br.com.diegocordeiro.dscproject.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tipo_permissao", length = 1, nullable = false)
	private Integer tipoPerfil;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "dt_nascimento", nullable = false)
	private Date dtnascimento;
	
	@Column(name = "estado_civil", length = 2, nullable = false)
	private String estadoCivil;
	
	@Column(name = "genero", length = 1, nullable = false)
	private String genero;
	
	@Column(name = "ind_portador_deficiencia", length = 1, nullable = false)
	private String indPortadorDeficiencia;
	
	@Column(name = "email", length = 512, nullable = false, unique = true)
	private String email;
	
	//inserir aqui lista de telefones com os seguintes campos
	//id, telefone, tipoTelefone, indstatus, indWhatsapp, indReceberMsg
	
	@Column(name = "ind_disponivel_viajar", length = 1, nullable = false)
	private String indDisponivelViajar;
	
	@Column(name = "ind_disponivel_mudar_cidade", length = 1, nullable = false)
	private String indDisponivelMudarCidade;
	
	//inserir aqui idLogradouro
	
	@Column(name = "resumo_profissional", length = 7000, nullable = false)
	private String resumoProfissional;
	
	//inserir aqui lista de redes sociais 
	
	@Column(name = "url_blog_site", length = 512, nullable = false)
	private String urlBlogSite;
	
	@Column(name = "ind_status", length = 1, nullable = false)
	private String indStatus;
	
	@Column(name = "login", length = 40, nullable = false)
	private String login;
	
	@Column(name = "senha", length = 255, nullable = false)
	private String senha;

	public Usuario(){
	}
	
	public Usuario(Integer id, Integer tipoPerfil, String nome, String cpf, Date dtnascimento, String estadoCivil,
			String genero, String indPortadorDeficiencia, String email, String indDisponivelViajar,
			String indDisponivelMudarCidade, String resumoProfissional, String urlBlogSite, String indStatus,
			String login, String senha) {
		super();
		this.id = id;
		this.tipoPerfil = tipoPerfil;
		this.nome = nome;
		this.cpf = cpf;
		this.dtnascimento = dtnascimento;
		this.estadoCivil = estadoCivil;
		this.genero = genero;
		this.indPortadorDeficiencia = indPortadorDeficiencia;
		this.email = email;
		this.indDisponivelViajar = indDisponivelViajar;
		this.indDisponivelMudarCidade = indDisponivelMudarCidade;
		this.resumoProfissional = resumoProfissional;
		this.urlBlogSite = urlBlogSite;
		this.indStatus = indStatus;
		this.login = login;
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
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

	public Date getDtnascimento() {
		return dtnascimento;
	}

	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getIndStatus() {
		return indStatus;
	}

	public void setIndStatus(String indStatus) {
		this.indStatus = indStatus;
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
