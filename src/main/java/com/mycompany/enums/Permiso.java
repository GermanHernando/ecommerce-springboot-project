package com.mycompany.enums;

public enum Permiso {
ADMINISTRADOR,
COMPRADOR;

public String securityName() {
	return "ROLE_"+ name();
}
	
}
