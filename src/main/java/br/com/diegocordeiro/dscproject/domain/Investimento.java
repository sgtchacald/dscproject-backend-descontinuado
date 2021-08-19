package br.com.diegocordeiro.dscproject.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="INVESTIMENTOS")
public class Investimento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "VALOR_INVESTIDO", nullable = false)
	private BigDecimal valorInvestido;
	
	@Column(name = "IND_STATUS", length = 1, nullable = false)
	private String indStatus;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_INVEST")
	private TipoInvestimento tipoInvestimento;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	public Investimento(){
	}
	
	public Investimento(Integer id, BigDecimal valorInvestido, String indStatus, TipoInvestimento tipoInvestimento,
			Usuario usuario) {
		super();
		this.id = id;
		this.valorInvestido = valorInvestido;
		this.indStatus = indStatus;
		this.tipoInvestimento = tipoInvestimento;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorInvestido() {
		return valorInvestido;
	}

	public void setValorInvestido(BigDecimal valorInvestido) {
		this.valorInvestido = valorInvestido;
	}

	public String getIndStatus() {
		return indStatus;
	}

	public void setIndStatus(String indStatus) {
		this.indStatus = indStatus;
	}

	public TipoInvestimento getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(TipoInvestimento tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
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
		Investimento other = (Investimento) obj;
		return Objects.equals(id, other.id);
	}
	
}
