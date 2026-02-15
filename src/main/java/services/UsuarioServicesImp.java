package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Usuario;
import repositories.UsuarioRepository;

@Service
public class UsuarioServicesImp implements UsuarioServices {

	@Autowired
	private UsuarioRepository repository;
	
	
	@Override
	public void guardar(Usuario usuario) {
		this.repository.save(usuario);
	}

}
