package com.mycompany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.forms.CompradorForm;

import jakarta.servlet.http.HttpSession;

@Controller
public class CarritoController {

	private static final String MESSAGE_URL = "/cart";

//	private final CarritoService carritoService;
//
//	public CarritoController(CarritoService carritoService) {
//		this.carritoService = carritoService;
//}

	//TODO Sólo del forms, no del models, tenerlo presente por el id
	@PostMapping(MESSAGE_URL + "/add/{id}")
	public String addProduct(@PathVariable Long id, @RequestParam int cantidad, HttpSession session) {
		CompradorForm comprador = (CompradorForm) session.getAttribute("usuarioLogueado");
		if (comprador == null) {
			return "redirect:/login";
		}
		//carritoService.agregarItem(id, cantidad, comprador, session);
		return "redirect:"+MESSAGE_URL;
	}
}
