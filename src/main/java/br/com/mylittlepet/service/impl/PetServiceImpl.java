package br.com.mylittlepet.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mylittlepet.commons.utils.FTPUtils;
import br.com.mylittlepet.model.dto.ConsultaDTO;
import br.com.mylittlepet.model.dto.FotoDTO;
import br.com.mylittlepet.model.dto.HistoricoDTO;
import br.com.mylittlepet.model.dto.PetDTO;
import br.com.mylittlepet.model.dto.RetornoDTO;
import br.com.mylittlepet.model.dto.VacinaDTO;
import br.com.mylittlepet.model.entity.Consulta;
import br.com.mylittlepet.model.entity.Historico;
import br.com.mylittlepet.model.entity.Pet;
import br.com.mylittlepet.model.entity.Vacina;
import br.com.mylittlepet.model.enums.TipoRetornoEnum;
import br.com.mylittlepet.model.mapper.ConsultaMapper;
import br.com.mylittlepet.model.mapper.HistoricoMapper;
import br.com.mylittlepet.model.mapper.PetMapper;
import br.com.mylittlepet.model.mapper.VacinaMapper;
import br.com.mylittlepet.model.repository.ConsultaRepository;
import br.com.mylittlepet.model.repository.HistoricoRepository;
import br.com.mylittlepet.model.repository.PetRepository;
import br.com.mylittlepet.model.repository.VacinaRepository;
import br.com.mylittlepet.service.PetService;

@Service("petService")
public class PetServiceImpl implements PetService {
	
	@Autowired
	private PetRepository petRepository;
	@Autowired
	private ConsultaRepository consultaRepository;
	@Autowired
	private HistoricoRepository historicoRepository;
	@Autowired
	private VacinaRepository vacinaRepository;
	
	private String criarDiretorioImagem(final PetDTO petDTO) {
		final StringBuffer diretorio = new StringBuffer(FTPUtils.DIRETORIO_BASE);
		diretorio.append(petDTO.getIdDono()).append("\\");
		diretorio.append("PET").append("\\");
		diretorio.append(petDTO.getId()).append("\\");
		diretorio.append("IBAGENS");
		return diretorio.toString();
	}
	
	private String criarNomeImagem(final PetDTO petDTO) {
		final StringBuffer nomeImagem = new StringBuffer();
		nomeImagem.append(petDTO.getIdDono());
		nomeImagem.append(petDTO.getId());
		nomeImagem.append(".jpg");
		return nomeImagem.toString();
	}

	@Override
	public PetDTO cadastrarPet(final PetDTO petDTO) {
		final RetornoDTO retornoDTO = new RetornoDTO();
		retornoDTO.setMetodoAcionado("PetServiceImpl.cadastrarPet");
		final StringBuilder mensagens = new StringBuilder();
		try {
			
			Pet pet = PetMapper.parse(petDTO);
			
			if(StringUtils.isNotEmpty(petDTO.getFoto())) {
				final String diretorio = criarDiretorioImagem(petDTO);
				final String nomeImagem = criarNomeImagem(petDTO);
				pet.setFoto(FTPUtils.salvarImagemFTP(petDTO.getFoto(), diretorio, nomeImagem));
			}
			
			petRepository.save(pet);
			retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.SUCESSO);
			mensagens.append("Pet cadastrado com sucesso.");
			petDTO.setId(pet.getId());
			
			if(petDTO.getConsultas() != null && !petDTO.getConsultas().isEmpty()) {
				for (ConsultaDTO consultaDTO : petDTO.getConsultas()) {
					consultaDTO.setIdPet(pet.getId());
					cadastrarConsulta(consultaDTO);
				}
			}
			
			if(petDTO.getHistoricos() != null && !petDTO.getHistoricos().isEmpty()) {
				for (HistoricoDTO historicoDTO : petDTO.getHistoricos()) {
					historicoDTO.setIdPet(pet.getId());
					cadastrarHistorico(historicoDTO);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.ERRO);
			retornoDTO.setMensagem(e.getMessage());
		}
		retornoDTO.setMensagem(mensagens.toString());
		petDTO.setRetornoDTO(retornoDTO);
		return petDTO;
	}
	
	@Override
	public ConsultaDTO cadastrarConsulta(final ConsultaDTO consultaDTO) {
		
		final RetornoDTO retornoDTO = new RetornoDTO();
		retornoDTO.setMetodoAcionado("PetServiceImpl.cadastrarConsulta");
		
		try {
			Consulta consulta = ConsultaMapper.parse(consultaDTO);
			consulta = consultaRepository.save(consulta);
			consultaDTO.setId(consulta.getId());
			retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.SUCESSO);
			retornoDTO.setMensagem("Cadastro consulta com sucesso " + consulta.getId());
		} catch (Exception e) {
			retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.ERRO);
			retornoDTO.setMensagem(e.getMessage());
		}
		consultaDTO.setRetornoDTO(retornoDTO);
		return consultaDTO;
	}
	
	@Override
	public HistoricoDTO cadastrarHistorico(final HistoricoDTO historicoDTO) {
		
		final RetornoDTO retornoDTO = new RetornoDTO();
		retornoDTO.setMetodoAcionado("PetServiceImpl.cadastrarHistorico");
		
		try {
			Historico historico = HistoricoMapper.parse(historicoDTO);
			historico = historicoRepository.save(historico);
			historicoDTO.setId(historico.getId());
			retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.SUCESSO);
			retornoDTO.setMensagem("Cadastro hitorico com sucesso " + historico.getId());
		} catch (Exception e) {
			retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.ERRO);
			retornoDTO.setMensagem(e.getMessage());
		}
		historicoDTO.setRetornoDTO(retornoDTO);
		return historicoDTO;
	}
	@Override

	public FotoDTO inserirFotoAlbum(final FotoDTO fotoDTO) {
		return null;
	}

	@Override
	public VacinaDTO cadastrarVacina(final VacinaDTO vacinaDTO) {
		
		final RetornoDTO retornoDTO = new RetornoDTO();
		retornoDTO.setMetodoAcionado("PetServiceImpl.cadastrarHistorico");
		
		try {
			Vacina vacina = VacinaMapper.parse(vacinaDTO);
			vacina = vacinaRepository.save(vacina);
			vacinaDTO.setId(vacina.getId());
			retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.SUCESSO);
			retornoDTO.setMensagem("Cadastro vacina com sucesso " + vacinaDTO.getId());
		} catch (Exception e) {
			retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.ERRO);
			retornoDTO.setMensagem(e.getMessage());
		}
		vacinaDTO.setRetornoDTO(retornoDTO);
		
		return vacinaDTO;
	}

}
