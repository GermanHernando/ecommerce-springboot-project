package models;

import java.time.LocalDateTime;

import enums.Estado;
import enums.MetodoPago;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAGOS")
public class Pago {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="FECHA_PAGO")
	private LocalDateTime fecha;
	@Column(name="MONTO")
	private double monto;
	@Column(name="METODO_PAGO")
	@Enumerated(EnumType.STRING)
	private MetodoPago metodo;
	@Column(name="ESTADO")
	@Enumerated(EnumType.STRING)
	private Estado estado;
	@Column(name = "PEDIDO_ID")
	private Long idPedido;
	
	Pago(){}
	
	public Pago(Long idPedido,LocalDateTime fecha, double monto) {
		this.fecha = fecha;
		this.monto = monto;
		this.estado = Estado.CREADO;
		
	}
	
	//TODO Considerar de seguir modelando con enums: Estado y MetodoPago + clase Envio
	
	//pagar()
	//cancelarPago()
	//incluirEnvio()?
}

