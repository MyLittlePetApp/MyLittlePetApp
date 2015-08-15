package br.com.mylittlepet.service;

import br.com.mylittlepet.model.dto.PessoaDTO;
import br.com.mylittlepet.model.dto.UsuarioDTO;

public interface UsuarioService {
	
	UsuarioDTO cadastrarUsuario(final UsuarioDTO usuarioDTO);
	
	PessoaDTO efetuarLogin(final UsuarioDTO usuarioDTO);

}