package br.com.mylittlepet.web.service.rest;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.mylittlepet.model.dto.UsuarioDTO;
import br.com.mylittlepet.model.enums.TipoUsuarioEnum;

public class UsuarioRestTest {
	
	final Client client = Client.create();
	
	public static void main(String[] args) {
		
		final UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setEmail("email@gmail.com");
		usuarioDTO.setNome("Denis");
		usuarioDTO.setSenha("denis123***");
		usuarioDTO.setSobrenome("Sobre o Nome");
		usuarioDTO.setTipoUsuario(TipoUsuarioEnum.DONO.getCodigo());
		
		UsuarioRestTest test = new UsuarioRestTest();
		test.testTeste();
		test.testCadastrarUsuario(usuarioDTO);
		test.testEfetuarLogin(usuarioDTO);
		
	}
	
	public void testTeste() {
		WebResource webResource = client.resource("http://localhost:8090/mylittlepet/usuario/teste");
		final String test = webResource.get(String.class);
		System.out.println(test);
	}

	public void testCadastrarUsuario(final UsuarioDTO usuarioDTO) {
		WebResource webResource = client.resource("http://localhost:8090/mylittlepet/usuario/cadastrarUsuario");
		final String test = webResource.type(MediaType.APPLICATION_JSON).post(String.class, usuarioDTO);
		System.out.println(test);
	}

	public void testEfetuarLogin(final UsuarioDTO usuarioDTO) {
		WebResource webResource = client.resource("http://localhost:8090/mylittlepet/usuario/efetuarLogin");
		final String test = webResource.type(MediaType.APPLICATION_JSON).post(String.class, usuarioDTO);
		System.out.println(test);
	}

}
