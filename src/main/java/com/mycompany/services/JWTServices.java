package com.mycompany.services;

import org.springframework.security.core.Authentication;

import com.mycompany.models.Usuario;

public interface JWTServices {

	public static final String PREFIX_TOKEN = "Bearer";

	public String buildToken(Usuario usuario);
	
	Authentication buildAuthentication(String token);
}
