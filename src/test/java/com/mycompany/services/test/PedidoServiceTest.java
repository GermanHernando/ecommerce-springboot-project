package com.mycompany.services.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycompany.app.App;
import com.mycompany.models.Pedido;
import com.mycompany.services.PedidoServices;

import helpers.PedidoHelper;

@SpringBootTest(classes = App.class)
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
