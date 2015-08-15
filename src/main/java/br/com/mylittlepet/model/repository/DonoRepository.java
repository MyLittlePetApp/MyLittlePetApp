package br.com.mylittlepet.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mylittlepet.model.entity.Dono;

@Repository
public interface DonoRepository extends CrudRepository<Dono, Long>{

}
