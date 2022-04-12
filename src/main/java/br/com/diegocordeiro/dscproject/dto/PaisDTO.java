package br.com.diegocordeiro.dscproject.dto;

import java.io.Serializable;

import br.com.diegocordeiro.dscproject.domain.Pais;

public class PaisDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String nomePt;
	private String sigla;
	private Integer bacen;
	private String urlBandeira;
	
	public PaisDTO() {
	}

	public PaisDTO(Pais obj) {
		id = obj.getId();
		nome = obj.getNome();
		nomePt = obj.getNomePt();
		sigla = obj.getSigla();
		bacen = obj.getBacen();
		urlBandeira = obj.getUrlBandeira();
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
	
	
}
