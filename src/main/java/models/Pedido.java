package models;

import java.time.LocalDateTime;
import java.util.List;

import enums.Estado;
import interfaces.Calculable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PEDIDOS")
public class Pedido implements Calculable{
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FECHA")
	private LocalDateTime fecha;
	@Column(name = "TOTAL")
	private double total;
	/*TODO Quizas convenga que sea directo un comprador porque los pedidos pueden llegar 
	a tener comprador y vendedor pero un Usuario no puede ser ambos a la vez*/
	@Column(name = "COMPRADOR_ID")
	private Usuario usuario;
	//TODO Chequear como queda la lista en DB
	private ItemPedido[]itemsPedido;
	@Column(name = "ESTADO")
	@Enumerated(EnumType.STRING)
	private Estado estado;
	@Column(name = "PAGO_ID")
	private Pago pago;
	
	Pedido(){}
	
	public Pedido(Usuario usuario,List<ItemPedido> itemsCarrito, double total) {
		this.fecha = LocalDateTime.now();
		this.total = total;
		this.usuario = usuario;
		this.llenarLista(itemsCarrito);
		this.estado = Estado.CREADO;
		this.agregarPedidoComprador(usuario);
	}
	
	private void llenarLista(List<ItemPedido>lista) {
		this.itemsPedido = new ItemPedido[lista.size()];
		for (int i = 0; i < itemsPedido.length; i++) {
			itemsPedido[i]= lista.get(i);
			itemsPedido[i].asignarPedido(this);
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
		this.pago = new Pago(this.id,this.fecha,calcularTotalConImpuestos());
		return pago;
	}
	
	private void agregarPedidoComprador(Usuario u) {
		if(u instanceof Comprador) {
			((Comprador)u).agregarPedido(this);
		}
	}
	
	public void cancelarPedidoComprador() {
		if(this.usuario instanceof Comprador) {
			((Comprador)this.usuario).eliminarPedido(this);
			this.estado = Estado.CANCELADO;
		}
	}
	

}
