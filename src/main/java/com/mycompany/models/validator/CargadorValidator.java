package com.mycompany.models.validator;

import com.mycompany.exceptions.QuantityCharactersException;

public class CargadorValidator {

	private static final String MSG_ERROR_WATS = "La cantidad de wats no puede ser 0(cero)";
	private static final String MSG_ERROR_CARGA_RAPIDA = "Debe tener un valor por si o por no";
	private static final int MIN_CANT_CARACTERES_WATS = 1;
	private static final int MAX_CANT_CARACTERES_WATS = 4;

	public static Integer watsValidator(Integer wats) {
		int cantCaracteres = 0;
		if (wats == null || wats == 0) {
			throw new IllegalArgumentException(MSG_ERROR_WATS);
		}
		cantCaracteres = String.valueOf(wats).length();
		if (cantCaracteres < MIN_CANT_CARACTERES_WATS || cantCaracteres > MAX_CANT_CARACTERES_WATS) {
			throw new QuantityCharactersException(MIN_CANT_CARACTERES_WATS, MAX_CANT_CARACTERES_WATS);
		}
		return wats;
	}
	
	public static Boolean cargaRapidaValidator(Boolean cargaRapida) {
		if(cargaRapida == null) {
			throw new IllegalArgumentException(MSG_ERROR_CARGA_RAPIDA);
		}
		return cargaRapida;
	}
	

}
