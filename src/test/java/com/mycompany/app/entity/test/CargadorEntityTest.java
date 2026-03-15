
package com.mycompany.app.entity.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.mycompany.models.Cargador;

import exceptions.QuantityCharactersException;
import helpers.CargadorHelper;
@SpringBootTest
@ActiveProfiles("test")
public class CargadorEntityTest {

	
	 //VALIDO
    @Test
    public void testCargadorValido() {
        Cargador Cargador = assertDoesNotThrow(() -> CargadorHelper.crearCargadorValido());
    }
    
    
 //NOMBRE INVALIDO
    @Test
    public void testNombreVacio() {
        assertThrows(IllegalArgumentException.class,
            () -> CargadorHelper.crearCargadorNombreVacio());
    }
    
    @Test
    public void testNombreTamanioInvalido() {
        assertThrows(QuantityCharactersException.class,
            () -> CargadorHelper.crearCargadorNombreTamanioInvalido());
    }

 //MARCA INVALIDA
    @Test
    public void testMarcaVacia() {
        assertThrows(IllegalArgumentException.class,
            () -> CargadorHelper.crearCargadorMarcaVacia());
    }
    
    @Test
    public void testMarcaTamanioInvalido() {
        assertThrows(QuantityCharactersException.class,
            () -> CargadorHelper.crearCargadorMarcaTamanioInvalido());
    }

 //COLOR INVALIDO
    @Test
    public void testColorVacio() {
        assertThrows(IllegalArgumentException.class,
            () -> CargadorHelper.crearCargadorColorVacio());
    }
    
    @Test
    public void testColorTamanioInvalido() {
        assertThrows(QuantityCharactersException.class,
            () -> CargadorHelper.crearCargadorColorTamanioInvalido());
    }
    
 //PRECIO INVALIDO
    @Test
    public void testPrecioVacio() {
        assertThrows(IllegalArgumentException.class,
            () -> CargadorHelper.crearCargadorPrecioInvalido());
    }
    
 //CANTIDAD INVALIDA
    @Test
    public void testCantidadVacia() {
        assertThrows(IllegalArgumentException.class,
            () -> CargadorHelper.crearCargadorCantidadInvalida());
    }
    
  //WATS INVALIDOS
    @Test
    public void testWatsVacio() {
        assertThrows(IllegalArgumentException.class,
            () -> CargadorHelper.crearCargadorWatsInvalidos());
    }
    
    @Test
    public void testWatsTamanioInvalido() {
        assertThrows(QuantityCharactersException.class,
            () -> CargadorHelper.crearCargadorWatsTamanioInvalido());
    }
    
	
}
