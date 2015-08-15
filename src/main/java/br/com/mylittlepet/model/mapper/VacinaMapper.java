package br.com.mylittlepet.model.mapper;

import java.util.HashSet;
import java.util.Set;

import br.com.mylittlepet.model.dto.VacinaDTO;
import br.com.mylittlepet.model.entity.Pet;
import br.com.mylittlepet.model.entity.Vacina;

public class VacinaMapper {
	
	public static Vacina parse(final VacinaDTO vacinaDTO) {
		final Vacina vacina = new Vacina();
		vacina.setDataVacina(vacinaDTO.getDataVacina());
		vacina.setId(vacinaDTO.getId());
		vacina.setNome(vacinaDTO.getNome());
		vacina.setPet(new Pet(vacinaDTO.getIdPet()));
		return vacina;
	}
	
	public static Set<Vacina> parse(final Set<VacinaDTO> vacinas) {
		Set<Vacina> retorno = null;
		if(vacinas != null && !vacinas.isEmpty()) {
			retorno = new HashSet<Vacina>();
			for (VacinaDTO vacinaDTO : vacinas) {
				retorno.add(parse(vacinaDTO));
			}
		}
		return retorno;
	}

}
