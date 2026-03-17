package com.mycompany.services;

import java.util.List;

import com.mycompany.models.Comprador;
import com.mycompany.models.Usuario;

public interface UsuarioServices {

	public Usuario obtenerId(Long id);
	
	public void guardarUsuario(Usuario usuario);
	
	public boolean existeUsuario(String email);

	public void eliminarComprador(Comprador c);

	public Usuario findByEmailAndPassword(String email, String contrasenia);
	
	public List<Usuario> listAll();
	
}
