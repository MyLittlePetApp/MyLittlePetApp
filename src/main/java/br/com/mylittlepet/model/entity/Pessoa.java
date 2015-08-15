package br.com.mylittlepet.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa", catalog = "mypet")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "nome", length = 20)
	private String nome;
	@Column(name = "sobrenome", length = 30)
	private String sobrenome;
	@Column(name = "foto", length = 65535)
	private String foto;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", length = 10)
	private Date dataNascimento;

	public Pessoa() {
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return this.sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getDataNascimento() == null) ? 0 : getDataNascimento().hashCode());
		result = prime * result + ((getFoto() == null) ? 0 : getFoto().hashCode());
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getNome() == null) ? 0 : getNome().hashCode());
		result = prime * result
				+ ((getSobrenome() == null) ? 0 : getSobrenome().hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (getDataNascimento() == null) {
			if (other.getDataNascimento() != null)
				return false;
		} else if (!getDataNascimento().equals(other.getDataNascimento()))
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
		if (getNome() == null) {
			if (other.getNome() != null)
				return false;
		} else if (!getNome().equals(other.getNome()))
			return false;
		if (getSobrenome() == null) {
			if (other.getSobrenome() != null)
				return false;
		} else if (!getSobrenome().equals(other.getSobrenome()))
			return false;
		return true;
	}

}