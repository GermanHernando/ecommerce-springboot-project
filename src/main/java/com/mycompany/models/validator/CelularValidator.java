package com.mycompany.models.validator;

import exceptions.QuantityCharactersException;

public class CelularValidator {
	private static final String MSG_ERROR_TAMANIO = "El tamanio no puede ser 0(cero)";
	private static final int MIN_CANT_CARACTERES_TAMANIO = 4;
	private static final int MAX_CANT_CARACTERES_TAMANIO = 7;
	private static final String MSG_ERROR_RAM = "La ram no puede ser 0(cero)";
	private static final int MIN_CANT_CARACTERES_RAM_ALMACENAMIENTO = 1;
	private static final int MAX_CANT_CARACTERES_RAM_ALMACENAMIENTO = 4;
	private static final String MSG_ERROR_ALMACENAMIENTO = "El almacenamiento no puede ser 0(cero)";
	private static final String MSJ_ERROR_RESOLUCION_PANTALLA_VACIA = "La resolucion de pantalla no puede ser nula o estar vacia";
	private static final int MIN_CHARACTER_RESOLUCION_PANTALLA_CAMARA = 8;
	private static final int MAX_CHARACTER_RESOLUCION_PANTALLA_CAMARA = 20;
	

	public static Integer tamanioValidator(Integer tamanio) {
		Integer cantCaracteres = 0;
		if (tamanio <= 0) {
			throw new IllegalArgumentException(MSG_ERROR_TAMANIO);
		}
		cantCaracteres = String.valueOf(tamanio).length();
		if (cantCaracteres < MIN_CANT_CARACTERES_TAMANIO || cantCaracteres > MAX_CANT_CARACTERES_TAMANIO) {
			throw new QuantityCharactersException(MIN_CANT_CARACTERES_TAMANIO, MAX_CANT_CARACTERES_TAMANIO);
		}
		return tamanio;
	}

	public static String resolucionPantallaValidator(String resolucionPantalla) {
		if (resolucionPantalla == null || resolucionPantalla.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_RESOLUCION_PANTALLA_VACIA);
		}
		if (resolucionPantalla.length() < MIN_CHARACTER_RESOLUCION_PANTALLA_CAMARA
				|| resolucionPantalla.length() > MAX_CHARACTER_RESOLUCION_PANTALLA_CAMARA) {
			throw new QuantityCharactersException(MIN_CHARACTER_RESOLUCION_PANTALLA_CAMARA,
					MAX_CHARACTER_RESOLUCION_PANTALLA_CAMARA);
		}
		return resolucionPantalla;
	}

	public static String resolucionCamaraValidator(String resolucionCamara) {
		if (resolucionCamara == null || resolucionCamara.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_RESOLUCION_PANTALLA_VACIA);
		}
		if (resolucionCamara.length() < MIN_CHARACTER_RESOLUCION_PANTALLA_CAMARA
				|| resolucionCamara.length() > MAX_CHARACTER_RESOLUCION_PANTALLA_CAMARA) {
			throw new QuantityCharactersException(MIN_CHARACTER_RESOLUCION_PANTALLA_CAMARA,
					MAX_CHARACTER_RESOLUCION_PANTALLA_CAMARA);
		}
		return resolucionCamara;
	}

	public static Integer ramValidator(Integer ram) {
		Integer cantCaracteres = 0;
		if (ram == 0) {
			throw new IllegalArgumentException(MSG_ERROR_RAM);
		}
		cantCaracteres = String.valueOf(ram).length();
		if (cantCaracteres < MIN_CANT_CARACTERES_RAM_ALMACENAMIENTO
				|| cantCaracteres > MAX_CANT_CARACTERES_RAM_ALMACENAMIENTO) {
			throw new QuantityCharactersException(MIN_CANT_CARACTERES_RAM_ALMACENAMIENTO,
					MAX_CANT_CARACTERES_RAM_ALMACENAMIENTO);
		}
		return ram;
	}

	public static Integer almacenamientoValidator(Integer almacenamiento) {
		Integer cantCaracteres = 0;
		if (almacenamiento == 0) {
			throw new IllegalArgumentException(MSG_ERROR_ALMACENAMIENTO);
		}
		cantCaracteres = String.valueOf(almacenamiento).length();
		if (cantCaracteres < MIN_CANT_CARACTERES_RAM_ALMACENAMIENTO
				|| cantCaracteres > MAX_CANT_CARACTERES_RAM_ALMACENAMIENTO) {
			throw new QuantityCharactersException(MIN_CANT_CARACTERES_RAM_ALMACENAMIENTO,
					MAX_CANT_CARACTERES_RAM_ALMACENAMIENTO);
		}
		return almacenamiento;
	}
	
	
	
	
}
