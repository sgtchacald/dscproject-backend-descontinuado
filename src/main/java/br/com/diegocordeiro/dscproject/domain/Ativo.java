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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ATIVOS")
public class Ativo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "CODIGO", length = 10, nullable = false)
	private String codigo;
	
	@Column(name = "NOME", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "DESCRICAO", length = 512, nullable = false)
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ativo")
	private List<Operacao> operacoes = new ArrayList<>();
	
	public Ativo() {
	}

	public Ativo(Integer id, String codigo, String nome, String descricao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Operacao> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<Operacao> operacoes) {
		this.operacoes = operacoes;
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
		Ativo other = (Ativo) obj;
		return Objects.equals(id, other.id);
	}
	
}
