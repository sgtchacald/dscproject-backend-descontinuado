package br.com.diegocordeiro.dscproject.enums;

public enum TipoTelefone {
	
	CELULAR("C", "Celular"),
	FIXO("F", "Residencial"),
	RECADO("R", "Recado");
	
	private String codigo;
	private String descricao;
	
	private TipoTelefone(String codigo, String descricao) {
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

	public static TipoTelefone toEnum(String codigo){
		
		if(codigo == null) {
			return null;
		}
		
		for(TipoTelefone x : TipoTelefone.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}

	

}
