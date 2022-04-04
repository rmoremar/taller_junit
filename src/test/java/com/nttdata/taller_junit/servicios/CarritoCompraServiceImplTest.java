package com.nttdata.taller_junit.servicios;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.nttdata.taller_junit.modelos.Articulo;

@RunWith(MockitoJUnitRunner.class)
public class CarritoCompraServiceImplTest {

	@InjectMocks
	private CarritoCompraServiceImpl carritoService = new CarritoCompraServiceImpl();

	@Mock
	private BaseDeDatosService bbdd;

	@Test
	public void testLimpiarCesta() {
		carritoService.addArticulo(new Articulo("Platanos", 15.99));
		assertFalse(carritoService.getArticulos().isEmpty());
		carritoService.limpiarCesta();
		assertTrue(carritoService.getArticulos().isEmpty());
	}

	@Test
	public void testAddArticulo() {
		carritoService.limpiarCesta();
		Articulo aux = new Articulo("Zanahorias", 1.11);
		carritoService.addArticulo(aux);
		assertFalse(carritoService.getArticulos().isEmpty());
	}

	@Test
	public void testGetNumArticulos() {
		carritoService.limpiarCesta();
		carritoService.addArticulo(new Articulo("Albaricoque", 3.8));
		carritoService.addArticulo(new Articulo("Zanahorias", 1.11));
		carritoService.addArticulo(new Articulo("Melocoton", 1.5));
		assertTrue(carritoService.getNumArticulos() == 3);
	}

	@Test
	public void testGetArticulos() {
		carritoService.limpiarCesta();
		carritoService.addArticulo(new Articulo("Albaricoque", 3.8));
		carritoService.addArticulo(new Articulo("Zanahorias", 1.11));
		carritoService.addArticulo(new Articulo("Melocoton", 1.5));
		for (Articulo articulo : carritoService.getArticulos()) {
			assertNotNull(articulo);
		}
	}

	@Test
	public void testTotalPrice() {
		carritoService.limpiarCesta();
		carritoService.addArticulo(new Articulo("Albaricoque", 3.5));
		carritoService.addArticulo(new Articulo("Zanahorias", 1.0));
		carritoService.addArticulo(new Articulo("Melocoton", 1.5));
		assertEquals(carritoService.totalPrice(), 6, 2);
	}

	@Test
	public void testCalcularDescuento() {
		assertEquals(carritoService.calcularDescuento(100.0, 21.0), 79, 2);
	}

	@Test
	public void testAplicarDescuento() {
		Articulo art = new Articulo("Camiseta", 20.0);
		when(bbdd.findArticuloById(1)).thenReturn(art);
		Double res = carritoService.aplicarDescuento(1, 10.0);
		assertEquals(res, Double.valueOf(18));
	}
	
	@Test
	public void testInsertar() {
		
	}
	
}
