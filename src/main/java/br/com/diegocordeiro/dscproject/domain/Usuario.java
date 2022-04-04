package br.com.diegocordeiro.dscproject.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.diegocordeiro.dscproject.enums.TipoPerfil;

@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "NOME", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "CPF", length = 11, nullable = false, unique = true)
	private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "DATA_NASCIMENTO", nullable = false)
	private Date dtNascimento;
	
	@Column(name = "ESTADO_CIVIL", length = 2, nullable = false)
	private String estadoCivil;
	
	@Column(name = "GENERO", length = 1, nullable = false)
	private String genero;
	
	@Column(name = "IND_PORTADOR_DEFICIENCIA", length = 1, nullable = false)
	private String indPortadorDeficiencia;
	
	@Column(name = "IND_DISPONIVEL_VIAJAR", length = 1, nullable = false)
	private String indDisponivelViajar;
	
	@Column(name = "IND_DISPONIVEL_MUDAR_CIDADE", length = 1, nullable = false)
	private String indDisponivelMudarCidade;
	
	//inserir aqui idLogradouro
	
	@Column(name = "RESUMO_PROFISSIONAL", nullable = false)
	@Type(type="text")
	private String resumoProfissional;
	
	//inserir aqui lista de redes sociais 
	
	@Column(name = "URL_BLOG_SITE", length = 512, nullable = false)
	private String urlBlogSite;
	
	@Column(name = "URL_IMAGEM_PERFIL", length = 512, nullable = true)
	private String urlImagemPerfil;
	
	@Column(name = "IND_STATUS", length = 1, nullable = false)
	private String indStatus;
	
	@Column(name = "EMAIL", length = 512, nullable = false, unique = true)
	private String email;
	
	@Column(name = "LOGIN", length = 40, nullable = false)
	private String login;
	
	@Column(name = "SENHA", length = 60, nullable = false)
	private String senha;
	
	@Column(name = "PERFIL", length = 1, nullable = false)
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS_USUARIO")
	private Set<Integer> perfis =  new HashSet<>();
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Operacao> operacoes = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Investimento> investimentos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Endereco> enderecos = new ArrayList<>();
	
	
	
	public Usuario(){
		addPerfil(TipoPerfil.VISITANTE);
	}

	public Usuario(Integer id, String nome, String cpf, Date dtNascimento, String estadoCivil,
			String genero, String indPortadorDeficiencia, String indDisponivelViajar,
			String indDisponivelMudarCidade, String resumoProfissional, String urlBlogSite, String urlImagemPerfil, String indStatus, 
			String email,String login, String senha) {
		super();
		this.id = id;
		//Adiciona o perfil de visitante para todos os usuários criados por default
		addPerfil(TipoPerfil.VISITANTE);
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.estadoCivil = estadoCivil;
		this.genero = genero;
		this.indPortadorDeficiencia = indPortadorDeficiencia;
		this.indDisponivelViajar = indDisponivelViajar;
		this.indDisponivelMudarCidade = indDisponivelMudarCidade;
		this.resumoProfissional = resumoProfissional;
		this.urlBlogSite = urlBlogSite;
		this.urlImagemPerfil = urlImagemPerfil;
		this.indStatus = indStatus;
		this.email = email;
		this.login = login;
		this.senha = senha;
	}

	public Usuario(Integer id, String nome, String cpf, Date dtNascimento, String estadoCivil,
			String genero, String indPortadorDeficiencia, String indDisponivelViajar,
			String indDisponivelMudarCidade, String resumoProfissional, String urlBlogSite, String urlImagemPerfil, String indStatus, 
			String email,String login, String senha, List<Telefone> telefones) {
		super();
		this.id = id;
		//Adiciona o perfil de visitante para todos os usuários criados por default
		addPerfil(TipoPerfil.VISITANTE);
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.estadoCivil = estadoCivil;
		this.genero = genero;
		this.indPortadorDeficiencia = indPortadorDeficiencia;
		this.indDisponivelViajar = indDisponivelViajar;
		this.indDisponivelMudarCidade = indDisponivelMudarCidade;
		this.resumoProfissional = resumoProfissional;
		this.urlBlogSite = urlBlogSite;
		this.urlImagemPerfil = urlImagemPerfil;
		this.indStatus = indStatus;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.telefones = telefones;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<TipoPerfil> getPerfis() {
		return perfis.stream().map(x -> TipoPerfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(TipoPerfil perfil) {
		perfis.add(perfil.getCodigo());
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
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

	public List<Operacao> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<Operacao> operacoes) {
		this.operacoes = operacoes;
	}

	public List<Investimento> getInvestimentos() {
		return investimentos;
	}

	public void setInvestimentos(List<Investimento> investimentos) {
		this.investimentos = investimentos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuário Criado: \n");
		builder.append("id: " + this.id + "\n");
		builder.append("Nome: " + this.nome + "\n");
		builder.append("CPF: " + this.cpf + "\n");
		builder.append("E-Mail: " + this.email + "\n");
		
		
		return builder.toString();
	}
	
	
	
		
}
