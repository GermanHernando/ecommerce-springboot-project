package com.mycompany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.models.Producto;
import com.mycompany.repositories.ProductoRepository;


public abstract class ProductoServicesImp<T extends Producto> implements ProductoServices<T> {

	@Autowired
	protected ProductoRepository repository;
	

	@Override
	public Producto obtenerId(Long id) {
		Optional<Producto> producto = this.repository.findById(id);
		return producto.get();
	}

	@Override
	public void guardarProducto(Producto producto) {
		this.repository.save(producto);
	}

	@Override
	public void eliminarProducto(Producto producto) {
		this.repository.delete(producto);
		
	}
	
	@Override
	public boolean existeProducto(String nombre) {
		boolean existe = false;
		if (nombre != null) {
			List<Producto> productos = this.repository.findByNombreIgnoreCase(nombre);
			existe = !productos.isEmpty();
		}
		return existe;
	}
	
	
	//TODO -Consultar si está bien implementado junto con sus hijas
	  @Override
	    public abstract List<T> getProductos();
	  
}
