package com.mycompany.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.enums.Estado;
import com.mycompany.models.Pago;

public class PedidoDTO {

	@JsonProperty(value = "dateTime")
	private LocalDateTime fecha;
	@JsonProperty(value = "amountQuantity")
	private Double total;
	@JsonProperty(value = "buyerProfile")
	private CompradorDTO compradorDTO;
	@JsonProperty(value = "listProducts")
	private List<ItemPedidoDTO> itemsPedido;
	private Estado estado;
	//TODO Debe ser DTO
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
	public List<ItemPedidoDTO> getItemsPedido() {
		return itemsPedido;
	}
	public void setItemsPedido(List<ItemPedidoDTO> itemsPedido) {
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
