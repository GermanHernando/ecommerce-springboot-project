package com.mycompany.models;

import com.mycompany.models.validator.ItemPedidoValidator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ITEMS_PEDIDOS")
public class ItemPedido {

	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="PEDIDO_ID")
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name = "PRODUCTO_ID")
	private Producto producto;
	@Column(name = "PRECIO_UNITARIO")
	private Double precio;
	@Column(name = "CANTIDAD")
	private Integer cantidad;
	
	public ItemPedido() {}
	
	public ItemPedido(Producto producto, Double precio, Integer cantidad) {
		this.setProducto(producto);
		this.setPrecio(precio);
		this.setCantidad(cantidad);
	}
	
	
	public void setProducto(Producto producto) {
		this.producto = ItemPedidoValidator.productoValidator(producto);
	}

	public void setPrecio(Double precio) {
		this.precio = ItemPedidoValidator.precioValidator(precio);
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = ItemPedidoValidator.cantidadValidator(cantidad);
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
