package models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Producto {

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
	
	public Producto(String nombre, String marca, String color, double precio, int cantidad) {
		this.nombre = nombre;
		this.marca = marca;
		this.color = color;
		this.precio = precio;
		this.cantidad = cantidad;
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
		this.nombre = nombre;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
	
	
}
