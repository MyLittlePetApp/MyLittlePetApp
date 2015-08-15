package br.com.mylittlepet.model.mapper;

import br.com.mylittlepet.model.dto.DonoDTO;
import br.com.mylittlepet.model.entity.Dono;

public class DonoMapper {
	
	public static Dono parse(final DonoDTO donoDTO) {
		final Dono dono = new Dono();
		dono.setDataNascimento(donoDTO.getDataNascimento());
		dono.setId(donoDTO.getId());
		dono.setNome(donoDTO.getNome());
		dono.setSobrenome(donoDTO.getSobrenome());
		return dono;
	}

}
