package br.com.mylittlepet.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mylittlepet.model.entity.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long>{
}