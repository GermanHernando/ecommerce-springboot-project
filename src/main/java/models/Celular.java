package models;

import exceptions.QuantityCharactersException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CELULARES")
public class Celular extends Producto {


	private static final String MSG_ERROR_TAMANIO = "El tamanio no puede ser 0(cero)";
	private static final int MIN_CANT_CARACTERES_TAMANIO = 9;
	private static final int MAX_CANT_CARACTERES_TAMANIO = 15;
	private static final String MSG_ERROR_RAM = "La ram no puede ser 0(cero)";
	private static final int MIN_CANT_CARACTERES_RAM_ALMACENAMIENTO = 1;
	private static final int MAX_CANT_CARACTERES_RAM_ALMACENAMIENTO = 4;
	private static final String MSG_ERROR_ALMACENAMIENTO = "El almacenamiento no puede ser 0(cero)";
	private static final String MSJ_ERROR_RESOLUCION_PANTALLA_VACIA = "La resolucion de pantalla no puede ser nula o estar vacia";
	private static final int MIN_CHARACTER_RESOLUCION_PANTALLA_CAMARA = 8;
	private static final int MAX_CHARACTER_RESOLUCION_PANTALLA_CAMARA = 20;

	@Column(name = "TAMANIO")
	private int tamanio;
	@Column(name = "RESOLUCION_PANTALLA")
	private String resolucionPantalla;
	@Column(name = "RESOLUCION_CAMARA")
	private String resolucionCamara;
	@Column(name = "RAM")
	private int ram;
	@Column(name = "ALMACENAMIENTO")
	private int almacenamiento;
	
	Celular(){}
	
	public Celular(String nombre, String marca, String color, double precio, int cantidad, int tamanio,
			String resolucionPantalla, String resolucionCamara, int ram, int almacenamiento) throws QuantityCharactersException{
		super(nombre, marca, color, precio, cantidad);
		this.setTamanio(tamanio);
		this.setResolucionPantalla(resolucionPantalla);
		this.setResolucionCamara(resolucionCamara);
		this.setRam(ram);
		this.setAlmacenamiento(almacenamiento);
	}


	public void setTamanio(int tamanio) {
		int cantCaracteres = 0;
		if (tamanio == 0) {
			throw new IllegalArgumentException(MSG_ERROR_TAMANIO);
		}
		cantCaracteres = String.valueOf(tamanio).length();
		if (cantCaracteres<MIN_CANT_CARACTERES_TAMANIO || cantCaracteres>MAX_CANT_CARACTERES_TAMANIO ) {
			throw new QuantityCharactersException(MIN_CANT_CARACTERES_TAMANIO, MAX_CANT_CARACTERES_TAMANIO);
		}
		this.tamanio = tamanio;
	}


	public void setResolucionPantalla(String resolucionPantalla) {
		if (resolucionPantalla == null || resolucionPantalla.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_RESOLUCION_PANTALLA_VACIA);
		}
		if (resolucionPantalla.length() < MIN_CHARACTER_RESOLUCION_PANTALLA_CAMARA || resolucionPantalla.length() > MAX_CHARACTER_RESOLUCION_PANTALLA_CAMARA) {
			throw new QuantityCharactersException(MIN_CHARACTER_RESOLUCION_PANTALLA_CAMARA,MAX_CHARACTER_RESOLUCION_PANTALLA_CAMARA);
		}
		this.resolucionPantalla = resolucionPantalla;
	}


	public void setResolucionCamara(String resolucionCamara) {
		if (resolucionCamara == null || resolucionCamara.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_RESOLUCION_PANTALLA_VACIA);
		}
		if (resolucionCamara.length() < MIN_CHARACTER_RESOLUCION_PANTALLA_CAMARA || resolucionCamara.length() > MAX_CHARACTER_RESOLUCION_PANTALLA_CAMARA) {
			throw new QuantityCharactersException(MIN_CHARACTER_RESOLUCION_PANTALLA_CAMARA,MAX_CHARACTER_RESOLUCION_PANTALLA_CAMARA);
		}
		this.resolucionCamara = resolucionCamara;
	}


	public void setRam(int ram) {
		int cantCaracteres = 0;
		if  (ram == 0) {
			throw new IllegalArgumentException(MSG_ERROR_RAM);
		}
		cantCaracteres = String.valueOf(ram).length();
		if (cantCaracteres<MIN_CANT_CARACTERES_RAM_ALMACENAMIENTO || cantCaracteres>MAX_CANT_CARACTERES_RAM_ALMACENAMIENTO) {
			throw new QuantityCharactersException(MIN_CANT_CARACTERES_RAM_ALMACENAMIENTO, MAX_CANT_CARACTERES_RAM_ALMACENAMIENTO);
		}
		this.ram = ram;
	}


	public void setAlmacenamiento(int almacenamiento) {
		int cantCaracteres = 0;
		if  (almacenamiento == 0) {
			throw new IllegalArgumentException(MSG_ERROR_ALMACENAMIENTO);
		}
		cantCaracteres = String.valueOf(almacenamiento).length();
		if (cantCaracteres<MIN_CANT_CARACTERES_RAM_ALMACENAMIENTO || cantCaracteres>MAX_CANT_CARACTERES_RAM_ALMACENAMIENTO) {
			throw new QuantityCharactersException(MIN_CANT_CARACTERES_RAM_ALMACENAMIENTO, MAX_CANT_CARACTERES_RAM_ALMACENAMIENTO);
		}
		this.almacenamiento = almacenamiento;
	}
	
	
	
	
	
}
