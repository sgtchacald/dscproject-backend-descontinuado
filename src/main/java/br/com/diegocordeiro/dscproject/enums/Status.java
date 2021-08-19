package br.com.diegocordeiro.dscproject.enums;

public enum Status {
	
	ATIVO("A", "Ativo"),
	INATIVO("I", "Inativo");
	
	private String codigo;
	private String descricao;
	
	private Status(String codigo, String descricao) {
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

	public static Status toEnum(String codigo){
		
		if(codigo == null) {
			return null;
		}
		
		for(Status x : Status.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}

	

}
