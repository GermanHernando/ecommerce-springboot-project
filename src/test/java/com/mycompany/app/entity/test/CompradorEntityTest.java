package com.mycompany.app.entity.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.mycompany.exceptions.QuantityCharactersException;
import com.mycompany.exceptions.UserEmailException;
import com.mycompany.exceptions.UserPasswordException;
import com.mycompany.models.Comprador;

import helpers.CompradorHelper;

@SpringBootTest
@ActiveProfiles("test")
public class CompradorEntityTest {

	@Test
	public void testTieneEmailValido() {
		Comprador c = assertDoesNotThrow(() -> CompradorHelper.crearCompradorValido());
		assertTrue(c.tieneEmail());
	}

	// EMAIL INVALIDO
	@Test
	public void testConstructorEmailNull() {
		assertThrows(UserEmailException.class, () -> {
			CompradorHelper.crearCompradorEmailNull();
		});
	}

	@Test
	public void testConstructorEmailVacio() {
		assertThrows(UserEmailException.class, () -> {
			CompradorHelper.crearCompradorEmailVacio();
		});
	}

	@Test
	public void testConstructorEmailFormatoInvalido() {
		assertThrows(UserEmailException.class, () -> {
			CompradorHelper.crearCompradorEmailFormatoInvalido();
		});
	}

	@Test
	public void testConstructorEmailCantCaracteres() {
		assertThrows(QuantityCharactersException.class, () -> {
			CompradorHelper.crearCompradorEmailCantCaracteres();
		});
	}

	// CONTRASENIA INVALIDA
	@Test
	public void testConstructorContraseniaNull() {
		assertThrows(UserPasswordException.class, () -> CompradorHelper.crearCompradorContraseniaNull());
	}

	@Test
	public void testConstructorContraseniaVacia() {
		assertThrows(UserPasswordException.class, () -> CompradorHelper.crearCompradorContraseniaVacia());
	}

	@Test
	public void testConstructorContraseniaCantCaracteres() {
		assertThrows(QuantityCharactersException.class,
				() -> CompradorHelper.crearCompradorContraseniaCantCaracteres());
	}

	@Test
	public void testConstructorContraseniaSinMayuscula() {
		assertThrows(UserPasswordException.class, () -> CompradorHelper.crearCompradorContraseniaSinMayuscula());
	}

	@Test
	public void testConstructorContraseniaSinNumero() {
		assertThrows(UserPasswordException.class, () -> CompradorHelper.crearCompradorContraseniaSinNumero());
	}

	@Test
	public void testConstructorContraseniaSinEspecial() {
		assertThrows(UserPasswordException.class, () -> CompradorHelper.crearCompradorContraseniaSinEspecial());
	}

	// NOMBRE INVALIDO
	@Test
	public void testConstructorNombreNull() {
		assertThrows(IllegalArgumentException.class, () -> CompradorHelper.crearCompradorNombreNull());
	}

	@Test
	public void testConstructorNombreVacio() {
		assertThrows(IllegalArgumentException.class, () -> CompradorHelper.crearCompradorNombreVacio());
	}

	@Test
	public void testConstructorNombreCantCaracteres() {
		assertThrows(QuantityCharactersException.class, () -> CompradorHelper.crearCompradorNombreCantCaracteres());
	}

	// APELLIDO INVALIDO
	@Test
	public void testConstructorApellidoNull() {
		assertThrows(IllegalArgumentException.class, () -> CompradorHelper.crearCompradorApellidoNull());
	}

	@Test
	public void testConstructorApellidoVacio() {
		assertThrows(IllegalArgumentException.class, () -> CompradorHelper.crearCompradorApellidoVacio());
	}

	@Test
	public void testConstructorApellidoCantCaracteres() {
		assertThrows(QuantityCharactersException.class, () -> CompradorHelper.crearCompradorApellidoCantCaracteres());
	}

	// TELEFONO INVALIDO
	@Test
	public void testConstructorTelefonoVacio() {
		assertThrows(IllegalArgumentException.class, () -> CompradorHelper.crearCompradorTelefonoVacio());
	}

	@Test
	public void testConstructorTelefonoCantCaracteres() {
		assertThrows(QuantityCharactersException.class, () -> CompradorHelper.crearCompradorTelefonoCantCaracteres());
	}

	// CALLE INVALIDA

	@Test
	public void testConstructorDireccionCalleNull() {
		assertThrows(IllegalArgumentException.class, () -> CompradorHelper.crearCompradorDireccionCalleInvalida());
	}

	@Test
	public void testConstructorDireccionCalleCaracteresInvalidos() {
		assertThrows(QuantityCharactersException.class,
				() -> CompradorHelper.crearCompradorDireccionCalleInvalidaCaracteres());
	}

	// ALTURA INVALIDA
	@Test
	public void testConstructorDireccionAlturaInvalida() {
		assertThrows(IllegalArgumentException.class, () -> CompradorHelper.crearCompradorDireccionAlturaInvalida());
	}

	@Test
	public void testConstructorDireccionAlturaCaracteresInvalidos() {
		assertThrows(QuantityCharactersException.class,
				() -> CompradorHelper.crearCompradorDireccionAlturaInvalidaCaracteres());
	}

	// PISO INVALIDO
	@Test
	public void testConstructorDireccionPisoCaracteresInvalidos() {
		assertThrows(QuantityCharactersException.class,
				() -> CompradorHelper.crearCompradorDireccionPisoInvalidoCaracteres());
	}

	// DEPARTAMENTO INVALIDO
	@Test
	public void testConstructorDireccionDepartamentoCaracteresInvalidos() {
		assertThrows(QuantityCharactersException.class,
				() -> CompradorHelper.crearCompradorDireccionDepartamentoInvalidoCaracteres());
	}

	// CIUDAD INVALIDA
	@Test
	public void testConstructorDireccionCiudadNull() {
		assertThrows(IllegalArgumentException.class, () -> CompradorHelper.crearCompradorDireccionCiudadInvalida());
	}

	@Test
	public void testConstructorDireccionCiudadCaracteresInvalidos() {
		assertThrows(QuantityCharactersException.class,
				() -> CompradorHelper.crearCompradorDireccionCiudadInvalidaCaracteres());
	}

	// PROVINCIA INVALIDA
	@Test
	public void testConstructorDireccionProvinciaNull() {
		assertThrows(IllegalArgumentException.class, () -> CompradorHelper.crearCompradorDireccionProvinciaInvalida());
	}

	@Test
	public void testConstructorDireccionProvinciaCaracteresInvalidos() {
		assertThrows(QuantityCharactersException.class,
				() -> CompradorHelper.crearCompradorDireccionProvinciaInvalidaCaracteres());
	}

	// PAIS INVALIDO
	@Test
	public void testConstructorDireccionPaisNull() {
		assertThrows(IllegalArgumentException.class, () -> CompradorHelper.crearCompradorDireccionPaisInvalido());
	}

	@Test
	public void testConstructorDireccionPaisCaracteresInvalidos() {
		assertThrows(QuantityCharactersException.class,
				() -> CompradorHelper.crearCompradorDireccionPaisInvalidoCaracteres());
	}

	// CODIGO POSTAL INVALIDO
	@Test
	public void testConstructorDireccionCodigoPostalNull() {
		assertThrows(IllegalArgumentException.class,
				() -> CompradorHelper.crearCompradorDireccionCodigoPostalInvalido());
	}

	@Test
	public void testConstructorDireccionCodigoPostalFormatoInvalido() {
		assertThrows(IllegalArgumentException.class,
				() -> CompradorHelper.crearCompradorDireccionCodigoPostalInvalidoFormato());
	}

}
