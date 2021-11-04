package com.locadora.LocadoradeLivrosApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.locadora.LocadoradeLivrosApi.models.Livro;
import com.locadora.LocadoradeLivrosApi.repository.LivroRepository;

@Service
public class LivrosService {
	
	@Autowired
	LivroRepository livroRepository;
	
	public List <Livro> listarLivros(){
		List<Livro> listLivros = livroRepository.findAll();
		return listLivros;
	}
	
	public Livro buscarPorId(Long id) {
		Optional<Livro> optionalLivro = livroRepository.findById(id);
		Livro livro = null;
		livro = optionalLivro.get();
		return livro;
	}
	
	public Livro salvarLivro(Livro livro) {
		Livro saveLivro = livroRepository.save(livro);
		return saveLivro;
	}
	
	public Livro alterarLivro(Livro livro) {
		Livro atualizarLivro = livroRepository.save(livro);
		return atualizarLivro;
	}
	
	public void deletarLivro (Livro livro) {
		try {
			livroRepository.delete(livro);
		} catch (DataIntegrityViolationException e) {
			throw new com.locadora.LocadoradeLivrosApi.service.exceptions.DataIntegrityViolationException
			("Este livro não pode ser deletado, possui aluguéis cadastrados");
		}

	}
}
