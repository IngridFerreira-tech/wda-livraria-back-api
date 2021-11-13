package com.locadora.LocadoradeLivrosApi.models;

import java.io.Serializable;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="livros")
public class Livro implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @JoinColumn(name="id")
	 	private Long id;
  
	 @NotBlank(message = "O nome não deve ser nulo")
	
	 	private String nome;
	 
	 
	 @OneToOne
	 	private Editora editora;
	 
	 @NotBlank(message = "O autor não deve ser nulo") 
	
	 	private String autor;
	 
	  @NotNull
	    private LocalDate lancamento;
	 
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
