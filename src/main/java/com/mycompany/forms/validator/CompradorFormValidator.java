package com.mycompany.forms.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import com.mycompany.forms.CompradorForm;

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
		if (cf.getNombre()==null || cf.getNombre().isBlank()) {
			errors.rejectValue("nombre", "nombre.empty");
		}
		
		if (cf.getApellido()==null || cf.getApellido().isBlank()) {
			errors.rejectValue("apellido", "apellido.empty");
		}
	}

}
