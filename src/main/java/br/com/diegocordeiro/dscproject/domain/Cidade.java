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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="CIDADES")
public class Cidade extends Auditoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "NOME", length = 120, nullable = false)
	private String nome;
	
	@Column(name = "ID_IBGE", length = 120, nullable = false)
	private String idIBGE;
	
	@Column(name = "DDD", length = 50, nullable = false)
	private String ddd;

	
	@Column(name = "UF", length = 2, nullable = false)
	private String uf;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private Estado estado;
	
	public Cidade(){
	}

	public Cidade(Integer id, String nome, String idIBGE, String ddd, String uf, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.idIBGE = idIBGE;
		this.ddd = ddd;
		this.uf = uf;
		this.estado = estado;
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

	public String getIdIBGE() {
		return idIBGE;
	}

	public void setIdIBGE(String idIBGE) {
		this.idIBGE = idIBGE;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
		Cidade other = (Cidade) obj;
		return Objects.equals(id, other.id);
	}
	
}
