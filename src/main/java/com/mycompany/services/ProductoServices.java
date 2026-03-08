package com.mycompany.services;

import com.mycompany.models.Producto;

public interface ProductoServices{

	public Producto obtenerId(Long id);
	
	public void guardarProducto(Producto producto);
	
	public void eliminarProducto(Producto producto);
	
	public boolean existeProducto(String nombre);
	
}
