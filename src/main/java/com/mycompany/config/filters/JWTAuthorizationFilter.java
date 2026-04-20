package com.mycompany.config.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mycompany.services.JWTServices;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Autowired
	private JWTServices jwtService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (existeTokenJWT(request)) {
			String token = fetchToken(request);
			Authentication auth = jwtService.buildAuthentication(token);
			
			SecurityContext contexto = SecurityContextHolder.getContext();
			contexto.setAuthentication(auth);
			
		}
		filterChain.doFilter(request, response);
	}

	private boolean existeTokenJWT(HttpServletRequest request) {
		String value = request.getHeader(HttpHeaders.AUTHORIZATION);
		return (value != null && value.startsWith(JWTServices.PREFIX_TOKEN));
	}

	private String fetchToken(HttpServletRequest request) {
		String value = request.getHeader(HttpHeaders.AUTHORIZATION);
		String[] segmentos = value.split(" ");
		return segmentos[1];
	}

}
