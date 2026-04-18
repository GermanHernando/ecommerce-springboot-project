package com.mycompany.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mycompany.models.Usuario;

@Service
public class JWTServiceImp implements JWTService {

	@Override
	public String buildToken(Usuario usuario) {
		return JWT.create().withKeyId("my-app-"+usuario.getId())
					.withClaim("authorization", this.obtenerPermisosUsuarios(usuario))
					.sign(Algorithm.HMAC512("my-secret-password"));
	}
	
	private List<String>obtenerPermisosUsuarios(Usuario usuario){
		List<String>permisos = new ArrayList<String>();
		for (GrantedAuthority auth : usuario.coleccionAutorizaciones() ) {
			permisos.add(auth.getAuthority());
		}
		return permisos;
	}

}
