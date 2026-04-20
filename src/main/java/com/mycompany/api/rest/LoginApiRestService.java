package com.mycompany.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.forms.LoginForm;
import com.mycompany.models.Usuario;
import com.mycompany.services.JWTServices;
import com.mycompany.services.UsuarioServices;

@RestController
public class LoginApiRestService  {
	
	public static final String API_LOGIN_URL = "/api/login";

	@Autowired
	private UsuarioServices userService;
	@Autowired
	private JWTServices jwtService;
	
	@PostMapping(value = API_LOGIN_URL, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestBody LoginForm loginFormulario) {
		String token = null;
		ResponseEntity<String> resultado = null;
		Usuario user = this.userService.findByEmailAndPassword(loginFormulario.getEmail(), loginFormulario.getPassword());
		if(user == null) {
			resultado = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}else {
			token = this.jwtService.buildToken(user);
			resultado = ResponseEntity.ok(token);
		}
		return resultado;
	}
	
	
	
	
}
