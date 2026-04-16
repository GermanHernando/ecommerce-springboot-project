package com.mycompany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycompany.forms.CompradorForm;
import com.mycompany.forms.LoginForm;
import com.mycompany.models.Comprador;
import com.mycompany.services.UsuarioServices;

@Controller
public class RegisterController {
	
	private final static String PATH_REGISTER_PAGE_URL = "/unsecured/register";
	private final static String PATH_CONTEXT_URL_REGISTER = "/register";

	@Autowired
	private UsuarioServices userService;
	

	@GetMapping(PATH_CONTEXT_URL_REGISTER)
	public String showRegister(Model model) {
		model.addAttribute("compradorForm", new CompradorForm());
		return PATH_REGISTER_PAGE_URL; // → templates/unsecured/register.html
	}

	@PostMapping(PATH_CONTEXT_URL_REGISTER)
	public String register(@ModelAttribute("compradorForm") CompradorForm compradorForm, Model model) {
		String result;

		if (userService.existeUsuario(compradorForm.getEmail())) {
			model.addAttribute("registerError", "El email ya está en uso.");
			model.addAttribute("compradorForm", compradorForm);
			result = PATH_REGISTER_PAGE_URL;
		} else {
			try {
				userService.guardarUsuario(new Comprador().generarNuevoComprador(compradorForm.devolverComprador()));
				model.addAttribute("successMessage", "Cuenta creada. ¡Ya podés iniciar sesión!");
				model.addAttribute("loginForm", new LoginForm());
				result = "redirect:" + LoginController.PATH_CONTEXT_URL_LOGIN;
			} catch (Exception e) {
				model.addAttribute("registerError", "Ocurrió un error: " + e.getMessage());
				model.addAttribute("compradorForm", compradorForm);
				result = PATH_REGISTER_PAGE_URL;
			}
		}

		return result;
	}

}
