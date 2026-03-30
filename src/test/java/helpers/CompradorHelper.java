package helpers;

import com.mycompany.models.Comprador;
import com.mycompany.models.Direccion;
import com.mycompany.models.InfoContacto;

public class CompradorHelper {

    // VALIDO
    public static final String EMAIL_VALIDO = "prueba@gmail.com";
    public static final String CONTRASENIA_VALIDA = "Contrasenia_1";
    public static final String NOMBRE_VALIDO = "Homero";
    public static final String APELLIDO_VALIDO = "Simpson";
    public static final int TELEFONO_VALIDO = 1122223333;
    public static final String CALLE_VALIDA = "Avenida siempre viva";
    public static final int ALTURA_VALIDA = 132;
    public static final int PISO_VALIDO = 1;
    public static final String DEPARTAMENTO_VALIDO = "3B";
    public static final String CIUDAD_VALIDA = "Castelar";
    public static final String PROVINCIA_VALIDA = "Buenos Aires";
    public static final String PAIS_VALIDO = "Argentina";
    public static final String CODIGO_POSTAL_VALIDO = "1714";

    // INVALIDO
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
    public static final String CALLE_INVALIDA_CARACTERES = "Av";
    public static final int ALTURA_INVALIDA = 0;
    public static final int ALTURA_INVALIDA_CARACTERES = 1234567891;
    public static final int PISO_INVALIDO_CARACTERES = 9999;
    public static final String DEPARTAMENTO_INVALIDO_CARACTERES = "12345678910";
    public static final String CIUDAD_INVALIDA_CARACTERES = "C";
    public static final String PROVINCIA_INVALIDA_CARACTERES = "P";
    public static final String PAIS_INVALIDO_CARACTERES = "P";
    public static final String CODIGO_POSTAL_INVALIDO_FORMATO = "ABC";

