package com.mycompany.models;

import java.util.HashSet;
import java.util.Set;

import exceptions.QuantityCharactersException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPRADORES")
public class Comprador extends Usuario {

	private static final String MSJ_ERROR_NOMBRE = "El nombre no puede ser vacío o contener caracteres especiales";
	private static final String MSJ_ERROR_APELLIDO = "El apellido no puede ser vacío o contener caracteres especiales";
	private static final String MSJ_ERROR_DIRECCION_VACIA = "La direccion no puede estar vacia";
	private static final int MAX_CHARACTER_DIRECCION = 100;
	private static final int MIN_CHARACTER_DIRECCION = 8;
	private static final String MSJ_ERROR_TELEFONO_VACIO = "El teléfono no puede estar vacio";
	private static final int MAX_CANT_CHARACTER_TELEFONO = 15;
	private static final int MIN_CANT_CHARACTER_TELEFONO = 8;
	private static final String REGEX_CODIGO_POSTAL = "^[A-Z]?[0-9]{4}[A-Z]{0,3}$";
	private static final String MSJ_ERROR_CODIGO_POSTAL_INVALIDO = "Codigo postal argentino invalido";
	private static final String MSJ_ERROR_CODIGO_POSTAL_VACIO = "Codigo postal no puede estar vacio";
	private static final int MIN_CANT_CHARACTER_NOMBRE_APELLIDO = 4;
	private static final int MAX_CANT_CHARACTER_NOMBRE_APELLIDO = 40;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDO")
	private String apellido;
	@Column(name = "TELEFONO")
	private int telefono;
	@Column(name = "DIRECCION")
	private String direccion;
	@Column(name = "CODIGO_POSTAL")
	private String codigoPostal;
	// private Carrito carrito; El carrito puede ser usado como una instancia pero
	// el carrito, queda en caché, no se modela en la DB
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID", referencedColumnName = "ID")
	private Set<Pedido> pedidos;

	public Comprador() {}

	public Comprador(String email, String contrasenia, String nombre, String apellido, int telefono, String direccion,
			String codigoPostal)throws QuantityCharactersException {
		super(email, contrasenia);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		this.setCodigoPostal(codigoPostal);
		// this.carrito = new Carrito(this);
		this.pedidos = new HashSet<Pedido>();
	}

	// public void guardarProductoEnCarrito(Producto p, int cantidad) {
	// this.carrito.agregarItem(p, cantidad);
	// }

	// public void eliminarProductoDeCarrito(Producto p, int cantidad) {
	// this.carrito.eliminarItem(p, cantidad);
	// }

	public void setNombre(String nombre)throws QuantityCharactersException{
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_NOMBRE);
		}
		if (nombre.length()<MIN_CANT_CHARACTER_NOMBRE_APELLIDO || nombre.length()>MAX_CANT_CHARACTER_NOMBRE_APELLIDO) {
			throw new QuantityCharactersException(MIN_CANT_CHARACTER_NOMBRE_APELLIDO, MAX_CANT_CHARACTER_NOMBRE_APELLIDO);
		}
		
		this.nombre = nombre;
	}

	public void setApellido(String apellido)throws QuantityCharactersException {
		if (apellido == null || apellido.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_APELLIDO);
		}
		if (apellido.length()<MIN_CANT_CHARACTER_NOMBRE_APELLIDO || apellido.length()>MAX_CANT_CHARACTER_NOMBRE_APELLIDO) {
			throw new QuantityCharactersException(MIN_CANT_CHARACTER_NOMBRE_APELLIDO, MAX_CANT_CHARACTER_NOMBRE_APELLIDO);
		}
		
		this.apellido = apellido;
	}

	public void setTelefono(int telefono)throws QuantityCharactersException {
		int cantCaracteres = 0;
		if (telefono == 0) {
			throw new IllegalArgumentException(MSJ_ERROR_TELEFONO_VACIO);
		}
		cantCaracteres = String.valueOf(telefono).length();
		if (cantCaracteres < MIN_CANT_CHARACTER_TELEFONO|| cantCaracteres > MAX_CANT_CHARACTER_TELEFONO) {
			throw new QuantityCharactersException(MIN_CANT_CHARACTER_TELEFONO,MAX_CANT_CHARACTER_TELEFONO);
		}
		this.telefono = telefono;
	}

	public void setDireccion(String direccion)throws QuantityCharactersException {
		if (direccion == null || direccion.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_DIRECCION_VACIA);
		}
		if (direccion.length() < MIN_CHARACTER_DIRECCION || direccion.length() > MAX_CHARACTER_DIRECCION) {
			throw new QuantityCharactersException(MIN_CHARACTER_DIRECCION,MAX_CHARACTER_DIRECCION);
		}
		this.direccion = direccion;
	}

	public void setCodigoPostal(String codigoPostal) {
		 if (codigoPostal == null) {
		       throw new IllegalArgumentException(MSJ_ERROR_CODIGO_POSTAL_VACIO);
	    }
		 if (!codigoPostal.matches(REGEX_CODIGO_POSTAL)) {
	    	throw new IllegalArgumentException(MSJ_ERROR_CODIGO_POSTAL_INVALIDO);
		}
	   
	    this.codigoPostal = codigoPostal;
	}

	public void agregarPedido(Pedido p) {
		pedidos.add(p);
	}

	public void eliminarPedido(Pedido p) {
		pedidos.remove(p);
	}

}
