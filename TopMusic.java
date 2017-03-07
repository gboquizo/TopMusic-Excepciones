package topmusicexcepciones;

import java.util.ArrayList;

import topmusicexcepciones.excepciones.AutorNoValidoException;
import topmusicexcepciones.excepciones.CancionNoValidaException;
import topmusicexcepciones.excepciones.FechaNoValidaException;
import topmusicexcepciones.excepciones.PosicionNoValidaException;
import topmusicexcepciones.excepciones.TituloNoValido;

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
public class TopMusic {
	/**
	 * ArrayList
	 */
	private ArrayList<Cancion> topMusic;

	/**
	 * Constructor
	 */
	public TopMusic() {
		topMusic = new ArrayList<Cancion>();
	}

	/**
	 * Añade una cancion al TopMusic
	 * 
	 * @param indice,
	 *            donde alojar la cancion (al usuario se muestra la posicion
	 *            empezando en 1)
	 */
	public void annadir(int indice, String titulo, String artista, int annoGrabacion) throws CancionNoValidaException,
			TituloNoValido, AutorNoValidoException, FechaNoValidaException, PosicionNoValidaException {
		
		if (fueraDeRango(indice - 1)) {
			throw new PosicionNoValidaException("Posición no válida.");
		}

		topMusic.add(indice - 1, new Cancion(titulo, artista, annoGrabacion));
		
	}

	/**
	 * Saca una cancion del top music
	 * 
	 * @param cancion
	 *            cancion a borrar del top
	 * @throws PosicionNoValidaException
	 */
	boolean sacar(int indice) throws PosicionNoValidaException {
		if (!topMusic.isEmpty())
			if (fueraDeRango(indice - 1))
				throw new PosicionNoValidaException("Error al borrar la canción: posición no válida");
			else
				topMusic.remove(indice - 1);
		return true;

	}

	/**
	 * Sube una posicion una cancion
	 * 
	 * @param cancion
	 *            a subir de posicion
	 * @return
	 * @throws PosicionNoValidaException
	 */
	boolean subir(int indice) throws PosicionNoValidaException {
		if (!(topMusic.isEmpty() || fueraDeRango(indice) || (indice - 2 < 0))) {
			topMusic.add(indice - 2, topMusic.remove(indice - 1));
			return true;
		} else

			throw new PosicionNoValidaException("Error al subir la canción: la canción está la primera.");
	}

	/**
	 * Baja una posicion una cancion
	 * 
	 * @param cancion
	 * @throws PosicionNoValidaException
	 */
	boolean bajar(int indice) throws PosicionNoValidaException {
		if (!(topMusic.isEmpty() || fueraDeRango(indice) || (indice > topMusic.size() - 1))) {
			topMusic.add(indice, topMusic.remove(indice - 1));
			return true;
		} else
			throw new PosicionNoValidaException("Error al bajar la canción: la canción está la última.");

	}

	/**
	 * Controla que la canción introducida en el TopMusic no pase de rango
	 * 
	 * @param indice
	 * @return
	 */
	private boolean fueraDeRango(int indice) {
		if (indice < 0 || indice > topMusic.size())
			return true;
		return false;
	}

	/**
	 * Recoge una posicion valida
	 * 
	 * @param indice
	 *            Indice de la posicion
	 * @return El indice si es valido
	 */
	int posicionValida(int indice) {
		if (indice > topMusic.size() || indice < 0)
			return topMusic.size();
		else
			return indice;
	}

	/**
	 * Muestra el top Music
	 */
	String mostrarTopMusic() {
		StringBuilder top = new StringBuilder("");
		if (!topMusic.isEmpty())
			if (topMusic.size() >= tamannoTop()) {
				top.append("Top Ten\n");
				for (int i = 0; i < tamannoTop(); i++) {
					top.append("(" + (i + 1) + ")" + topMusic.get(i).toString() + "\n");
				}
				return top.toString().toUpperCase();

			} else {
				return "No hay 10 canciones, introduce algunas primero";
			}
		return "Top vacío";
	}

	/**
	 * Muestra la cancion del top
	 */
	Cancion masEscuchada() {
		if (!topMusic.isEmpty()) {
			return topMusic.get(0);
		}
		return null;
	}

	/**
	 * @return tamanno de la lista
	 */
	private int tamannoTop() {
		if (topMusic.size() < 10)
			return topMusic.size();
		return 10;
	}

	/**
	 * Indica si la lista esta vacia o no
	 * 
	 * @return
	 */
	boolean isEmpty() {
		return topMusic.isEmpty();
	}

	/**
	 * Método que controla el tamaño de la lista
	 * 
	 * @return tamaño del topMusic
	 */
	public int size() {
		return topMusic.size() + 1;
	}
}