package br.com.mylittlepet.model.entity;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipopet", catalog = "mypet")
public class TipoPet implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "descricao", nullable = false, length = 25)
	private String descricao;

	public TipoPet() {
	}
	
	public TipoPet(final Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		TipoPet other = (TipoPet) obj;
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
		return true;
	}

}