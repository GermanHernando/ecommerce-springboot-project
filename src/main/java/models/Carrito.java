package models;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

	private static final String MSJ_CARRITO_VACIO = "No puede generarse el pedido sin productos.";
	private List<ItemPedido>itemsCarrito;
	private Comprador comprador;
	
	public Carrito(Comprador comprador) {
		this.comprador = comprador;
		this.itemsCarrito = new ArrayList<ItemPedido>();
	}
	
	
	public void agregarItem(Producto p,int cantidad) {
		if(p!=null) {
			ItemPedido itemBuscado = this.buscarItemCarrito(p);
			if (itemBuscado!=null) {
				itemBuscado.incrementarCantidad(cantidad);
			}else {
				this.itemsCarrito.add(new ItemPedido(p,p.getPrecio(),cantidad));
			}
		}
	}

	
	public void eliminarItem(Producto p,int cantidad) {
		if(p!=null) {
			ItemPedido itemBuscado = this.buscarItemCarrito(p);
			if (itemBuscado!=null && itemBuscado.quedaCantidad(cantidad)) {
				itemBuscado.disminuirCantidad(cantidad);
			}else {
				this.itemsCarrito.remove(itemBuscado);
			}
		}
	}
	

	private ItemPedido buscarItemCarrito(Producto p) {
		int index = 0;
		while (index<itemsCarrito.size() && itemsCarrito.get(index).mismoNombre(p.getNombre())) {
			index++;
		}
		return index<itemsCarrito.size()?itemsCarrito.get(index):null;
	}
	
	public void listarItems() {
		for (ItemPedido itemCarrito : itemsCarrito) {
			System.out.println(itemCarrito.datoItem());
		}
	}
	
	
	//Considerar private si es que sólo se ve el total en el pedido y no en una vista previa del carrito
	public double calcularSubTotalCarrito() {
		double acumulado = 0;
		for (ItemPedido itemCarrito : itemsCarrito) {
			acumulado += itemCarrito.calcularSubTotal();
		}
		return acumulado;
	}
	
	private List<ItemPedido> copiaLista(){
		List<ItemPedido>copiaItems = new ArrayList<ItemPedido>();
		for (ItemPedido itemPedido : itemsCarrito) {
			copiaItems.add(itemPedido);
		}
		return copiaItems;
	}
	
	
	public Pedido generarPedido() {
		if (this.itemsCarrito.isEmpty()) {
			throw new RuntimeException(MSJ_CARRITO_VACIO);
		}
		Pedido p = new Pedido(this.comprador,copiaLista(),calcularSubTotalCarrito());
		itemsCarrito.clear();
		return p;
	}
	
	
	
}
