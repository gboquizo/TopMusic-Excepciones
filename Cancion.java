package topmusicexcepciones;

import java.util.Calendar;
import java.util.regex.Pattern;

import topmusicexcepciones.excepciones.AutorNoValidoException;
import topmusicexcepciones.excepciones.CancionNoValidaException;
import topmusicexcepciones.excepciones.FechaNoValidaException;
import topmusicexcepciones.excepciones.TituloNoValido;

/**
 * Top Music. Mejoremos la versi�n anterior, pero como conocemos QU� ES una
 * excepci�n, vamos a utilizarla. Los errores los controlaremos mediante las
 * siguientes excepciones:
 *
 * FechaNoValidaException CancionNoValidaException. AutorNoValidoException
 * PosicionNoValidaException
 *
 * Y recuerda:
 *
 * En caso de error, el usuario ha de saber CON EXACTITUD cu�l ha sido el
 * problema. Error al insertar la canci�n: t�tulo no es v�lido. Error al
 * insertar la canci�n: autor no es v�lido Error al borrar la canci�n: posici�n
 * no v�lida Error al bajar la canci�n: posici�n no v�lida. Error al subir la
 * canci�n: la canci�n est� la primera. El m�todo Cancion.getInstance() ya no es
 * necesario. Sigue usando expresiones regulares
 *
 * Utiliza pruebas unitarias para el control de errores.
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
public class Cancion {

	/**
	 * Fecha del sistema
	 */
	private static final Calendar FECHA = Calendar.getInstance();
	/**
	 * Fecha del sistema
	 */
	private static final int ANNO = FECHA.get(Calendar.YEAR);
	/**
	 * Patr�n para validar el t�tulo de la canci�n y el autor.
	 */
	private static final Pattern PATTERN = Pattern.compile("([\\w'�,������!]+\\s?){2,}");

	/**
	 * T�tulo de la canci�n
	 */
	private String titulo;

	/**
	 * Nombre del artista
	 */
	private String artista;

	/**
	 * A�o de grabaci�n
	 */
	private int annoGrabacion;

	/**
	 * Constructor de la clase
	 * 
	 * @param titulo,titulo
	 *            de la canci�n
	 * @param artista,artista
	 *            de la canci�n
	 * @param annoGrabacion,a�o
	 *            de grabaci�n de la canci�n
	 * @throws CancionNoValidaException
	 * @throws AutorNoValidoException
	 * @throws FechaNoValidaException
	 * @throws TituloNoValido
	 */
	Cancion(String titulo, String artista, int annoGrabacion)
			throws CancionNoValidaException, TituloNoValido, AutorNoValidoException, FechaNoValidaException {
		if (!PATTERN.matcher(titulo).matches() && !PATTERN.matcher(artista).matches()
				&& !(annoGrabacion > 1950 && annoGrabacion <= ANNO)) {
			throw new CancionNoValidaException("La canci�n no es v�lida.");
		} else
			setTitulo(titulo);
		setArtista(artista);
		setannoGrabacion(annoGrabacion);
	}


	/**
	 * Lee el t�tulo de la canci�n
	 * 
	 * @return titulo
	 */
	String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo,
	 *            titulo de la cancion
	 * @throws TituloNoValido
	 */
	private void setTitulo(String titulo) throws TituloNoValido {
		if (!PATTERN.matcher(titulo).matches())
			throw new TituloNoValido("Error al insertar la canci�n. El t�tulo no es v�lido");
		else
			this.titulo = titulo;
	}

	/**
	 * Lee el nombre del artista
	 * 
	 * @return artista
	 */
	String getArtista() {
		return artista;
	}

	/**
	 * @param artista,
	 *            artista de la cancion
	 * @throws AutorNoValidoException
	 */
	private void setArtista(String artista) throws AutorNoValidoException {
		if (!PATTERN.matcher(artista).matches())
			throw new AutorNoValidoException("Error al insertar la canci�n: El autor indicado no es v�lido");
		else
			this.artista = artista;
	}

	/**
	 * Lee el a�o de grabaci�n
	 * 
	 * @return annoGrabacion
	 */
	int getannoGrabacion() {
		return annoGrabacion;
	}

	/**
	 * @param annoGrabacion, a�o de grabaci�n de la canci�n
	 * @throws FechaNoValidaException 
	 * */
	private void setannoGrabacion(int annoGrabacion) throws FechaNoValidaException {
		if(!(annoGrabacion > 1950 && annoGrabacion <= ANNO))
			throw new FechaNoValidaException("Error al insertar la canci�n. La fecha no es v�lida.");
		else
			this.annoGrabacion = annoGrabacion;
	}



	@Override
	public String toString() {
		return "" + titulo + " , " + artista + " (" + annoGrabacion + ")";
	}
}