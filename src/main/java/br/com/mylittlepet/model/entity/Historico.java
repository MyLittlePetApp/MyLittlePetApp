package br.com.mylittlepet.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "historico", catalog = "mypet")
public class Historico implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pet", nullable = false)
	private Pet pet;
	@Column(name = "descricao", length = 65535)
	private String descricao;

	public Historico() {
	}

	public Historico(Pet pet) {
		this.pet = pet;
	}

	public Historico(Pet pet, String descricao) {
		this.pet = pet;
		this.descricao = descricao;
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

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getDescricao() == null) ? 0 : getDescricao().hashCode());
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getPet() == null) ? 0 : getPet().hashCode());
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
		Historico other = (Historico) obj;
		if (getDescricao() == null) {
			if (other.getDescricao() != null)
				return false;
		} else if (!getDescricao().equals(other.getDescricao()))
			return false;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		if (getPet() == null) {
			if (other.getPet() != null)
				return false;
		} else if (!getPet().equals(other.getPet()))
			return false;
		return true;
	}

}