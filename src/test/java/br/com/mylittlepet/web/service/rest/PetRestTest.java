package br.com.mylittlepet.web.service.rest;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.mylittlepet.model.dto.ConsultaDTO;
import br.com.mylittlepet.model.dto.HistoricoDTO;
import br.com.mylittlepet.model.dto.PetDTO;
import br.com.mylittlepet.model.dto.VacinaDTO;
import br.com.mylittlepet.model.enums.TipoPetEnum;

public class PetRestTest {

	Client client = Client.create();
	
	public static void main(String[] args) {
		
		PetRestTest test = new PetRestTest();
		//test.testCadastrarPet();
		//test.testCadastrarHistorico();
		//test.testCadastrarConsulta();
		test.testCadastrarVacina();
		
	}
	
	@Test
	public void testCadastrarPet() {
		
		final PetDTO petDTO = new PetDTO();
		petDTO.setIdDono(1L);
		petDTO.setTipoPet(TipoPetEnum.CACHORRO.getCodigo());
		petDTO.setDataNascimento(new Date());
		petDTO.setNome("PET TOTO");
		petDTO.setRaca("Se Vira Lata");
		petDTO.setId(2L);
		WebResource webResource = client.resource("http://localhost:8090/mylittlepet/pet/cadastrarPet");
		final String test = webResource.type(MediaType.APPLICATION_JSON).post(String.class, petDTO);
		System.out.println(test);
		
		
	}

	@Test
	public void testCadastrarHistorico() {
		
		final HistoricoDTO historicoDTO = new HistoricoDTO();
		historicoDTO.setDescricao("Historico PET ID");
		historicoDTO.setId(1L);
		historicoDTO.setIdPet(2L);
		
		WebResource webResource = client.resource("http://localhost:8090/mylittlepet/pet/cadastrarHistorico");
		final String test = webResource.type(MediaType.APPLICATION_JSON).post(String.class, historicoDTO);
		System.out.println(test);
		
	}

	@Test
	public void testCadastrarConsulta() {
		
		final ConsultaDTO consultaDTO = new ConsultaDTO();
		consultaDTO.setDataConsulta(new Date());
		consultaDTO.setIdPet(2L);
		consultaDTO.setMotivoConsulta("TESTE CADASTRO Novo ");
		consultaDTO.setPrescricaoMedica("TOMA NUKU");
		
		WebResource webResource = client.resource("http://localhost:8090/mylittlepet/pet/cadastrarConsulta");
		final String test = webResource.type(MediaType.APPLICATION_JSON).post(String.class, consultaDTO);
		System.out.println(test);
	}

	@Test
	public void testInserirFotoAlbum() {
		
		WebResource webResource = client.resource("http://localhost:8090/mylittlepet/pet/cadastrarFotoAlbum");
		
	}

	@Test
	public void testCadastrarVacina() {
		
		final VacinaDTO vacinaDTO = new VacinaDTO();
		vacinaDTO.setDataVacina(new Date());
		vacinaDTO.setId(1L);
		vacinaDTO.setIdPet(2L);
		vacinaDTO.setNome("Sei la");
		
		WebResource webResource = client.resource("http://localhost:8090/mylittlepet/pet/cadastrarVacina");
		final String test = webResource.type(MediaType.APPLICATION_JSON).post(String.class, vacinaDTO);
		System.out.println(test);
		
	}

}
