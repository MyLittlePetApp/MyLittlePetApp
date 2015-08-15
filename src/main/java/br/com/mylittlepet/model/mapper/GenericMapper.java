package br.com.mylittlepet.model.mapper;

import java.io.Serializable;

import br.com.mylittlepet.model.dto.GenericDTO;

public interface GenericMapper {
	
	public GenericDTO parseDTO(final Serializable objeto);
	
	public Serializable parseObjeto(final GenericDTO DTO);

}