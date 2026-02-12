package model;

import java.time.LocalDateTime;
import java.util.List;

import enums.Estado;
import interfaces.Calculable;

public class Pedido implements Calculable{
	
	private static int id;
	private LocalDateTime fecha;
	private double total;
	private Usuario usuario;
	private ItemCarrito[]itemsPedido;
	private Estado estado;
	private Pago pago;
	
		
	public Pedido(Usuario usuario,List<ItemCarrito> itemsCarrito, double total) {
		id++;
		this.fecha = LocalDateTime.now();
		this.total = total;
		this.usuario = usuario;
		this.llenarLista(itemsCarrito);
		this.estado = Estado.CREADO;
		this.agregarPedidoComprador(usuario);
	}
	
	private void llenarLista(List<ItemCarrito>lista) {
		this.itemsPedido = new ItemCarrito[lista.size()];
		for (int i = 0; i < itemsPedido.length; i++) {
			itemsPedido[i]= lista.get(i);
		}
		
	}
	
	@Override
	public double precioConIva(double total) {
		return total*Calculable.IVA;
	}
	
	
	public double calcularTotalConImpuestos() {
		return precioConIva(this.total);
		
	}

	public Pago generarPago() {
		this.pago = new Pago(this.fecha,calcularTotalConImpuestos());
		return pago;
	}
	
	private void agregarPedidoComprador(Usuario u) {
		if(u instanceof Comprador) {
			((Comprador)u).agregarPedido(this);
		}
	}
	
	public void cancelarPedidoComprador() {
		if(this.usuario instanceof Comprador && this.estado.equals(Estado.CANCELADO)) {
			((Comprador)this.usuario).eliminarPedido(this);
		}
	}
	

}
