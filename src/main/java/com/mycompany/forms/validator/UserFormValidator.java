package com.mycompany.forms.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.forms.UsuarioForm;
import com.mycompany.services.UsuarioServices;


public abstract class UserFormValidator implements Validator{
	
	@Autowired
	protected UsuarioServices userServices;

	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioForm.class.equals(clazz);
	}

	//FIXME utilizar una clase validator del models para evitar repetir tanto codigo
	//Reveer clase grabada para recordar parametros del "rejectValue", quizás le pase la excepcion que agarro del catch
	//Envolver en bloques try catch
	@Override
	public void validate(Object target, Errors errors) {
		UsuarioForm uf = (UsuarioForm)target;
		
		if (uf.getEmail()==null || uf.getEmail().isBlank()) {
			errors.rejectValue("email", "email.empty");
		}else {
			boolean existe = userServices.existeUsuario(uf.getEmail());
			if(existe) errors.rejectValue("email", "email.already.exists");
		}
		
		if (uf.getContrasenia()==null || uf.getContrasenia().isBlank()) {
			errors.rejectValue("contrasenia", "contrasenia.empty");
		}
		
	
		
		
	}

}
