package com.mycompany.services.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycompany.app.App;
import com.mycompany.models.Comprador;
import com.mycompany.services.UsuarioServices;

import helpers.CompradorHelper;

@SpringBootTest(classes = App.class)
public class CompradorServiceTest {

	@Autowired
	private UsuarioServices usuario;
	
	@Test
	private void testSaveUsuarioCompradorSucces() {
		Comprador c = CompradorHelper.crearCompradorValido();
		usuario.guardarUsuario(c);
	}
	
	@Test
	private void testDeleteUsuarioCompradorSucces() {
		Comprador c = CompradorHelper.crearCompradorValido();
		usuario.eliminarComprador(c);
	}
	
}
