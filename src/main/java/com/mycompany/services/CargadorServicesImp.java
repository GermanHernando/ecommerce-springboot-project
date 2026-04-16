package com.mycompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.models.Cargador;
import com.mycompany.repositories.CargadorRepository;

@Service
public class CargadorServicesImp extends ProductoServicesImp<Cargador> implements CargadorServices {

	@Autowired
	private CargadorRepository cargadorRepository;
	
	@Override
	public List<Cargador> getProductos() {
		return this.cargadorRepository.findAll();
	}

}
