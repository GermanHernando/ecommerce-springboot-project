package models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
	@Column(name = "TELEFONO")
	//TODO Ver porque en la tabla quedó como VARCHAR y acá está como INT el Telefono
	private int telefono;
	@Column(name = "DIRECCION")
	private String direccion;
	@Column(name = "CODIGO_POSTAL")
	private int codigoPostal;
	//private Carrito carrito; El carrito puede ser usado como una instancia pero el carrito, queda en caché, no se modela en la DB
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID", referencedColumnName = "ID" )
	private Set<Pedido>pedidos;
	
	
	public Comprador() {}
	
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
	
	
	// public void guardarProductoEnCarrito(Producto p, int cantidad) {
	// 	this.carrito.agregarItem(p, cantidad);
	// }
	
	// public void eliminarProductoDeCarrito(Producto p, int cantidad) {
	// 	this.carrito.eliminarItem(p, cantidad);
	// }
	
	
	public void agregarPedido(Pedido p) {
		pedidos.add(p);
	}
	
	public void eliminarPedido(Pedido p) {
		pedidos.remove(p);
	}
	
	

	
	
	
	
	
	
	
	
	
}
