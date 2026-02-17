package services;

import models.Producto;

public interface ProductoServices{

	public Producto obtenerId(Long id);
	
	public void guardarProducto(Producto producto);
	
	public boolean existeProducto(String nombre);
	
}
