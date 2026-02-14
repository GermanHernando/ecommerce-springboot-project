package model;

import java.util.regex.Pattern;

public abstract class Usuario {

	private static final String MSJ_CONTRASENIA_INVALIDA = "La contrasenia no puede ser nula o vacía.";
	private Integer id;
	private String email;
	private String contrasenia;
	private String contraseniaAnterior;
	
	public Usuario(String email, String contrasenia) {
		this.email = email;
		this.setContrasenia(contrasenia);
		this.contraseniaAnterior = contrasenia;
	}

	public void setEmail(String email) {
		if(validarEmail(email)) {
			this.email = email;
		}
	}
	
	private  boolean validarEmail(String email) {
		String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		return Pattern.matches(regex, email);
	}
	

	public void setContrasenia(String contrasenia) {
		if(contrasenia==null || contrasenia.isBlank()) {
			throw new IllegalArgumentException(MSJ_CONTRASENIA_INVALIDA);
		}
		this.contrasenia = contrasenia;	
	}
	
	//cambiarContrasenia()
	
	
	
	
	
	
}
