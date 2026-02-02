package model;

public class Cargador extends Producto {

	private int wats;
	private boolean cargaRapida;
	
	public Cargador(String nombre, String marca, String color, double precio, int cantidad, int wats,
			boolean cargaRapida) {
		super(nombre, marca, color, precio, cantidad);
		this.wats = wats;
		this.cargaRapida = cargaRapida;
	}

	public void setWats(int wats) {
		this.wats = wats;
	}

	public void setCargaRapida(boolean cargaRapida) {
		this.cargaRapida = cargaRapida;
	}
	
	
	
	
}
