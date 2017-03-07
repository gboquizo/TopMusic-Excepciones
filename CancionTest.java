package topmusicexcepciones;
import org.junit.*;

import topmusicexcepciones.excepciones.AutorNoValidoException;
import topmusicexcepciones.excepciones.CancionNoValidaException;
import topmusicexcepciones.excepciones.FechaNoValidaException;
import topmusicexcepciones.excepciones.TituloNoValido;
public class CancionTest {
	
	@Before
	public void initCancion(){
		try {
			Cancion cancion = new Cancion("Don´t let me down","The B-52's, Jain",1999);
			Assert.assertEquals("Don´t let me down",cancion.getTitulo());
			Assert.assertEquals("The B-52's, Jain",cancion.getArtista());
			Assert.assertEquals(1999,cancion.getannoGrabacion());
		} catch (TituloNoValido e) {
			Assert.assertEquals("Error al insertar la canción. El título no es válido",e.getMessage());
		} catch (AutorNoValidoException e) {
			Assert.assertEquals("Error al insertar la canción: El autor indicado no es válido",e.getMessage());
		} catch (FechaNoValidaException e) {
			Assert.assertEquals("Error al insertar la canción. La fecha no es válida.",e.getMessage());
		}catch (CancionNoValidaException e) {
			Assert.assertEquals("La canción no es válida.",e.getMessage());
		}
	}

}