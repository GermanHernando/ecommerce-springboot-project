package com.mycompany.models;

import com.mycompany.models.validator.InfoContactoValidator;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class InfoContacto {

	@Column(name = "CONTACTO_TELEFONO")
	private Integer telefono;
	@Embedded
	private Direccion direccion;

	public InfoContacto(Integer telefono, Direccion direccion) {
		this.setTelefono(telefono);
		this.setDireccion(direccion);
	}

	public void setTelefono(Integer telefono) {
		this.telefono = InfoContactoValidator.telefonoValidator(telefono);
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = InfoContactoValidator.direccionValidator(direccion);
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

}
