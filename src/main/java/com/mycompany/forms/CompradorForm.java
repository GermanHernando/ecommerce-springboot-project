package com.mycompany.forms;

public class CompradorForm extends UsuarioForm {
//TODO Consultar si está bien que tenga ID este form
	private Long id;
	private String nombre;
	private String apellido;

	public CompradorForm() {}

	public CompradorForm(Long id, String email, String contrasenia, String nombre, String apellido) {
		super(email, contrasenia);
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	// Si puede mostrar de la lógica del mismo form
	public boolean existeUsuarioComprador() {
		return this.id != null && this.id > 0;
	}

}
