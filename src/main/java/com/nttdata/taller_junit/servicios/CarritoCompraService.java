package com.nttdata.taller_junit.servicios;

import java.util.List;

import com.nttdata.taller_junit.modelos.Articulo;

public interface CarritoCompraService {

	void limpiarCesta();
	
	void addArticulo(Articulo articulo);
	
	Integer getNumArticulos();
	
	List<Articulo> getArticulos();
	
	Double totalPrice();
	
	Double calcularDescuento(Double precio, Double porcentaje);
	
	Double aplicarDescuento(Integer idArticulo, Double porcentajeDescuento);
	
	Integer insertar(Articulo art);
}
