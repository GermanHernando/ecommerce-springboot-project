package com.mycompany.models.validator;

import com.mycompany.exceptions.QuantityCharactersException;
import com.mycompany.models.Direccion;

public class InfoContactoValidator {

	private static final String MSJ_ERROR_TELEFONO_VACIO = "El teléfono no puede estar vacio";
	private static final int MAX_CANT_CHARACTER_TELEFONO = 15;
	private static final int MIN_CANT_CHARACTER_TELEFONO = 8;
	private static final String MSJ_ERROR_DIRECCION = "Debe completarse la dirección";
	
	public static int telefonoValidator(Integer telefono)throws QuantityCharactersException {
		int cantCaracteres = 0;
		if (telefono == 0) {
			throw new IllegalArgumentException(MSJ_ERROR_TELEFONO_VACIO);
		}
		cantCaracteres = telefono.toString().length();
		if (cantCaracteres < MIN_CANT_CHARACTER_TELEFONO || cantCaracteres > MAX_CANT_CHARACTER_TELEFONO) {
			throw new QuantityCharactersException(MIN_CANT_CHARACTER_TELEFONO, MAX_CANT_CHARACTER_TELEFONO);
		}
		return telefono;
	}
	
	public static Direccion direccionValidator(Direccion direccion){
		if(direccion == null) {
			throw new IllegalArgumentException(MSJ_ERROR_DIRECCION);
		}
		return direccion;
	}
	
	
}
