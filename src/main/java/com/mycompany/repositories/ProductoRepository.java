package com.mycompany.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	public List<Producto> findByNombreIgnoreCase(String nombre);
	
	
}
