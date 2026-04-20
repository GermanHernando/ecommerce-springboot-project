package com.mycompany.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.mycompany.api.rest.LoginApiRestService;
import com.mycompany.config.filters.JWTAuthorizationFilter;
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
			.authorizeHttpRequests(auth -> auth.requestMatchers("/css/**", "/images/**", "/javascript/**").permitAll()
					.requestMatchers("/admin/**").hasAnyRole(Permiso.ADMINISTRADOR.name())
					.requestMatchers("/login","/sigin").permitAll()
					.anyRequest().permitAll())
		//FIXME Consultar, me tira un error en la url y no me deja loguearme pero si voy a /admin/users desde la url, funciona bien
		.formLogin(page -> page.loginPage("/login").permitAll().defaultSuccessUrl("/login"))
		.build();
		
	}
	 
	
	
	

}
