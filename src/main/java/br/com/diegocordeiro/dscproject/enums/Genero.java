package br.com.diegocordeiro.dscproject.enums;

public enum Genero {
	
	
	FEMININO("F", "Feminino"),
	MASCULINO("M", "Masculino"),
	OUTRO("O", "Outro");
	
	private String codigo;
	private String descricao;
	
	private Genero(String codigo, String descricao) {
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

	public static Genero toEnum(String codigo){
		
		if(codigo == null) {
			return null;
		}
		
		for(Genero x : Genero.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}

	

}
