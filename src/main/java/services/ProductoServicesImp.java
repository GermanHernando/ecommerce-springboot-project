package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Producto;
import repositories.ProductoRepository;

@Service
public class ProductoServicesImp implements ProductoServices {

	@Autowired
	private ProductoRepository repository;

	@Override
	public Producto obtenerId(Long id) {
		Optional<Producto> producto = this.repository.findById(id);
		return producto.get();
	}

	@Override
	public void guardarProducto(Producto usuario) {
		this.repository.save(usuario);
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

}
