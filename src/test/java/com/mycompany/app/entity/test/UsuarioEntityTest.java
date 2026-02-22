package com.mycompany.app.entity.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import models.Comprador;

public class UsuarioEntityTest {

	private String email = null;
	private String contrasenia = null;
	private String nombre = null;
	private String apellido = null;
	private int telefono = 0;
	private String direccion = null;
	private String codigoPostal = null;
	
	
	@Test
	public void testTieneEmailValido() {
		//Los valores de los atributos de cada test, reemplazan a los originales de la clase
		this.email = null;
		this.contrasenia = null;
		this.nombre = null;
		this.apellido = null;
		this.telefono = 0;
		this.direccion = null;
		this.codigoPostal = null;
		
		Comprador c = new Comprador(email,contrasenia,nombre,apellido,telefono,direccion,codigoPostal);
		
		assertTrue(c.tieneEmail());
		
		
	}
	
}
