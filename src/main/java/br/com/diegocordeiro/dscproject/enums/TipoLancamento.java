package br.com.diegocordeiro.dscproject.enums;

public enum TipoLancamento {

	PAGAR("E", "Pagamento"),
	RECEBER("S", "Recebimento");

	private String codigo;
	private String descricao;

	private TipoLancamento(String codigo, String descricao) {
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

	public static TipoLancamento toEnum(String codigo){
		
		if(codigo == null) {
			return null;
		}
		
		for(TipoLancamento x : TipoLancamento.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}
}
