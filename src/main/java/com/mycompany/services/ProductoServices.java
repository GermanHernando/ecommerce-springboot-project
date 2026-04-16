package com.mycompany.services;

import java.util.List;

import com.mycompany.models.Producto;

public interface ProductoServices <T extends Producto>{

	public Producto obtenerId(Long id);
	
	public void guardarProducto(Producto producto);
	
	public void eliminarProducto(Producto producto);
	
	public boolean existeProducto(String nombre);

	public    List<T> getProductos();

	
}
