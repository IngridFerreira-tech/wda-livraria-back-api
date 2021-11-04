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

import com.locadora.LocadoradeLivrosApi.models.Livro;
import com.locadora.LocadoradeLivrosApi.repository.LivroRepository;
import com.locadora.LocadoradeLivrosApi.service.LivrosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST Livros")
@CrossOrigin(origins="http://localhost:8080")
public class LivroController {
	
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	LivrosService serviceListarLivro;
	
	@Autowired
	LivrosService serviceBuscarIdLivro;
	
	@Autowired
	LivrosService serviceSalvarLivro;
	
	@Autowired
	LivrosService serviceDeletarLivro;
	
	@Autowired
	LivrosService serviceAlterarLivro;
	
	@GetMapping("/livros")
	@ApiOperation(value="Retorna uma lista de livros")
	public List<Livro> listarLivros(){
		return serviceListarLivro.listarLivros();
	}
	
	@GetMapping("/livros/{id}")
	@ApiOperation(value="Retorna um livro único")
	public Livro listarLivroUnico(@PathVariable(value="id") long id){
		return serviceBuscarIdLivro.buscarPorId(id);
	}
	
	@PostMapping("/livro")
	@ApiOperation(value="Salvar um livro")
	public Livro salvarLivro(@RequestBody @Valid Livro livro) {
		return serviceSalvarLivro.salvarLivro(livro);
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
	
	@DeleteMapping("/livro")
	@ApiOperation(value="Deleta um livro")
	public void deletarLivro(@RequestBody Livro livro) {
		serviceDeletarLivro.deletarLivro(livro);

	}
	
	@PutMapping("/editar/livro")
	@ApiOperation(value="Atualiza um livro")
	public Livro atualizarLivro(@RequestBody @Valid Livro livro) {
		return serviceAlterarLivro.alterarLivro(livro);
	}

}
