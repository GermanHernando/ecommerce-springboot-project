package com.mycompany.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.forms.CompradorForm;
import com.mycompany.models.Comprador;
import com.mycompany.models.Usuario;
import com.mycompany.services.UsuarioServices;

@Controller
public class UserAdminController {

	private static final String PATH_PAGES_URL = "admin/users"; // Template
	private static final String PATH_CONTEXT_URL = "/admin/users"; // Package
	private static final String FORM_ATTRIBUTE = "form";
	private static final String LIST_ATTRIBUTE = "listado";

	
	@Autowired
	private UsuarioServices usuarioService;

	@GetMapping(value = PATH_CONTEXT_URL)
	public String init(Model model) {
		List<Usuario>usuarios = this.usuarioService.listAll();
		model.addAttribute(LIST_ATTRIBUTE,usuarios);
		return PATH_PAGES_URL + "/list";
	}

	@GetMapping(value = PATH_CONTEXT_URL + "/edit")
	public String edit(Model model, @RequestParam(name = "id",defaultValue = "-1")Long id) {
		CompradorForm formularioComprador = new CompradorForm();
		if(id != null && id > 0) {
			Usuario usuario = usuarioService.obtenerId(id);
			formularioComprador.setId(usuario.getId());
			formularioComprador.setEmail(usuario.getEmail());
			formularioComprador.setContrasenia(usuario.getContrasenia());
			if(usuario instanceof Comprador) {
				Comprador comprador = (Comprador)usuario;
				formularioComprador.setNombre(comprador.getNombre());
				formularioComprador.setApellido(comprador.getApellido());				
			}
		}
		model.addAttribute(FORM_ATTRIBUTE, formularioComprador);
		return PATH_PAGES_URL + "/form";
	}

	@PostMapping(value = PATH_CONTEXT_URL + "/save")
	public String save(@ModelAttribute(name = FORM_ATTRIBUTE) CompradorForm formulario) {
		if(formulario.existeUsuarioComprador()) {
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
		}else {			
			Comprador comprador = formulario.devolverComprador();
			this.usuarioService.guardarUsuario(comprador);
		}
		
		return "redirect:" + PATH_CONTEXT_URL;
	}

}
