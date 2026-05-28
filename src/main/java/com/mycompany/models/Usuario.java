package com.mycompany.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.mycompany.enums.Permiso;
import com.mycompany.exceptions.QuantityCharactersException;
import com.mycompany.exceptions.UserEmailException;
import com.mycompany.exceptions.UserPasswordException;
import com.mycompany.models.validator.UsuarioValidator;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
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
	@Enumerated(EnumType.ORDINAL)
	@ElementCollection(targetClass = Permiso.class)
	@CollectionTable(name = "PERMISOS_USUARIOS",joinColumns = @JoinColumn(name = "USUARIO_ID"))
	@Column(name = "PERMISO_ID" )
	private List<Permiso>permisos;

	public Usuario() {}

	public Usuario(String email, String contrasenia) throws QuantityCharactersException {
		this.setEmail(email);
		this.setContrasenia(contrasenia);
		this.setActivo(true);
		this.permisos = new ArrayList<Permiso>();
		this.permisos.add(Permiso.COMPRADOR);
	}
	
	public void convertirEnAdmin() {
		this.permisos.add(Permiso.ADMINISTRADOR);
	}
	
	public void setEmail(String email) throws QuantityCharactersException,UserEmailException {
		this.email = UsuarioValidator.emailValidator(email).toLowerCase().trim();
	}

	public void setContrasenia(String contrasenia) throws QuantityCharactersException, UserPasswordException {
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

	public List<GrantedAuthority>coleccionAutorizaciones(){
		List<GrantedAuthority>credenciales = new ArrayList<GrantedAuthority>();
		for (Permiso permiso : this.permisos) {
			credenciales.add(new SimpleGrantedAuthority(permiso.securityName()));
		}
		return credenciales;
	}

}
