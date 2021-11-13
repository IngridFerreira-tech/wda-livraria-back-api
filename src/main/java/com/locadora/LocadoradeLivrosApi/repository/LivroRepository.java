package com.locadora.LocadoradeLivrosApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.locadora.LocadoradeLivrosApi.models.Livro;



public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	Livro findById(long id);
	
	@Query("select a from Livro a where a.quantidade != 0")
	List<Livro> findList();
}
