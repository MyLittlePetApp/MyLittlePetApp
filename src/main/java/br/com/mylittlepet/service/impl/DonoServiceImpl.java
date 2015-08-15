package br.com.mylittlepet.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mylittlepet.commons.utils.FTPUtils;
import br.com.mylittlepet.model.dto.DonoDTO;
import br.com.mylittlepet.model.dto.RetornoDTO;
import br.com.mylittlepet.model.entity.Contato;
import br.com.mylittlepet.model.entity.Dono;
import br.com.mylittlepet.model.entity.Endereco;
import br.com.mylittlepet.model.enums.TipoRetornoEnum;
import br.com.mylittlepet.model.mapper.ContatoMapper;
import br.com.mylittlepet.model.mapper.DonoMapper;
import br.com.mylittlepet.model.mapper.EnderecoMapper;
import br.com.mylittlepet.model.repository.ContatoRepository;
import br.com.mylittlepet.model.repository.DonoRepository;
import br.com.mylittlepet.model.repository.EnderecoRepository;
import br.com.mylittlepet.service.DonoService;

@Component("donoService")
public class DonoServiceImpl implements DonoService {
	
	@Autowired 
	private DonoRepository donoRepository;
	@Autowired
	private ContatoRepository contatoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	private String criarDiretorioImagem(final DonoDTO donoDTO) {
		final StringBuffer diretorio = new StringBuffer(FTPUtils.DIRETORIO_BASE);
		diretorio.append(donoDTO.getId()).append("\\");
		diretorio.append("DONO").append("\\");
		diretorio.append("IBAGENS");
		return diretorio.toString();
	}
	
	private String criarNomeImagem(final DonoDTO donoDTO) {
		final StringBuffer nomeImagem = new StringBuffer();
		nomeImagem.append(donoDTO.getId());
		//nomeImagem.append(donoDTO.getNome());
		//nomeImagem.append(new Random().nextInt());
		nomeImagem.append(".jpg");
		return nomeImagem.toString();
	}

	public RetornoDTO cadastrarDono(final DonoDTO donoDTO) {
		
		final RetornoDTO retornoDTO = new RetornoDTO();
		try {
			Dono dono = DonoMapper.parse(donoDTO);
			if(StringUtils.isNotEmpty(donoDTO.getFoto())) {
				final String diretorio = criarDiretorioImagem(donoDTO);
				final String nomeImagem = criarNomeImagem(donoDTO);
				dono.setFoto(FTPUtils.salvarImagemFTP(donoDTO.getFoto(), diretorio, nomeImagem));
			}
			donoRepository.save(dono);
			final Contato contato = ContatoMapper.parse(donoDTO.getContatos(), dono);
			if(contato != null) {
				contatoRepository.save(contato);
			}
			final Endereco endereco = EnderecoMapper.parse(donoDTO.getEnderecos(), dono);
			if(endereco != null) {
				enderecoRepository.save(endereco);
			}
			retornoDTO.setMensagem("Dono cadastrado com sucesso");
			retornoDTO.setMetodoAcionado("DonoServiceImpl.cadastrarDono");
			retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.SUCESSO);
		} catch (Exception e) {
			retornoDTO.setMensagem(e.getMessage());
			retornoDTO.setMetodoAcionado("DonoServiceImpl.cadastrarDono");
			retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.ERRO);
		}
		return retornoDTO;
	}

	public Dono buscarPorID(Long id) {
		return donoRepository.findOne(id);
	}
}