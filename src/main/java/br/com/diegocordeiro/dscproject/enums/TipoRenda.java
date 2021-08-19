package br.com.diegocordeiro.dscproject.enums;

public enum TipoRenda {

	RENDA_FIXA	  ("F", "Renda Fixa"	  ),
    RENDA_VARIAVEL ("V", "Renda Variável");

	private String codigo;
	private String descricao;
	
	private TipoRenda(String codigo, String descricao) {
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

	public static TipoRenda toEnum(String codigo){
		
		if(codigo == null) {
			return null;
		}
		
		for(TipoRenda x : TipoRenda.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}

	

}
