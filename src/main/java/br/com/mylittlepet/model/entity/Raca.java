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
@Table(name = "raca", catalog = "mypet")
public class Raca implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_pet", nullable = false)
	private TipoPet tipopet;
	@Column(name = "descricao", nullable = false, length = 50)
	private String descricao;

	public Raca() {}
	
	public Raca(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public TipoPet getTipopet() {
		return this.tipopet;
	}

	public void setTipopet(TipoPet tipopet) {
		this.tipopet = tipopet;
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
		result = prime * result + ((getTipopet() == null) ? 0 : getTipopet().hashCode());
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
		Raca other = (Raca) obj;
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
		if (getTipopet() == null) {
			if (other.getTipopet() != null)
				return false;
		} else if (!getTipopet().equals(other.getTipopet()))
			return false;
		return true;
	}
	
}