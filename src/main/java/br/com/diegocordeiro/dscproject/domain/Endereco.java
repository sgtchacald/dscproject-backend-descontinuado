package br.com.diegocordeiro.dscproject.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ENDERECOS")
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", length = 60, nullable = false)
	private Integer id;
	
	@Column(name = "CEP", length = 60, nullable = false)
	private String cep;
	
	@Column(name = "TIPO_LOGRADOURO", length = 60, nullable = false)
	private String tipoLogradouro;
	
	@Column(name = "LOGRADOURO_COM_NUMERO", length = 512, nullable = false)
	private String logradouroComNumero;
	
	@Column(name = "LOGRADOURO_SEM_NUMERO", length = 512, nullable = false)
	private String logradouroSemNumero;
	
	@Column(name = "COMPLEMENTO", length = 100, nullable = false)
	private String complemento;
	
	@Column(name = "UF_CIDADE", length = 2, nullable = false)
	private String ufCidade;
	
	@Column(name = "NOME_CIDADE", length = 255, nullable = false)
	private String nomeCidade;
	
	@Column(name = "ID_IBGE_CIDADE", nullable = false)
	private String idIBGECidade;
	
	
	@Column(name = "NOME_BAIRRO_CIDADE",length = 255, nullable = false)
	private String nomeBairroCidade;
	
	@Column(name = "ORIGEM_CADASTRO",length = 1, nullable = false)
	private String origemCadastro;
	
	@ManyToOne
	@JoinColumn(name = "ID_CIDADE")
	private Cidade cidade;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	public Endereco() {
	}

	public Endereco(Integer id, String cep, String tipoLogradouro, String logradouroComNumero,
			String logradouroSemNumero, String complemento, String ufCidade, String nomeCidade, String idIBGECidade,
			String nomeBairroCidade, String origemCadastro, Cidade cidade, Usuario usuario) {
		super();
		this.id = id;
		this.cep = cep;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouroComNumero = logradouroComNumero;
		this.logradouroSemNumero = logradouroSemNumero;
		this.complemento = complemento;
		this.ufCidade = ufCidade;
		this.nomeCidade = nomeCidade;
		this.idIBGECidade = idIBGECidade;
		this.nomeBairroCidade = nomeBairroCidade;
		this.origemCadastro = origemCadastro;
		this.cidade = cidade;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouroComNumero() {
		return logradouroComNumero;
	}

	public void setLogradouroComNumero(String logradouroComNumero) {
		this.logradouroComNumero = logradouroComNumero;
	}

	public String getLogradouroSemNumero() {
		return logradouroSemNumero;
	}

	public void setLogradouroSemNumero(String logradouroSemNumero) {
		this.logradouroSemNumero = logradouroSemNumero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUfCidade() {
		return ufCidade;
	}

	public void setUfCidade(String ufCidade) {
		this.ufCidade = ufCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getIdIBGECidade() {
		return idIBGECidade;
	}

	public void setIdIBGECidade(String idIBGECidade) {
		this.idIBGECidade = idIBGECidade;
	}

	public String getNomeBairroCidade() {
		return nomeBairroCidade;
	}

	public void setNomeBairroCidade(String nomeBairroCidade) {
		this.nomeBairroCidade = nomeBairroCidade;
	}

	public String getOrigemCadastro() {
		return origemCadastro;
	}

	public void setOrigemCadastro(String origemCadastro) {
		this.origemCadastro = origemCadastro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
	
}
