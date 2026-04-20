package com.mycompany.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mycompany.models.Usuario;

@Service
public class JWTServicesImp implements JWTServices {

	private final String KEY_EMAIL = "email";
	private final String KEY_AUTHORIZATION = "authorization";

	@Override
	public String buildToken(Usuario usuario) {
		return JWT.create().withKeyId("my-app-" + usuario.getId()).withClaim(KEY_EMAIL, usuario.getEmail())
				.withClaim(KEY_AUTHORIZATION, this.obtenerPermisosUsuarios(usuario))
				.sign(Algorithm.HMAC512("my-secret-password"));
	}

	@Override
	public Authentication buildAuthentication(String token) {
		DecodedJWT decodedToken = JWT.decode(token);
		String id = decodedToken.getKeyId();
		String email = decodedToken.getClaim(KEY_EMAIL).asString();
		Claim claim = decodedToken.getClaim(KEY_AUTHORIZATION);

		List<String> permisos = claim.asList(String.class);
		Authentication auth = new UsernamePasswordAuthenticationToken(id, email, convertirPermisos(permisos));
		return auth;
	}

	private List<String> obtenerPermisosUsuarios(Usuario usuario) {
		List<String> permisos = new ArrayList<String>();
		for (GrantedAuthority auth : usuario.coleccionAutorizaciones()) {
			permisos.add(auth.getAuthority());
		}
		return permisos;
	}

	private List<GrantedAuthority> convertirPermisos(List<String> permisos) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String permiso : permisos) {
			authorities.add(new SimpleGrantedAuthority(permiso));
		}
		return authorities;
	}

}
