package com.locadora.LocadoradeLivrosApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.LocadoradeLivrosApi.models.Editora;



public interface EditoraRepository extends JpaRepository<Editora, Long>{
	
	Editora findById(long id);

}
