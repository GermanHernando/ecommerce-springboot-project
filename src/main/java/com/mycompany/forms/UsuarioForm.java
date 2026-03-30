package com.mycompany.forms;

import exceptions.QuantityCharactersException;

public abstract class UsuarioForm {

	private Long id;
	private String email;
	private String contrasenia;

	public UsuarioForm() {}

	public UsuarioForm(String email, String contrasenia) {
		this.email = email;
		this.contrasenia = contrasenia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	protected abstract String getNombre();
	protected abstract String getApellido();

	public CompradorForm devolverComprador() throws QuantityCharactersException, IllegalArgumentException{
		return new CompradorForm(this.id,this.email,this.contrasenia,this.getNombre(),this.getApellido());
	}
	

}
