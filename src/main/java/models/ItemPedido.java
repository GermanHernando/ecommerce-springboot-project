package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ITEMS_PEDIDO")
public class ItemPedido {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//TODO Modificar en DB para que en vez de un ID, agarre un PEDIDO, ver
	@Column(name="PEDIDO_ID")
	private Pedido pedido;
	@Column(name = "PRODUCTO_ID")
	private Producto producto;
	@Column(name = "PRECIO_UNITARIO")
	private double precio;
	@Column(name = "CANTIDAD")
	private int cantidad;
	
	public ItemPedido() {}
	
	public ItemPedido(Producto producto, double precio, int cantidad) {
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public void incrementarCantidad(int cantidad) {
		this.cantidad+=cantidad;
	}
	
	public void disminuirCantidad(int cantidad) {
		this.cantidad -= cantidad;
	}
	
	public boolean quedaCantidad(int cantidad) {
		int sobrante = this.cantidad - cantidad;
		return sobrante>0;
	}
	
	
	public boolean mismoNombre(String nombre) {
		return this.producto.mismoNombre(nombre);
	}
	
	public double calcularSubTotal() {
		return cantidad*precio;
	}
	
	public void asignarPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public String datoItem() {
		return "Nombre: "+this.producto.getNombre()+", Cantidad: "+this.cantidad+", Precio: $"+this.precio;
	}
	
}
