package com.mycompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.models.Producto;
import com.mycompany.repositories.ProductoRepository;


public abstract class ProductoServicesImp<T extends Producto> implements ProductoServices<T> {

	@Autowired
	protected ProductoRepository<T> repository;
	
	@Override
	public  T obtenerProductoPorId(Long id) {
	return this.repository.findById(id).orElse(null);	
	}

	@Override
	public void guardarProducto(T producto) {
		this.repository.save(producto);
	}

	@Override
	public void eliminarProducto(T producto) {
		this.repository.delete(producto);
		
	}
	
	@Override
	public boolean existeProducto(String nombre) {
		boolean existe = false;
		if (nombre != null) {
			List<T> productos = this.repository.findByNombreIgnoreCase(nombre);
			existe = !productos.isEmpty();
		}
		return existe;
	}
	
	
	  @Override
	    public  List<T> getProductos(){
		  return this.repository.findAll();
	  }
	  
}
