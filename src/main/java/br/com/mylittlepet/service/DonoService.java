package br.com.mylittlepet.service;

import br.com.mylittlepet.model.dto.DonoDTO;
import br.com.mylittlepet.model.dto.RetornoDTO;
import br.com.mylittlepet.model.entity.Dono;

public interface DonoService {
	
	public RetornoDTO cadastrarDono(final DonoDTO donoDTO);
	
	public Dono buscarPorID(final Long id);

}
