package helpers;

import com.mycompany.models.Cargador;

public class CargadorHelper {

	 // DATOS VALIDOS
    public static final String NOMBRE_VALIDO = "Galaxy S23";
    public static final String MARCA_VALIDA = "Samsung";
    public static final String COLOR_VALIDO = "Negro";
    public static final double PRECIO_VALIDO = 999.99;
    public static final int CANTIDAD_VALIDA = 10;
    public static final int WATS_VALIDOS = 10;
     
	
	//DATOS INVALIDOS
	
    private static final String NOMBRE_INVALIDO = null;
	private static final String NOMBRE_TAMANIO_INVALIDO = "N";
	private static final String MARCA_INVALIDA = null;
	private static final String MARCA_TAMANIO_INVALIDO = "M";
	private static final String COLOR_INVALIDO = null;
	private static final String COLOR_TAMANIO_INVALIDO = "C";
	private static final int PRECIO_CANTIDAD_INVALIDO = 0; 
	private static final int WATS_INVALIDOS = 0;
	private static final int WATS_TAMANIO_INVALIDO = 123456;
	
	
	
	
	
	 // CREAR Cargador VÁLIDO
    public static Cargador crearCargadorValido() {
        return new Cargador(
            NOMBRE_VALIDO,MARCA_VALIDA,COLOR_VALIDO,PRECIO_VALIDO,CANTIDAD_VALIDA,WATS_VALIDOS,true
           );
    }
    
    
    //NOMBRE INVALIDO
    public static Cargador crearCargadorNombreVacio() {
        return new Cargador(
            NOMBRE_INVALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            WATS_VALIDOS,true
        );
    }
    
    public static Cargador crearCargadorNombreTamanioInvalido() {
        return new Cargador(
            NOMBRE_TAMANIO_INVALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
            WATS_VALIDOS,true
        );
    }
    
    
    //MARCA INVALIDA
    public static Cargador crearCargadorMarcaVacia() {
        return new Cargador(
        		NOMBRE_VALIDO, MARCA_INVALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
        		WATS_VALIDOS,true
        );
    }
    
    public static Cargador crearCargadorMarcaTamanioInvalido() {
        return new Cargador(
        		NOMBRE_VALIDO, MARCA_TAMANIO_INVALIDO, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
        		WATS_VALIDOS,true
        );
    }
    
    
    //COLOR INVALIDO
    public static Cargador crearCargadorColorVacio() {
        return new Cargador(
        		NOMBRE_VALIDO, MARCA_VALIDA, COLOR_INVALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
        		WATS_VALIDOS,true
        );
    }
    
    public static Cargador crearCargadorColorTamanioInvalido() {
        return new Cargador(
        		NOMBRE_VALIDO, MARCA_VALIDA, COLOR_TAMANIO_INVALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
        		WATS_VALIDOS,true
        );
    }
    //PRECIO INVALIDO
    public static Cargador crearCargadorPrecioInvalido() {
        return new Cargador(
        		NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_CANTIDAD_INVALIDO, CANTIDAD_VALIDA,
        		WATS_VALIDOS,true
        );
    }
    
    
    //CANTIDAD INVALIDA
    public static Cargador crearCargadorCantidadInvalida() {
        return new Cargador(
        		NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, PRECIO_CANTIDAD_INVALIDO,
        		WATS_VALIDOS,true
        );
    }
	
    //WATS INVALIDOS
    public static Cargador crearCargadorWatsInvalidos() {
        return new Cargador(
        		NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
        		WATS_INVALIDOS,true
        );
    }
    
    public static Cargador crearCargadorWatsTamanioInvalido() {
        return new Cargador(
        		NOMBRE_VALIDO, MARCA_VALIDA, COLOR_VALIDO, PRECIO_VALIDO, CANTIDAD_VALIDA,
        		WATS_TAMANIO_INVALIDO,true
        );
    }
	
}
