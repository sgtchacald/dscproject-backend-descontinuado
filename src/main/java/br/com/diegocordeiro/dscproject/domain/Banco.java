package br.com.diegocordeiro.dscproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="CONTAS")
public class Conta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;

	@Column(name = "AGENCIA", length = 30, nullable = false)
	private String agencia;

	@Column(name = "AGENCIA_DV", length = 30, nullable = false)
	private String agenciaDigito;

	@Column(name = "CONTA", length = 30, nullable = false)
	private String conta;

	@Column(name = "CONTA_DV", length = 30, nullable = false)
	private String contaDigito;

	@OneToMany(mappedBy = "ativo")
	private Banco banco;

	@JsonIgnore
	@OneToMany(mappedBy = "ativo")
	private List<Operacao> operacoes = new ArrayList<>();

	public Conta() {
	}

	public Conta(Integer id, String codigo, String nome, String descricao) {
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
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}
	
}
