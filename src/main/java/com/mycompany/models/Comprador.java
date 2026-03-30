package com.mycompany.models;

import java.util.HashSet;
import java.util.Set;

import com.mycompany.forms.CompradorForm;
import com.mycompany.models.validator.CompradorValidator;

import exceptions.QuantityCharactersException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPRADORES")
public class Comprador extends Usuario {

	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDO")
	private String apellido;
	@Embedded
	private InfoContacto infoContacto;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "COMPRADOR_ID", referencedColumnName = "ID")
	private Set<Pedido> pedidos;

	public Comprador() {
	}

	public Comprador(String email, String contrasenia, String nombre, String apellido, InfoContacto infoContacto)
			throws QuantityCharactersException {
		super(email, contrasenia);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setInfoContacto(infoContacto);
		// this.carrito = new Carrito(this);
		this.pedidos = new HashSet<Pedido>();
	}

	public void setNombre(String nombre) throws QuantityCharactersException {
		this.nombre = CompradorValidator.nombreValidator(nombre);
	}

	public void setApellido(String apellido) throws QuantityCharactersException {
		this.apellido = CompradorValidator.apellidoValidator(apellido);
	}

	public void setInfoContacto(InfoContacto infoContacto) {
		this.infoContacto = infoContacto;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public InfoContacto getInfoContacto() {
		return infoContacto;
	}

	public void agregarPedido(Pedido p) {
		pedidos.add(p);
	}

	public void eliminarPedido(Pedido p) {
		pedidos.remove(p);
	}

	public Comprador generarNuevoComprador(CompradorForm cf) {
		return new Comprador(cf.getEmail(), cf.getContrasenia(), cf.getNombre(), cf.getApellido(),null);
	}

	// public void guardarProductoEnCarrito(Producto p, int cantidad) {
	// this.carrito.agregarItem(p, cantidad);
	// }

	// public void eliminarProductoDeCarrito(Producto p, int cantidad) {
	// this.carrito.eliminarItem(p, cantidad);
	// }

}
