package com.locadora.LocadoradeLivrosApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.LocadoradeLivrosApi.models.Aluguel;


public interface AluguelRepository extends JpaRepository<Aluguel, Long>{
	
	Aluguel findById(long id);
	
}
