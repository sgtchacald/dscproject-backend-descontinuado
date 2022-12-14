package br.com.diegocordeiro.dscproject.enums;

public enum Indicador {
	
	SIM("S", "Sim"),
	NAO("N", "Não");
	
	private String codigo;
	private String descricao;
	
	private Indicador(String codigo, String descricao) {
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

	public static Indicador toEnum(String codigo){
		
		if(codigo == null) {
			return null;
		}
		
		for(Indicador x : Indicador.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}

	

}
