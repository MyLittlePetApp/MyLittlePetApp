package br.com.mylittlepet.web.service.rest;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.mylittlepet.model.dto.DonoDTO;
import br.com.mylittlepet.service.DonoService;

@RestController
@RequestMapping("/dono")
public class DonoRest {
	
	@Autowired
	private DonoService donoService;
	
	@RequestMapping(value="teste", method = RequestMethod.GET)
	public @ResponseBody String teste() {
		return "Hello World!!!";
	}
	
	@RequestMapping(value="cadastrarPerfilDono",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public String cadastrarPerfilDono(@RequestBody final DonoDTO donoDTO) {
		return new Gson().toJson(donoService.cadastrarDono(donoDTO));
	}
	
	@RequestMapping(value="mudarFotoPerfil",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public String mudarFotoPerfil(@RequestBody final DonoDTO donoDTO) {
		return new Gson().toJson("");
	}


}