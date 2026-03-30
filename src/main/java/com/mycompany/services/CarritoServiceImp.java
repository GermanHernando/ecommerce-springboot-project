package com.mycompany.services;

import org.springframework.stereotype.Service;

import com.mycompany.models.Carrito;
import com.mycompany.models.Comprador;
import com.mycompany.models.Producto;
import com.mycompany.repositories.ProductoRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class CarritoServiceImp implements CarritoService {

    private final ProductoRepository productoRepository;

    public CarritoServiceImp(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void agregarItem(Long productoId, int cantidad, Comprador comprador, HttpSession session) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + productoId));

        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new Carrito(comprador);
        }

        carrito.agregarItem(producto, cantidad);
        session.setAttribute("carrito", carrito);
    }
}