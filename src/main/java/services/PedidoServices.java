package services;

import java.time.LocalDateTime;

import models.Pedido;

public interface PedidoServices {

	public Pedido obtenerId(Long id);

	public void guardarPedido(Pedido pedido);

	//TODO Verificar si esta bien con LocalDateTime, se vuelve menos exacta la busqueda?
	public boolean existePedido(LocalDateTime fecha);

}
