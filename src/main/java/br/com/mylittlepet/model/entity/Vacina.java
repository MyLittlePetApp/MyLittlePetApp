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
@Table(name = "vacina", catalog = "mypet")
public class Vacina implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "pet", nullable = false)
	private Pet pet;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "veterinario")
	private Veterinario veterinario;
	@Column(name = "nome", length = 45)
	private String nome;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_vacina", length = 10)
	private Date dataVacina;

	public Vacina() {}

	public Vacina(Pet pet, Veterinario veterinario, String nome, Date dataVacina) {
		this.pet = pet;
		this.veterinario = veterinario;
		this.nome = nome;
		this.dataVacina = dataVacina;
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Date getDataVacina() {
		return this.dataVacina;
	}

	public void setDataVacina(Date dataVacina) {
		this.dataVacina = dataVacina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getDataVacina() == null) ? 0 : getDataVacina().hashCode());
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getNome() == null) ? 0 : getNome().hashCode());
		result = prime * result + ((getPet() == null) ? 0 : getPet().hashCode());
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
		Vacina other = (Vacina) obj;
		if (getDataVacina() == null) {
			if (other.getDataVacina() != null)
				return false;
		} else if (!getDataVacina().equals(other.getDataVacina()))
			return false;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		if (getNome() == null) {
			if (other.getNome() != null)
				return false;
		} else if (!getNome().equals(other.getNome()))
			return false;
		if (getPet() == null) {
			if (other.getPet() != null)
				return false;
		} else if (!getPet().equals(other.getPet()))
			return false;
		if (getVeterinario() == null) {
			if (other.getVeterinario() != null)
				return false;
		} else if (!getVeterinario().equals(other.getVeterinario()))
			return false;
		return true;
	}

}