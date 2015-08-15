package br.com.mylittlepet.model.mapper;


import org.springframework.util.StringUtils;

import br.com.mylittlepet.commons.utils.CriptografiaUtils;
import br.com.mylittlepet.model.dto.UsuarioDTO;
import br.com.mylittlepet.model.entity.TipoUsuario;
import br.com.mylittlepet.model.entity.Usuario;

public class UsuarioMapper {

	public static Usuario parse(final UsuarioDTO usuarioDTO) {
		Usuario usuario = null;
		if(usuarioDTO != null && !StringUtils.isEmpty(usuarioDTO.getEmail()) 
				&& !StringUtils.isEmpty(usuarioDTO.getSenha())) {
			usuario = new Usuario();
			usuario.setEmail(usuarioDTO.getEmail());
			usuario.setSenha(CriptografiaUtils.criptografarSenha(usuarioDTO.getSenha()));
			usuario.setTipoUsuario(new TipoUsuario());
			usuario.getTipoUsuario().setId(usuarioDTO.getTipoUsuario());
			
		}
		return usuario;
	}
	
}