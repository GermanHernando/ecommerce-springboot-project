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

	private static final String MSJ_ERROR_PRODUCTO_NULO = "El producto no puede ser nulo";
	private static final String MSJ_ERROR_PRECIO = "El precio no puede ser menor o igual a 0(cero)";
	private static final String MSJ_ERROR_CANTIDAD = "La cantidad no puede ser menor o igual a 0(cero)";
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
		this.setProducto(producto);
		this.setPrecio(precio);
		this.setCantidad(cantidad);
	}
	
	
	public void setProducto(Producto producto) {
		if (producto == null) {
			throw new IllegalArgumentException(MSJ_ERROR_PRODUCTO_NULO);
		}
		this.producto = producto;
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