    // MÉTODOS DE DIRECCIÓN
    public static Direccion crearDireccionValida() {
        return new Direccion(CALLE_VALIDA, ALTURA_VALIDA, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, CIUDAD_VALIDA, PROVINCIA_VALIDA,
                PAIS_VALIDO, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionCalleInvalida() {
        return new Direccion(VARIABLE_NULL, ALTURA_VALIDA, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, CIUDAD_VALIDA, PROVINCIA_VALIDA,
                PAIS_VALIDO, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionCalleInvalidaCaracteres() {
        return new Direccion(CALLE_INVALIDA_CARACTERES, ALTURA_VALIDA, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, CIUDAD_VALIDA, PROVINCIA_VALIDA,
                PAIS_VALIDO, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionAlturaInvalida() {
        return new Direccion(CALLE_VALIDA, ALTURA_INVALIDA, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, CIUDAD_VALIDA, PROVINCIA_VALIDA,
                PAIS_VALIDO, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionAlturaInvalidaCaracteres() {
        return new Direccion(CALLE_VALIDA, ALTURA_INVALIDA_CARACTERES, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, CIUDAD_VALIDA, PROVINCIA_VALIDA,
                PAIS_VALIDO, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionPisoInvalidoCaracteres() {
        return new Direccion(CALLE_VALIDA, ALTURA_VALIDA, PISO_INVALIDO_CARACTERES,
                DEPARTAMENTO_VALIDO, CIUDAD_VALIDA, PROVINCIA_VALIDA,
                PAIS_VALIDO, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionDepartamentoInvalidoCaracteres() {
        return new Direccion(CALLE_VALIDA, ALTURA_VALIDA, PISO_VALIDO,
                DEPARTAMENTO_INVALIDO_CARACTERES, CIUDAD_VALIDA, PROVINCIA_VALIDA,
                PAIS_VALIDO, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionCiudadInvalida() {
        return new Direccion(CALLE_VALIDA, ALTURA_VALIDA, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, VARIABLE_NULL, PROVINCIA_VALIDA,
                PAIS_VALIDO, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionCiudadInvalidaCaracteres() {
        return new Direccion(CALLE_VALIDA, ALTURA_VALIDA, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, CIUDAD_INVALIDA_CARACTERES, PROVINCIA_VALIDA,
                PAIS_VALIDO, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionProvinciaInvalida() {
        return new Direccion(CALLE_VALIDA, ALTURA_VALIDA, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, CIUDAD_VALIDA, VARIABLE_NULL,
                PAIS_VALIDO, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionProvinciaInvalidaCaracteres() {
        return new Direccion(CALLE_VALIDA, ALTURA_VALIDA, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, CIUDAD_VALIDA, PROVINCIA_INVALIDA_CARACTERES,
                PAIS_VALIDO, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionPaisInvalido() {
        return new Direccion(CALLE_VALIDA, ALTURA_VALIDA, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, CIUDAD_VALIDA, PROVINCIA_VALIDA,
                VARIABLE_NULL, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionPaisInvalidoCaracteres() {
        return new Direccion(CALLE_VALIDA, ALTURA_VALIDA, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, CIUDAD_VALIDA, PROVINCIA_VALIDA,
                PAIS_INVALIDO_CARACTERES, CODIGO_POSTAL_VALIDO);
    }

    public static Direccion crearDireccionCodigoPostalInvalido() {
        return new Direccion(CALLE_VALIDA, ALTURA_VALIDA, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, CIUDAD_VALIDA, PROVINCIA_VALIDA,
                PAIS_VALIDO, VARIABLE_NULL);
    }

    public static Direccion crearDireccionCodigoPostalInvalidoFormato() {
        return new Direccion(CALLE_VALIDA, ALTURA_VALIDA, PISO_VALIDO,
                DEPARTAMENTO_VALIDO, CIUDAD_VALIDA, PROVINCIA_VALIDA,
                PAIS_VALIDO, CODIGO_POSTAL_INVALIDO_FORMATO);
    }

    // MÉTODOS DE INFO CONTACTO
    public static InfoContacto crearInfoContactoValida() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionValida());
    }

    public static InfoContacto crearInfoContactoTelefonoInvalido() {
        return new InfoContacto(TELEFONO_INVALIDO_VACIO, crearDireccionValida());
    }

    public static InfoContacto crearInfoContactoTelefonoCaracteresInvalido() {
        return new InfoContacto(TELEFONO_INVALIDO_CARACTERES, crearDireccionValida());
    }

    public static InfoContacto crearInfoContactoDireccionCalleInvalida() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionCalleInvalida());
    }

    public static InfoContacto crearInfoContactoDireccionCalleInvalidaCaracteres() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionCalleInvalidaCaracteres());
    }

    public static InfoContacto crearInfoContactoDireccionAlturaInvalida() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionAlturaInvalida());
    }

    public static InfoContacto crearInfoContactoDireccionAlturaInvalidaCaracteres() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionAlturaInvalidaCaracteres());
    }

    public static InfoContacto crearInfoContactoDireccionPisoInvalidoCaracteres() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionPisoInvalidoCaracteres());
    }

    public static InfoContacto crearInfoContactoDireccionDepartamentoInvalidoCaracteres() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionDepartamentoInvalidoCaracteres());
    }

    public static InfoContacto crearInfoContactoDireccionCiudadInvalida() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionCiudadInvalida());
    }

    public static InfoContacto crearInfoContactoDireccionCiudadInvalidaCaracteres() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionCiudadInvalidaCaracteres());
    }

    public static InfoContacto crearInfoContactoDireccionProvinciaInvalida() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionProvinciaInvalida());
    }

    public static InfoContacto crearInfoContactoDireccionProvinciaInvalidaCaracteres() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionProvinciaInvalidaCaracteres());
    }

    public static InfoContacto crearInfoContactoDireccionPaisInvalido() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionPaisInvalido());
    }

