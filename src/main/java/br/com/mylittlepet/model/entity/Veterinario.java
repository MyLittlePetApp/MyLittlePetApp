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
@Table(name = "veterinario", catalog = "mypet")
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")  
public class Veterinario extends Pessoa implements java.io.Serializable {

	@Column(name = "crmv")
	private Integer crmv;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "veterinario")
	private Set<Consulta> consultas = new HashSet<Consulta>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "veterinario")
	private Set<Vacina> vacinas = new HashSet<Vacina>(0);

	public Veterinario() {}

	public Integer getCrmv() {
		return this.crmv;
	}
	public void setCrmv(Integer crmv) {
		this.crmv = crmv;
	}
	public Set<Consulta> getConsultas() {
		return this.consultas;
	}
	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}
	public Set<Vacina> getVacinas() {
		return this.vacinas;
	}
	public void setVacinas(Set<Vacina> vacinas) {
		this.vacinas = vacinas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((getCrmv() == null) ? 0 : getCrmv().hashCode());
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
		Veterinario other = (Veterinario) obj;
		if (getCrmv() == null) {
			if (other.getCrmv() != null)
				return false;
		} else if (!getCrmv().equals(other.getCrmv()))
			return false;
		return true;
	}

}