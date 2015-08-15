package br.com.mylittlepet.model.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "pet", catalog = "mypet")
public class Pet implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "nome", length = 20)
	private String nome;
	@ManyToOne
	@JoinColumn(name = "dono", nullable = false)
	private Dono dono;
	@ManyToOne
	@JoinColumn(name = "tipo", nullable = false)
	private TipoPet tipopet;
	@Column(name = "foto", length = 65535)
	private String foto;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	@Column(name = "raca", length = 20)
	private String descOutraRaca;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pet")
	private Set<Historico> historicos;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pet")
	private Set<Consulta> consultas;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pet")
	private Set<Foto> fotos;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pet")
	private Set<Vacina> vacinas;

	public Pet() {}

	public Pet(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dono getDono() {
		return this.dono;
	}

	public void setDono(Dono dono) {
		this.dono = dono;
	}

	public TipoPet getTipopet() {
		return this.tipopet;
	}

	public void setTipopet(TipoPet tipopet) {
		this.tipopet = tipopet;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDescOutraRaca() {
		return this.descOutraRaca;
	}

	public void setDescOutraRaca(String descOutraRaca) {
		this.descOutraRaca = descOutraRaca;
	}

	public Set<Historico> getHistoricos() {
		return this.historicos;
	}

	public void setHistoricos(Set<Historico> historicos) {
		this.historicos = historicos;
	}

	public Set<Consulta> getConsultas() {
		return this.consultas;
	}

	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Set<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(Set<Foto> fotos) {
		this.fotos = fotos;
	}

	public Set<Vacina> getVacinas() {
		return this.vacinas;
	}

	public void setVacinas(Set<Vacina> vacinas) {
		this.vacinas = vacinas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getDataNascimento() == null) ? 0 : getDataNascimento().hashCode());
		result = prime * result
				+ ((getDescOutraRaca() == null) ? 0 : getDescOutraRaca().hashCode());
		result = prime * result + ((getDono() == null) ? 0 : getDono().hashCode());
		result = prime * result + ((getFoto() == null) ? 0 : getFoto().hashCode());
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
		Pet other = (Pet) obj;
		if (getDataNascimento() == null) {
			if (other.getDataNascimento() != null)
				return false;
		} else if (!getDataNascimento().equals(other.getDataNascimento()))
			return false;
		if (getDescOutraRaca() == null) {
			if (other.getDescOutraRaca() != null)
				return false;
		} else if (!getDescOutraRaca().equals(other.getDescOutraRaca()))
			return false;
		if (getDono() == null) {
			if (other.getDono() != null)
				return false;
		} else if (!getDono().equals(other.getDono()))
			return false;
		if (getFoto() == null) {
			if (other.getFoto() != null)
				return false;
		} else if (!getFoto().equals(other.getFoto()))
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