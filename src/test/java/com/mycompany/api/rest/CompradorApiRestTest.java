package com.mycompany.api.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.dtos.UsuarioDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "test")
public class CompradorApiRestTest {

	@LocalServerPort
	private int port;
	//Ya viene definida como component con Spring, es propio de esta libreria
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void listUsers() {
		URI uri = URI.create("http://localhost:" + this.port + CompradorApiRestService.PATH_USERS_URL);
		HttpRequest request = HttpRequest.newBuilder(uri).GET()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			//Devuelve lista de UsuariosDTO cuando lee el response.body()
			List<UsuarioDTO> usuarios = mapper.readerForListOf(UsuarioDTO.class).readValue(response.body());
			assertEquals(2,usuarios.size());
		} catch (Exception e) {
			fail(e.getCause());
		} 
	}
	//FIXME Consultar - Hay un error supuestamente en la configuración
}
