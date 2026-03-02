package com.mycompany.app.entity.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import exceptions.QuantityCharactersException;
import helpers.CompradorHelper;
import models.Comprador;

public class CompradorEntityTest {


	
	@Test
	public void testTieneEmailValido() {
	    Comprador c = assertDoesNotThrow(() -> CompradorHelper.crearCompradorValido());
	    assertTrue(c.tieneEmail());
	}
	
	//EMAIL INVALIDO
    @Test
    public void testConstructorEmailNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            CompradorHelper.crearCompradorEmailNull();
        });
    }

    
    @Test
    public void testConstructorEmailVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            CompradorHelper.crearCompradorEmailVacio();
        });
    }

   
    @Test
    public void testConstructorEmailFormatoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            CompradorHelper.crearCompradorEmailFormatoInvalido();
        });
    }

   
    @Test
    public void testConstructorEmailCantCaracteres() {
        assertThrows(QuantityCharactersException.class, () -> {
            CompradorHelper.crearCompradorEmailCantCaracteres();
        });
    }
    
    
    //CONTRASENIA INVALIDA
    @Test
    public void testConstructorContraseniaNull() {
        assertThrows(IllegalArgumentException.class,
                () -> CompradorHelper.crearCompradorContraseniaNull());
    }

    @Test
    public void testConstructorContraseniaVacia() {
        assertThrows(IllegalArgumentException.class,
                () -> CompradorHelper.crearCompradorContraseniaVacia());
    }

    @Test
    public void testConstructorContraseniaCantCaracteres() {
        assertThrows(QuantityCharactersException.class,
                () -> CompradorHelper.crearCompradorContraseniaCantCaracteres());
    }

    @Test
    public void testConstructorContraseniaSinMayuscula() {
        assertThrows(IllegalArgumentException.class,
                () -> CompradorHelper.crearCompradorContraseniaSinMayuscula());
    }

    @Test
    public void testConstructorContraseniaSinNumero() {
        assertThrows(IllegalArgumentException.class,
                () -> CompradorHelper.crearCompradorContraseniaSinNumero());
    }

    @Test
    public void testConstructorContraseniaSinEspecial() {
       assertThrows(IllegalArgumentException.class,
               () -> CompradorHelper.crearCompradorContraseniaSinEspecial());
    }

   
    
    //NOMBRE INVALIDO
    @Test
    public void testConstructorNombreNull() {
        assertThrows(IllegalArgumentException.class,
                () -> CompradorHelper.crearCompradorNombreNull());
    }

    @Test
    public void testConstructorNombreVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> CompradorHelper.crearCompradorNombreVacio());
    }

    @Test
    public void testConstructorNombreCantCaracteres() {
        assertThrows(QuantityCharactersException.class,
                () -> CompradorHelper.crearCompradorNombreCantCaracteres());
    }
    
    //APELLIDO INVALIDO
    @Test
    public void testConstructorApellidoNull() {
        assertThrows(IllegalArgumentException.class,
                () -> CompradorHelper.crearCompradorApellidoNull());
    }

    @Test
    public void testConstructorApellidoVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> CompradorHelper.crearCompradorApellidoVacio());
    }

    @Test
    public void testConstructorApellidoCantCaracteres() {
        assertThrows(QuantityCharactersException.class,
                () -> CompradorHelper.crearCompradorApellidoCantCaracteres());
    }
    
    //TELEFONO INVALIDO
    @Test
    public void testConstructorTelefonoVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> CompradorHelper.crearCompradorTelefonoVacio());
    }

    @Test
    public void testConstructorTelefonoCantCaracteres() {
        assertThrows(QuantityCharactersException.class,
                () -> CompradorHelper.crearCompradorTelefonoCantCaracteres());
    }
    
    //DIRECCION INVALIDA
    @Test
    public void testConstructorDireccionNull() {
        assertThrows(IllegalArgumentException.class,
                () -> CompradorHelper.crearCompradorDireccionNull());
    }

    @Test
    public void testConstructorDireccionVacia() {
        assertThrows(IllegalArgumentException.class,
                () -> CompradorHelper.crearCompradorDireccionVacia());
    }

    @Test
    public void testConstructorDireccionCantCaracteres() {
        assertThrows(QuantityCharactersException.class,
                () -> CompradorHelper.crearCompradorDireccionCantCaracteres());
    }

    //CODIGO POSTAL INVALIDO
    @Test
    public void testConstructorCodigoPostalFormatoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> CompradorHelper.crearCompradorCodigoPostalFormatoInvalido());
    }
    
    
}

