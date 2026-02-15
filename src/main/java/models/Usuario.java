package models;


import java.util.regex.Pattern;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario {

	private static final String MSJ_CONTRASENIA_INVALIDA = "La contrasenia no puede ser nula o vacía.";
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="EMAIL")
	private String email;
	@Column(name="CONTRASENIA")
	private String contrasenia;
	
	public Usuario(String email, String contrasenia) {
		this.email = email;
		this.setContrasenia(contrasenia);
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
