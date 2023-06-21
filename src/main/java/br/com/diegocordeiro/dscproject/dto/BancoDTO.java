package br.com.diegocordeiro.dscproject.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

import br.com.diegocordeiro.dscproject.domain.Ativo;

public class AtivoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotBlank(message="{erro.campo.obrigatorio}")
	private String codigo;
	
	@NotBlank(message="{erro.campo.obrigatorio}")
	private String nome;
	
	@NotBlank(message="{erro.campo.obrigatorio}")
	private String descricao;
	
	public AtivoDTO(){
	}
	
	public AtivoDTO(Ativo obj){
		id = obj.getId();
		codigo = obj.getCodigo();
		nome = obj.getNome();
		descricao = obj.getDescricao();
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
	
}