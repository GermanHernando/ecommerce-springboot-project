package com.mycompany.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompradorDTO extends UsuarioDTO {

	@JsonProperty(value = "firstName")
	private String nombre;
	@JsonProperty(value = "secondName")
	private String apellido;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
}
