package br.com.diegocordeiro.dscproject.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.diegocordeiro.dscproject.enums.TipoOperadoraTelefone;
import br.com.diegocordeiro.dscproject.enums.TipoTelefone;

@Entity
@Table(name="TELEFONES")
public class Telefone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "OPERADORA_TELEFONE", length = 1, nullable = false)
	private String operadora;
	
	@Column(name = "TIPO_TELEFONE", length = 1, nullable = false)
	private String tipoTelefone;
	
	@Column(name = "DDD_TELEFONE", length = 5, nullable = false)
	private String ddd;
	
	@Column(name = "NUMERO_TELEFONE", length = 9, nullable = false)
	private String numero;
	
	@Column(name = "IND_RECEBER_MSG_WHATSAPP", length = 1, nullable = false)
	private String indReceberMsgWhatsapp;
	
	@Column(name = "IND_RECEBER_MSG_SMS", length = 1, nullable = false)
	private String indReceberMsgSms;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	public Telefone(){
	}	
	
	public Telefone(Integer id, TipoOperadoraTelefone operadora, TipoTelefone tipoTelefone, String ddd, String numero,
			String indReceberMsgWhatsapp, String indReceberMsgSms, Usuario usuario) {
		super();
		this.id = id;
		this.operadora = operadora.getCodigo();
		this.tipoTelefone = tipoTelefone.getCodigo();
		this.ddd = ddd;
		this.numero = numero;
		this.indReceberMsgWhatsapp = indReceberMsgWhatsapp;
		this.indReceberMsgSms = indReceberMsgSms;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoOperadoraTelefone getOperadora() {
		return TipoOperadoraTelefone.toEnum(operadora);
	}

	public void setOperadora(TipoOperadoraTelefone operadora) {
		this.operadora = operadora.getCodigo();
	}

	public TipoTelefone getTipoTelefone() {
		return TipoTelefone.toEnum(tipoTelefone);
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone.getCodigo();
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getIndReceberMsgWhatsapp() {
		return indReceberMsgWhatsapp;
	}

	public void setIndReceberMsgWhatsapp(String indReceberMsgWhatsapp) {
		this.indReceberMsgWhatsapp = indReceberMsgWhatsapp;
	}

	public String getIndReceberMsgSms() {
		return indReceberMsgSms;
	}

	public void setIndReceberMsgSms(String indReceberMsgSms) {
		this.indReceberMsgSms = indReceberMsgSms;
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
		Telefone other = (Telefone) obj;
		return Objects.equals(id, other.id);
	}

	
}
