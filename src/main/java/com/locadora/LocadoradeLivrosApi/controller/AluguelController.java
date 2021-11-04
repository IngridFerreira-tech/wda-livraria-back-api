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

import com.locadora.LocadoradeLivrosApi.models.Aluguel;
import com.locadora.LocadoradeLivrosApi.repository.AluguelRepository;
import com.locadora.LocadoradeLivrosApi.service.AlugueisService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Livros")
@CrossOrigin(origins = "*")
public class AluguelController {

	@Autowired
	AluguelRepository aluguelRepository;

	@Autowired
	AlugueisService listarAlugueis;

	@Autowired
	AlugueisService buscarIdAlugueisService;

	@Autowired
	AlugueisService salvarAlugueisService;

	@Autowired
	AlugueisService editarAlugueisService;

	@Autowired
	AlugueisService deletarAlugueisService;

	@GetMapping("/alugueis")
	@ApiOperation(value = "Retorna uma lista de alugueis")
	public List<Aluguel> listarAlugueis() {
		return listarAlugueis.listarAlugueis();
	}

	@GetMapping("/alugueis/{id}")
	@ApiOperation(value = "Retorna um aluguel único")
	public Aluguel buscarPorId(@PathVariable(value = "id") long id) {
		return buscarIdAlugueisService.buscarPorId(id);
	}

	@PostMapping("/aluguel")
	@ApiOperation(value = "Salva um aluguel")
	public Aluguel salvarAluguel(@RequestBody @Valid Aluguel aluguel) {
		return salvarAlugueisService.salvarAluguel(aluguel);
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

	@DeleteMapping("/aluguel")
	@ApiOperation(value = "Deleta uma aluguel")
	public void deletarAluguel(@RequestBody Aluguel aluguel) {
		deletarAlugueisService.deletarAluguel(aluguel);
	}

	@PutMapping("/editar/aluguel")
	@ApiOperation(value = "Atualiza um aluguel")
	public Aluguel atualizarAluguel(@RequestBody @Valid Aluguel aluguel) {
		return editarAlugueisService.alterarAluguel(aluguel);
	}

}
