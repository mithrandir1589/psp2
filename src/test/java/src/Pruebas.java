import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Pruebas {

	@Test
	public void pruebaObtenerListaX() {//Prueba método devolverListaX() de la clase Datos
		Datos d = new Datos();
		d.obtenerListasNumeros("D:\\numeros.txt");//Debe ser una ruta valida en el equipo
		LinkedList<Double> listaPruebaNumerosX = new LinkedList();
		listaPruebaNumerosX.add((double) 130);
		listaPruebaNumerosX.add((double) 650);
		listaPruebaNumerosX.add((double) 99);
		listaPruebaNumerosX.add((double) 150);
		listaPruebaNumerosX.add((double) 128);
		listaPruebaNumerosX.add((double) 302);
		listaPruebaNumerosX.add((double) 95);
		listaPruebaNumerosX.add((double) 945);
		listaPruebaNumerosX.add((double) 368);
		listaPruebaNumerosX.add((double) 961);
		
		assertEquals(listaPruebaNumerosX, d.devolverListaX());
		
	}
	@Test
	public void pruebaObtenerListaY() {//Prueba método devolverListaX() de la clase Datos
		Datos d = new Datos();
		d.obtenerListasNumeros("D:\\numeros.txt");//Debe ser una ruta valida en el equipo
		LinkedList<Double> listaPruebaNumerosY = new LinkedList();
		listaPruebaNumerosY.add((double) 15);
		listaPruebaNumerosY.add((double) 69.9);
		listaPruebaNumerosY.add((double) 6.5);
		listaPruebaNumerosY.add((double) 22.4);
		listaPruebaNumerosY.add((double) 28.4);
		listaPruebaNumerosY.add((double) 65.9);
		listaPruebaNumerosY.add((double) 19.4);
		listaPruebaNumerosY.add((double) 198.7);
		listaPruebaNumerosY.add((double) 38.8);
		listaPruebaNumerosY.add((double) 138.2);
		
		assertEquals(listaPruebaNumerosY, d.devolverListaY());
		
	}
	
	@Test
	public void pruebaObtenerBetaUno(){
		Calculos c = new Calculos();
		c.inicializarValores("D:\\numeros.txt");//Debe ser una ruta valida en el equipo
		assertEquals(0.1681, c.getBetaUno(),0.0001);
	}
	
	@Test
	public void pruebaObtenerBetaCero(){
		Calculos c = new Calculos();
		c.inicializarValores("D:\\numeros.txt");//Debe ser una ruta valida en el equipo
		assertEquals(-4.0388, c.getBetaCero(),0.0001);
	}
	
	@Test
	public void pruebaObtenerCoeficiente(){
		Calculos c = new Calculos();
		c.inicializarValores("D:\\numeros.txt");//Debe ser una ruta valida en el equipo
		assertEquals(0.9333, c.getCoeficiente(),0.0001);
	}
	
}
