package br.com.mylittlepet.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mylittlepet.model.entity.Veterinario;

@Repository
public interface VeterinarioRepository  extends CrudRepository<Veterinario, Long>{

}
