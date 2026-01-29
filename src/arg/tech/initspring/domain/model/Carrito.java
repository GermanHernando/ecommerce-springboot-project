package arg.tech.initspring.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

	private List<ItemCarrito>itemsCarrito;
	private Usuario usuario;
	
	public Carrito(Usuario u) {
		this.usuario = u;
		this.itemsCarrito = new ArrayList<ItemCarrito>();
	}
	
	
	public void agregarItem(Producto p,int cantidad) {
		if(p!=null) {
			ItemCarrito itemBuscado = this.buscarItemCarrito(p);
			if (itemBuscado!=null) {
				itemBuscado.incrementarCantidad(cantidad);
			}else {
				this.itemsCarrito.add(new ItemCarrito(p,p.getPrecio(),cantidad));
			}
		}
	}

	
	public void eliminarItem(Producto p,int cantidad) {
		if(p!=null) {
			ItemCarrito itemBuscado = this.buscarItemCarrito(p);
			if (itemBuscado!=null && itemBuscado.quedaCantidad(cantidad)) {
				itemBuscado.disminuirCantidad(cantidad);
			}else {
				this.itemsCarrito.remove(itemBuscado);
			}
		}
	}
	

	private ItemCarrito buscarItemCarrito(Producto p) {
		int index = 0;
		while (index<itemsCarrito.size() && itemsCarrito.get(index).mismoNombre(p.getNombre())) {
			index++;
		}
		return index<itemsCarrito.size()?itemsCarrito.get(index):null;
	}
	
	public void listarItems() {
		for (ItemCarrito itemCarrito : itemsCarrito) {
			System.out.println(itemCarrito.datoItem());
		}
	}
	
	
	//Considerar private si es que sólo se ve el total en el pedido y no en una vista previa del carrito
	public double calcularSubTotalCarrito() {
		double acumulado = 0;
		for (ItemCarrito itemCarrito : itemsCarrito) {
			acumulado += itemCarrito.calcularSubTotal();
		}
		return acumulado;
	}
	
	
	public Pedido generarPedido() {
		Pedido p = new Pedido(this.usuario,itemsCarrito,calcularSubTotalCarrito());
		itemsCarrito.clear();
		return p;
	}
	
	
	
}
