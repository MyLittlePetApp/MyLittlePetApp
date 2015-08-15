package br.com.mylittlepet.model.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class HistoricoDTO implements GenericDTO, Serializable {
	
	private Long id;
	private Long idPet;
	private String descricao;
	private RetornoDTO retornoDTO;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdPet() {
		return idPet;
	}
	public void setIdPet(Long idPet) {
		this.idPet = idPet;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public RetornoDTO getRetornoDTO() {
		return retornoDTO;
	}
	public void setRetornoDTO(RetornoDTO retornoDTO) {
		this.retornoDTO = retornoDTO;
	}
	
}