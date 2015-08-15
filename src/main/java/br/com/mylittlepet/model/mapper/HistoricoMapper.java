package br.com.mylittlepet.model.mapper;

import java.util.HashSet;
import java.util.Set;

import br.com.mylittlepet.model.dto.HistoricoDTO;
import br.com.mylittlepet.model.entity.Historico;
import br.com.mylittlepet.model.entity.Pet;

public class HistoricoMapper {
	
	public static Historico parse(final HistoricoDTO historicoDTO) {
		final Historico historico = new Historico();
		historico.setId(historicoDTO.getId());
		historico.setDescricao(historicoDTO.getDescricao());
		historico.setPet(new Pet(historicoDTO.getIdPet()));
		return historico;
	}
	
	public static Historico parse(final HistoricoDTO historicoDTO, final Pet pet) {
		final Historico historico = parse(historicoDTO);
		historico.setPet(pet);
		return historico;
	}
	
	public static Set<Historico> parse (final Set<HistoricoDTO> historicos, final Pet pet) {
		Set<Historico> retorno = null;
		if(historicos != null && !historicos.isEmpty()) {
			retorno = new HashSet<Historico>();
			for (HistoricoDTO historicoDTO : historicos) {
				retorno.add(parse(historicoDTO, pet));
			}
		}
		return retorno;
	}
	
	public static Set<Historico> parse (final Set<HistoricoDTO> historicos) {
		Set<Historico> retorno = null;
		if(historicos != null && !historicos.isEmpty()) {
			retorno = new HashSet<Historico>();
			for (HistoricoDTO historicoDTO : historicos) {
				retorno.add(parse(historicoDTO));
			}
		}
		return retorno;
	}

}