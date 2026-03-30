package com.mycompany.models;

import com.mycompany.models.validator.CargadorValidator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="CARGADORES")
public class Cargador extends Producto {
	
	@Column(name = "WATS") 
	private Integer wats;
	@Column(name = "CARGA_RAPIDA")
	private Boolean cargaRapida;
	
	Cargador(){}
	
	public Cargador(String nombre, String marca, String color, Double precio, Integer cantidad, Integer wats,
			Boolean cargaRapida) {
		super(nombre, marca, color, precio, cantidad);
		this.setWats(wats);
		this.setCargaRapida(cargaRapida);
	}

	public void setWats(Integer wats) {
		this.wats = CargadorValidator.watsValidator(wats);
	}

	public void setCargaRapida(Boolean cargaRapida) {
		this.cargaRapida = CargadorValidator.cargaRapidaValidator(cargaRapida);
	}

	public Integer getWats() {
		return wats;
	}

	public Boolean isCargaRapida() {
		return cargaRapida;
	}
	
	
	
	
}
