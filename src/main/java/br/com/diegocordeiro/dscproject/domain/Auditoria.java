package br.com.diegocordeiro.dscproject.domain;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Auditoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "DATA_CADASTRO")
	private Date dataCadastro;
	
	@Column(name = "DATA_EDICAO")
	private Date dataEdicao;
	
	@Column(name = "DATA_EXCLUSAO")
	private Date dataExclusao;
	
	@Column(name = "USUARIO_CRIOU")
	private Integer usuarioCriou;
	
	@Column(name = "USUARIO_EDITOU")
	private Integer usuarioEditou;
	
	@Column(name = "USUARIO_EXCLUIU")
	private Integer usuarioExcluiu;
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(Date dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Integer getUsuarioCriou() {
		return usuarioCriou;
	}

	public void setUsuarioCriou(Integer usuarioCriou) {
		this.usuarioCriou = usuarioCriou;
	}

	public Integer getUsuarioEditou() {
		return usuarioEditou;
	}

	public void setUsuarioEditou(Integer usuarioEditou) {
		this.usuarioEditou = usuarioEditou;
	}

	public Integer getUsuarioExcluiu() {
		return usuarioExcluiu;
	}

	public void setUsuarioExcluiu(Integer usuarioExcluiu) {
		this.usuarioExcluiu = usuarioExcluiu;
	}	
}