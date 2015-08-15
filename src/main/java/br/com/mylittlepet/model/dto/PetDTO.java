package br.com.mylittlepet.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class PetDTO implements GenericDTO, Serializable {
	
	private Long id;
	private Long idDono;
	private String nome;
	private Integer idRaca;
	private String raca;
	private Integer tipoPet;
	private String foto;
	private Date dataNascimento;
	private Set<HistoricoDTO> historicos;
	private Set<ConsultaDTO> consultas;
	private Set<FotoDTO> fotos;
	private Set<VacinaDTO> vacinas;
	private RetornoDTO retornoDTO;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdDono() {
		return idDono;
	}
	public void setIdDono(Long idDono) {
		this.idDono = idDono;
	}
	public Integer getIdRaca() {
		return idRaca;
	}
	public void setIdRaca(Integer idRaca) {
		this.idRaca = idRaca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public Integer getTipoPet() {
		return tipoPet;
	}
	public void setTipoPet(Integer tipoPet) {
		this.tipoPet = tipoPet;
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
	public Set<HistoricoDTO> getHistoricos() {
		return historicos;
	}
	public void setHistoricos(Set<HistoricoDTO> historicos) {
		this.historicos = historicos;
	}
	public Set<ConsultaDTO> getConsultas() {
		return consultas;
	}
	public void setConsultas(Set<ConsultaDTO> consultas) {
		this.consultas = consultas;
	}
	public Set<FotoDTO> getFotos() {
		return fotos;
	}
	public void setFotos(Set<FotoDTO> fotos) {
		this.fotos = fotos;
	}
	public Set<VacinaDTO> getVacinas() {
		return vacinas;
	}
	public void setVacinas(Set<VacinaDTO> vacinas) {
		this.vacinas = vacinas;
	}
	public RetornoDTO getRetornoDTO() {
		return retornoDTO;
	}
	public void setRetornoDTO(RetornoDTO retornoDTO) {
		this.retornoDTO = retornoDTO;
	}
	
}