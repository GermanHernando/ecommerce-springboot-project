package com.mycompany.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.dtos.UsuarioDTO;
import com.mycompany.forms.CompradorForm;
import com.mycompany.services.UsuarioServices;

@RestController
public class CompradorApiRestService {

	public static final String PATH_USERS_URL = "/api/users";
	private static final String PATH_USERS_SAVE_URL = "/api/users/save";
	
	@Autowired
	private UsuarioServices userService;

	
	@GetMapping(value = PATH_USERS_URL, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsuarioDTO>> list() {
		List<UsuarioDTO> usuarios = this.userService.listAll();
		return ResponseEntity.ok(usuarios);
	}

	@PostMapping(value = PATH_USERS_SAVE_URL, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody CompradorForm compradorFormulario) {
		compradorFormulario.getEmail();
		
		return ResponseEntity.ok("Todo Ok");
	}

}
