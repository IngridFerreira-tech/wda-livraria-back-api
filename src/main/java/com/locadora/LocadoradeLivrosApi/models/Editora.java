package com.locadora.LocadoradeLivrosApi.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="editoras")

public class Editora {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @JoinColumn(name="id")
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
