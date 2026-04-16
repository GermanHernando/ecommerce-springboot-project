package com.mycompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.models.Celular;
import com.mycompany.repositories.CelularRepository;

@Service
public class CelularServicesImp extends ProductoServicesImp<Celular> implements CelularServices{

	@Autowired
	private CelularRepository celularRepository;
	
	 @Override
	    public List<Celular> getProductos() {
	        return this.celularRepository.findAll();
	    }
}
