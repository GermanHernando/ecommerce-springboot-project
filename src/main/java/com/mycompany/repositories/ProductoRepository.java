package com.mycompany.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.models.Producto;


public interface ProductoRepository <T extends Producto> extends JpaRepository<T, Long> {

	public List<T> findByNombreIgnoreCase(String nombre);
	
	
}
