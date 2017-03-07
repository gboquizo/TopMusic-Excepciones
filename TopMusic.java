package topmusicexcepciones;

import java.util.ArrayList;

import topmusicexcepciones.excepciones.AutorNoValidoException;
import topmusicexcepciones.excepciones.CancionNoValidaException;
import topmusicexcepciones.excepciones.FechaNoValidaException;
import topmusicexcepciones.excepciones.PosicionNoValidaException;
import topmusicexcepciones.excepciones.TituloNoValido;

/**
 * Top Music. Mejoremos la versi�n anterior. En este caso, antes de crear la
 * canci�n (mediante Cancion.getInstance()) realiza las comprobaciones de los
 * campos (usa expresiones regulares):
 * 
 * El t�tulo de la canci�n: Me too, Don�t let me down, 19 d�as y 500 noches,
 * Come... El autor/grupo: The B-52's, Jain... El a�o: Nunca posterior al a�o
 * actual
 * 
 * Entrega:
 * 
 * El c�digo comprimido, como siempre url del github y lo tienes en un
 * repositorio
 * 
 * @author Guillermo Boquizo S�nchez
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
	 * A�ade una cancion al TopMusic
	 * 
	 * @param indice,
	 *            donde alojar la cancion (al usuario se muestra la posicion
	 *            empezando en 1)
	 */
	public void annadir(int indice, String titulo, String artista, int annoGrabacion) throws CancionNoValidaException,
			TituloNoValido, AutorNoValidoException, FechaNoValidaException, PosicionNoValidaException {
		
		if (fueraDeRango(indice - 1)) {
			throw new PosicionNoValidaException("Posici�n no v�lida.");
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
				throw new PosicionNoValidaException("Error al borrar la canci�n: posici�n no v�lida");
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

			throw new PosicionNoValidaException("Error al subir la canci�n: la canci�n est� la primera.");
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
			throw new PosicionNoValidaException("Error al bajar la canci�n: la canci�n est� la �ltima.");

	}

	/**
	 * Controla que la canci�n introducida en el TopMusic no pase de rango
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
		return "Top vac�o";
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
	 * M�todo que controla el tama�o de la lista
	 * 
	 * @return tama�o del topMusic
	 */
	public int size() {
		return topMusic.size() + 1;
	}
}