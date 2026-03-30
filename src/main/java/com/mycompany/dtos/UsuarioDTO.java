package com.mycompany.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class UsuarioDTO {

	@JsonProperty(value = "user")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
