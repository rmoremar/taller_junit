package com.nttdata.taller_junit.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nttdata.taller_junit.modelos.Articulo;

public class CarritoCompraServiceImpl implements CarritoCompraService {

	private List<Articulo> cesta = new ArrayList<>();
	
	@Autowired
	private BaseDeDatosService bbddService;

	@Override
	public void limpiarCesta() {
		cesta.clear();
	}

	@Override
	public void addArticulo(Articulo articulo) {
		cesta.add(articulo);
	}

	@Override
	public Integer getNumArticulos() {
		return cesta.size();
	}

	@Override
	public List<Articulo> getArticulos() {
		return cesta;
	}

	@Override
	public Double totalPrice() {
		Double total = 0.0;
		for (Articulo articulo : cesta) {
			total += articulo.getPrecio();
		}
		return total;
	}

	@Override
	public Double calcularDescuento(Double precio, Double porcentaje) {
		return precio - precio * porcentaje / 100;
	}

	@Override
	public Double aplicarDescuento(Integer idArticulo, Double porcentajeDescuento) {
		Double result = null;
		Articulo artBD = bbddService.findArticuloById(idArticulo);
		if (null != artBD) {
			result = calcularDescuento(artBD.getPrecio(), porcentajeDescuento);
		} else {
			System.out.println("No se ha encontrado el item " + idArticulo + " en BD");
		}
		return result;
	}

	@Override
	public Integer insertar(Articulo art) {
		Integer nuevoId = bbddService.insertArticulo(art);
		cesta.add(art);
		return nuevoId;
	}
	

}
