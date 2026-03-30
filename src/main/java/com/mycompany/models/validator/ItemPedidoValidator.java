package com.mycompany.models.validator;

import com.mycompany.models.Producto;

public class ItemPedidoValidator {

	private static final String MSJ_ERROR_PRODUCTO_NULO = "El producto no puede ser nulo";
	private static final String MSJ_ERROR_PRECIO = "El precio no puede ser menor o igual a 0(cero)";
	private static final String MSJ_ERROR_CANTIDAD = "La cantidad no puede ser menor o igual a 0(cero)";

	
	public static Producto productoValidator(Producto producto) {
		if (producto == null) {
			throw new IllegalArgumentException(MSJ_ERROR_PRODUCTO_NULO);
		}
		return producto;
	}

	public static Double precioValidator(Double precio) {
		if (precio == null || precio <= 0) {
			throw new IllegalArgumentException(MSJ_ERROR_PRECIO);
		}
		return precio;
	}

	public static Integer cantidadValidator(Integer cantidad) {
		if (cantidad == null || cantidad <= 0) {
			throw new IllegalArgumentException(MSJ_ERROR_CANTIDAD);
		}
		return cantidad;
	}
}
