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

import com.locadora.LocadoradeLivrosApi.models.Editora;
import com.locadora.LocadoradeLivrosApi.repository.EditoraRepository;
import com.locadora.LocadoradeLivrosApi.service.EditorasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Livros")
@CrossOrigin(origins = "*")
public class EditoraController {

	@Autowired
	EditoraRepository editoraRepository;
	
	@Autowired
	EditorasService serviceBuscar;
	
	@Autowired
	EditorasService serviceSalvar;
	
	@Autowired
	EditorasService serviceBuscarPorIdEditora;
	
	@Autowired
	EditorasService serviceAlterarEditora;
	
	@Autowired
	EditorasService serviceDeletarEditora;
	
	@GetMapping("/editoras")
	@ApiOperation(value = "Retorna uma lista de editoras")
	public List<Editora> listarLivros() {
		return serviceBuscar.listarEditoras();
	}

	@GetMapping("/editoras/{id}")
	@ApiOperation(value = "Retorna uma editora único")
	public Editora listarEditoraUnica(@PathVariable(value = "id") long id) {
		return serviceBuscarPorIdEditora.buscarPorId(id);
	}

	@PostMapping("/editora")
	@ApiOperation(value = "Salva uma editora")
	public Editora salvarEditora(@RequestBody @Valid Editora editora) {
		return serviceSalvar.salvarEditora(editora);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}

	@DeleteMapping("/editora")
	@ApiOperation(value = "Deleta uma editora")
	public void deletarEditora(@RequestBody Editora editora) {
		serviceDeletarEditora.deletarEditora(editora);
			
	}

	@PutMapping("/editar/editora")
	@ApiOperation(value = "Atualiza uma editora")
	public Editora atualizarEditora(@RequestBody @Valid Editora editora) {
		return serviceAlterarEditora.alterarEditora(editora);

	}
}
