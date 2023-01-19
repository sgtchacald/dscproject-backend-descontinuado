package br.com.diegocordeiro.dscproject.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.diegocordeiro.dscproject.enums.TipoOperacao;

@Entity
@Table(name="OPERACOES")
public class Operacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", length = 100, nullable = false)
	private Integer id;
	
	@Column(name = "DATA_OPERACAO")
	private Date dataOperacao;
	
	@Column(name = "PARIDADE", length = 50, nullable = false)
	private String paridade;
	
	@Column(name = "TIPO_OPERACAO", length = 1, nullable = false)
	private String tipoOperacao;
	
	@Column(name = "VALOR_COTACAO_ATIVO")
	private BigDecimal valorAtivo;
	
	@Column(name = "QUANTIA_ATIVO")
	private BigDecimal quantiaAtivo;
	
	@Column(name = "VALOR_EXECUTADO_OPERACAO")
	private BigDecimal valorExecutadoNaOperacao;
	
	@Column(name = "TAXA_OPERACAO")
	private BigDecimal taxaOperacao;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "ID_ATIVO")
	private Ativo ativo;

	public Operacao(){
	}

	public Operacao(Integer id, Date dataOperacao, String paridade,  TipoOperacao tipoOperacao, BigDecimal valorAtivo, BigDecimal quantiaAtivo,
			BigDecimal valorExecutadoNaOperacao, BigDecimal taxaOperacao, Usuario usuario, Ativo ativo) {
		super();
		this.id = id;
		this.dataOperacao = dataOperacao;
		this.paridade = paridade;
		this.tipoOperacao = tipoOperacao.getCodigo();
		this.valorAtivo = valorAtivo;
		this.quantiaAtivo = quantiaAtivo;
		this.valorExecutadoNaOperacao = valorExecutadoNaOperacao;
		this.taxaOperacao = taxaOperacao;
		this.usuario = usuario;
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
	
	public String getParidade() {
		return paridade;
	}

	public void setParidade(String paridade) {
		this.paridade = paridade;
	}

	public TipoOperacao getTipoOperacao() {
		return TipoOperacao.toEnum(tipoOperacao);
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao.getCodigo();
	}

	public BigDecimal getValorAtivo() {
		return valorAtivo;
	}

	public void setValorAtivo(BigDecimal valorAtivo) {
		this.valorAtivo = valorAtivo;
	}

	public BigDecimal getQuantiaAtivo() {
		return quantiaAtivo;
	}

	public void setQuantiaAtivo(BigDecimal quantiaAtivo) {
		this.quantiaAtivo = quantiaAtivo;
	}

	public BigDecimal getValorExecutadoNaOperacao() {
		return valorExecutadoNaOperacao;
	}

	public void setValorExecutadoNaOperacao(BigDecimal valorExecutadoNaOperacao) {
		this.valorExecutadoNaOperacao = valorExecutadoNaOperacao;
	}

	public BigDecimal getTaxaOperacao() {
		return taxaOperacao;
	}

	public void setTaxaOperacao(BigDecimal taxaOperacao) {
		this.taxaOperacao = taxaOperacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}
	
}
