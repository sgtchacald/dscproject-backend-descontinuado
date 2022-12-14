package br.com.diegocordeiro.dscproject.enums;

public enum TipoPerfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	VISITANTE(2, "ROLE_VISITANTE");
	
	private int codigo;
	private String descricao;
	
	private TipoPerfil(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoPerfil toEnum(Integer codigo){
		
		if(codigo == null) {
			return null;
		}
		
		for(TipoPerfil x : TipoPerfil.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" + codigo);
	}
	
	

}
