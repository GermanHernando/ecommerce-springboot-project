package models;

import java.util.regex.Pattern;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario {

	private static final Pattern REGEX_EMAIL = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
	private static final Pattern REGEX_CONTRASENIA_MAYUS = Pattern.compile(".*[A-Z].*");
	private static final Pattern REGEX_CONTRASENIA_MINUS = Pattern.compile(".*[a-z].*");
	private static final Pattern REGEX_CONTRASENIA_NUMBER = Pattern.compile(".*\\d.*");
	private static final Pattern REGEX_CONTRASENIA_CHARACTER_ESP = Pattern.compile(".*[@$!%*?&].*");
	private static final String MSJ_ERROR_EMAIL = "El email no puede ser nulo o estar vacio";
	private static final String MSJ_ERROR_EMAIL_ESPACIOS = "El email no puede contener espacios";
	private static final String MSJ_ERROR_VALIDACION_EMAIL = "Introduzca un email valido";
	private static final String MSJ_CONTRASENIA_INVALIDA = "La contrasenia no puede ser nula o vacia";
	private static final String MSJ_ERROR_MAX_CONTRASENIA = "La contrasenia es demasiado larga";
	private static final String MSJ_ERROR_MIN_CONTRASENIA = "La contrasenia es demasiado corta";
	private static final String MSJ_ERROR_CONTRASENIA_MAYUS = "Debe contener al menos una mayuscula";
	private static final String MSJ_ERROR_CONTRASENIA_MINUS = "Debe contener al menos una minuscula";
	private static final String MSJ_ERROR_CONTRASENIA_NUMBER = "Debe contener al menos un numero";
	private static final String MSJ_ERROR_CONTRASENIA_CHARACTER_ESP = "Debe contener un caracter especial";
	private static final String MSJ_ERROR_CONTRASENIA_SPACES = "La contrasenia no puede contener espacios";
	private static final int MAX_TAMANIO_CONTRASENIA = 64;
	private static final int MIN_TAMANIO_CONTRASENIA = 8;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "CONTRASENIA")
	private String contrasenia;

	Usuario() {}

	public Usuario(String email, String contrasenia) {
		this.setEmail(email);
		this.setContrasenia(contrasenia);
	}

	//TODO Validar que no haya emails duplicados en DB
	public void setEmail(String email) {
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_EMAIL);
		}
		if (email.contains(" ")) {
			throw new IllegalArgumentException(MSJ_ERROR_EMAIL_ESPACIOS);
		}

		if (!validarRegexEmail(email)) {
			throw new IllegalArgumentException(MSJ_ERROR_VALIDACION_EMAIL);
		}
		this.email = email.toLowerCase().trim();
	}

	private boolean validarRegexEmail(String email) {
		return REGEX_EMAIL.matcher(email).matches();
	}

	public void setContrasenia(String contrasenia) {
		if (contrasenia == null || contrasenia.isBlank()) {
			throw new IllegalArgumentException(MSJ_CONTRASENIA_INVALIDA);
		}
		if (contrasenia.length()<MIN_TAMANIO_CONTRASENIA) {
			throw new IllegalArgumentException(MSJ_ERROR_MIN_CONTRASENIA);
		}
		if (contrasenia.length()>MAX_TAMANIO_CONTRASENIA) {
			throw new IllegalArgumentException(MSJ_ERROR_MAX_CONTRASENIA);
		}
		if (contrasenia.contains(" ")) {
			throw new IllegalArgumentException(MSJ_ERROR_CONTRASENIA_SPACES);
		}
		if (!validarMayusContrasenia(contrasenia)) {
			throw new IllegalArgumentException(MSJ_ERROR_CONTRASENIA_MAYUS);
		}
		if (!validarMinusContrasenia(contrasenia)) {
			throw new IllegalArgumentException(MSJ_ERROR_CONTRASENIA_MINUS);
		}
		if (!validarNumberContrasenia(contrasenia)) {
			throw new IllegalArgumentException(MSJ_ERROR_CONTRASENIA_NUMBER);
		}
		if (!validarEspecialCharacterContrasenia(contrasenia)) {
			throw new IllegalArgumentException(MSJ_ERROR_CONTRASENIA_CHARACTER_ESP);
		}
		this.contrasenia = contrasenia;
	}
	
	private boolean validarMayusContrasenia(String contrasenia) {
		return REGEX_CONTRASENIA_MAYUS.matcher(contrasenia).find();
	}
	
	private boolean validarMinusContrasenia(String contrasenia) {
		return REGEX_CONTRASENIA_MINUS.matcher(contrasenia).find();
	}
	
	private boolean validarNumberContrasenia(String contrasenia) {
		return REGEX_CONTRASENIA_NUMBER.matcher(contrasenia).find();
	}
	
	private boolean validarEspecialCharacterContrasenia(String contrasenia) {
		return REGEX_CONTRASENIA_CHARACTER_ESP.matcher(contrasenia).find();
	}
		
		
		
		
	// cambiarContrasenia()

}
