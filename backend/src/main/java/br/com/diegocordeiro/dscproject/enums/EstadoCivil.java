package br.com.diegocordeiro.dscproject.enums;

public enum EstadoCivil {
	
	SOLTEIRO("S", "Solteiro(a)"),
	CASADO("C", "Casado(a)"),
	DIVORCIADO("D", "Divorciado(a)"),
	VIUVO("V", "Viúvo(a)"),
	SEPARADO("X", "Separado(a)");
	
	private String codigo;
	private String descricao;
	
	private EstadoCivil(String codigo, String descricao) {
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

	public static EstadoCivil toEnum(String codigo){
		
		if(codigo == null) {
			return null;
		}
		
		for(EstadoCivil x : EstadoCivil.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}

	

}
