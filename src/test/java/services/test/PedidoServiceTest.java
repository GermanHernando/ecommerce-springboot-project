package services.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import helpers.PedidoHelper;
import models.Pedido;
import services.PedidoServices;

@SpringBootTest
public class PedidoServiceTest {

	@Autowired
	private PedidoServices pedido;
	
	
	@Test
	private void testSavePedidoSucces() {
		Pedido p = PedidoHelper.crearPedidoValido();
		pedido.guardarPedido(p);
	}
	
	@Test
	private void testDeletePedidoSucces() {
		Pedido p = PedidoHelper.crearPedidoValido();
		pedido.eliminarPedido(p);
	}
	
	
	
}
