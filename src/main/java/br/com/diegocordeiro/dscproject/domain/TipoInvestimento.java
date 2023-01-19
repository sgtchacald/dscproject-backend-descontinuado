package br.com.diegocordeiro.dscproject.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.diegocordeiro.dscproject.enums.TipoRenda;

@Entity
@Table(name="TIPO_INVESTIMENTO")
public class TipoInvestimento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", length = 100, nullable = false)
	private Integer id;
	
	@Column(name = "NOME", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "DESCRICAO", length = 512, nullable = false)
	private String descricao;
	
	@Column(name = "TIPO_RENDA", length = 1, nullable = false)
	private String tipoRenda;
	
	@JsonBackReference
	@OneToMany(mappedBy = "tipoInvestimento")
	private List<Investimento> investimentos = new ArrayList<>();

	public TipoInvestimento(){
	}

	public TipoInvestimento(Integer id, String nome, String descricao, TipoRenda tipoRenda) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tipoRenda = tipoRenda.getCodigo();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoRenda getTipoRenda() {
		return TipoRenda.toEnum(tipoRenda);
	}

	public void setTipoRenda(TipoRenda tipoRenda) {
		this.tipoRenda = tipoRenda.getCodigo();
	}

	public List<Investimento> getInvestimentos() {
		return investimentos;
	}

	public void setInvestimentos(List<Investimento> investimentos) {
		this.investimentos = investimentos;
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
		TipoInvestimento other = (TipoInvestimento) obj;
		return Objects.equals(id, other.id);
	}
	
}

