package br.com.mylittlepet.model.mapper;

import java.util.HashSet;
import java.util.Set;

import br.com.mylittlepet.model.dto.ConsultaDTO;
import br.com.mylittlepet.model.entity.Consulta;
import br.com.mylittlepet.model.entity.Pet;

public class ConsultaMapper {
	
	public static Consulta parse(final ConsultaDTO consultaDTO) {
		final Consulta consulta = new Consulta();
		consulta.setDataConsulta(consultaDTO.getDataConsulta());
		consulta.setId(consultaDTO.getId());
		consulta.setMotivoConsulta(consultaDTO.getMotivoConsulta());
		consulta.setPet(new Pet(consultaDTO.getIdPet()));
		consulta.setPrescricaoMedica(consultaDTO.getPrescricaoMedica());
		return consulta;
	}
	
	public static Consulta parse(final ConsultaDTO consultaDTO, final Pet pet) {
		final Consulta consulta = parse(consultaDTO);
		consulta.setPet(pet);
		return consulta;
	}

	
	public static Set<Consulta> parse (final Set<ConsultaDTO> consultas, final Pet pet) {
		Set<Consulta> retorno = null;

		if(consultas != null && !consultas.isEmpty()) {
			retorno = new HashSet<Consulta>();
			for (ConsultaDTO consultaDTO : consultas) {
				retorno.add(parse(consultaDTO, pet));
			}
		}
		return retorno;
		
	}
	
	public static Set<Consulta> parse (final Set<ConsultaDTO> consultas) {
		Set<Consulta> retorno = null;

		if(consultas != null && !consultas.isEmpty()) {
			retorno = new HashSet<Consulta>();
			for (ConsultaDTO consultaDTO : consultas) {
				retorno.add(parse(consultaDTO));
			}
		}
		return retorno;
		
	}
	
}