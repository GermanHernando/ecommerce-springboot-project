package com.mycompany.services;

import java.util.List;

import com.mycompany.models.Producto;

public interface ProductoServices <T extends Producto>{

	public T obtenerProductoPorId(Long id);
	
	public void guardarProducto(T producto);
	
	public void eliminarProducto(T producto);
	
	public boolean existeProducto(String nombre);

	public List<T> getProductos();

	
}
