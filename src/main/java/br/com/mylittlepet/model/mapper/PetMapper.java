package br.com.mylittlepet.model.mapper;

import br.com.mylittlepet.model.dto.PetDTO;
import br.com.mylittlepet.model.entity.Dono;
import br.com.mylittlepet.model.entity.Pet;
import br.com.mylittlepet.model.entity.TipoPet;

public class PetMapper {

	public static Pet parse(final PetDTO petDTO) {
		Pet pet = null;
		if(petDTO.getIdDono() != null &&
				petDTO.getTipoPet() != null) {
			pet = new Pet();
			pet.setNome(petDTO.getNome());
			pet.setDataNascimento(petDTO.getDataNascimento());
			pet.setDescOutraRaca(petDTO.getRaca());
			pet.setDono(new Dono(petDTO.getIdDono()));
			pet.setId(petDTO.getId());
			pet.setTipopet(new TipoPet(petDTO.getTipoPet()));
			//pet.setHistoricos(HistoricoMapper.parse(petDTO.getHistoricos(), pet));
			//pet.setConsultas(ConsultaMapper.parse(petDTO.getConsultas(), pet));
		//	pet.setFotos(FotoMapper.parse(petDTO.getFotos()));
		}
		return pet;
	}
}
