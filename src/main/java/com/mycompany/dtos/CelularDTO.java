package com.mycompany.dtos;

public class CelularDTO extends ProductoDTO {

	private Integer tamanio;
	private String resolucionPantalla;
	private String resolucionCamara;
	private Integer ram;
	private Integer almacenamiento;
	
	
	public Integer getTamanio() {
		return tamanio;
	}
	public void setTamanio(Integer tamanio) {
		this.tamanio = tamanio;
	}
	public String getResolucionPantalla() {
		return resolucionPantalla;
	}
	public void setResolucionPantalla(String resolucionPantalla) {
		this.resolucionPantalla = resolucionPantalla;
	}
	public String getResolucionCamara() {
		return resolucionCamara;
	}
	public void setResolucionCamara(String resolucionCamara) {
		this.resolucionCamara = resolucionCamara;
	}
	public Integer getRam() {
		return ram;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	public Integer getAlmacenamiento() {
		return almacenamiento;
	}
	public void setAlmacenamiento(Integer almacenamiento) {
		this.almacenamiento = almacenamiento;
	}
	
	
}
