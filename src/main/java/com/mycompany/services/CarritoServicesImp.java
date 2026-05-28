package com.mycompany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.models.Carrito;
import com.mycompany.models.Comprador;
import com.mycompany.models.Producto;
import com.mycompany.repositories.ProductoRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class CarritoServicesImp implements CarritoServices {

	@Autowired
    private ProductoRepository<Producto> productoRepository;


    @Override
    public void agregarItem(Long productoId, int cantidad, Comprador comprador, HttpSession session) {
        Producto producto = productoRepository.findById(productoId).orElse(null);
        if(producto!=null) {
        	  Carrito carrito = (Carrito) session.getAttribute("carrito");
              if (carrito == null) {
                  carrito = new Carrito(comprador);
              }

              carrito.agregarItem(producto, cantidad);
              session.setAttribute("carrito", carrito);	
        }
    }
    
    
}