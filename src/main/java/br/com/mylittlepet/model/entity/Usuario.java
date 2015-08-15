package br.com.mylittlepet.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario", catalog = "mypet")
public class Usuario implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	@Column(name = "senha", nullable = false, length = 128)
	private String senha;
	@OneToOne
	private Pessoa pessoa;
	@ManyToOne
	@JoinColumn(name = "tipo_usuario", nullable = false)
	private TipoUsuario tipoUsuario;

	public Usuario() {
	}

	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public Usuario(String email, String senha, Pessoa pessoa) {
		this.email = email;
		this.senha = senha;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getPessoa() == null) ? 0 : getPessoa().hashCode());
		result = prime * result + ((getSenha() == null) ? 0 : getSenha().hashCode());
		result = prime * result + ((getTipoUsuario() == null) ? 0 : getTipoUsuario().hashCode());
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
		Usuario other = (Usuario) obj;
		if (getEmail() == null) {
			if (other.getEmail() != null)
				return false;
		} else if (!getEmail().equals(other.getEmail()))
			return false;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		if (getPessoa() == null) {
			if (other.getPessoa() != null)
				return false;
		} else if (!getPessoa().equals(other.getPessoa()))
			return false;
		if (getSenha() == null) {
			if (other.getSenha() != null)
				return false;
		} else if (!getSenha().equals(other.getSenha()))
			return false;
		if (getTipoUsuario() == null) {
			if (other.getTipoUsuario() != null)
				return false;
		} else if (!getTipoUsuario().equals(other.getTipoUsuario()))
			return false;
		return true;
	}
	
	
}