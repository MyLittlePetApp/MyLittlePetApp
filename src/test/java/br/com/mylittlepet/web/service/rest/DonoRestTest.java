package br.com.mylittlepet.web.service.rest;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.mylittlepet.model.dto.ContatoDTO;
import br.com.mylittlepet.model.dto.DonoDTO;
import br.com.mylittlepet.model.dto.EnderecoDTO;

public class DonoRestTest {

	final Client client = Client.create();
	
	public static void main(String[] args) {
		DonoRestTest donoRest = new DonoRestTest();
		donoRest.testTeste();
		
		donoRest.testCadastrarPerfilDono();
	}
	
	@Test
	public void testTeste() {
		WebResource webResource = client.resource("http://localhost:8090/mylittlepet/dono/teste");
		final String test = webResource.get(String.class);
		System.out.println(test);
		//fail("Not yet implemented");
	}

	@Test
	public void testCadastrarPerfilDono() {
		WebResource webResource = client.resource("http://localhost:8090/mylittlepet/dono/cadastrarPerfilDono");
		
		final DonoDTO donoDTO = new DonoDTO();
		donoDTO.setContatos(new ContatoDTO());
		donoDTO.getContatos().setCelular("123456789");
		donoDTO.getContatos().setEmail("emailcontato@email.com");
		donoDTO.getContatos().setId(1L);
		donoDTO.getContatos().setTelefone("87654321");
		
		donoDTO.setEnderecos(new EnderecoDTO());
		donoDTO.getEnderecos().setCep("12345678");
		donoDTO.getEnderecos().setCidade("CIDADE");
		donoDTO.getEnderecos().setId(1L);
		donoDTO.getEnderecos().setLogradouro("Rua do teste");
		donoDTO.getEnderecos().setNumero(1);
		donoDTO.getEnderecos().setUf("SP");
		
		donoDTO.setDataNascimento(new Date());
		//donoDTO.setFoto(ImageUtils.converterImagemEmStringBASE64("C:\\teste\\input\\mypet.png"));
		donoDTO.setId(1L);
		donoDTO.setNome("Teste Foto FTP");
		donoDTO.setSobrenome("Sobre Nome");
		
		final String test = webResource.type(MediaType.APPLICATION_JSON).post(String.class, donoDTO);
		System.out.println(test);
	}

	@Test
	public void testMudarFotoPerfil() {
		//fail("Not yet implemented");
	}

}