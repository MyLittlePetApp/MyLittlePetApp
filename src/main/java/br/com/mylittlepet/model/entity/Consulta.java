package br.com.mylittlepet.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "consulta", catalog = "mypet")
public class Consulta implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pet", nullable = false)
	private Pet pet;
	@ManyToOne
	@JoinColumn(name = "veterinario")
	private Veterinario veterinario;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_consulta", length = 10)
	private Date dataConsulta;
	@Column(name = "prescricao_medica", length = 65535)
	private String prescricaoMedica;
	@Column(name = "motivo_consulta", length = 65535)
	private String motivoConsulta;

	public Consulta() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pet getPet() {
		return this.pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Veterinario getVeterinario() {
		return this.veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Date getDataConsulta() {
		return this.dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getPrescricaoMedica() {
		return this.prescricaoMedica;
	}

	public void setPrescricaoMedica(String prescricaoMedica) {
		this.prescricaoMedica = prescricaoMedica;
	}

	public String getMotivoConsulta() {
		return this.motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getDataConsulta() == null) ? 0 : getDataConsulta().hashCode());
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result
				+ ((getMotivoConsulta() == null) ? 0 : getMotivoConsulta().hashCode());
		result = prime * result + ((getPet() == null) ? 0 : getPet().hashCode());
		result = prime
				* result
				+ ((getPrescricaoMedica() == null) ? 0 : getPrescricaoMedica().hashCode());
		result = prime * result
				+ ((getVeterinario() == null) ? 0 : getVeterinario().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (getDataConsulta() == null) {
			if (other.getDataConsulta() != null)
				return false;
		} else if (!getDataConsulta().equals(other.getDataConsulta()))
			return false;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		if (getMotivoConsulta() == null) {
			if (other.getMotivoConsulta() != null)
				return false;
		} else if (!getMotivoConsulta().equals(other.getMotivoConsulta()))
			return false;
		if (getPet() == null) {
			if (other.getPet() != null)
				return false;
		} else if (!getPet().equals(other.getPet()))
			return false;
		if (getPrescricaoMedica() == null) {
			if (other.getPrescricaoMedica() != null)
				return false;
		} else if (!getPrescricaoMedica().equals(other.getPrescricaoMedica()))
			return false;
		if (getVeterinario() == null) {
			if (other.getVeterinario() != null)
				return false;
		} else if (!getVeterinario().equals(other.getVeterinario()))
			return false;
		return true;
	}

}