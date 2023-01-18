package br.com.diegocordeiro.dscproject.enums;

public enum OperacaoPersistencia {
	INSERIR("I", "Inserir"),
	EDITAR("E", "Editar"),
	EXCLUIR("D", "Excluir");
	
	private String codigo;
	private String descricao;
	
	private OperacaoPersistencia(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static OperacaoPersistencia toEnum(String codigo){
		
		if(codigo == null) {
			return null;
		}
		
		for(OperacaoPersistencia x : OperacaoPersistencia.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}

	

}
