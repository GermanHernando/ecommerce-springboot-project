package com.mycompany.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.mycompany.api.rest.LoginApiRestService;
import com.mycompany.config.filters.JWTAuthorizationFilter;
import com.mycompany.controllers.LoginController;
import com.mycompany.enums.Permiso;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private JWTAuthorizationFilter jwtFilter;
	
	
	@Bean
	public SecurityFilterChain apifilterChain(HttpSecurity http)throws Exception {
		
		return http.securityMatcher("/api/**")
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(request -> request.requestMatchers(LoginApiRestService.API_LOGIN_URL).permitAll() 
			.anyRequest().authenticated())
			.csrf(csrt -> csrt.disable())
			.addFilterAfter(this.jwtFilter, BasicAuthenticationFilter.class)
			.build();						
	}
	
	
	@Bean
	public SecurityFilterChain webfilterChain(HttpSecurity http)throws Exception {
		
	return	http.securityMatcher("/**")
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
			.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()))
			.authorizeHttpRequests(auth -> auth.requestMatchers("/css/**", "/images/**", "/javascript/**").permitAll()
			.requestMatchers("/login","/sigin","/index","/register").permitAll()
			.requestMatchers("/admin/**").hasAnyRole(Permiso.ADMINISTRADOR.name())
			.anyRequest().authenticated())
		.formLogin(page -> page.loginPage(LoginController.PATH_CONTEXT_URL_LOGIN).permitAll())
		.build();
		
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return (request,response,accessDeniedException) ->{
			response.sendRedirect(LoginController.PATH_CONTEXT_URL_LOGIN);
		};
	}
	
	
	
	
	 
	
	
	

}
