import javax.swing.JOptionPane;
/**
 * Clase encargada de construir y mostrar la interfaz de la aplicaci�n. Se comunica unicamente con la clase Calculos
 * @author Miguel �ngel Quintero
 * @version 05/03/2017
 *
 */
public class Interfaz {
	/**
	 * M�todo main invoca el m�todo cargarPantalla 
	 * @param args
	 */
	public static void main(String[] args) {//Declaracion metodo
		cargarPantalla();

	}
	/**Fin del m�todo**/
	
	/**
	 * M�todo encargado de instanciar la clase Calculos, para realizar la invocaci�n del m�todo inicializarValores, al que 
	 * le pasa como parametro la ruta ingresada en el campo de texto que aparece en pantalla, que de ser correcta devuelve 
	 * el promedio y la desviaci�n de los n�meros presentes en la lista ingresada. 
	 */
	public static void cargarPantalla(){//Declaracion metodo
		Calculos c = new Calculos();
		String rutaArchivo = JOptionPane.showInputDialog("Ingrese la ruta del archivo");
		if(rutaArchivo == null || rutaArchivo.isEmpty()){
			JOptionPane.showMessageDialog(null, "Debe ingresar una ruta en el campo de texto");
			System.exit(0);
		}
		String xK = JOptionPane.showInputDialog("Ingrese Xk");
		if(xK == null || xK.isEmpty()){
			JOptionPane.showMessageDialog(null, "Xk debe ser un n�mero v�lido y el campo no debe estar vacio");
			System.exit(0);
		}
		try {
			c.setXK(Double.parseDouble(xK));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al ingresar Xk. Xk debe ser un n�mero v�lido");
			System.exit(0);
		}
				
		c.inicializarValores(rutaArchivo);
		
		System.out.println("Bo: " + c.getBetaCero() + " | B1: " + c.getBetaUno() + " | Coeficiente correlaci�n: " + c.getCoeficiente() + " | Coeficiente al cuadrado: " + Math.pow(c.getCoeficiente(), 2) + " | Yk: " + c.getYK());
		
	}
	/**Fin del m�todo **/
}
