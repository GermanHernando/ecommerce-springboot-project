package com.mycompany.app.entity.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.mycompany.models.Pedido;

import helpers.PedidoHelper;

@SpringBootTest
@ActiveProfiles("test")
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
