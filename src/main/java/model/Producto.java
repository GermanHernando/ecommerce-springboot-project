package model;

public abstract class Producto {

	private Integer id;
	private String nombre;
	private String marca;
	private String color;
	private double precio;
	private int cantidad;
	
	public Producto(String nombre, String marca, String color, double precio, int cantidad) {
		id++;
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
