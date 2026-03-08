package com.mycompany.services.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycompany.app.App;
import com.mycompany.models.Celular;
import com.mycompany.services.ProductoServices;

import helpers.CelularHelper;

@SpringBootTest(classes = App.class)
public class CelularServiceTest {

	
	@Autowired
	private ProductoServices producto;
	
	
	@Test
	public void testSaveCelularCelularSucces() {
		Celular c = CelularHelper.crearCelularValido();
		producto.guardarProducto(c);
	}
	
	@Test
	public void testDeleteCelularCelularSucces() {
		Celular c = CelularHelper.crearCelularValido();
		producto.eliminarProducto(c);
	}
	
	
}
