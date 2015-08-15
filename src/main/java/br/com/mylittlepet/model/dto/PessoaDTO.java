package br.com.mylittlepet.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class PessoaDTO implements GenericDTO, Serializable {
	
	private Long id;
    private String nome;
    private String sobrenome;
    private String foto;
    private Date dataNascimento;
    private UsuarioDTO usuario;
    private EnderecoDTO enderecos;
    private ContatoDTO contatos;
    private RetornoDTO retornoDTO;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public EnderecoDTO getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(EnderecoDTO enderecos) {
		this.enderecos = enderecos;
	}
	public ContatoDTO getContatos() {
		return contatos;
	}
	public void setContatos(ContatoDTO contatos) {
		this.contatos = contatos;
	}
	public RetornoDTO getRetornoDTO() {
		return retornoDTO;
	}
	public void setRetornoDTO(RetornoDTO retornoDTO) {
		this.retornoDTO = retornoDTO;
	}

}