package com.mycompany.app.entity.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import helpers.PedidoHelper;
import models.Pedido;



public class PedidoEntityTest {

	
	//PEDIDO VALIDO
	@Test
	public void testPedidoValido() {
	    Pedido p = assertDoesNotThrow(() -> PedidoHelper.crearPedidoValido());
	}
	
	
	//COMPRADOR INVALIDO
	@Test
	public void testPedidoCompradorInvalido() {
		 assertThrows(IllegalArgumentException.class, () -> {
	            PedidoHelper.crearPedidoCompradorInvalido();
	        });
	}
	
	//LISTA INVALIDA
	@Test
	public void testPedidoListaInvalida() {
		 assertThrows(IllegalArgumentException.class, () -> {
	            PedidoHelper.crearPedidoListaInvalida();
	        });
	}
	
	//TOTAL INVALIDO
		@Test
		public void testPedidoTotalInvalido() {
			 assertThrows(IllegalArgumentException.class, () -> {
		            PedidoHelper.crearPedidoTotalInvalido();
		        });
		}
		
	
	
}
