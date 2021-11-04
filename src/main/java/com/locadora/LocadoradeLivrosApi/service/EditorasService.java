package com.locadora.LocadoradeLivrosApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.locadora.LocadoradeLivrosApi.models.Editora;
import com.locadora.LocadoradeLivrosApi.repository.EditoraRepository;

@Service
public class EditorasService {	
	
	
	
	@Autowired
	EditoraRepository editoraRepository;
	
	public List <Editora> listarEditoras(){
		List<Editora> listEditora = editoraRepository.findAll();
	
		return listEditora;
	}

	public Editora buscarPorId(Long id) {
		Optional<Editora> optionalEditora = editoraRepository.findById(id);
		Editora editora = null;
		editora = optionalEditora.get();
		return editora;
	}
	
	public Editora salvarEditora(Editora editora) {
		Editora saveEditora = editoraRepository.save(editora);
		return saveEditora;
	}
	
	public Editora alterarEditora(Editora editora) {
		Editora atualizarEditora = editoraRepository.save(editora);
		return atualizarEditora;
	}
	
	public void deletarEditora (Editora editora) {
		try {
			editoraRepository.delete(editora);
		} catch (DataIntegrityViolationException e) {
			throw new com.locadora.LocadoradeLivrosApi.service.exceptions.DataIntegrityViolationException
			("Esta editora não pode ser deletada, possui livros associados");
		}
			
		
	}
}
