package br.com.mylittlepet.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class ConsultaDTO implements GenericDTO, Serializable {
	
	private Long id;
	private Long idPet;
	private Date dataConsulta;
	private String prescricaoMedica;
	private String motivoConsulta;
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
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public String getPrescricaoMedica() {
		return prescricaoMedica;
	}
	public void setPrescricaoMedica(String prescricaoMedica) {
		this.prescricaoMedica = prescricaoMedica;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public RetornoDTO getRetornoDTO() {
		return retornoDTO;
	}
	public void setRetornoDTO(RetornoDTO retornoDTO) {
		this.retornoDTO = retornoDTO;
	}
	
}