package com.mycompany.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.models.Cargador;
import com.mycompany.models.Celular;
import com.mycompany.models.Producto;
import com.mycompany.repositories.ProductoRepository;

//service en hijas
@Service
public  class ProductoServicesImp implements ProductoServices {

	@Autowired
	private ProductoRepository repository;
	

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
	
	
	//FIXME COMO HAGO LOS DTOS cuando se usa herencia? Tiene que haber clases que extiendan a productoServicesImp(sacar instance of)

	  @Override
	    public List<Celular> getCelulares() {
	        return this.repository.findAll()
	                .stream()
	                .filter(p -> p instanceof Celular)
	                .map(p -> (Celular) p)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public List<Cargador> getCargadores() {
	        return this.repository.findAll()
	                .stream()
	                .filter(p -> p instanceof Cargador)
	                .map(p -> (Cargador) p)
	                .collect(Collectors.toList());
	    }

	
}
