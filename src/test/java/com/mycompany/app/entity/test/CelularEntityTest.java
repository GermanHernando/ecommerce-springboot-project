	package com.mycompany.app.entity.test;

	import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.mycompany.models.Celular;

import exceptions.QuantityCharactersException;
import helpers.CelularHelper;
	@SpringBootTest
	@ActiveProfiles("test")
	public class CelularEntityTest {

	  //VALIDO
	    @Test
	    public void testCelularValido() {
	        Celular celular = assertDoesNotThrow(() -> CelularHelper.crearCelularValido());
	    }
	    
	    
	 //NOMBRE INVALIDO
	    @Test
	    public void testNombreVacio() {
	        assertThrows(IllegalArgumentException.class,
	            () -> CelularHelper.crearCelularNombreVacio());
	    }
	    
	    @Test
	    public void testNombreTamanioInvalido() {
	        assertThrows(QuantityCharactersException.class,
	            () -> CelularHelper.crearCelularNombreTamanioInvalido());
	    }

	 //MARCA INVALIDA
	    @Test
	    public void testMarcaVacia() {
	        assertThrows(IllegalArgumentException.class,
	            () -> CelularHelper.crearCelularMarcaVacia());
	    }
	    
	    @Test
	    public void testMarcaTamanioInvalido() {
	        assertThrows(QuantityCharactersException.class,
	            () -> CelularHelper.crearCelularMarcaTamanioInvalido());
	    }

	 //COLOR INVALIDO
	    @Test
	    public void testColorVacio() {
	        assertThrows(IllegalArgumentException.class,
	            () -> CelularHelper.crearCelularColorVacio());
	    }
	    
	    @Test
	    public void testColorTamanioInvalido() {
	        assertThrows(QuantityCharactersException.class,
	            () -> CelularHelper.crearCelularColorTamanioInvalido());
	    }
	    
	 //PRECIO INVALIDO
	    @Test
	    public void testPrecioVacio() {
	        assertThrows(IllegalArgumentException.class,
	            () -> CelularHelper.crearCelularPrecioInvalido());
	    }
	    
	 //CANTIDAD INVALIDA
	    @Test
	    public void testCantidadVacia() {
	        assertThrows(IllegalArgumentException.class,
	            () -> CelularHelper.crearCelularCantidadInvalida());
	    }
	    

	  //TAMANIO INVALIDO
	    @Test
	    public void testTamanioCero() {
	        assertThrows(IllegalArgumentException.class,
	            () -> CelularHelper.crearCelularTamanioCero());
	    }

	    @Test
	    public void testTamanioInvalido() {
	        assertThrows(QuantityCharactersException.class,
	            () -> CelularHelper.crearCelularTamanioInvalido());
	    }

	  //RESOLUCION PANTALLA INVALIDA
	    @Test
	    public void testResolucionPantallaVacia() {
	        assertThrows(IllegalArgumentException.class,
	            () -> CelularHelper.crearCelularResolucionPantallaVacia());
	    }

	    @Test
	    public void testResolucionPantallaTamanioInvalido() {
	        assertThrows(QuantityCharactersException.class,
	            () -> CelularHelper.crearCelularResolucionPantallaTamanioInvalido());
	    }

	  //RESOLUCION CAMARA INVALIDA
	    @Test
	    public void testResolucionCamaraVacia() {
	        assertThrows(IllegalArgumentException.class,
	            () -> CelularHelper.crearCelularResolucionCamaraVacia());
	    }
	    @Test
	    public void testResolucionCamaraTamanioInvalido() {
	        assertThrows(QuantityCharactersException.class,
	            () -> CelularHelper.crearCelularResolucionCamaraTamanioInvalido());
	    }
	    
	   //RAM INVALIDA
	    @Test
	    public void testRamCero() {
	        assertThrows(IllegalArgumentException.class,
	            () -> CelularHelper.crearCelularRamCero());
	    }

	    @Test
	    public void testRamTamanioInvalido() {
	        assertThrows(QuantityCharactersException.class,
	            () -> CelularHelper.crearCelularRamTamanioInvalido());
	    }

	   //ALMACENAMIENTO INVALIDO
	    @Test
	    public void testAlmacenamientoCero() {
	        assertThrows(IllegalArgumentException.class,
	            () -> CelularHelper.crearCelularAlmacenamientoCero());
	    }

	    @Test
	    public void testAlmacenamientoTamanioInvalido() {
	        assertThrows(QuantityCharactersException.class,
	            () -> CelularHelper.crearCelularAlmacenamientoTamanioInvalido());
	    }

	}
	

