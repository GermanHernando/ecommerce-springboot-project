package com.mycompany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycompany.forms.CompradorForm;
import com.mycompany.forms.LoginForm;
import com.mycompany.models.Usuario;
import com.mycompany.services.UsuarioServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	public final static String PATH_URL_LOGIN = "/unsecured/login";
	public final static String PATH_CONTEXT_URL_LOGIN = "/login";
	public final static String PATH_CONTEXT_URL_SIGIN= "/sigin";
	
	@Autowired
	private UsuarioServices userService;


	@GetMapping(PATH_CONTEXT_URL_LOGIN)
	public String showLogin(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		model.addAttribute("compradorForm", new CompradorForm());
		return PATH_URL_LOGIN; // → templates/unsecured/login.html
	}

	
	@PostMapping(PATH_CONTEXT_URL_SIGIN)
	public String processLogin(@ModelAttribute("loginForm") LoginForm form, HttpSession session, Model model) {
		Usuario usuario = userService.findByEmailAndPassword(form.getEmail(), form.getPassword());
		String resultadoEsperado = "redirect:/index";
		if (usuario == null) {
			model.addAttribute("error", "Email o contraseña incorrectos.");
			resultadoEsperado = PATH_URL_LOGIN;
		} else if (!usuario.isActivo()) {
			model.addAttribute("error", "Tu cuenta está desactivada. Contactá al administrador.");
			resultadoEsperado = PATH_URL_LOGIN;
		} else {
			SecurityContext contexto = SecurityContextHolder.getContext();
			Authentication authentication = new UsernamePasswordAuthenticationToken(form.getEmail(), null, usuario.coleccionAutorizaciones());
			contexto.setAuthentication(authentication);
			session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, contexto);
		}
		return resultadoEsperado;
	}
 

}