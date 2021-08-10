package br.com.diegocordeiro.dscproject.enums;

public enum TipoLogradouro {

	AEROPORTO	(1, "Aeroporto"	  ),
    ALAMEDA		(2, "Alameda"	  ),
    ÁREA		(3, "Área"		  ),
    AVENIDA		(4, "Avenida"	  ),
    CAMPO		(5, "Campo"		  ),
    CHACARA		(6, "Chácara"	  ),
    COLONIA		(7, "Colônia"	  ),
    CONDOMINIO	(8, "Condomínio"  ),
    CONJUNTO	(9, "Conjunto"	  ),
    DISTRITO	(10, "Distrito"	  ),
    ESPLANADA	(11, "Esplanada"  ),
    ESTACAO		(12, "Estação"	  ),
    ESTRADA		(13, "Estrada"	  ),
    FAVELA		(14, "Favela"	  ),
    FEIRA		(15, "Feira"	  ),
    JARDIM		(16, "Jardim"	  ),
    LADEIRA		(17, "Ladeira"	  ),
    LAGO		(18, "Lago"		  ),
    LAGOA		(19, "Lagoa"	  ),
    LARGO		(20, "Largo"	  ),
    LOTEAMENTO	(21, "Loteamento" ),
    MORRO		(22, "Morro"	  ),
    NUCLEO		(23, "Núcleo"	  ),
    PARQUE		(24, "Parque"	  ),
    PASSARELA	(25, "Passarela"  ),
    PATIO		(26, "Pátio"	  ),
    PRACA		(27, "Praça"	  ),
    QUADRA		(28, "Quadra"	  ),
    RECANTO		(29, "Recanto"	  ),
    RESIDENCIAL	(30, "Residencial"),
    RODOVIA		(31, "Rodovia"	  ),
    RUA			(32, "Rua"		  ),
    SETOR		(33, "Setor"	  ),
    SITIO		(34, "Sítio"	  ),
    TRAVESSA	(35, "Travessa"	  ),
    TRECHO		(36, "Trecho"	  ),
    TREVO		(39, "Trevo"	  ),
    VALE		(40, "Vale"		  ),
    VEREDA		(41, "Vereda"	  ),
    VIA			(42, "Via"		  ),
    VIADUTO		(43, "Viaduto"	  ),
    VIELA		(44, "Viela"	  ),
    VILA		(45, "Vila"		  );

	private Integer codigo;
	private String descricao;
	
	private TipoLogradouro(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static TipoLogradouro toEnum(String codigo){
		
		if(codigo == null) {
			return null;
		}
		
		for(TipoLogradouro x : TipoLogradouro.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido" + codigo);
	}

	

}
