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
@Table(name = "foto", catalog = "mypet")
public class Foto implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pet", nullable = false)
	private Pet pet;
	@Column(name = "url", nullable = false, length = 65535)
	private String url;
	@Column(name = "descricao", length = 65535)
	private String descricao;

	public Foto() {
	}

	public Foto(Pet pet, String url) {
		this.pet = pet;
		this.url = url;
	}

	public Foto(Pet pet, String url, String descricao) {
		this.pet = pet;
		this.url = url;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
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
		Foto other = (Foto) obj;
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
		if (getUrl() == null) {
			if (other.getUrl() != null)
				return false;
		} else if (!getUrl().equals(other.getUrl()))
			return false;
		return true;
	}

}