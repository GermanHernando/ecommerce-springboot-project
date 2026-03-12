package com.mycompany.models;

import exceptions.QuantityCharactersException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="CARGADORES")
public class Cargador extends Producto {
	
	private static final String MSG_ERROR_WATS = "La cantidad de wats no puede ser 0(cero)";
	private static final int MIN_CANT_CARACTERES_WATS = 1;
	private static final int MAX_CANT_CARACTERES_WATS = 4;
	@Column(name = "WATS") 
	private int wats;
	@Column(name = "CARGA_RAPIDA")
	private boolean cargaRapida;
	
	Cargador(){}
	
	public Cargador(String nombre, String marca, String color, double precio, int cantidad, int wats,
			boolean cargaRapida) {
		super(nombre, marca, color, precio, cantidad);
		this.setWats(wats);
		this.setCargaRapida(cargaRapida);
	}

	public void setWats(int wats) {
		int cantCaracteres = 0;
		if (wats == 0) {
			throw new IllegalArgumentException(MSG_ERROR_WATS);
		}
		cantCaracteres = String.valueOf(wats).length();
		if (cantCaracteres<MIN_CANT_CARACTERES_WATS || cantCaracteres>MAX_CANT_CARACTERES_WATS ) {
			throw new QuantityCharactersException(MIN_CANT_CARACTERES_WATS, MAX_CANT_CARACTERES_WATS);
		}
		this.wats = wats;
	}

	public void setCargaRapida(boolean cargaRapida) {
		this.cargaRapida = cargaRapida;
	}

	public int getWats() {
		return wats;
	}

	public boolean isCargaRapida() {
		return cargaRapida;
	}
	
	
	
	
}
