package com.mycompany.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//session.invalidate();
		SecurityContextHolder.clearContext();
		return "redirect:" + LoginController.PATH_CONTEXT_URL_LOGIN;
	}

	
}
