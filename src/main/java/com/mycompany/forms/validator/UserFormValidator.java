package com.mycompany.forms.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.exceptions.QuantityCharactersException;
import com.mycompany.exceptions.UserEmailException;
import com.mycompany.exceptions.UserPasswordException;
import com.mycompany.forms.UsuarioForm;
import com.mycompany.models.validator.UsuarioValidator;
import com.mycompany.services.UsuarioServices;

public abstract class UserFormValidator implements Validator {

	@Autowired
	protected UsuarioServices userServices;

	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UsuarioForm uf = (UsuarioForm) target;
		try {
			UsuarioValidator.emailValidator(uf.getEmail());
			boolean existe = userServices.existeUsuario(uf.getEmail());
			if (existe) errors.rejectValue("email", "email.already.exists");
		} catch (QuantityCharactersException e) {
			errors.rejectValue("email", e.getMessage());
		} catch (UserEmailException e) {
			errors.rejectValue("email", e.getMessage());
		}

		try {
			UsuarioValidator.contraseniaValidator(uf.getContrasenia());
		} catch (QuantityCharactersException e) {
			errors.rejectValue("contrasenia", e.getMessage());
		} catch (UserPasswordException e) {
			errors.rejectValue("contrasenia", e.getMessage());
		}
	}

}
