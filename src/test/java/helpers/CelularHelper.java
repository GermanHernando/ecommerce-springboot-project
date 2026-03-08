package helpers;

import com.mycompany.models.Celular;

public class CelularHelper {

    // DATOS VÁLIDOS
    public static final String NOMBRE_VALIDO = "Galaxy S23";
    public static final String MARCA_VALIDA = "Samsung";
    public static final String COLOR_VALIDO = "Negro";
    public static final double PRECIO_VALIDO = 999.99;
    public static final int CANTIDAD_VALIDA = 10;
    public static final int TAMANIO_VALIDO = 123456789; 
    public static final String RESOLUCION_PANTALLA_VALIDA = "1080x2400";
    public static final String RESOLUCION_CAMARA_VALIDA = "108MP Ultra"; 
    public static final int RAM_VALIDA = 8; 
    public static final int ALMACENAMIENTO_VALIDO = 256;

    // DATOS INVÁLIDOS
    public static final int TAMANIO_CARACTERES_INVALIDO_CERO = 0;
    public static final int TAMANIO_CARACTERES_INVALIDO = 123; 
    public static final String RESOLUCION_PANTALLA_VACIA = "";
    public static final String RESOLUCION_PANTALLA_TAMANIO_CARACTERES_INVALIDO= "1234567";
    public static final String RESOLUCION_CAMARA_VACIA = "";
    public static final String RESOLUCION_CAMARA_CARACTERES_INVALIDO = "1234567";
    public static final int RAM_INVALIDA_CERO = 0;
    public static final int RAM_CARACTERES_INVALIDA= 12345; 
    public static final int ALMACENAMIENTO_INVALIDO_CERO = 0;
    public static final int ALMACENAMIENTO_CARACTERES_INVALIDO = 12345;
	private static final String NOMBRE_INVALIDO = null;
	private static final String NOMBRE_TAMANIO_INVALIDO = "N";
	private static final String MARCA_INVALIDA = null;
	private static final String MARCA_TAMANIO_INVALIDO = "M";
	private static final String COLOR_INVALIDO = null;
	private static final String COLOR_TAMANIO_INVALIDO = "C";
	private static final int PRECIO_CANTIDAD_INVALIDO = 0; 

    // CREAR CELULAR VÁLIDO
    public static Celular crearCelularValido() {
        return new Celular(
            NOMBRE_VALIDO,MARCA_VALIDA,COLOR_VALIDO,PRECIO_VALIDO,CANTIDAD_VALIDA,TAMANIO_VALIDO,RESOLUCION_PANTALLA_VALIDA,
            RESOLUCION_CAMARA_VALIDA,RAM_VALIDA,ALMACENAMIENTO_VALIDO);
    }
    //NOMBRE INVALIDO
    public static Celular crearCelularNombreVacio() {
        return new Celular(
            NOMBRE_INVALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_VALIDO
        );
    }
    
    public static Celular crearCelularNombreTamanioInvalido() {
        return new Celular(
            NOMBRE_TAMANIO_INVALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_VALIDO
        );
    }
    
    
    //MARCA INVALIDA
    public static Celular crearCelularMarcaVacia() {
        return new Celular(
        		NOMBRE_VALIDO, MARCA_INVALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_VALIDO
        );
    }
    
    public static Celular crearCelularMarcaTamanioInvalido() {
        return new Celular(
        		NOMBRE_VALIDO, MARCA_TAMANIO_INVALIDO, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_VALIDO
        );
    }
    
    
    //COLOR INVALIDO
    public static Celular crearCelularColorVacio() {
        return new Celular(
        		NOMBRE_VALIDO, MARCA_VALIDA, COLOR_INVALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_VALIDO
        );
    }
    
    public static Celular crearCelularColorTamanioInvalido() {
        return new Celular(
        		NOMBRE_VALIDO, MARCA_VALIDA, COLOR_TAMANIO_INVALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_VALIDO
        );
    }
    //PRECIO INVALIDO
    public static Celular crearCelularPrecioInvalido() {
        return new Celular(
        		NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_CANTIDAD_INVALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_VALIDO
        );
    }
    
    
    //CANTIDAD INVALIDA
    public static Celular crearCelularCantidadInvalida() {
        return new Celular(
        		NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, PRECIO_CANTIDAD_INVALIDO,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_VALIDO
        );
    }

    // TAMANIO INVALIDO
    public static Celular crearCelularTamanioCero() {
        return new Celular(
            NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_CARACTERES_INVALIDO_CERO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_VALIDO
        );
    }

    public static Celular crearCelularTamanioInvalido() {
        return new Celular(
            NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_CARACTERES_INVALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_VALIDO
        );
    }

 
 //RESOLUCION PANTALLA INVALIDA
    public static Celular crearCelularResolucionPantallaVacia() {
        return new Celular(
            NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VACIA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_VALIDO
        );
    }

    public static Celular crearCelularResolucionPantallaTamanioInvalido() {
        return new Celular(
            NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_TAMANIO_CARACTERES_INVALIDO, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_VALIDO
        );
    }

    //RESOLUCION CAMARA INVALIDA
    public static Celular crearCelularResolucionCamaraVacia() {
		return new Celular(
	            NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
	            TAMANIO_VALIDO,
	            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VACIA,
	            RAM_VALIDA, ALMACENAMIENTO_VALIDO);
    }
    
	public static Celular crearCelularResolucionCamaraTamanioInvalido() {
		return new Celular(
	            NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
	            TAMANIO_VALIDO,
	            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_CARACTERES_INVALIDO,
	            RAM_VALIDA, ALMACENAMIENTO_VALIDO
	        );
	}

    
    //RAM INVALIDA
    public static Celular crearCelularRamCero() {
        return new Celular(
            NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_INVALIDA_CERO, ALMACENAMIENTO_VALIDO
        );
    }

  
    public static Celular crearCelularRamTamanioInvalido() {
        return new Celular(
            NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_CARACTERES_INVALIDA, ALMACENAMIENTO_VALIDO
        );
    }

    //ALMACENAMIENTO INVÁLIDO
    public static Celular crearCelularAlmacenamientoCero() {
        return new Celular(
            NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_INVALIDO_CERO
        );
    }

    public static Celular crearCelularAlmacenamientoTamanioInvalido() {
        return new Celular(
            NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            TAMANIO_VALIDO,
            RESOLUCION_PANTALLA_VALIDA, RESOLUCION_CAMARA_VALIDA,
            RAM_VALIDA, ALMACENAMIENTO_CARACTERES_INVALIDO
        );
    }

	
}