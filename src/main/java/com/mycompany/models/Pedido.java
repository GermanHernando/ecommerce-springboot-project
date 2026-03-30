package com.mycompany.models;

import java.time.LocalDateTime;
import java.util.List;

import com.mycompany.enums.Estado;
import com.mycompany.interfaces.Calculable;
import com.mycompany.models.validator.PedidoValidator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PEDIDOS")
public class Pedido implements Calculable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FECHA")
	private LocalDateTime fecha;
	@Column(name = "TOTAL")
	private Double total;
	@ManyToOne
	@JoinColumn(name = "COMPRADOR_ID")
	private Comprador comprador;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID", referencedColumnName = "ID")
	private List<ItemPedido> itemsPedido;
	@Column(name = "ESTADO")
	@Enumerated(EnumType.STRING)
	private Estado estado;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PAGO_ID")
	private Pago pago;

	Pedido() {
	}

	public Pedido(Comprador comprador, List<ItemPedido> itemsCarrito, Double total) {
		this.fecha = LocalDateTime.now();
		this.setComprador(comprador);
		this.setItemsPedido(itemsCarrito);
		this.setTotal(total);
		this.estado = Estado.CREADO;
		this.agregarPedidoAComprador(comprador);
	}

	private void setComprador(Comprador comprador) {
		this.comprador = PedidoValidator.compradorValidator(comprador);
	}

	public void setItemsPedido(List<ItemPedido> itemsPedido) {
		List<ItemPedido> lista = PedidoValidator.itemsPedidoValidator(itemsPedido);
		llenarLista(lista);
	}

	private void setTotal(Double total) {
		this.total = PedidoValidator.totalValidator(total);
	}

	private void llenarLista(List<ItemPedido> lista) {
		this.itemsPedido = lista;
		for (ItemPedido itemPedido : itemsPedido) {
			itemPedido.asignarPedido(this);
		}
	}

	@Override
	public double precioConIva(double total) {
		return total * Calculable.IVA;
	}

	public double calcularTotalConImpuestos() {
		return precioConIva(this.total);

	}

	public Pago generarPago() {
		this.pago = new Pago(this.id, this.fecha, calcularTotalConImpuestos());
		return pago;
	}

	private void agregarPedidoAComprador(Comprador comprador) {
		if (comprador != null) {
			comprador.agregarPedido(this);
		}
	}

	public void cancelarPedidoComprador() {
		this.comprador.eliminarPedido(this);
		this.estado = Estado.CANCELADO;
	}

}
