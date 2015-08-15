package br.com.mylittlepet.model.enums;

public enum TipoPetEnum {
	
	CACHORRO(1, "Cachorro"),
	GATO(2, "Gato"),
	COELHO(3, "Coelho"),
	TARTARUGA(4, "Tartaruga"),
	PEIXE(5, "Peixe"),
	PERIQUITO(6, "Periquito"),
	CALOPSITA(7, "Calopsita"),
	HAMSTER(8, "Hamster"),
	PORQUINHO_DA_INDIA(9, "Porquinho da India"),
	IGUANA(10, "Iguana"),
	COBRA(11, "Cobra"),
	ARANHA(12, "Aranha"),
	LAGARTO(13, "Lagarto"),
	RATO(14, "Rato");
	
	private final Integer codigo;
	private final String descricao;

	private TipoPetEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}


}
