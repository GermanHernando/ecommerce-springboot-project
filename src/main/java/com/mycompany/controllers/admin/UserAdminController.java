package com.mycompany.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycompany.forms.UserForm;

@Controller
public class UserAdminController {
	
	private static final String PATH_PAGES_URL = "/admin/users"; //Template
	private static final String PATH_CONTEXT_URL = "/adm/users"; //Package
	private static final String FORM_ATTRIBUTE = "form";
	
	
	
	@GetMapping(value = PATH_PAGES_URL)
	public String init() {
		return PATH_PAGES_URL + "/list";
	}
	
	@GetMapping(value = PATH_CONTEXT_URL + "/edit")
	public String edit(Model model) {
		model.addAttribute(FORM_ATTRIBUTE, new UserForm());
		return PATH_PAGES_URL + "/form";
	}
	
	@PostMapping(value = PATH_CONTEXT_URL + "/save")
	public String save(@ModelAttribute(name = FORM_ATTRIBUTE) UserForm formulario) {
		formulario.getEmail();
		return "redirect:" + PATH_CONTEXT_URL;
	}
	

}
