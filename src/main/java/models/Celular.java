package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CELULARES")
public class Celular extends Producto {


	@Column(name = "TAMANIO")
	private int tamanio;
	@Column(name = "RESOLUCION_PANTALLA")
	private String resolucionPantalla;
	@Column(name = "RESOLUCION_CAMARA")
	private String resolucionCamara;
	@Column(name = "RAM")
	private int ram;
	@Column(name = "ALMACENAMIENTO")
	private int almacenamiento;
	
	
	public Celular(String nombre, String marca, String color, double precio, int cantidad, int tamanio,
			String resolucionPantalla, String resolucionCamara, int ram, int almacenamiento) {
		super(nombre, marca, color, precio, cantidad);
		this.tamanio = tamanio;
		this.resolucionPantalla = resolucionPantalla;
		this.resolucionCamara = resolucionCamara;
		this.ram = ram;
		this.almacenamiento = almacenamiento;
	}


	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}


	public void setResolucionPantalla(String resolucionPantalla) {
		this.resolucionPantalla = resolucionPantalla;
	}


	public void setResolucionCamara(String resolucionCamara) {
		this.resolucionCamara = resolucionCamara;
	}


	public void setRam(int ram) {
		this.ram = ram;
	}


	public void setAlmacenamiento(int almacenamiento) {
		this.almacenamiento = almacenamiento;
	}
	
	
	
	
	
}
