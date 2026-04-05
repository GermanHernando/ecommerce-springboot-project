package com.mycompany.forms.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.forms.LoginForm;
import com.mycompany.models.validator.UsuarioValidator;
import com.mycompany.services.UsuarioServices;

import exceptions.QuantityCharactersException;

public class LoginFormValidator implements Validator {

	//TODO Consultar, está bien si reutilizo la clase UsuarioServices? O debería tener un LoginServices?
	@Autowired
	protected UsuarioServices userServices;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginForm lf = (LoginForm)target;
		try {
			UsuarioValidator.emailValidator(lf.getEmail());
			boolean existe = userServices.existeUsuario(lf.getEmail());
			if (existe)errors.rejectValue("email", "email.already.exists");
		} catch (QuantityCharactersException e) {
			errors.rejectValue("email", "email.invalid.length");
		} catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			if (msg.contains("nulo") || msg.contains("vacio")) {
				errors.rejectValue("email", "email.empty");
			} else if (msg.contains("espacios")) {
				errors.rejectValue("email", "email.spaces");
			} else {
				errors.rejectValue("email", "email.invalid.format");
			}
		}

		try {
			UsuarioValidator.contraseniaValidator(lf.getPassword());
		} catch (QuantityCharactersException e) {
			errors.rejectValue("contrasenia", "contrasenia.invalid.length");
		} catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			if (msg.contains("nula") || msg.contains("vacia")) {
				errors.rejectValue("contrasenia", "contrasenia.empty");
			} else if (msg.contains("espacios")) {
				errors.rejectValue("contrasenia", "contrasenia.spaces");
			} else if (msg.contains("mayuscula")) {
				errors.rejectValue("contrasenia", "contrasenia.no.uppercase");
			} else if (msg.contains("minuscula")) {
				errors.rejectValue("contrasenia", "contrasenia.no.lowercase");
			} else if (msg.contains("numero")) {
				errors.rejectValue("contrasenia", "contrasenia.no.number");
			} else if (msg.contains("especial")) {
				errors.rejectValue("contrasenia", "contrasenia.no.special.char");
			}
		}
	}

}
