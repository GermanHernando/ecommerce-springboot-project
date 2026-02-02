package model;

import java.util.HashSet;
import java.util.Set;

public class Comprador extends Usuario {

	private String nombre;
	private String apellido;
	private int telefono;
	private String direccion;
	private int codigoPostal;
	//private Carrito carrito; El carrito puede ser usado como una instancia pero el carrito, queda en caché, no se modela en la DB
	private Set<Pedido>pedidos;
	
	public Comprador(String email, String contrasenia, String nombre, String apellido, int telefono, String direccion,
			int codigoPostal) {
		super(email, contrasenia);
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		//this.carrito = new Carrito(this);
		this.pedidos = new HashSet<Pedido>();
	}
	
	
	public void guardarProductoEnCarrito(Producto p, int cantidad) {
		this.carrito.agregarItem(p, cantidad);
	}
	
	public void eliminarProductoDeCarrito(Producto p, int cantidad) {
		this.carrito.eliminarItem(p, cantidad);
	}
	
	
	public void agregarPedido(Pedido p) {
		pedidos.add(p);
	}
	
	public void eliminarPedido(Pedido p) {
		pedidos.remove(p);
	}
	
	

	
	
	
	
	
	
	
	
	
}
