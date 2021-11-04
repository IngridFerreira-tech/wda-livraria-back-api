package com.locadora.LocadoradeLivrosApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.locadora.LocadoradeLivrosApi.models.Aluguel;
import com.locadora.LocadoradeLivrosApi.repository.AluguelRepository;

@Service
public class AlugueisService {

	@Autowired
	AluguelRepository aluguelRepository;

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
		Aluguel savealuguel = aluguelRepository.save(aluguel);
		return savealuguel;
	}

	public Aluguel alterarAluguel(Aluguel aluguel) {
		Aluguel atualizarAluguel = aluguelRepository.save(aluguel);
		return atualizarAluguel;
	}

	public void deletarAluguel(Aluguel aluguel) {
		try {
			aluguelRepository.delete(aluguel);
		} catch (DataIntegrityViolationException e) {
			throw new com.locadora.LocadoradeLivrosApi.service.exceptions.DataIntegrityViolationException(
					"Este aluguel não pode ser deletado, possui livros e usuários cadastrados");
		}
	}
}
