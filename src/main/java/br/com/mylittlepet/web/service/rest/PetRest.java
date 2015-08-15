package br.com.mylittlepet.web.service.rest;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.mylittlepet.model.dto.ConsultaDTO;
import br.com.mylittlepet.model.dto.FotoDTO;
import br.com.mylittlepet.model.dto.HistoricoDTO;
import br.com.mylittlepet.model.dto.PetDTO;
import br.com.mylittlepet.model.dto.VacinaDTO;
import br.com.mylittlepet.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetRest {
	
	@Autowired
	private PetService petService;
	
	@RequestMapping(value="teste", method = RequestMethod.GET)
	public String teste() {
		return "Hello World!!!";
	}
	
	@RequestMapping(value="cadastrarPet",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public String cadastrarPet(@RequestBody final PetDTO petDTO) {
		return new Gson().toJson(petService.cadastrarPet(petDTO));
	}
	
	@RequestMapping(value="cadastrarHistorico",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public String cadastrarHistorico(@RequestBody final HistoricoDTO historicoDTO) {
		return new Gson().toJson(petService.cadastrarHistorico(historicoDTO));
	}
	
	@RequestMapping(value="cadastrarConsulta",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public String cadastrarConsulta(@RequestBody final ConsultaDTO consultaDTO) {
		return new Gson().toJson(petService.cadastrarConsulta(consultaDTO));
	}
	
	@RequestMapping(value="inserirFotoAlbum",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public String inserirFotoAlbum(@RequestBody final FotoDTO fotoDTO) {
		return new Gson().toJson("");
	}
	
	@RequestMapping(value="cadastrarVacina",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public String cadastrarVacina(@RequestBody final VacinaDTO vacinaDTO) {
		return new Gson().toJson(petService.cadastrarVacina(vacinaDTO));
	}
	
}