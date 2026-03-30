package com.mycompany.models.validator;

import java.util.List;

import com.mycompany.models.Comprador;
import com.mycompany.models.ItemPedido;

public class PedidoValidator {
	private static final String MSJ_ERROR_COMPRADOR = "No se encontro el usuario, debe estar logeado para continuar con el pedido";
	private static final String MSJ_ERROR_TOTAL = "El total no puede ser igual o menor a 0";
	private static final String MSJ_ERROR_LISTA = "La lista no puede ser nula o vacia";

	public static Comprador compradorValidator(Comprador comprador) {
		if (comprador == null) {
			throw new IllegalArgumentException(MSJ_ERROR_COMPRADOR);
		}
		return comprador;
	}

	public static List<ItemPedido> itemsPedidoValidator(List<ItemPedido> itemsPedido) {
		if (itemsPedido == null || itemsPedido.isEmpty()) {
			throw new IllegalArgumentException(MSJ_ERROR_LISTA);
		}
		return itemsPedido;
	}

	public static Double totalValidator(Double total) {
		if (total == null ||total <= 0) {
			throw new IllegalArgumentException(MSJ_ERROR_TOTAL);
		}
		return total;
	}
}
