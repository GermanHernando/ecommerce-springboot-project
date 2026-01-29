package arg.tech.initspring.domain.model;

public abstract class Usuario {

	private String email;
	private String contrasenia;
	
	public Usuario(String email, String contrasenia) {
		this.email = email;
		this.contrasenia = contrasenia;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	
	
	
	
	
}
