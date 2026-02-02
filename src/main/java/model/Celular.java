package model;

public class Celular extends Producto {

	
	private int tamanio;
	private String resolucionPantalla;
	private String resolucionCamara;
	private int ram;
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
