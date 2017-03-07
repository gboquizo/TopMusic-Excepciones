package topmusicexcepciones;

import java.util.Calendar;
import java.util.regex.Pattern;

import topmusicexcepciones.excepciones.AutorNoValidoException;
import topmusicexcepciones.excepciones.CancionNoValidaException;
import topmusicexcepciones.excepciones.FechaNoValidaException;
import topmusicexcepciones.excepciones.TituloNoValido;

/**
 * Top Music. Mejoremos la versión anterior, pero como conocemos QUÉ ES una
 * excepción, vamos a utilizarla. Los errores los controlaremos mediante las
 * siguientes excepciones:
 *
 * FechaNoValidaException CancionNoValidaException. AutorNoValidoException
 * PosicionNoValidaException
 *
 * Y recuerda:
 *
 * En caso de error, el usuario ha de saber CON EXACTITUD cuál ha sido el
 * problema. Error al insertar la canción: título no es válido. Error al
 * insertar la canción: autor no es válido Error al borrar la canción: posición
 * no válida Error al bajar la canción: posición no válida. Error al subir la
 * canción: la canción está la primera. El método Cancion.getInstance() ya no es
 * necesario. Sigue usando expresiones regulares
 *
 * Utiliza pruebas unitarias para el control de errores.
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
	 * Patrón para validar el título de la canción y el autor.
	 */
	private static final Pattern PATTERN = Pattern.compile("([\\w'´,áéóúüñ!]+\\s?){2,}");

	/**
	 * Título de la canción
	 */
	private String titulo;

	/**
	 * Nombre del artista
	 */
	private String artista;

	/**
	 * Año de grabación
	 */
	private int annoGrabacion;

	/**
	 * Constructor de la clase
	 * 
	 * @param titulo,titulo
	 *            de la canción
	 * @param artista,artista
	 *            de la canción
	 * @param annoGrabacion,año
	 *            de grabación de la canción
	 * @throws CancionNoValidaException
	 * @throws AutorNoValidoException
	 * @throws FechaNoValidaException
	 * @throws TituloNoValido
	 */
	Cancion(String titulo, String artista, int annoGrabacion)
			throws CancionNoValidaException, TituloNoValido, AutorNoValidoException, FechaNoValidaException {
		if (!PATTERN.matcher(titulo).matches() && !PATTERN.matcher(artista).matches()
				&& !(annoGrabacion > 1950 && annoGrabacion <= ANNO)) {
			throw new CancionNoValidaException("La canción no es válida.");
		} else
			setTitulo(titulo);
		setArtista(artista);
		setannoGrabacion(annoGrabacion);
	}


	/**
	 * Lee el título de la canción
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
			throw new TituloNoValido("Error al insertar la canción. El título no es válido");
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
			throw new AutorNoValidoException("Error al insertar la canción: El autor indicado no es válido");
		else
			this.artista = artista;
	}

	/**
	 * Lee el año de grabación
	 * 
	 * @return annoGrabacion
	 */
	int getannoGrabacion() {
		return annoGrabacion;
	}

	/**
	 * @param annoGrabacion, año de grabación de la canción
	 * @throws FechaNoValidaException 
	 * */
	private void setannoGrabacion(int annoGrabacion) throws FechaNoValidaException {
		if(!(annoGrabacion > 1950 && annoGrabacion <= ANNO))
			throw new FechaNoValidaException("Error al insertar la canción. La fecha no es válida.");
		else
			this.annoGrabacion = annoGrabacion;
	}



	@Override
	public String toString() {
		return "" + titulo + " , " + artista + " (" + annoGrabacion + ")";
	}
}