package br.com.diegocordeiro.dscproject.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OPERACOES")
public class Operacao extends Auditoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 100, nullable = false)
	private Integer id;
	
	@Column(name = "DATA_OPERACAO")
	private Date dataOperacao;
	
	@Column(name = "TIPO_OPERACAO", length = 1, nullable = false)
	private String tipoOperacao;
	
	@Column(name = "VALOR_COTACAO_ATIVO")
	private double valorAtivo;
	
	@Column(name = "QUANTIA_ATIVO")
	private double quantiaAtivo;
	
	@Column(name = "VALOR_EXECUTADO_OPERACAO")
	private double valorExecutadoNaOperacao;
	
	@Column(name = "TAXA_OPERACAO")
	private double taxaOperacao;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "ID_ATIVO")
	private Ativo ativo;

	public Operacao(){
	}

	public Operacao(Integer id, Date dataOperacao, String tipoOperacao, double valorAtivo, double quantiaAtivo,
			double valorExecutadoNaOperacao, double taxaOperacao, Usuario usuario, Ativo ativo) {
		super();
		this.id = id;
		this.dataOperacao = dataOperacao;
		this.tipoOperacao = tipoOperacao;
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

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public double getValorAtivo() {
		return valorAtivo;
	}

	public void setValorAtivo(double valorAtivo) {
		this.valorAtivo = valorAtivo;
	}

	public double getQuantiaAtivo() {
		return quantiaAtivo;
	}

	public void setQuantiaAtivo(double quantiaAtivo) {
		this.quantiaAtivo = quantiaAtivo;
	}

	public double getValorExecutadoNaOperacao() {
		return valorExecutadoNaOperacao;
	}

	public void setValorExecutadoNaOperacao(double valorExecutadoNaOperacao) {
		this.valorExecutadoNaOperacao = valorExecutadoNaOperacao;
	}

	public double getTaxaOperacao() {
		return taxaOperacao;
	}

	public void setTaxaOperacao(double taxaOperacao) {
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
