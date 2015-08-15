package br.com.mylittlepet.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class VacinaDTO implements GenericDTO, Serializable {
	
	private Long id;
	private Long idPet;
	private String nome;
	private Date dataVacina;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataVacina() {
		return dataVacina;
	}
	public void setDataVacina(Date dataVacina) {
		this.dataVacina = dataVacina;
	}
	public RetornoDTO getRetornoDTO() {
		return retornoDTO;
	}
	public void setRetornoDTO(RetornoDTO retornoDTO) {
		this.retornoDTO = retornoDTO;
	}
	
}