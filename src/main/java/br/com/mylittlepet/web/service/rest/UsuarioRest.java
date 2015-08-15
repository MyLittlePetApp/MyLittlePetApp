package br.com.mylittlepet.web.service.rest;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.mylittlepet.model.dto.UsuarioDTO;
import br.com.mylittlepet.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {
	
	@Autowired
	private UsuarioService usuarioService; 
	
	@RequestMapping(value="teste", method = RequestMethod.GET)
	public String teste() {
		return "Hello World!!!";
	}
	
	@RequestMapping(value="cadastrarUsuario",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public String cadastrarUsuario(@RequestBody final UsuarioDTO usuarioDTO) {
		return new Gson().toJson(usuarioService.cadastrarUsuario(usuarioDTO));
	}
	
	@RequestMapping(value="efetuarLogin",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public String efetuarLogin(@RequestBody final UsuarioDTO usuarioDTO) {
		return new Gson().toJson(usuarioService.efetuarLogin(usuarioDTO)); //DonoDTO
	}
	
}