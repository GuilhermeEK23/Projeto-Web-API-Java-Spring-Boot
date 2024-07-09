package br.com.criandoapi.projeto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "O nome é obrigatório!")
	@Size(min = 3, message = "O nome deve conter no mínimo 3 carácteres!")
	@Column(name = "name", length = 200, nullable = true)
	private String name;
	
	@NotBlank(message = "O nome de usuário é obrigatório!")
	@Column(name = "username", length = 100, nullable = true)
	private String username;
	
	@NotBlank(message = "O E-mail é obrigatório!")
	@Email(message = "Insira um E-mail válido!")
	@Column(name = "email", length = 50, nullable = true)
	private String email;
	
	@NotBlank(message = "A senha é obrigatória!")
	@Column(name = "password", length = 100, nullable = true)
	private String password;
	
	@NotBlank(message = "O telefone é obrigatório!")
	@Column(name = "phone", length = 15, nullable = true)
	private String phone;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
