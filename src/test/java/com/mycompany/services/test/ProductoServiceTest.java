package com.mycompany.services.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.mycompany.App;
import com.mycompany.models.Producto;
import com.mycompany.services.ProductoServices;

@SpringBootTest(classes = App.class)
@ActiveProfiles("test")
public abstract class ProductoServiceTest<T extends Producto, S extends ProductoServices<T>>{

	@Autowired
	private S service;

	public void guardarProducto(T producto) {
		this.service.guardarProducto(producto);
	}

	public void eliminarProducto(T producto) {
		this.service.eliminarProducto(producto);
	}


}
