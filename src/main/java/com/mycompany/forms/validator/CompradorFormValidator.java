package com.mycompany.forms.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.mycompany.exceptions.QuantityCharactersException;
import com.mycompany.forms.CompradorForm;
import com.mycompany.models.validator.CompradorValidator;

@Component
public class CompradorFormValidator extends UserFormValidator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CompradorForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		super.validate(target, errors);
		 CompradorForm cf = (CompradorForm) target;
		 
		 try {
	            CompradorValidator.nombreValidator(cf.getNombre());
	        } catch (QuantityCharactersException e) {
	            errors.rejectValue("nombre", "nombre.invalid.length");
	        } catch (IllegalArgumentException e) {
	            errors.rejectValue("nombre", "nombre.empty");
	        }

	        try {
	            CompradorValidator.apellidoValidator(cf.getApellido());
	        } catch (QuantityCharactersException e) {
	            errors.rejectValue("apellido", "apellido.invalid.length");
	        } catch (IllegalArgumentException e) {
	            errors.rejectValue("apellido", "apellido.empty");
	        }
	    }

}
