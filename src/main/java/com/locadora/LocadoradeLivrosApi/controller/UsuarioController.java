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

import com.locadora.LocadoradeLivrosApi.models.Usuario;
import com.locadora.LocadoradeLivrosApi.repository.UsuarioRepository;
import com.locadora.LocadoradeLivrosApi.service.UsuariosService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Livros")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuariosService listarUsuariosService;

	@Autowired
	UsuariosService buscarIdUsuarioService;

	@Autowired
	UsuariosService salvarUsuarioService;

	@Autowired
	UsuariosService editarUsuarioService;

	@Autowired
	UsuariosService deletarUsuarioService;

	@GetMapping("/usuarios")
	@ApiOperation(value = "Retorna uma lista de usuários")
	public List<Usuario> listarUsuarios() {
		return listarUsuariosService.listarUsuarios();
	}

	@GetMapping("/usuarios/{id}")
	@ApiOperation(value = "Retodelna um único usuário")
	public Usuario listarUsuarioUnico(@PathVariable(value = "id") long id) {
		return buscarIdUsuarioService.buscarPorId(id);
	}

	@PostMapping("/usuario")
	@ApiOperation(value = "Salva um usuário")
	public Usuario salvarUsuario(@RequestBody @Valid Usuario usuario) {
		return salvarUsuarioService.salvarUsuario(usuario);
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

	@DeleteMapping("/usuario")
	@ApiOperation(value = "Deleta um usuário")
	public void deletarUsuario(@RequestBody Usuario usuario) {
		deletarUsuarioService.deletarUsuario(usuario);
	}

	@PutMapping("/editar/usuario")
	@ApiOperation(value = "Atualiza um usuário")
	public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
		return editarUsuarioService.alterarUsuario(usuario);
	}
}
