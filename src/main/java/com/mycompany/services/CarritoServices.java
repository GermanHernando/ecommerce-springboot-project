package com.mycompany.services;

import com.mycompany.models.Comprador;

import jakarta.servlet.http.HttpSession;

public interface CarritoServices {

	  public void agregarItem(Long productoId, int cantidad, Comprador comprador, HttpSession session);
	
}