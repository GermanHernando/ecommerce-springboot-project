package models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPRADORES")
public class Comprador extends Usuario {

	private static final String MSJ_ERROR_LARGO_DIRECCION = "La direccion debe tener entre 8 y 100 caracteres";
	private static final String MSJ_ERROR_NOMBRE = "El nombre no puede ser vacío o contener caracteres especiales";
	private static final String MSJ_ERROR_APELLIDO = "El apellido no puede ser vacío o contener caracteres especiales";
	private static final String MSJ_ERROR_DIRECCION_VACIA = "La direccion no puede estar vacia";
	private static final int MAX_CARACTERES_DIRECCION = 100;
	private static final int MIN_CARACTERES_DIRECCION = 8;
	private static final String MSJ_ERROR_TELEFONO = "El teléfono no puede ser 0(cero) y no puede ser un número menor a 8 ni mayor a 15 dígitos";
	private static final int MAX_CANT_CARACTERES_TELEFONO = 15;
	private static final int MIN_CANT_CARACTERES_TELEFONO = 8;
	private static final String REGEX_CODIGO_POSTAL = "^[A-Z]?[0-9]{4}[A-Z]{0,3}$";
	private static final String MSJ_ERROR_CODIGO_POSTAL_INVALIDO = "Codigo postal argentino invalido";
	private static final String MSJ_ERROR_CODIGO_POSTAL_VACIO = "Codigo postal no puede estar vacio";
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDO")
	private String apellido;
	@Column(name = "TELEFONO")
	private int telefono;
	@Column(name = "DIRECCION")
	private String direccion;
	@Column(name = "CODIGO_POSTAL")
	private String codigoPostal;
	// private Carrito carrito; El carrito puede ser usado como una instancia pero
	// el carrito, queda en caché, no se modela en la DB
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID", referencedColumnName = "ID")
	private Set<Pedido> pedidos;

	public Comprador() {
	}

	public Comprador(String email, String contrasenia, String nombre, String apellido, int telefono, String direccion,
			String codigoPostal) {
		super(email, contrasenia);
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		// this.carrito = new Carrito(this);
		this.pedidos = new HashSet<Pedido>();
	}

	// public void guardarProductoEnCarrito(Producto p, int cantidad) {
	// this.carrito.agregarItem(p, cantidad);
	// }

	// public void eliminarProductoDeCarrito(Producto p, int cantidad) {
	// this.carrito.eliminarItem(p, cantidad);
	// }

	public void setNombre(String nombre) {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_NOMBRE);
		}
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		if (apellido == null || apellido.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_APELLIDO);
		}
		this.apellido = apellido;
	}

	public void setTelefono(int telefono) {
		int cantCaracteres = String.valueOf(telefono).length();
		if (telefono == 0 || cantCaracteres < MIN_CANT_CARACTERES_TELEFONO
				|| cantCaracteres > MAX_CANT_CARACTERES_TELEFONO) {
			throw new IllegalArgumentException(MSJ_ERROR_TELEFONO);
		}
		this.telefono = telefono;
	}

	public void setDireccion(String direccion) {
		if (direccion == null || direccion.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_DIRECCION_VACIA);
		}
		if (direccion.length() < MIN_CARACTERES_DIRECCION || direccion.length() > MAX_CARACTERES_DIRECCION) {
			throw new IllegalArgumentException(MSJ_ERROR_LARGO_DIRECCION);
		}
		this.direccion = direccion;
	}

	public void setCodigoPostal(String codigoPostal) {
		 if (codigoPostal == null) {
		       throw new IllegalArgumentException(MSJ_ERROR_CODIGO_POSTAL_VACIO);
	    }
	    if (!codigoPostal.matches(REGEX_CODIGO_POSTAL)) {
	    	throw new IllegalArgumentException(MSJ_ERROR_CODIGO_POSTAL_INVALIDO);
		   }
	    this.codigoPostal = codigoPostal;
	}

	public void agregarPedido(Pedido p) {
		pedidos.add(p);
	}

	public void eliminarPedido(Pedido p) {
		pedidos.remove(p);
	}

}
