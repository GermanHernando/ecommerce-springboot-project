package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Usuario;
import repositories.UsuarioRepository;

@Service
public class UsuarioServicesImp implements UsuarioServices {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public Usuario obtenerId(Long id) {
		Optional<Usuario> usuario = this.repository.findById(id);
		return usuario.isPresent()?usuario.get():null;
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		this.repository.save(usuario);
	}

	@Override
	public boolean existeUsuario(String email) {
		boolean existe = false;
		if (email != null) {
			List<Usuario> usuarios = this.repository.findByEmail(email);
			existe = !usuarios.isEmpty();
		}
		return existe;
	}

}
