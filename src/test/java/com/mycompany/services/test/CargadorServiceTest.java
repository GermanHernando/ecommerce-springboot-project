package com.mycompany.services.test;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import com.mycompany.models.Cargador;
import com.mycompany.services.CargadorServices;

import helpers.CargadorHelper;

@ActiveProfiles("test")
public class CargadorServiceTest extends ProductoServiceTest<Cargador,CargadorServices>{

	@Test
	public void testSaveCargadorCargadorSucces() {
		Cargador c = CargadorHelper.crearCargadorValido();
		guardarProducto(c);
	}

	@Test
	public void testDeleteCargadorCargadorSucces() {
		Cargador c = CargadorHelper.crearCargadorValido();
		eliminarProducto(c);
	}


	


}
