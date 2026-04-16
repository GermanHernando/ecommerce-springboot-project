package com.mycompany.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.dtos.UsuarioDTO;
import com.mycompany.forms.CompradorForm;
import com.mycompany.forms.validator.UserFormValidator;
import com.mycompany.models.Comprador;
import com.mycompany.models.Usuario;
import com.mycompany.services.UsuarioServices;

@Controller
public class UserAdminController {

	private static final String PATH_PAGES_URL = "admin/users"; // Template
	private static final String PATH_CONTEXT_URL = "/admin/users"; // Package
	private static final String PATH_CONTEXT_FORM_URL ="/form"; 
	private static final String FORM_ATTRIBUTE = "form";
	private static final String LIST_ATTRIBUTE = "listado";

	@Autowired
	private UsuarioServices usuarioService;
	@Autowired
	private UserFormValidator validator;

	@InitBinder(value = FORM_ATTRIBUTE)
	void initForm(WebDataBinder binder) {
		binder.addValidators(this.validator);
	}

	@GetMapping(value = PATH_CONTEXT_URL)
	public String init(Model model) {
		List<UsuarioDTO> usuarios = this.usuarioService.listAll();
		model.addAttribute(LIST_ATTRIBUTE, usuarios);
		return PATH_PAGES_URL + "/list";
	}
	

	
	//Los datos de Registro (telefono, direccion, cod postal) tienen que ser pedidos posteriormente
	//no cuando se crea el usuario Comprador
	@GetMapping(value = PATH_CONTEXT_URL + "/new")
	public String newUser(Model model) {
	    model.addAttribute(FORM_ATTRIBUTE, new CompradorForm());
	    return PATH_PAGES_URL + PATH_CONTEXT_FORM_URL;
	}

	
	@GetMapping(value = PATH_CONTEXT_URL + "/edit")
	public String edit(Model model, @RequestParam(name = "id", defaultValue = "-1") Long id) {
		CompradorForm formularioComprador = new CompradorForm();
		if (id != null && id > 0) {
			Usuario usuario = usuarioService.obtenerId(id);
			formularioComprador.setId(usuario.getId());
			formularioComprador.setEmail(usuario.getEmail());
			formularioComprador.setContrasenia(usuario.getContrasenia());
			if (usuario instanceof Comprador) {
				Comprador comprador = (Comprador) usuario;
				formularioComprador.setNombre(comprador.getNombre());
				formularioComprador.setApellido(comprador.getApellido());
			}
		}
		model.addAttribute(FORM_ATTRIBUTE, formularioComprador);
		return PATH_PAGES_URL + PATH_CONTEXT_FORM_URL;
	}

	@PostMapping(value = PATH_CONTEXT_URL + "/save")
	public String save(@Validated @ModelAttribute(name = FORM_ATTRIBUTE) CompradorForm formulario,
			BindingResult binderResults) {
		String returnPath = null;
		if (!binderResults.hasErrors()) {
			if (formulario.existeUsuarioComprador()) {
				Usuario usuario = usuarioService.obtenerId(formulario.getId());
				usuario.setEmail(formulario.getEmail());
				if (formulario.getContrasenia() != null && !formulario.getContrasenia().isBlank()) {
					usuario.setContrasenia(formulario.getContrasenia());
				}
				if (usuario instanceof Comprador) {
					Comprador comprador = (Comprador) usuario;
					comprador.setNombre(formulario.getNombre());
					comprador.setApellido(formulario.getApellido());
				}
				usuarioService.guardarUsuario(usuario);
			} else {
				Comprador comprador = new Comprador().generarNuevoComprador(formulario.devolverComprador());
				this.usuarioService.guardarUsuario(comprador);
			}
			returnPath = "redirect:" + PATH_CONTEXT_URL;
		} else {
			returnPath = PATH_PAGES_URL + PATH_CONTEXT_FORM_URL;
		}
		return returnPath;
	}

}
