package com.locadora.LocadoradeLivrosApi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.locadora.LocadoradeLivrosApi.models.Aluguel;
import com.locadora.LocadoradeLivrosApi.models.Livro;
import com.locadora.LocadoradeLivrosApi.repository.AluguelRepository;
import com.locadora.LocadoradeLivrosApi.repository.LivroRepository;

@Service
public class AlugueisService {

	@Autowired
	AluguelRepository aluguelRepository;
	
	@Autowired
	LivroRepository livroRepository;

	public List<Aluguel> listarAlugueis() {
		List<Aluguel> listAlugueis = aluguelRepository.findAll();
		return listAlugueis;
	}

	public Aluguel buscarPorId(Long id) {
		Optional<Aluguel> optionalAluguel = aluguelRepository.findById(id);
		Aluguel aluguel = null;
		aluguel = optionalAluguel.get();
		return aluguel;
	}

	public Aluguel salvarAluguel(Aluguel aluguel) {
		
		Livro livro  = livroRepository.getById(aluguel.getLivro().getId());
		
		LocalDate dataAtual = LocalDate.now();
		
		aluguel.setData_devolucao(null);
		
		if(aluguel.getData_previsao().isBefore(aluguel.getData_aluguel())) {
			throw new com.locadora.LocadoradeLivrosApi.service.exceptions.DataIntegrityViolationException(
					"A data de previsão não pode ser maior que a de aluguel");
		}	
		else if(aluguel.getData_previsao().isBefore(aluguel.getData_aluguel())) {
			throw new com.locadora.LocadoradeLivrosApi.service.exceptions.DataIntegrityViolationException(
					"A data de aluguel deve ser a data atual: "+ dataAtual);
		}
		else {				
		
		if(livro.getQuantidade() > 0) {
			livro.setQuantidade(livro.getQuantidade() - 1);
			
			livroRepository.save(livro);
			
			Aluguel savealuguel = aluguelRepository.save(aluguel);
			return savealuguel;			
		}

		else {
			throw new com.locadora.LocadoradeLivrosApi.service.exceptions.DataIntegrityViolationException(
					"Este livro não está disponível para aluguel");
		}
		}
		
	}

	public Aluguel alterarAluguel(Aluguel aluguel) {
		
		Livro livro  = livroRepository.findById(aluguel.getLivro().getId()).orElseThrow(null);
		
		LocalDate dataAtual = LocalDate.now();
		
		if(aluguel.getData_devolucao().isBefore(aluguel.getData_aluguel())) {
			throw new com.locadora.LocadoradeLivrosApi.service.exceptions.DataIntegrityViolationException(
					"A data de devolução não pode ser maior que a de aluguel");
		
		}else if(aluguel.getData_devolucao().isAfter(dataAtual) || aluguel.getData_devolucao().isBefore(dataAtual)){
			throw new com.locadora.LocadoradeLivrosApi.service.exceptions.DataIntegrityViolationException(
					"A data de devolução deve ser a data atual: "+ dataAtual);
		
		}
		else {
		if(aluguel.getData_devolucao() != null) {
			livro.setQuantidade(livro.getQuantidade() + 1);
			
			livroRepository.save(livro);
			
			Aluguel atualizarAluguel = aluguelRepository.save(aluguel);
			return atualizarAluguel;
		}
		}
		return aluguel;

	}

	public void deletarAluguel(Aluguel aluguel) {
		Livro livro  = livroRepository.findById(aluguel.getLivro().getId()).orElseThrow(null);
		if(aluguel.getData_devolucao() != null) {
			throw new com.locadora.LocadoradeLivrosApi.service.exceptions.DataIntegrityViolationException(
					"Este aluguel não pode ser deletado, possui livros e usuários cadastrados");
		}
		else {
			livro.setQuantidade(livro.getQuantidade() + 1);
			aluguelRepository.delete(aluguel);
		}
		
	}
}
