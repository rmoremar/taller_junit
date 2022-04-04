package com.nttdata.taller_junit.servicios;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nttdata.taller_junit.modelos.Articulo;

@Service
public class BaseDeDatosService {

	Map<Integer, Articulo> storage = new HashMap<Integer, Articulo>();

	public BaseDeDatosService() {
		super();
		this.initBD();
	}

	public void initBD() {
		this.storage = new HashMap<Integer, Articulo>();
		storage.put(1, new Articulo("Camiseta", 18.0));
		storage.put(2, new Articulo("Jersey", 32.2));
		storage.put(3, new Articulo("Cinturon", 12.4));
		storage.put(4, new Articulo("Sudadera", 41.0));
		storage.put(5, new Articulo("Pantalon", 37.8));
		storage.put(6, new Articulo("Gorra", 15.7));
		storage.put(7, new Articulo("Zapato", 56.0));
		storage.put(8, new Articulo("Chaqueta", 90.5));
	}

	public Articulo findArticuloById(Integer idArticulo) {
		System.out.println("Buscando en BBDD el Articulo con ID: " + idArticulo);
		return storage.get(idArticulo);
	}
	
	public Integer insertArticulo(Articulo art) {
		storage.put(storage.size()+1, art);
		return storage.size()+1;
	}
}