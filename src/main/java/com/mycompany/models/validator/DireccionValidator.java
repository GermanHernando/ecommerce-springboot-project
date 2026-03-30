package com.mycompany.models.validator;

import exceptions.QuantityCharactersException;

public class DireccionValidator {

	private static final String MSJ_ERROR_CALLE_VACIA = "La direccion no puede estar vacia";
	private static final int MAX_CHARACTER_CALLE = 80;
	private static final int MIN_CHARACTER_CALLE = 4;
	private static final String MSJ_ERROR_ALTURA_VACIA = "La altura no puede estar vacía";
	private static final int MIN_CARACTERES_ALTURA = 1;
	private static final int MAX_CARACTERES_ALTURA = 8;
	private static final int MIN_CARACTERES_PISO = 1;
	private static final int MAX_CARACTERES_PISO = 2;
	private static final int MIN_CARACTERES_DEPARTAMENTO = 1;
	private static final int MAX_CARACTERES_DEPARTAMENTO = 5;
	private static final String MSJ_ERROR_CIUDAD_VACIA = "La calle no puede estar vacía";
	private static final int MIN_CHARACTER_CIUDAD = 4;
	private static final int MAX_CHARACTER_CIUDAD = 80;
	private static final String MSJ_ERROR_PROVINCIA_VACIA = "La provincia no puede estar vacía";
	private static final int MIN_CHARACTER_PROVINCIA = 4;
	private static final int MAX_CHARACTER_PROVINCIA = 80;
	private static final String MSJ_ERROR_PAIS_VACIO = "El país no puede estar vacío";
	private static final int MIN_CHARACTER_PAIS = 4;
	private static final int MAX_CHARACTER_PAIS = 80;
	private static final String MSJ_ERROR_CODIGO_POSTAL_VACIO = "Codigo postal no puede estar vacio";
	private static final String REGEX_CODIGO_POSTAL = "^[A-Z]?[0-9]{4}[A-Z]{0,3}$";
	private static final String MSJ_ERROR_CODIGO_POSTAL_INVALIDO = "Codigo postal argentino invalido";
	
	
	
	public static String calleValidator(String calle) throws QuantityCharactersException {
		if (calle == null || calle.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_CALLE_VACIA);
		}
		if (calle.length() < MIN_CHARACTER_CALLE || calle.length() > MAX_CHARACTER_CALLE) {
			throw new QuantityCharactersException(MIN_CHARACTER_CALLE, MAX_CHARACTER_CALLE);
		}
		return calle;
	}

	public static Integer alturaValidator(Integer altura)throws QuantityCharactersException {
		int cantCaracteres = 0;
		if (altura == null || altura<=0) {
			throw new IllegalArgumentException(MSJ_ERROR_ALTURA_VACIA);
		}
		cantCaracteres = altura.toString().length();
		if (cantCaracteres < MIN_CARACTERES_ALTURA || cantCaracteres > MAX_CARACTERES_ALTURA) {
			throw new QuantityCharactersException(MIN_CARACTERES_ALTURA, MAX_CARACTERES_ALTURA);
		}
		return altura;
	}

	public static Integer pisoValidator(Integer piso)throws QuantityCharactersException {
		int cantCaracteres = 0;
		if (piso != null) {
			cantCaracteres = piso.toString().length();
			if (cantCaracteres < MIN_CARACTERES_PISO || cantCaracteres > MAX_CARACTERES_PISO) {
				throw new QuantityCharactersException(MIN_CARACTERES_PISO, MAX_CARACTERES_PISO);
			}
		}
		return piso;
	}

	public static String departamentoValidator(String departamento)throws QuantityCharactersException {
		int cantCaracteres = 0;
		if (departamento != null) {
			cantCaracteres = departamento.toString().length();
			if (cantCaracteres < MIN_CARACTERES_DEPARTAMENTO || cantCaracteres > MAX_CARACTERES_DEPARTAMENTO) {
				throw new QuantityCharactersException(MIN_CARACTERES_DEPARTAMENTO, MAX_CARACTERES_DEPARTAMENTO);
			}
		}
		return departamento;
	}

	public static String ciudadValidator(String ciudad) {
		if (ciudad == null || ciudad.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_CIUDAD_VACIA);
		}
		if (ciudad.length() < MIN_CHARACTER_CIUDAD || ciudad.length() > MAX_CHARACTER_CIUDAD) {
			throw new QuantityCharactersException(MIN_CHARACTER_CIUDAD, MAX_CHARACTER_CIUDAD);
		}
		return ciudad;
	}

	public static String provinciaValidator(String provincia) {
		if (provincia == null || provincia.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_PROVINCIA_VACIA);
		}
		if (provincia.length() < MIN_CHARACTER_PROVINCIA || provincia.length() > MAX_CHARACTER_PROVINCIA) {
			throw new QuantityCharactersException(MIN_CHARACTER_PROVINCIA, MAX_CHARACTER_PROVINCIA);
		}
		return provincia;
	}

	public static String paisValidator(String pais) {
		if (pais == null || pais.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_PAIS_VACIO);
		}
		if (pais.length() < MIN_CHARACTER_PAIS || pais.length() > MAX_CHARACTER_PAIS) {
			throw new QuantityCharactersException(MIN_CHARACTER_PAIS, MAX_CHARACTER_PAIS);
		}
		return pais;
	}

	public static String codigoPostalValidator(String codigoPostal) {
		if (codigoPostal == null) {
			throw new IllegalArgumentException(MSJ_ERROR_CODIGO_POSTAL_VACIO);
		}
		if (!codigoPostal.matches(REGEX_CODIGO_POSTAL)) {
			throw new IllegalArgumentException(MSJ_ERROR_CODIGO_POSTAL_INVALIDO);
		}
		return codigoPostal;
	}
}
