package br.com.diegocordeiro.dscproject.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="PAISES")
public class Pais extends Auditoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "NOME", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "NOME_PT", length = 100, nullable = false)
	private String nomePt;
	
	@Column(name = "SIGLA", length = 2, nullable = false)
	private String sigla;
	
	@Column(name = "BACEN", nullable = false)
	private Integer bacen;
	
	@Column(name = "URL_BANDEIRA", length = 1024, nullable = true)
	private String urlBandeira;
	
	@JsonBackReference
	@OneToMany(mappedBy = "pais")
	private List<Estado> estados = new ArrayList<>();
	
	public Pais() {
	}

	public Pais(Integer id, String nome, String nomePt, String sigla, Integer bacen, String urlBandeira) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomePt = nomePt;
		this.sigla = sigla;
		this.bacen = bacen;
		this.urlBandeira = urlBandeira;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomePt() {
		return nomePt;
	}

	public void setNomePt(String nomePt) {
		this.nomePt = nomePt;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getBacen() {
		return bacen;
	}

	public void setBacen(Integer bacen) {
		this.bacen = bacen;
	}

	public String getUrlBandeira() {
		return urlBandeira;
	}

	public void setUrlBandeira(String urlBandeira) {
		this.urlBandeira = urlBandeira;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
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
		Pais other = (Pais) obj;
		return Objects.equals(id, other.id);
	}
}
