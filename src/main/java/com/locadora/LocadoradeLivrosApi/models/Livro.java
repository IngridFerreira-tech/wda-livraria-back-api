package com.locadora.LocadoradeLivrosApi.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="livros")
public class Livro implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(generator = "increment")
	 @GenericGenerator(name = "increment", strategy = "increment")
	 @JoinColumn(name="id")
	 	private Long id;
  
	 @NotBlank(message = "O nome não pode ser nulo")
	 	private String nome;
	 
	 @OneToOne
	 @NotBlank(message = "O nome da editora não pode ser nula")
	 	private Editora editora;
	 
	 @NotBlank(message = "O nome do autor não pode ser nulo") 
	 	private String autor;
	 
	  @NotNull
	  @NotBlank(message = "A data de lançamento não pode ser nula")
	    private LocalDate lancamento;
	 
	  @NotNull
	  @NotBlank(message = "A quantidade não pode ser nula")
	 	private int quantidade;

		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}
	
		public String getNome() {
			return nome;
		}
	
		public void setNome(String nome) {
			this.nome = nome;
		}
	
	
		public String getAutor() {
			return autor;
		}
	
		public void setAutor(String autor) {
			this.autor = autor;
		}
	
		public LocalDate getLancamento() {
			return lancamento;
		}

		public void setLancamento(LocalDate lancamento) {
			this.lancamento = lancamento;
		}

		public int getQuantidade() {
			return quantidade;
		}
	
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
	
		public Editora getEditora() {
			return editora;
		}
	
		public void setEditora(Editora editora) {
			this.editora = editora;
		}
		
	
	 
	 
}
