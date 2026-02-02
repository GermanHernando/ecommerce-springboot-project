package model;

import java.time.LocalDateTime;

import enums.MetodoPago;

public class Pago {

	private static int idPago;
	private LocalDateTime fecha;
	private double monto;
	private MetodoPago metodo;
	
	public Pago(LocalDateTime fecha, double monto) {
		idPago++;
		this.fecha = fecha;
		this.monto = monto;
		
	}
	
	//TODO Considerar de seguir modelando con enums: Estado y MetodoPago + clase Envio
	
	//pagar()
	//cancelarPago()
	//incluirEnvio()?
}

