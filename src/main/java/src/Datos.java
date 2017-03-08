import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import javax.swing.JOptionPane;

/**
 * 
 * Clase encargada de la manipulaci�n de los datos, lee el archivo .txt cargado y almacena los datos le�dos
 * en una lista
 * @author Miguel �ngel Quintero P.
 * @version 05/03/2017
 * 
 * **/

public class Datos {
	/**Variables de la clase**/
	private LinkedList<Double> listaNumerosX = new LinkedList();
	private LinkedList<Double> listaNumerosY = new LinkedList();
	
	/**
	 * @param ruta. String con la ruta del archivo con la lista de n�meros x e y. 
	 * Metodo que crea las listas de n�meros teniendo en cuenta la ruta recibida.
	 *
	 * **/
	public void obtenerListasNumeros(String ruta){//Declaracion metodo
		try {
			BufferedReader bf = new BufferedReader(new FileReader(ruta));
			LinkedList<Double> listaTemporalX = new LinkedList();
			LinkedList<Double> listaTemporalY = new LinkedList();
			String lineaLeida; 
			double numeroTemporalX;
			double numeroTemporalY;
			String numerosTemporal [];
			while ((lineaLeida = bf.readLine()) != null) {
				numerosTemporal = lineaLeida.split(",");				
				numeroTemporalX = Double.parseDouble(numerosTemporal[0]);
				numeroTemporalY = Double.parseDouble(numerosTemporal[1]);
				listaTemporalX.add(numeroTemporalX);
				listaTemporalY.add(numeroTemporalY);
			}
			this.listaNumerosX = listaTemporalX;
			this.listaNumerosY = listaTemporalY;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error leyendo la ruta del archivo. Verifique que la ruta ingresada "
					+ "exista o que campo de la ruta no est� vac�o");
			System.exit(0);
		}
		
	}
	
	/**
	 * Metodo que retorna la lista de n�meros X
	 * @return lista de n�merosX
	 * **/
	public LinkedList<Double> devolverListaX(){//Declaracion metodo
		return this.listaNumerosX;
	}
	
	/**
	 * Metodo que retorna la lista de n�meros Y
	 * @return lista de n�merosY
	 * **/
	public LinkedList<Double> devolverListaY(){//Declaracion metodo
		return this.listaNumerosY;
	}
}
