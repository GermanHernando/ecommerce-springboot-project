package services.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycompany.app.App;

import helpers.CelularHelper;
import models.Celular;
import services.ProductoServices;

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
