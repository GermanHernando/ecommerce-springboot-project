package com.mycompany.models.validator;

import com.mycompany.exceptions.QuantityCharactersException;

public class ProductoValidator {

	private static final String MSJ_ERROR_NOMBRE = "El nombre no puede ser nulo o estar vacio";
	private static final String MSJ_ERROR_MARCA = "La marca no puede ser nula o estar vacia";
	private static final String MSJ_ERROR_COLOR = "El color no puede ser nulo o estar vacio";
	private static final String MSJ_ERROR_PRECIO = "El precio no puede ser menor o igual a 0(cero)";
	private static final String MSJ_ERROR_CANTIDAD = "La cantidad no puede ser menor o igual a 0(cero)";
	private static final int MIN_CHARACTER_NOMBRE_MARCA = 2;
	private static final int MAX_CHARACTER_NOMBRE_MARCA = 100;
	private static final int MIN_CHARACTER_COLOR = 3;
	private static final int MAX_CHARACTER_COLOR = 40;

	public static String nombreValidator(String nombre) throws QuantityCharactersException {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_NOMBRE);
		}
		if (nombre.length() < MIN_CHARACTER_NOMBRE_MARCA || nombre.length() > MAX_CHARACTER_NOMBRE_MARCA) {
			throw new QuantityCharactersException(MIN_CHARACTER_NOMBRE_MARCA, MAX_CHARACTER_NOMBRE_MARCA);
		}
		return nombre;
	}

	public static String marcaValidator(String marca) throws QuantityCharactersException {
		if (marca == null || marca.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_MARCA);
		}
		if (marca.length() < MIN_CHARACTER_NOMBRE_MARCA || marca.length() > MAX_CHARACTER_NOMBRE_MARCA) {
			throw new QuantityCharactersException(MIN_CHARACTER_NOMBRE_MARCA, MAX_CHARACTER_NOMBRE_MARCA);
		}
		return marca;
	}

	public static String colorValidator(String color) throws QuantityCharactersException {
		if (color == null || color.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_COLOR);
		}
		if (color.length() < MIN_CHARACTER_COLOR || color.length() > MAX_CHARACTER_COLOR) {
			throw new QuantityCharactersException(MIN_CHARACTER_COLOR, MAX_CHARACTER_COLOR);
		}
		return color;
	}

	public static Double precioValidator(Double precio) {
		if (precio == null ||precio <= 0) {
			throw new IllegalArgumentException(MSJ_ERROR_PRECIO);
		}
		return precio;
	}

	public static Integer cantidadValidator(Integer cantidad) {
		if (cantidad == null ||cantidad <= 0) {
			throw new IllegalArgumentException(MSJ_ERROR_CANTIDAD);
		}
		return cantidad;
	}

}
