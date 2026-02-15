package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CARGADORES")
public class Cargador extends Producto {
	@Id
	@Column(name = "ID")
	//TODO Chequear si necesita el generated value para el ID
	private Long id;
	@Column(name = "WATS")
	private int wats;
	@Column(name = "CARGA_RAPIDA")
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
