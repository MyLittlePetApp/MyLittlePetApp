package br.com.mylittlepet.model.mapper;

import br.com.mylittlepet.model.dto.EnderecoDTO;
import br.com.mylittlepet.model.entity.Endereco;
import br.com.mylittlepet.model.entity.Pessoa;

public class EnderecoMapper {
	
	public static Endereco parse(final EnderecoDTO enderecoDTO) {
		Endereco endereco = null;
		if(enderecoDTO != null) {
			endereco = new Endereco();
			endereco.setCep(enderecoDTO.getCep());
			endereco.setCidade(enderecoDTO.getCidade());
			endereco.setId(enderecoDTO.getId());
			endereco.setLogradouro(enderecoDTO.getLogradouro());
			endereco.setNumero(enderecoDTO.getNumero());
			endereco.setUf(enderecoDTO.getUf());
		}
		return endereco;
	}
	
	public static Endereco parse(final EnderecoDTO enderecoDTO, final Pessoa pessoa) {
		final Endereco endereco = parse(enderecoDTO);
		endereco.setPessoa(pessoa);
		return endereco;
	}

}
