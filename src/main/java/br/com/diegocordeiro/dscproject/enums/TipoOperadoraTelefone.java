package br.com.diegocordeiro.dscproject.enums;

public enum TipoOperadoraTelefone {
	
	OI("O", "Oi"),
	TIM("T", "Tim"),
	CLARO("C", "Claro"),
	VIVO("V", "Vivo");
	
	private String codigo;
	private String descricao;
	
	private TipoOperadoraTelefone(String codigo, String descricao) {
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

	public static TipoOperadoraTelefone toEnum(String codigo){
		
		if(codigo == null) {
			return null;
		}
		
		for(TipoOperadoraTelefone x : TipoOperadoraTelefone.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}

	

}
