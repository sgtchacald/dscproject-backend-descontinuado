package br.com.diegocordeiro.dscproject.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import br.com.diegocordeiro.dscproject.domain.Operacao;

public class OperacaoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
private Integer id;
	
	private Date dataOperacao;
	
	private String paridade;
	
	private String tipoOperacao;
	
	private BigDecimal valorAtivo;
	
	private BigDecimal quantiaAtivo;
	
	private BigDecimal valorExecutadoNaOperacao;
	
	private BigDecimal taxaOperacao;
	
	Integer usuarioId;
	
	Integer ativoId;	
	
	public OperacaoDTO(){
	}
	
	public OperacaoDTO(Operacao obj){
		id = obj.getId();
		dataOperacao = obj.getDataOperacao();
		paridade = obj.getParidade();
		tipoOperacao = obj.getTipoOperacao().getCodigo();
		valorAtivo = obj.getValorAtivo();
		quantiaAtivo = obj.getQuantiaAtivo();
		valorExecutadoNaOperacao = obj.getValorExecutadoNaOperacao();
		taxaOperacao = obj.getTaxaOperacao();
		usuarioId = obj.getUsuario().getId();
		ativoId = obj.getAtivo().getId();
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

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
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

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getAtivoId() {
		return ativoId;
	}

	public void setAtivoId(Integer ativoId) {
		this.ativoId = ativoId;
	}
	
}