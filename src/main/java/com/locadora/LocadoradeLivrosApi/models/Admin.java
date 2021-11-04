package com.locadora.LocadoradeLivrosApi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="admins")
public class Admin {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private Long id;
 
	 @NotBlank(message = "O nome não deve ser nulo")
	 @Column(nullable = false)
	 	private String nome;
	 
	 @NotBlank(message = "O nome não deve ser nulo")
	 @Column(nullable = false, unique = true)
	 	private String login;
	 
	 @NotBlank(message = "O nome não deve ser nulo")
	 @Column(nullable = false)
	 	private String senha;
	 
	 
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
		
			public String getLogin() {
				return login;
			}
		
			public void setLogin(String login) {
				this.login = login;
			}
		
			public String getSenha() {
				return senha;
			}
		
			public void setSenha(String senha) {
				this.senha = senha;
			}

			
	 
	

}
