package services;

import models.Pedido;

public interface PedidoServices {

	public Pedido obtenerId(Long id);

	public void guardarPedido(Pedido pedido);
	
	public void eliminarPedido(Pedido pedido);

	//Se puede hacer algún método con ESTADO
	
}
