package com.mycompany.models;

import com.mycompany.models.validator.ProductoValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;


@Entity
@Table(name = "PRODUCTOS")
@Inheritance(strategy = InheritanceType.JOINED)
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
	private Double precio;
	@Column(name = "CANTIDAD")
	private Integer cantidad;
	
	Producto(){}
	
	public Producto(String nombre, String marca, String color, Double precio, Integer cantidad) {
		this.setNombre(nombre);
		this.setMarca(marca);
		this.setColor(color);
		this.setPrecio(precio);
		this.setCantidad(cantidad);
	}
	
	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getColor() {
		return color;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Double  getPrecio() {
		return this.precio;
	}
	
	public Integer getCantidad() {
		return this.cantidad;
	}
	
	public boolean mismoNombre(String nombre) {
		return this.nombre.equals(nombre);
	}
	
	public boolean mismaMarca(String nombre) {
		return this.nombre.equals(nombre);
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
		this.nombre = ProductoValidator.nombreValidator(nombre);
	}

	public void setMarca(String marca) {
		this.marca = ProductoValidator.marcaValidator(marca);
	}

	public void setColor(String color) {
		this.color = ProductoValidator.colorValidator(color);
	}

	public void setPrecio(double precio) {
		this.precio = ProductoValidator.precioValidator(precio);
	}

	public void setCantidad(int cantidad) {
		this.cantidad = ProductoValidator.cantidadValidator(cantidad);
	}

	
	
	
	
}
