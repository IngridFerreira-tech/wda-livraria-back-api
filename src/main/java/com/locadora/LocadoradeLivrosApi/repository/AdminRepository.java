package com.locadora.LocadoradeLivrosApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;
import com.locadora.LocadoradeLivrosApi.models.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	Admin findById(long id);
	
	public Optional<Admin> findBylogin(String login);

}
