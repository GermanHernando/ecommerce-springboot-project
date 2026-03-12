package com.mycompany.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mycompany.models.Cargador;
import com.mycompany.models.Celular;
import com.mycompany.services.ProductoServices;

@Controller
public class ProductoController {

	  @Autowired
	    private ProductoServices productoService;

	    @GetMapping("/productos")
	    public String productos(Model model) {
	        List<Celular> celulares = new ArrayList<Celular>();
	        List<Cargador> cargadores = new ArrayList<Cargador>();
			try {
				celulares = productoService.getCelulares();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				cargadores =  productoService.getCargadores();
			} catch (Exception e) {
				e.printStackTrace();
			}

	        model.addAttribute("celulares", celulares);
	        model.addAttribute("cargadores", cargadores);
	        model.addAttribute("totalProductos", celulares.size() + cargadores.size());
	        model.addAttribute("currentYear", java.time.Year.now().getValue());

	        return "productos"; // → templates/productos.html
	}
}
