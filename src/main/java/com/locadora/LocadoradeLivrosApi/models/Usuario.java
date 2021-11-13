package com.locadora.LocadoradeLivrosApi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	  @Id
	  @GeneratedValue(generator = "increment")
	  @GenericGenerator(name = "increment", strategy = "increment")
	  @JoinColumn(name="id")
	    private Long id;
	  
	  @NotBlank(message = "O nome não deve ser nulo")
	  @Size(min = 5, message = "Deve ser o nome e sobrenome")
	  @Column(nullable = false)
	    private String nome;
	  
	  @NotBlank(message = "O endereço não deve ser nulo")
	  @Column(nullable = false)
	    private String endereco;
	  
	  @NotBlank(message = "A cidade não deve ser nulo")
	  @Column(nullable = false)
	    private String cidade;
	  
	  @NotBlank(message = "O email não deve ser nulo")
	  @Email
	  @Column(nullable = false)
	    private String email;

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	  
	  



}
