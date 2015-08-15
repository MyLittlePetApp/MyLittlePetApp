package br.com.mylittlepet.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "endereco", catalog = "mypet")
public class Endereco implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "logradouro", nullable = false, length = 50)
	private String logradouro;
	@Column(name = "numero", nullable = false)
	private int numero;
	@Column(name = "cep")
	private String cep;
	@Column(name = "cidade", nullable = false, length = 50)
	private String cidade;
	@Column(name = "uf", nullable = false, length = 2)
	private String uf;
	@ManyToOne
	private Pessoa pessoa;

	public Endereco() {
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Pessoa getPessoa() {
		return pessoa;
	}



	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}



	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getCep() == null) ? 0 : getCep().hashCode());
		result = prime * result + ((getCidade() == null) ? 0 : getCidade().hashCode());
		result = prime * result
				+ ((getLogradouro() == null) ? 0 : getLogradouro().hashCode());
		result = prime * result + getNumero();
		result = prime * result + ((getPessoa() == null) ? 0 : getPessoa().hashCode());
		result = prime * result + ((getUf() == null) ? 0 : getUf().hashCode());
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
		Endereco other = (Endereco) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		if (getCep() == null) {
			if (other.getCep() != null)
				return false;
		} else if (!getCep().equals(other.getCep()))
			return false;
		if (getCidade() == null) {
			if (other.getCidade() != null)
				return false;
		} else if (!getCidade().equals(other.getCidade()))
			return false;
		if (getLogradouro() == null) {
			if (other.getLogradouro() != null)
				return false;
		} else if (!getLogradouro().equals(other.getLogradouro()))
			return false;
		if (getNumero() != other.getNumero())
			return false;
		if (getPessoa() == null) {
			if (other.getPessoa() != null)
				return false;
		} else if (!getPessoa().equals(other.getPessoa()))
			return false;
		if (getUf() == null) {
			if (other.getUf() != null)
				return false;
		} else if (!getUf().equals(other.getUf()))
			return false;
		return true;
	}

}