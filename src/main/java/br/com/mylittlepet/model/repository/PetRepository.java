package br.com.mylittlepet.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mylittlepet.model.entity.Pet;


@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
	
}