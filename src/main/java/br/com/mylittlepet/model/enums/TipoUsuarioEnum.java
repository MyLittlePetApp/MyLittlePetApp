package br.com.mylittlepet.model.enums;

public enum TipoUsuarioEnum {
	
	DONO(1, "DONO"),
	VETERINARIO(2, "VET");
	
	private final Integer codigo;
	private final String descricao;

	private TipoUsuarioEnum(Integer codigo, String descricao) {
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