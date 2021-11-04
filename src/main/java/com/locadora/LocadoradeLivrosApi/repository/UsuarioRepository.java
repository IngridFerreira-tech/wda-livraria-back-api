package com.locadora.LocadoradeLivrosApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.LocadoradeLivrosApi.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findById(long id);

}
