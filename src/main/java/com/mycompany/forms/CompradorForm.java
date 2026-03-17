package com.mycompany.forms;

import com.mycompany.models.Comprador;

import exceptions.QuantityCharactersException;

public class CompradorForm {

	private Long id;
	private String email;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private int telefono;
	private String direccion;
	private String codigoPostal;

	
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Comprador devolverComprador() throws QuantityCharactersException, IllegalArgumentException{
		return new Comprador(this.email,this.contrasenia,this.nombre,this.apellido,this.telefono,this.direccion,this.codigoPostal);
	}

	public boolean existeUsuarioComprador() {
		return this.id!=null && this.id>0;
	}
}
