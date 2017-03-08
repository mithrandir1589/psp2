import java.util.LinkedList;

/**
 * Clase encargada de realizar los c�lculos y la comunicaci�n entre la clase Interfaz y la clase Datos. Realiza
 * los calculos de parametros de regresi�n, coeficiente de correlaci�n. 
 * @author Miguel �ngel Quintero 
 * @version 05/03/2017
 * 
 **/
public class Calculos {
	/**Variables de la clase **/
	private double promedioX;
	private double promedioY;
	private String rutaArchivo;
	private double betaCero;
	private double betaUno;
	private double coeficienteCorrelacion;
	private double yK;
	private double xK;
	
	private LinkedList<Double> listaNumerosX;
	private LinkedList<Double> listaNumerosY;
	/**
	 * M�todo que obtiene la ruta del archivo y se la asigna a la variable rutaArchivo de esta clase para que sea usada por 
	 * cualquiera de los m�todos de la misma.
	 * @param rutaArchivo Ruta del archivo
	 */
	private void obtenerRutaArchivo(String rutaArchivo){//Declaracion metodo
		this.rutaArchivo = rutaArchivo;		
	}
	/**Fin del m�todo**/
	
	/**
	 * M�todo encargado de obtener las lista de n�meros, obtenida de invocar el m�todo obtenerListasNumeros de la clase Datos
	 */
	private void configurarListaNumeros(){//Declaracion metodo
		Datos datos = new Datos();
		datos.obtenerListasNumeros(this.rutaArchivo);
		this.listaNumerosX = datos.devolverListaX();
		this.listaNumerosY = datos.devolverListaY();
	}
	/**Fin del m�todo **/
	
	/**
	 * M�todo que invoca los m�todos que permiten obtener la ruta del archivo y la lista de n�meros
	 * @param ruta Ruta del archivo
	 */
	public void inicializarValores(String ruta){//Declaracion metodo
		obtenerRutaArchivo(ruta);
		configurarListaNumeros();
		calcularPromedio();
		calcularBetaUnoYCoeficiente();
		calcularBetaCero();
		calcularYK();
	}
	/**Fin del m�todo**/
	
	/**
	 * M�todo encargado de calcular el promedio, usando los datos presentes en la lista de n�meros listaNumerosX y listaNumerosY
	 */
	private void calcularPromedio(){//Declaracion metodo
		double sumaX = 0;
		double sumaY = 0;
		int cantidadNumeros = this.listaNumerosX.size();
		for (int i = 0; i < cantidadNumeros ; i++){
			sumaX = sumaX + this.listaNumerosX.get(i);
			sumaY = sumaY + this.listaNumerosY.get(i);
		}
		this.promedioX = (double) sumaX / cantidadNumeros;
		this.promedioY = (double) sumaY / cantidadNumeros;
	}
	/** Fin del m�todo **/
	
	/**
	 * Metodo encargado de calcular el parametro beta sub uno y el coeficiente de correlacion
	 */
	private void calcularBetaUnoYCoeficiente(){//Declaracion metodo
		double sumaProductoXY = 0;
		double cantidadNumeros = this.listaNumerosX.size();
		double sumaX = 0;
		double sumaY = 0;
		double sumaCuadradosY = 0;
		double productoPromediosCantidadNumeros = cantidadNumeros * this.promedioX * this.promedioY;
		double sumaCuadradosX = 0;
		double productoPromedioXCuadrado = cantidadNumeros * Math.pow(this.promedioX,2);
		
		double numeradorCoeficiente = 0;
		double denominadorCoeficiente = 0;
		for ( int i = 0; i< cantidadNumeros; i++){
			sumaProductoXY = sumaProductoXY + (this.listaNumerosX.get(i) * this.listaNumerosY.get(i));
			sumaX = sumaX + this.listaNumerosX.get(i);
			sumaY = sumaY + this.listaNumerosY.get(i);			
			sumaCuadradosX = sumaCuadradosX + (Math.pow(this.listaNumerosX.get(i),2));
			sumaCuadradosY = sumaCuadradosY + (Math.pow(this.listaNumerosY.get(i),2));
		}
		numeradorCoeficiente = (cantidadNumeros * sumaProductoXY) - (sumaX * sumaY);
		denominadorCoeficiente = Math.sqrt( ((cantidadNumeros * sumaCuadradosX) - Math.pow(sumaX, 2)) * ((cantidadNumeros * sumaCuadradosY) - Math.pow(sumaY, 2)) );
		this.coeficienteCorrelacion = numeradorCoeficiente / denominadorCoeficiente;
		this.betaUno = (sumaProductoXY - productoPromediosCantidadNumeros) / (sumaCuadradosX - productoPromedioXCuadrado);		
	}
	/**Fin del m�todo**/
	
	/**
	 * M�todo encargado de retornar el parametro beta sub uno
	 * @return betaUno Valor del parametro beta sub uno
	 */
	public double getBetaUno(){//Declaracion metodo
		return this.betaUno;
	}
	/**Fin del m�todo**/
	
	/**
	 * M�todo encargado de calcular el parametro beta sub cero 
	 */
	private void calcularBetaCero(){//Declaracion metodo
		this.betaCero = this.promedioY - (this.betaUno * this.promedioX);
	}
	/**Fin del m�todo**/
	
	/**
	 * M�todo encargado de retornar el parametro beta sub uno
	 * @return betaUno Valor del parametro beta sub uno
	 */
	public double getBetaCero(){//Declaracion metodo
		return this.betaCero;
	}
	/**Fin del metodo**/
	
	/**
	 * M�todo encargado de retornar el parametro xK
	 * @param xK
	 */
	public void setXK(double xK){//Declaracion metodo
		this.xK = xK;
	}
	/**Fin del m�todo**/
	
	/**
	 * M�todo encargado de calcular el parametro yK
	 */
	private void calcularYK(){//Declaracion metodo 
		this.yK = this.betaCero + (this.betaUno * this.xK);
	}
	/**Fin del m�todo**/
	
	/**
	 * M�todo encargado de retornar el parametro yK
	 * @return yK
	 */
	public double getYK(){//Declaracion metodo
		return this.yK;
	}
	/**Fin del m�todo**/
	
	/**
	 * M�todo encargado de retornar el coeficiente de correlacion
	 * @return coeficienteCorrelacion
	 */
	public double getCoeficiente(){//Declaracion metodo
		return this.coeficienteCorrelacion;
	}
	
	
}
