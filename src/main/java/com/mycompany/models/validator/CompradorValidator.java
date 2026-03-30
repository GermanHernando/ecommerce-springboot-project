package com.mycompany.models.validator;
import exceptions.QuantityCharactersException;

public class CompradorValidator {
	private static final String MSJ_ERROR_NOMBRE = "El nombre no puede ser vacío o contener caracteres especiales";
	private static final String MSJ_ERROR_APELLIDO = "El apellido no puede ser vacío o contener caracteres especiales";
	private static final int MIN_CANT_CHARACTER_NOMBRE_APELLIDO = 4;
	private static final int MAX_CANT_CHARACTER_NOMBRE_APELLIDO = 40;

	public static String nombreValidator(String nombre) throws QuantityCharactersException {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_NOMBRE);
		}
		if (nombre.length() < MIN_CANT_CHARACTER_NOMBRE_APELLIDO
				|| nombre.length() > MAX_CANT_CHARACTER_NOMBRE_APELLIDO) {
			throw new QuantityCharactersException(MIN_CANT_CHARACTER_NOMBRE_APELLIDO,
					MAX_CANT_CHARACTER_NOMBRE_APELLIDO);
		}
		return nombre;
	}

	public static String apellidoValidator(String apellido) throws QuantityCharactersException {
		if (apellido == null || apellido.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_APELLIDO);
		}
		if (apellido.length() < MIN_CANT_CHARACTER_NOMBRE_APELLIDO
				|| apellido.length() > MAX_CANT_CHARACTER_NOMBRE_APELLIDO) {
			throw new QuantityCharactersException(MIN_CANT_CHARACTER_NOMBRE_APELLIDO,
					MAX_CANT_CHARACTER_NOMBRE_APELLIDO);
		}
		return apellido;
	}

}
