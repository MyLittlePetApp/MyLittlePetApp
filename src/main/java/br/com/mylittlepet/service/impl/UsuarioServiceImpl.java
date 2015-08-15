package br.com.mylittlepet.service.impl;

import javax.persistence.NoResultException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mylittlepet.commons.utils.CriptografiaUtils;
import br.com.mylittlepet.model.dto.PessoaDTO;
import br.com.mylittlepet.model.dto.RetornoDTO;
import br.com.mylittlepet.model.dto.UsuarioDTO;
import br.com.mylittlepet.model.entity.Dono;
import br.com.mylittlepet.model.entity.Usuario;
import br.com.mylittlepet.model.entity.Veterinario;
import br.com.mylittlepet.model.enums.TipoRetornoEnum;
import br.com.mylittlepet.model.enums.TipoUsuarioEnum;
import br.com.mylittlepet.model.mapper.UsuarioMapper;
import br.com.mylittlepet.model.repository.DonoRepository;
import br.com.mylittlepet.model.repository.UsuarioRepository;
import br.com.mylittlepet.model.repository.VeterinarioRepository;
import br.com.mylittlepet.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private VeterinarioRepository veterinarioRepository;
	@Autowired 
	private DonoRepository donoRepository;
	
	public UsuarioDTO cadastrarUsuario(final UsuarioDTO usuarioDTO) {
		final RetornoDTO retornoDTO = validarCadastroUsuario(usuarioDTO);
		try {
			if(TipoRetornoEnum.SUCESSO.equals(retornoDTO.getTipoRetornoEnum()) ) {
				Usuario usuario = UsuarioMapper.parse(usuarioDTO);
				if(TipoUsuarioEnum.DONO.getCodigo().equals(usuarioDTO.getTipoUsuario())) {
					final Dono dono = new Dono();
					dono.setNome(usuarioDTO.getNome());
					dono.setSobrenome(usuarioDTO.getSobrenome());
					donoRepository.save(dono);
					usuario.setPessoa(dono);
				} else if(TipoUsuarioEnum.VETERINARIO.getCodigo().equals(usuarioDTO.getTipoUsuario())) {
					final Veterinario veterinario = new Veterinario();
					veterinario.setNome(usuarioDTO.getNome());
					veterinario.setSobrenome(usuarioDTO.getSobrenome());
					veterinarioRepository.save(veterinario);
					usuario.setPessoa(veterinario);
				}
				usuario = usuarioRepository.save(usuario);
				retornoDTO.setMensagem("Usuario cadastrado com sucesso.");
				retornoDTO.setMetodoAcionado("UsuarioServiceImpl.cadastrarUsuario");
				usuarioDTO.setId(usuario.getId());
			}
		} catch (Exception e) {
			retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.ERRO);
			retornoDTO.setMensagem(e.getMessage());
			e.printStackTrace();
		}
		usuarioDTO.setRetornoDTO(retornoDTO);
		return usuarioDTO;
	}

	public PessoaDTO efetuarLogin(final UsuarioDTO usuarioDTO) {

		final PessoaDTO pessoaDTO = new PessoaDTO();
		try {
			final Usuario usuario = usuarioRepository.findByEmailAndSenha(usuarioDTO.getEmail(), CriptografiaUtils.criptografarSenha(usuarioDTO.getSenha()));
			pessoaDTO.setNome(usuario.getPessoa().getNome());
			pessoaDTO.setSobrenome(usuario.getPessoa().getSobrenome());
			pessoaDTO.setUsuario(new UsuarioDTO());
			pessoaDTO.getUsuario().setEmail(usuario.getEmail());
			pessoaDTO.getUsuario().setTipoUsuario(usuario.getTipoUsuario().getId());
			
		} catch (NoResultException e) {
			pessoaDTO.setRetornoDTO(new RetornoDTO(TipoRetornoEnum.ERRO,"Usuario/Senha Invalidos", "UsuarioServiceImpl.efetuarLogin"));
		} catch (Exception e) {
			pessoaDTO.setRetornoDTO(new RetornoDTO(TipoRetornoEnum.ERRO, e.getMessage(), "UsuarioServiceImpl.efetuarLogin"));
		}
		return pessoaDTO;
	}
	
	private RetornoDTO validarCadastroUsuario(final UsuarioDTO usuarioDTO) {
		
		RetornoDTO retornoDTO = new RetornoDTO();
		
		if(usuarioDTO.getTipoUsuario() != null 
				&& StringUtils.isNotEmpty(usuarioDTO.getEmail())
				&& StringUtils.isNotEmpty(usuarioDTO.getNome())
				&& StringUtils.isNotEmpty(usuarioDTO.getSenha())
				&& StringUtils.isNotEmpty(usuarioDTO.getSobrenome())) {
			try {
				final Usuario usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());
				if(usuario != null) {
					retornoDTO= (new RetornoDTO(TipoRetornoEnum.ERRO, "Email ja cadastrado no sistema.", "UsuarioServiceImpl.validarCadastroUsuario"));
				} else {
					retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.SUCESSO);	
				}
			} catch (NoResultException e) {
				retornoDTO.setTipoRetornoEnum(TipoRetornoEnum.SUCESSO);
			} catch (Exception e) {
				retornoDTO= (new RetornoDTO(TipoRetornoEnum.ERRO, e.getMessage(), "UsuarioServiceImpl.validarCadastroUsuario"));
			}
		} else {
			retornoDTO= (new RetornoDTO(TipoRetornoEnum.ERRO, "Nao foram preenchidos todos os campos obrigatorios.", "UsuarioServiceImpl.validarCadastroUsuario"));
		}
		
		return retornoDTO;
	}

}