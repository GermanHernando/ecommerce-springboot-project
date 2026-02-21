package models;

import java.time.LocalDateTime;
import java.util.List;

import enums.Estado;
import interfaces.Calculable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PEDIDOS")
public class Pedido implements Calculable{
	
	private static final String MSJ_ERROR_COMPRADOR= "No se encontro el usuario, debe estar logeado para continuar con el pedido";
	private static final String MSJ_ERROR_TOTAL = "El total no puede ser igual o menor a 0"; 
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FECHA")
	private LocalDateTime fecha;
	@Column(name = "TOTAL")
	private double total;
	@Column(name = "COMPRADOR_ID")
	private Comprador comprador;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID", referencedColumnName = "ID" )
	private List<ItemPedido>itemsPedido;
	@Column(name = "ESTADO")
	@Enumerated(EnumType.STRING)
	private Estado estado;
	@Column(name = "PAGO_ID")
	private Pago pago;
	
	Pedido(){}
	
	public Pedido(Comprador comprador,List<ItemPedido> itemsCarrito, double total) {
		this.fecha = LocalDateTime.now();
		this.setTotal(total);
		this.setComprador(comprador);
		this.llenarLista(itemsCarrito);
		this.estado = Estado.CREADO;
		this.agregarPedidoAComprador(comprador);
	}

	private void setComprador(Comprador comprador) {
		if(comprador==null) {
			throw new IllegalArgumentException(MSJ_ERROR_COMPRADOR);
		}
		this.comprador = comprador;
	}

	
	private void setTotal(double total) {
		if (total<=0) {
			throw new IllegalArgumentException(MSJ_ERROR_TOTAL);
		}
		this.total = total;
	}
	
	private void llenarLista(List<ItemPedido>lista) {
		if(!lista.isEmpty()) {
			this.itemsPedido = lista;
			for (ItemPedido itemPedido : itemsPedido) {
				itemPedido.asignarPedido(this);
			}
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
	
	private void agregarPedidoAComprador(Comprador comprador) {
		if(comprador!=null) {
			comprador.agregarPedido(this);
		}
	}
	
	public void cancelarPedidoComprador() {
			this.comprador.eliminarPedido(this);
			this.estado = Estado.CANCELADO;
	}
	

}