    public static InfoContacto crearInfoContactoDireccionPaisInvalidoCaracteres() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionPaisInvalidoCaracteres());
    }

    public static InfoContacto crearInfoContactoDireccionCodigoPostalInvalido() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionCodigoPostalInvalido());
    }

    public static InfoContacto crearInfoContactoDireccionCodigoPostalInvalidoFormato() {
        return new InfoContacto(TELEFONO_VALIDO, crearDireccionCodigoPostalInvalidoFormato());
    }

    // MÉTODOS DE COMPRADOR
    public static Comprador crearCompradorValido() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoValida());
    }

    public static Comprador crearCompradorEmailVacio() {
        return new Comprador(VARIABLE_VACIA, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoValida());
    }

    public static Comprador crearCompradorEmailNull() {
        return new Comprador(VARIABLE_NULL, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoValida());
    }

    public static Comprador crearCompradorEmailFormatoInvalido() {
        return new Comprador(EMAIL_INVALIDO_FORMATO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoValida());
    }

    public static Comprador crearCompradorEmailCantCaracteres() {
        return new Comprador(EMAIL_CANT_CARACTERES, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoValida());
    }

    // CONTRASEÑA INVALIDA
    public static Comprador crearCompradorContraseniaNull() {
        return new Comprador(EMAIL_VALIDO, VARIABLE_NULL, NOMBRE_VALIDO, APELLIDO_VALIDO,
                crearInfoContactoValida());
    }

    public static Comprador crearCompradorContraseniaVacia() {
        return new Comprador(EMAIL_VALIDO, VARIABLE_VACIA, NOMBRE_VALIDO, APELLIDO_VALIDO,
                crearInfoContactoValida());
    }

    public static Comprador crearCompradorContraseniaCantCaracteres() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_CANT_CARACTERES, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoValida());
    }

    public static Comprador crearCompradorContraseniaSinMayuscula() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_SIN_MAYUSCULA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoValida());
    }

    public static Comprador crearCompradorContraseniaSinNumero() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_SIN_NUMERO, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoValida());
    }

    public static Comprador crearCompradorContraseniaSinEspecial() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_SIN_ESPECIAL, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoValida());
    }

    // NOMBRE INVALIDO
    public static Comprador crearCompradorNombreNull() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, VARIABLE_NULL,
                APELLIDO_VALIDO, crearInfoContactoValida());
    }

    public static Comprador crearCompradorNombreVacio() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, VARIABLE_VACIA,
                APELLIDO_VALIDO, crearInfoContactoValida());
    }

    public static Comprador crearCompradorNombreCantCaracteres() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_CANT_CARACTERES,
                APELLIDO_VALIDO, crearInfoContactoValida());
    }

    // APELLIDO INVALIDO
    public static Comprador crearCompradorApellidoNull() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                VARIABLE_NULL, crearInfoContactoValida());
    }

    public static Comprador crearCompradorApellidoVacio() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                VARIABLE_VACIA, crearInfoContactoValida());
    }

    public static Comprador crearCompradorApellidoCantCaracteres() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_CANT_CARACTERES, crearInfoContactoValida());
    }

    // TELEFONO INVALIDO
    public static Comprador crearCompradorTelefonoVacio() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoTelefonoInvalido());
    }

    public static Comprador crearCompradorTelefonoCantCaracteres() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoTelefonoCaracteresInvalido());
    }

    // DIRECCIÓN INVALIDA (calle, altura, piso, depto, ciudad, provincia, pais, cp)
    public static Comprador crearCompradorDireccionCalleInvalida() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionCalleInvalida());
    }

    public static Comprador crearCompradorDireccionCalleInvalidaCaracteres() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionCalleInvalidaCaracteres());
    }

    public static Comprador crearCompradorDireccionAlturaInvalida() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionAlturaInvalida());
    }

    public static Comprador crearCompradorDireccionAlturaInvalidaCaracteres() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionAlturaInvalidaCaracteres());
    }

    public static Comprador crearCompradorDireccionPisoInvalidoCaracteres() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionPisoInvalidoCaracteres());
    }

    public static Comprador crearCompradorDireccionDepartamentoInvalidoCaracteres() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionDepartamentoInvalidoCaracteres());
    }

    public static Comprador crearCompradorDireccionCiudadInvalida() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionCiudadInvalida());
    }

    public static Comprador crearCompradorDireccionCiudadInvalidaCaracteres() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionCiudadInvalidaCaracteres());
    }

    public static Comprador crearCompradorDireccionProvinciaInvalida() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionProvinciaInvalida());
    }

    public static Comprador crearCompradorDireccionProvinciaInvalidaCaracteres() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionProvinciaInvalidaCaracteres());
    }

    public static Comprador crearCompradorDireccionPaisInvalido() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionPaisInvalido());
    }

    public static Comprador crearCompradorDireccionPaisInvalidoCaracteres() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionPaisInvalidoCaracteres());
    }

    public static Comprador crearCompradorDireccionCodigoPostalInvalido() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionCodigoPostalInvalido());
    }

    public static Comprador crearCompradorDireccionCodigoPostalInvalidoFormato() {
        return new Comprador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO, crearInfoContactoDireccionCodigoPostalInvalidoFormato());
    }
}