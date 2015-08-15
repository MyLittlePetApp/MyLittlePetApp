package br.com.mylittlepet.model.mapper;

import br.com.mylittlepet.model.dto.ContatoDTO;
import br.com.mylittlepet.model.entity.Contato;
import br.com.mylittlepet.model.entity.Pessoa;

public class ContatoMapper {
	
	public static Contato parse(final ContatoDTO contatoDTO) {
		Contato contato = null;
		if(contatoDTO != null) {
			contato = new Contato();
			contato.setId(contatoDTO.getId());
			contato.setCelular(contatoDTO.getCelular());
			contato.setEmail(contatoDTO.getEmail());
			contato.setTelefone(contatoDTO.getTelefone());
		}
		return contato;
	}
	
	public static Contato parse(final ContatoDTO contatoDTO, final Pessoa pessoa) {
		final Contato contato = parse(contatoDTO);
		contato.setPessoa(pessoa);;
		return contato;
	}


}
