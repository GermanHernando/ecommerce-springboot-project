package services.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import helpers.CelularHelper;
import models.Celular;
import services.ProductoServices;

@SpringBootTest
public class CelularServiceTest {

	
	@Autowired
	private ProductoServices producto;
	
	
	@Test
	private void testSaveCelularCelularSucces() {
		Celular c = CelularHelper.crearCelularValido();
		producto.guardarProducto(c);
	}
	
	@Test
	private void testDeleteCelularCelularSucces() {
		Celular c = CelularHelper.crearCelularValido();
		producto.eliminarProducto(c);
	}
	
	
}
