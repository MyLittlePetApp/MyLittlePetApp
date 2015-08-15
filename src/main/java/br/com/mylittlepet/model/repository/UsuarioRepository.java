package br.com.mylittlepet.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mylittlepet.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	public Usuario findByEmail(final String email);
	
	public Usuario findByEmailAndSenha(final String email, final String senha);
	
	//@Query(value = "SELECT * FROM PERSON_TABLE p WHERE p.AGE > ?1", isNative = true)
    //List<Person> findAllOlderThan(int minAge);
	
	//@Query("select count(p) from Person p where p.age > ?1")
    //Long countAllOlderThan(int minAge);
	
	//@Query(named = Person.BY_NAME, singleResult = SingleResultType.ANY)
    //Person findByName(String firstName, String lastName);
}