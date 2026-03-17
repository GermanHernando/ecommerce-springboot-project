package com.mycompany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.models.Comprador;
import com.mycompany.models.Usuario;
import com.mycompany.repositories.UsuarioRepository;

@Service
public class UsuarioServicesImp implements UsuarioServices {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public Usuario obtenerId(Long id) {
		Optional<Usuario> usuario = this.repository.findById(id);
		return usuario.isPresent() ? usuario.get() : null;
	}

	@Override
	@Transactional
	public void guardarUsuario(Usuario usuario) {
		  System.out.println("Guardando usuario: " + usuario.getEmail());
		    System.out.println("Activo: " + usuario.isActivo());
		    this.repository.save(usuario);
		    System.out.println("Usuario guardado con ID: " + usuario.getId());
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

	@Override
	public void eliminarComprador(Comprador c) {
		repository.delete(c);
	}


	public Usuario findByEmailAndPassword(String email, String password) {
	    List<Usuario> usuarios = repository.findByEmailAndContrasenia(email, password);
	    return usuarios.isEmpty() ? null : usuarios.get(0);
	}

	@Override
	public List<Usuario> listAll() {
		return this.repository.findAll();
	}
}
