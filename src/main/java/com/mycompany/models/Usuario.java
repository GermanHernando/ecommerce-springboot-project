package com.mycompany.models;

import com.mycompany.models.validator.UsuarioValidator;

import exceptions.QuantityCharactersException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	@Column(name = "CONTRASENIA")
	private String contrasenia;
	@Column(name = "ACTIVO")
	private boolean activo;

	Usuario() {}

	public Usuario(String email, String contrasenia) throws QuantityCharactersException {
		this.setEmail(email);
		this.setContrasenia(contrasenia);
		this.setActivo(true);
	}

	// TODO Validar que no haya emails duplicados en DB
	public void setEmail(String email) throws QuantityCharactersException {
		this.email = UsuarioValidator.emailValidator(email).toLowerCase().trim();
	}

	public void setContrasenia(String contrasenia) throws QuantityCharactersException {
		this.contrasenia = UsuarioValidator.contraseniaValidator(contrasenia);
	}

	public boolean tieneEmail() {
		return this.email != null && !this.email.isBlank();
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	// cambiarContrasenia()

}
