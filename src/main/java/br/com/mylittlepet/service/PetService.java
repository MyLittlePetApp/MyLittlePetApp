package br.com.mylittlepet.service;

import br.com.mylittlepet.model.dto.ConsultaDTO;
import br.com.mylittlepet.model.dto.FotoDTO;
import br.com.mylittlepet.model.dto.HistoricoDTO;
import br.com.mylittlepet.model.dto.PetDTO;
import br.com.mylittlepet.model.dto.VacinaDTO;


public interface PetService {
	
	public PetDTO cadastrarPet(final PetDTO petDTO);
	
	public HistoricoDTO cadastrarHistorico(final HistoricoDTO historicoDTO);
	
	public ConsultaDTO cadastrarConsulta(final ConsultaDTO consultaDTO);
	
	public FotoDTO inserirFotoAlbum(final FotoDTO fotoDTO);
	
	public VacinaDTO cadastrarVacina(final VacinaDTO vacinaDTO);

}
