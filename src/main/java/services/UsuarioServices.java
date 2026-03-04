package services;

import models.Comprador;
import models.Usuario;

public interface UsuarioServices {

	public Usuario obtenerId(Long id);
	
	public void guardarUsuario(Usuario usuario);
	
	public boolean existeUsuario(String email);

	public void eliminarComprador(Comprador c);
	
}
