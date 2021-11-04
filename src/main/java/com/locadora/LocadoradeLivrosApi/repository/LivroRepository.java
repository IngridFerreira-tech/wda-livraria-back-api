package com.locadora.LocadoradeLivrosApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.LocadoradeLivrosApi.models.Livro;



public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	Livro findById(long id);
}
