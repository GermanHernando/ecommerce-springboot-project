package com.mycompany.services;

import com.mycompany.models.Usuario;

public interface JWTService {

	public String buildToken(Usuario usuario);
	
	
}
