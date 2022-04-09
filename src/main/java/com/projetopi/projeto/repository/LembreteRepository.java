package com.projetopi.projeto.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.projetopi.projeto.model.Lembrete;

public interface LembreteRepository extends CrudRepository<Lembrete, Long>{
	
	Lembrete findByCodigo(long codigo);
	
	List<Lembrete> findByTitulo(String titulo);
	
	// Query para a busca
		@Query(value = "select u from Lembrete u where u.titulo like %?1%")
		List<Lembrete> findByNomesLembrete(String nome);
}
