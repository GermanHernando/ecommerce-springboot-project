package com.mycompany.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.enums.Estado;
import com.mycompany.models.ItemPedido;
import com.mycompany.models.Pago;

public class PedidoDTO {

	@JsonProperty(value = "dateTime")
	private LocalDateTime fecha;
	@JsonProperty(value = "amountQuantity")
	private Double total;
	@JsonProperty(value = "buyerProfile")
	private CompradorDTO compradorDTO;
	@JsonProperty(value = "listProducts")
	private List<ItemPedido> itemsPedido;
	//TODO Consultar si está bien Enum
	private Estado estado;
	//Capaz no deba de estar el pago
	private Pago pago;
	
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public CompradorDTO getCompradorDTO() {
		return compradorDTO;
	}
	public void setCompradorDTO(CompradorDTO compradorDTO) {
		this.compradorDTO = compradorDTO;
	}
	public List<ItemPedido> getItemsPedido() {
		return itemsPedido;
	}
	public void setItemsPedido(List<ItemPedido> itemsPedido) {
		this.itemsPedido = itemsPedido;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Pago getPago() {
		return pago;
	}
	public void setPago(Pago pago) {
		this.pago = pago;
	}
	
	
	
	
	
}
