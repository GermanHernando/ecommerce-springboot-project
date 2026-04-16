package com.mycompany.forms;

public class CompradorForm extends UsuarioForm {
	
	private String nombre;
	private String apellido;

	public CompradorForm() {}

	public CompradorForm(Long id, String email, String contrasenia, String nombre, String apellido) {
		super(email, contrasenia);
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public boolean existeUsuarioComprador() {
		return super.getId()!= null && super.getId()> 0;
	}

}
