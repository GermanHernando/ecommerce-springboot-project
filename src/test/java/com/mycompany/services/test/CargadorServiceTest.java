package com.mycompany.services.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycompany.app.App;
import com.mycompany.models.Cargador;
import com.mycompany.services.ProductoServices;

import helpers.CargadorHelper;

@SpringBootTest(classes = App.class)
public class CargadorServiceTest {

	
	@Autowired
	private ProductoServices producto;
	
	
	@Test
	public void testSaveCargadorCargadorSucces() {
		Cargador c = CargadorHelper.crearCargadorValido();
		producto.guardarProducto(c);
	}
	
	@Test
	public void testDeleteCargadorCargadorSucces() {
		Cargador c = CargadorHelper.crearCargadorValido();
		producto.eliminarProducto(c);
	}
}
