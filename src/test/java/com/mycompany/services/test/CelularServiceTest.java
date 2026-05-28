package com.mycompany.services.test;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import com.mycompany.models.Celular;
import com.mycompany.services.CelularServices;

import helpers.CelularHelper;


@ActiveProfiles("test")
public class CelularServiceTest extends ProductoServiceTest<Celular, CelularServices> {

	@Test
	public void testSaveCelularCelularSucces() {
		Celular c = CelularHelper.crearCelularValido();
		guardarProducto(c);
	}

	@Test
	public void testDeleteCelularCelularSucces() {
		Celular c = CelularHelper.crearCelularValido();
		eliminarProducto(c);
	}

}
