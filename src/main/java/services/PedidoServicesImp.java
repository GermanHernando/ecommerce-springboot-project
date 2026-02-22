package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Pedido;
import repositories.PedidoRepository;

@Service
public class PedidoServicesImp implements PedidoServices {

	@Autowired
	private PedidoRepository repository;
	
	
	@Override
	public Pedido obtenerId(Long id) {
		Optional<Pedido> pedidos = this.repository.findById(id);
		return pedidos.get();
	}

	@Override
	public void guardarPedido(Pedido pedido) {
		this.repository.save(pedido);
	}

	
}
