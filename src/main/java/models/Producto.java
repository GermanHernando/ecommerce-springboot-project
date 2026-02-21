package models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Producto {

	private static final String MSJ_ERROR_NOMBRE = "El nombre no puede ser nulo o estar vacio";
	private static final String MSJ_ERROR_MARCA = "La marca no puede ser nula o estar vacia";
	private static final String MSJ_ERROR_COLOR = "El color no puede ser nulo o estar vacio";
	private static final String MSJ_ERROR_PRECIO = "El precio no puede ser menor o igual a 0(cero)";
	private static final String MSJ_ERROR_CANTIDAD = "La cantidad no puede ser menor o igual a 0(cero)";
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "MARCA")
	private String marca;
	@Column(name = "COLOR")
	private String color;
	@Column(name = "PRECIO")
	private double precio;
	@Column(name = "CANTIDAD")
	private int cantidad;
	
	Producto(){}
	
	public Producto(String nombre, String marca, String color, double precio, int cantidad) {
		this.setNombre(nombre);
		this.setMarca(marca);
		this.setColor(color);
		this.setPrecio(precio);
		this.setCantidad(cantidad);
	}
	
	public boolean mismoNombre(String nombre) {
		return this.nombre.equals(nombre);
	}
	
	public boolean mismaMarca(String nombre) {
		return this.nombre.equals(nombre);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double  getPrecio() {
		return this.precio;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	public void aumentarCantidad() {
		this.cantidad++;
	}
	
	public void aumentarCantidad(int cantidad) {
		this.cantidad += cantidad;
	}
	
	public void disminuirCantidad() {
		this.cantidad--;
	}
	
	public void disminuirCantidad(int cantidad) {
		this.cantidad -= cantidad;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_NOMBRE);
		}
		this.nombre = nombre;
	}

	public void setMarca(String marca) {
		if (marca == null || marca.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_MARCA);
		}
		this.marca = marca;
	}

	public void setColor(String color) {
		if (color == null || color.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_COLOR);
		}
		this.color = color;
	}

	public void setPrecio(double precio) {
		if (precio <= 0) {
			throw new IllegalArgumentException(MSJ_ERROR_PRECIO);
		}
		this.precio = precio;
	}

	public void setCantidad(int cantidad) {
		if (cantidad <= 0) {
			throw new IllegalArgumentException(MSJ_ERROR_CANTIDAD);
		}
		this.cantidad = cantidad;
	}

	
	
	
	
}
