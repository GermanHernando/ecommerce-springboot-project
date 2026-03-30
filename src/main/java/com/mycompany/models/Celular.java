package com.mycompany.models;

import com.mycompany.models.validator.CelularValidator;

import exceptions.QuantityCharactersException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "CELULARES")
public class Celular extends Producto {

	@Column(name = "TAMANIO")
	private Integer tamanio;
	@Column(name = "RESOLUCION_PANTALLA")
	private String resolucionPantalla;
	@Column(name = "RESOLUCION_CAMARA")
	private String resolucionCamara;
	@Column(name = "RAM")
	private Integer ram;
	@Column(name = "ALMACENAMIENTO")
	private Integer almacenamiento;
	

	Celular() {}

	public Celular(String nombre, String marca, String color, Double precio, Integer cantidad, Integer tamanio,
			String resolucionPantalla, String resolucionCamara, Integer ram, Integer almacenamiento)
			throws QuantityCharactersException {
		super(nombre, marca, color, precio, cantidad);
		this.setTamanio(tamanio);
		this.setResolucionPantalla(resolucionPantalla);
		this.setResolucionCamara(resolucionCamara);
		this.setRam(ram);
		this.setAlmacenamiento(almacenamiento);
	}

	public void setTamanio(Integer tamanio) {
		this.tamanio = CelularValidator.tamanioValidator(tamanio);
	}

	public void setResolucionPantalla(String resolucionPantalla) {
		this.resolucionPantalla = CelularValidator.resolucionPantallaValidator(resolucionPantalla);
	}

	public void setResolucionCamara(String resolucionCamara) {
		
		this.resolucionCamara = CelularValidator.resolucionCamaraValidator(resolucionCamara);
	}

	public void setRam(Integer ram) {
		this.ram = CelularValidator.ramValidator(ram);
	}

	public void setAlmacenamiento(Integer almacenamiento) {
		this.almacenamiento = CelularValidator.almacenamientoValidator(almacenamiento);
	}

	public Integer getTamanio() {
		return tamanio;
	}

	public String getResolucionPantalla() {
		return resolucionPantalla;
	}

	public String getResolucionCamara() {
		return resolucionCamara;
	}

	public Integer getRam() {
		return ram;
	}

	public Integer getAlmacenamiento() {
		return almacenamiento;
	}

}
