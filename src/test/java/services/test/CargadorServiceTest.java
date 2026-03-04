package services.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import helpers.CargadorHelper;
import models.Cargador;
import services.ProductoServices;

@SpringBootTest
public class CargadorServiceTest {

	
	@Autowired
	private ProductoServices producto;
	
	
	@Test
	private void testSaveCargadorCargadorSucces() {
		Cargador c = CargadorHelper.crearCargadorValido();
		producto.guardarProducto(c);
	}
	
	@Test
	private void testDeleteCargadorCargadorSucces() {
		Cargador c = CargadorHelper.crearCargadorValido();
		producto.eliminarProducto(c);
	}
}
