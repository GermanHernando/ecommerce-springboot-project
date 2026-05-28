package com.mycompany.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.models.Cargador;
import com.mycompany.models.Celular;
import com.mycompany.services.CargadorServices;
import com.mycompany.services.CelularServices;

@Controller
public class ProductoController {
	private static final String URL_CONTEXT_PRODUCTOS = "/productos";
	private static final String URL_LINK_PRODUCTOS = "unsecured/productos";
	@Autowired
	private CelularServices celularService;
	@Autowired
	private CargadorServices cargadorService;

	@GetMapping(URL_CONTEXT_PRODUCTOS)
	public String productos(@RequestParam(name="tipo",required=false,defaultValue = "celulares")String tipo,Model model) {
		List<Celular> celulares = new ArrayList<Celular>();
		List<Cargador> cargadores = new ArrayList<Cargador>();
		try {
			if ("cargadores".equals(tipo)) {
				cargadores = cargadorService.getProductos();
				model.addAttribute("cargadores", cargadores);
				model.addAttribute("totalProductos", cargadores.size());
			} else {
				celulares = celularService.getProductos();
				model.addAttribute("celulares", celulares);
				model.addAttribute("totalProductos", celulares.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("tipoActivo", tipo);
		model.addAttribute("currentYear", java.time.Year.now().getValue());

		return URL_LINK_PRODUCTOS; // → templates /unsecured/productos.html
	}
}
