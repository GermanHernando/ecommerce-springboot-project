package com.mycompany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycompany.forms.CompradorForm;
import com.mycompany.forms.LoginForm;
import com.mycompany.models.Comprador;
import com.mycompany.models.Usuario;
import com.mycompany.services.UsuarioServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	private final UsuarioServices userService;
	private final static String PATH_PAGES_URL = "login";
	private final static String PATH_CONTEXT_URL = "/login";
	private final static String PATH_REGISTER_PAGE_URL = "register";

	public LoginController(UsuarioServices userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		model.addAttribute("compradorForm", new CompradorForm());
		return PATH_PAGES_URL; // → templates/login.html
	}

	@PostMapping("/login")
	public String processLogin(@ModelAttribute("loginForm") LoginForm form, HttpSession session, Model model) {
		Usuario usuario = userService.findByEmailAndPassword(form.getEmail(), form.getPassword());
		String resultadoEsperado = "redirect:/";
		if (usuario == null) {
			model.addAttribute("error", "Email o contraseña incorrectos.");
			resultadoEsperado = "login";
		} else if (!usuario.isActivo()) {
			model.addAttribute("error", "Tu cuenta está desactivada. Contactá al administrador.");
			resultadoEsperado = "login";
		} else {
			session.setAttribute("usuarioLogueado", usuario);
		}
		return resultadoEsperado;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:" + PATH_CONTEXT_URL;
	}

	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("compradorForm", new CompradorForm());
		return PATH_REGISTER_PAGE_URL; // → templates/register.html
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("compradorForm") CompradorForm compradorForm, Model model) {
		String result;

		if (userService.existeUsuario(compradorForm.getEmail())) {
			System.out.println(">>> Email ya existe");
			model.addAttribute("registerError", "El email ya está en uso.");
			model.addAttribute("compradorForm", compradorForm);
			result = PATH_REGISTER_PAGE_URL;
		} else {
			try {
				userService.guardarUsuario(new Comprador().generarNuevoComprador(compradorForm.devolverComprador()));
				model.addAttribute("successMessage", "Cuenta creada. ¡Ya podés iniciar sesión!");
				model.addAttribute("loginForm", new LoginForm());
				result = "redirect:/" + PATH_PAGES_URL;
			} catch (Exception e) {
				model.addAttribute("registerError", "Ocurrió un error: " + e.getMessage());
				model.addAttribute("compradorForm", compradorForm);
				result = PATH_REGISTER_PAGE_URL;
			}
		}

		return result;
	}

}