package com.locadora.LocadoradeLivrosApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.locadora.LocadoradeLivrosApi.models.Usuario;
import com.locadora.LocadoradeLivrosApi.repository.UsuarioRepository;

@Service
public class UsuariosService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuarios() {
		List<Usuario> listUsuarios = usuarioRepository.findAll();
		return listUsuarios;
	}

	public Usuario buscarPorId(Long id) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		Usuario usuario = null;
		usuario = optionalUsuario.get();
		return usuario;
	}

	public Usuario salvarUsuario(Usuario usuario) {
		Usuario saveusuario = usuarioRepository.save(usuario);
		return saveusuario;
	}

	public Usuario alterarUsuario(Usuario usuario) {
		Usuario atualizarUsuario = usuarioRepository.save(usuario);
		return atualizarUsuario;
	}

	public void deletarUsuario(Usuario usuario) {
		try {
			usuarioRepository.delete(usuario);
		} catch (DataIntegrityViolationException e) {
			throw new com.locadora.LocadoradeLivrosApi.service.exceptions.DataIntegrityViolationException(
					"Este usuário não pode ser deletado, possui aluguéis cadastrados");
		}

	}
}
