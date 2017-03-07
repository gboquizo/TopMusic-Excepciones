package utiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Permite lectura desde teclado
 */
public class Teclado {

	/**
	 * Lee un carácter del teclado
	 * 
	 * @return carácter introducido por el usuario
	 */
	public static char leerCaracter() {
		char caracter = 0;
		boolean valida = false;
		do {
			try {
				caracter = leerCadena().charAt(0);
				valida = true;
			} catch (Exception e) {
				System.err.println("Error, introduce un carácter");
			}
		} while (!valida);
		return caracter;
	}

	/**
	 * Lee un carácter del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return carácter introducido por el usuario
	 */
	public static char leerCaracter(String msj) {
		System.out.println(msj);
		return leerCaracter();
	}

	/**
	 * Lee una cadena del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return cadena introducida por el usuario
	 */
	public static String leerCadena(String msj) {
		System.out.println(msj);
		return leerCadena();
	}

	/**
	 * Lee una cadena del teclado
	 * 
	 * @return cadena introducida por el usuario
	 */

	public static String leerCadena() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String cadena;
		boolean valida = false;
		do {
			try {
				cadena = bReader.readLine(); // Lee una línea de texto (hasta
												// intro)
				valida = true;
			} catch (IOException e) {
				System.err.println("Error, debes introducir una cadena");
				cadena = "";
			}
		} while (!valida);
		return cadena;
	}

	/**
	 * Lee un entero del teclado
	 * 
	 * 
	 * @return entero introducido por el usuario
	 */
	public static int leerEntero() {
		int x = 0;
		boolean valida = false;
		do {
			try {
				x = Integer.parseInt(leerCadena().trim()); // Quita los espacios
															// del
															// String y
															// convierte a
				valida = true; // int
			} catch (Exception e) {
				System.err.println("Error, esto no es un entero. Introduce un entero");
			}
		} while (!valida);
		return x;
	}

	/**
	 * Lee una entero del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return entero introducida por el usuario
	 */
	public static int leerEntero(String msj) {
		System.out.println(msj);
		return leerEntero();
	}

	/**
	 * Lee un decimal del teclado
	 * 
	 * @return decimal introducido por el usuario
	 */
	public static double leerDecimal() {
		double x = 0;
		boolean valida = false;
		do {
			try {
				x = Double.parseDouble(leerCadena().trim()); // Quita los
																// espacios
				valida = true; // del String y
				// convierte a
				// double
			} catch (Exception e) {
				System.err.println("Error, esto no es un decimal.Introduce un decimal");
			}
		} while (!valida);
		return x;
	}

	/**
	 * Lee un decimal del teclado
	 * 
	 * @param msj
	 *            mensaje mostrado al usuario
	 * @return decimal introducida por el usuario
	 */
	public static double leerDecimal(String msj) {
		System.out.println(msj);
		return leerDecimal();
	}

	/**
	 * Permite continuar introduciendo un caracter por teclado.
	 * 
	 * @param msg,
	 *            mensaje a mostrar al usuario
	 * @return si desea continuar o no.
	 */
	public static boolean deseaContinuar(String msg) {
		switch (Teclado.leerCaracter(msg)) {
		case 'n':
		case 'N':
			return false;
		default:
			return true;
		}
	}

	/**
	 * Devuelve un entero mayor que cero
	 * 
	 * @param msj
	 *            Mensaje que solicita la entrada de datos
	 * @return entero mayor que cero
	 */
	public static int leerEnteroPositivo(String msj) {
		int x;
		do {
			x = leerEntero(msj);
		} while (x <= 0);
		return x;
	}
}