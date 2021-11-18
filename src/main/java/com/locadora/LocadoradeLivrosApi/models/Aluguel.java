package com.locadora.LocadoradeLivrosApi.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "aluguel")
public class Aluguel {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;

	@OneToOne
	@NotNull 
	@NotBlank(message = "O nome do livro não pode ser nulo")
	private Livro livro;

	@OneToOne
	@NotNull
	@NotBlank(message = "O nome do usuário não pode ser nulo")
	private Usuario usuario;

	@NotNull
	@NotBlank(message = "A data do aluguel não pode ser nulo")
	private LocalDate data_aluguel;

	@NotNull
	@NotBlank(message = "A data de  previsão não pode ser nulo")
	private LocalDate data_previsao;

	private LocalDate data_devolucao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getData_aluguel() {
		return data_aluguel;
	}

	public void setData_aluguel(LocalDate data_aluguel) {
		this.data_aluguel = data_aluguel;
	}

	public LocalDate getData_previsao() {
		return data_previsao;
	}

	public void setData_previsao(LocalDate data_previsao) {
		this.data_previsao = data_previsao;
	}

	public LocalDate getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(LocalDate data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

}
