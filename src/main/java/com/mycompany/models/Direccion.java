package com.mycompany.models;

import com.mycompany.exceptions.QuantityCharactersException;
import com.mycompany.models.validator.DireccionValidator;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Direccion {

	@Column(name = "DIR_CALLE")
	private String calle;
	@Column(name = "DIR_ALTURA")
	private Integer altura;
	@Column(name = "DIR_PISO")
	private Integer piso;
	@Column(name = "DIR_DEPARTAMENTO")
	private String departamento;
	@Column(name = "DIR_CIUDAD")
	private String ciudad;
	@Column(name = "DIR_PROVINCIA")
	private String provincia;
	@Column(name = "DIR_PAIS")
	private String pais;
	@Column(name = "DIR_CODIGO_POSTAL")
	private String codigoPostal;
	
	
	public Direccion(String calle, Integer altura, Integer piso, String departamento, String ciudad,
			String provincia, String pais, String codigoPostal) {
		this.setCalle(calle);
		this.setAltura(altura);
		this.setPiso(piso);
		this.setDepartamento(departamento);
		this.setCiudad(ciudad);
		this.setProvincia(provincia);
		this.setPais(pais);
		this.setCodigoPostal(codigoPostal);
	}


	public void setCalle(String calle) throws QuantityCharactersException {
		this.calle = DireccionValidator.calleValidator(calle);
	}


	public void setAltura(Integer altura) {
		this.altura = DireccionValidator.alturaValidator(altura);
	}


	public void setPiso(Integer piso) {
		this.piso = DireccionValidator.pisoValidator(piso);
	}


	public void setDepartamento(String departamento) {
		this.departamento = DireccionValidator.departamentoValidator(departamento);
	}


	public void setCiudad(String ciudad) {
		this.ciudad = DireccionValidator.ciudadValidator(ciudad);
	}


	public void setProvincia(String provincia) {
		this.provincia = DireccionValidator.provinciaValidator(provincia);
	}


	public void setPais(String pais) {
		this.pais = DireccionValidator.paisValidator(pais);
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = DireccionValidator.codigoPostalValidator(codigoPostal);
	}

	public String getCalle() {
		return calle;
	}


	public Integer getAltura() {
		return altura;
	}


	public Integer getPiso() {
		return piso;
	}


	public String getDepartamento() {
		return departamento;
	}


	public String getCiudad() {
		return ciudad;
	}


	public String getProvincia() {
		return provincia;
	}


	public String getPais() {
		return pais;
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	
	
	
	
}
