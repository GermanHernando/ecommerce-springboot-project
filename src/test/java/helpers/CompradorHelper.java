package helpers;

import models.Comprador;

public class CompradorHelper {

	//VALIDO
	public static final String EMAIL_VALIDO = "prueba@gmail.com";
	public static final String CONTRASENIA_VALIDA = "Contrasenia_1";
	public static final String NOMBRE_VALIDO = "Homero";
	public static final String APELLIDO_VALIDO = "Simpson";
	public static final int TELEFONO_VALIDO = 1122223333;
	public static final String DIRECCION_VALIDA = "Avenida siempre viva";
	public static final String CODIGO_POSTAL_VALIDO = "1714";
	//INVALIDO
	public static final String VARIABLE_VACIA = "";
	public static final String VARIABLE_NULL = null;
	public static final String EMAIL_INVALIDO_FORMATO = "email-invalido";
	public static final String EMAIL_CANT_CARACTERES = "emailconmayorcantidaddecaracteresrecomendadosparaelprogramaestablecido@gmail.com";
	public static final String CONTRASENIA_CANT_CARACTERES = "Contrasenia_1ContraseniaContrasenia";
	public static final String CONTRASENIA_SIN_MAYUSCULA = "contrasenia_1";
	public static final String CONTRASENIA_SIN_NUMERO = "Contrasenia";
	public static final String CONTRASENIA_SIN_ESPECIAL = "Password123";	
	public static final String NOMBRE_CANT_CARACTERES = "H";
	public static final String APELLIDO_CANT_CARACTERES = "S";
	public static final int TELEFONO_INVALIDO_VACIO = 0;
	public static final int TELEFONO_INVALIDO_CARACTERES = 123;
	public static final String DIRECCION_INVALIDA_CARACTERES= "Av";
	public static final String CODIGO_POSTAL_INVALIDO_FORMATO = "ABC";
	
	
	//VALIDO
	public static final Comprador crearCompradorValido() {
		return new Comprador(EMAIL_VALIDO,CONTRASENIA_VALIDA,NOMBRE_VALIDO,
				APELLIDO_VALIDO,TELEFONO_VALIDO,DIRECCION_VALIDA,CODIGO_POSTAL_VALIDO);
	}
	
	//EMAIL INVALIDO
	public static Comprador crearCompradorEmailVacio() {
	    return new Comprador(VARIABLE_VACIA, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}

	
	public static Comprador crearCompradorEmailNull() {
	    return new Comprador(VARIABLE_NULL, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}

	public static Comprador crearCompradorEmailFormatoInvalido() {
	    return new Comprador(EMAIL_INVALIDO_FORMATO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}

	public static Comprador crearCompradorEmailCantCaracteres() {
	    return new Comprador(EMAIL_CANT_CARACTERES, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}
	
	//CONTRASENIA INVALIDA
	public static Comprador crearCompradorContraseniaNull() {
	    return new Comprador(EMAIL_VALIDO, VARIABLE_NULL, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}
	public static Comprador crearCompradorContraseniaVacia() {
	    return new Comprador(EMAIL_VALIDO, VARIABLE_VACIA, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}
	public static Comprador crearCompradorContraseniaCantCaracteres() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_CANT_CARACTERES, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}

	public static Comprador crearCompradorContraseniaSinMayuscula() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_SIN_MAYUSCULA, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}

	public static Comprador crearCompradorContraseniaSinNumero() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_SIN_NUMERO, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}

	public static Comprador crearCompradorContraseniaSinEspecial() {
	    return new Comprador(EMAIL_VALIDO,CONTRASENIA_SIN_ESPECIAL, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}
	
	//NOMBRE INVALIDO
	public static Comprador crearCompradorNombreNull() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, VARIABLE_NULL,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}
	public static Comprador crearCompradorNombreVacio() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, VARIABLE_VACIA,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}
	public static Comprador crearCompradorNombreCantCaracteres() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_CANT_CARACTERES,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}

	//APELLIDO INVALIDO
	public static Comprador crearCompradorApellidoNull() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            VARIABLE_NULL, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}
	
	public static Comprador crearCompradorApellidoVacio() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            VARIABLE_VACIA, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}
	
	public static Comprador crearCompradorApellidoCantCaracteres() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            APELLIDO_CANT_CARACTERES, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}
	
	//TELEFONO INVALIDO
	public static Comprador crearCompradorTelefonoVacio() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_INVALIDO_VACIO, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}

	public static Comprador crearCompradorTelefonoCantCaracteres() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_INVALIDO_CARACTERES, DIRECCION_VALIDA, CODIGO_POSTAL_VALIDO);
	}
	
	//DIRECCION INVALIDA
	public static Comprador crearCompradorDireccionNull() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, VARIABLE_NULL, CODIGO_POSTAL_VALIDO);
	}
	public static Comprador crearCompradorDireccionVacia() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, VARIABLE_VACIA, CODIGO_POSTAL_VALIDO);
	}
	
	public static Comprador crearCompradorDireccionCantCaracteres() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_INVALIDA_CARACTERES, CODIGO_POSTAL_VALIDO);
	}
	
	//CODIGO POSTAL INVALIDO
	public static Comprador crearCompradorCodigoPostalFormatoInvalido() {
	    return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
	            APELLIDO_VALIDO, TELEFONO_VALIDO, DIRECCION_VALIDA, CODIGO_POSTAL_INVALIDO_FORMATO);
	}
	
	
}
