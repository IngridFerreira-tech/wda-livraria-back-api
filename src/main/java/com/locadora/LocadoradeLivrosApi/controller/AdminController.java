package com.locadora.LocadoradeLivrosApi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.LocadoradeLivrosApi.models.Admin;
import com.locadora.LocadoradeLivrosApi.repository.AdminRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Livros")
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired
	AdminRepository adminRepository ;
	
	
	@GetMapping("/admins")
	@ApiOperation(value="Retorna uma lista de administradores do sistema")
	public List<Admin> listaradmins(){
		return adminRepository.findAll();
	}
	
	@GetMapping("/admins/{id}")
	@ApiOperation(value="Retorna um administrador único")
	public Admin listarAdminUnico(@PathVariable(value="id") long id){
		return adminRepository.findById(id);
	}
	
		
	
	@PostMapping("/admin")
	@ApiOperation(value="Salva um administrador")
	public Admin salvarAdmin(@RequestBody @Valid Admin admin) {
		
		return adminRepository.save(admin);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
		
		return errors;
	}
	
	@DeleteMapping("/admin")
	@ApiOperation(value="Deleta um administrador")
	public void deletarAdmin(@RequestBody Admin admin) {
		adminRepository.delete(admin);
	}
	
	@PutMapping("/editar/admin")
	@ApiOperation(value="Atualiza um administrador")
	public Admin atualizarAdmin(@RequestBody @Valid Admin admin) {
		return adminRepository.save(admin);
	}
	
}
