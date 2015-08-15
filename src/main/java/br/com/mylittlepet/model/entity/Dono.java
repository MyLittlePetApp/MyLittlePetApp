package br.com.mylittlepet.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "dono", catalog = "mypet")
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")  
public class Dono extends Pessoa implements java.io.Serializable {

	@Column(name = "cpf", length = 11)
	private String cpf;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dono")
	private Set<Pet> pets = new HashSet<Pet>(0);

	public Dono() {
	}
	
	public Dono(final Long id) {
		this.setId(id);
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<Pet> getPets() {
		return this.pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((getCpf() == null) ? 0 : getCpf().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dono other = (Dono) obj;
		if (getCpf() == null) {
			if (other.getCpf() != null)
				return false;
		} else if (!getCpf().equals(other.getCpf()))
			return false;
		return true;
	}

}