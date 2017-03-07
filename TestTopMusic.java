package topmusicexcepciones;

import topmusicexcepciones.excepciones.AutorNoValidoException;
import topmusicexcepciones.excepciones.CancionNoValidaException;
import topmusicexcepciones.excepciones.FechaNoValidaException;
import topmusicexcepciones.excepciones.PosicionNoValidaException;
import topmusicexcepciones.excepciones.TituloNoValido;
import utiles.Menu;
import utiles.Teclado;

/**
 * Top Music. Mejoremos la versión anterior. En este caso, antes de crear la
 * canción (mediante Cancion.getInstance()) realiza las comprobaciones de los
 * campos (usa expresiones regulares):
 * 
 * El título de la canción: Me too, Don´t let me down, 19 días y 500 noches,
 * Come... El autor/grupo: The B-52's, Jain... El año: Nunca posterior al año
 * actual
 * 
 * Entrega:
 * 
 * El código comprimido, como siempre url del github y lo tienes en un
 * repositorio
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 2.0
 */
public class TestTopMusic {
	private static TopMusic topMusic = new TopMusic();

	public static void main(String[] args) {
		Menu menu = new Menu("\nTop Music", new String[] { "Añadir canción", "Eliminar canción", "Subir un puesto",
				"Bajar un puesto", "Mostrar Top Music", "Mostrar la canción más escuchada", "Salir" });
		int opcion;

		do {
			opcion = menu.gestionar();
			gestionarOpcion(opcion);
		} while (opcion != menu.getSALIR());
	}

	private static void gestionarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			annadirCancion();
			break;
		case 2:
			eliminarCancion();
			break;
		case 3:
			subirCancion();
			break;
		case 4:
			bajarCancion();
			break;
		case 5:
			mostrarTop();
			break;
		case 6:
			mostrarTop1();
			break;
		case 7:
			salir();
			break;
		}

	}

	/**
	 * Muestra el nº 1 del top
	 */
	private static void mostrarTop1() {
		if (mostrarSiVacio())
			return;
		System.out.println(topMusic.masEscuchada());

	}

	/**
	 * Añade una cancion al top
	 * 
	 * @return
	 */
	private static void annadirCancion() {
		try {
			topMusic.annadir(
					Teclado.leerEntero("Introduce una posicion en el top (entre 1 y " + topMusic.size() + "):"),
					Teclado.leerCadena("Titulo: "), Teclado.leerCadena("Artista: "),
					Teclado.leerEntero("Año grabacion:(entre 1950 y el año actual): "));
				System.out.println("Cancion añadida!");
		} catch (CancionNoValidaException | TituloNoValido | AutorNoValidoException | FechaNoValidaException
				| PosicionNoValidaException e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Elimina una cancion del top
	 */
	private static void eliminarCancion() {
		if (mostrarSiVacio())
			return;
		try {
			if (!topMusic.sacar(topMusic.posicionValida(Teclado.leerEntero("Posicion:")))) {
				System.out.println("No se pudo eliminar");
			} else
				System.out.println("Cancion eliminada!");
		} catch (PosicionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Sube una cancion del top
	 */
	private static void subirCancion() {
		if (mostrarSiVacio())
			return;
		try {
			if (topMusic.subir(topMusic.posicionValida(Teclado.leerEntero("Posicion:"))))
				System.out.println("Cancion subida!");
			else
				System.err.println("No se puede subir la canción, ya es Top 1");
		} catch (PosicionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Baja una cancion del top1
	 */
	private static void bajarCancion() {
		if (mostrarSiVacio())
			return;
		try {
			if (topMusic.bajar(topMusic.posicionValida(Teclado.leerEntero("Posicion:"))))
				System.out.println("Cancion bajada!");
			else
				System.err.println("No se pudo bajar la cancion");
		} catch (PosicionNoValidaException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Muestra el top completo
	 */
	private static void mostrarTop() {
		if (mostrarSiVacio())
			return;
		System.out.println(topMusic.mostrarTopMusic());

	}

	/**
	 * Muestra un mensaje si la lista está vacía.
	 * 
	 * @return true si la lista está vacía. false en otro caso
	 */
	private static boolean mostrarSiVacio() {
		if (topMusic.isEmpty()) {
			System.err.println("Top Vacío. No se puede realizar la acción");
			return true;
		}
		return false;
	}

	/**
	 * Sale del programa
	 */
	private static void salir() {
		System.out.println("Adios!");
		System.exit(0);
	}
}