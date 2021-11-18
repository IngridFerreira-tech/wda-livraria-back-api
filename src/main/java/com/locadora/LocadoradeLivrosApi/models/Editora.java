package com.locadora.LocadoradeLivrosApi.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="editoras")

public class Editora {
	
	 @Id
	 @GeneratedValue(generator = "increment")
	 @GenericGenerator(name = "increment", strategy = "increment")
	    private Long id;
	  
	  @NotBlank(message = "O nome não pode ser vazio")
	    private String nome;
	  
	  @NotBlank(message = "A cidade não pode ser vazia")
	    private String cidade;
	  
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
	
		public String getCidade() {
			return cidade;
		}
	
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

	  
	  
}
