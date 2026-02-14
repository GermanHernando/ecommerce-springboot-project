package model;

public class ItemCarrito {

	private Integer id;
	private Producto producto;
	private double precio;
	private int cantidad;
	
	public ItemCarrito(Producto producto, double precio, int cantidad) {
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
	
	
	public String datoItem() {
		return "Nombre: "+this.producto.getNombre()+", Cantidad: "+this.cantidad+", Precio: $"+this.precio;
	}
	
}
