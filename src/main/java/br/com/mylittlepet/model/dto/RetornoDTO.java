package br.com.mylittlepet.model.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.mylittlepet.model.enums.TipoRetornoEnum;

@SuppressWarnings("serial")
@XmlRootElement
public class RetornoDTO implements GenericDTO, Serializable {
	
	private TipoRetornoEnum tipoRetornoEnum;
	private String mensagem;
	private String metodoAcionado;
	
	public RetornoDTO() {
	}

	public RetornoDTO(final TipoRetornoEnum tipoRetornoEnum, final String mensagem,
			final String metodoAcionado) {
		this.tipoRetornoEnum = tipoRetornoEnum;
		this.mensagem = mensagem;
		this.metodoAcionado = metodoAcionado;
	}
	
	public TipoRetornoEnum getTipoRetornoEnum() {
		return tipoRetornoEnum;
	}
	public void setTipoRetornoEnum(TipoRetornoEnum tipoRetornoEnum) {
		this.tipoRetornoEnum = tipoRetornoEnum;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getMetodoAcionado() {
		return metodoAcionado;
	}
	public void setMetodoAcionado(String metodoAcionado) {
		this.metodoAcionado = metodoAcionado;
	}
}