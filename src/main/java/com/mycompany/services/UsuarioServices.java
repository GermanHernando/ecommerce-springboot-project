package com.mycompany.services;

import java.util.List;

import com.mycompany.dtos.UsuarioDTO;
import com.mycompany.models.Usuario;

public interface UsuarioServices {

	public Usuario obtenerId(Long id);
	
	public void guardarUsuario(Usuario usuario);
	
	public boolean existeUsuario(String email);

	public void eliminarUsuario(Usuario u);

	public Usuario findByEmailAndPassword(String email, String contrasenia);
	
	public List<UsuarioDTO> listAll();
	
}
