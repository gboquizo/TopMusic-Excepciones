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
			Cancion cancion = new Cancion("Don�t let me down","The B-52's, Jain",1999);
			Assert.assertEquals("Don�t let me down",cancion.getTitulo());
			Assert.assertEquals("The B-52's, Jain",cancion.getArtista());
			Assert.assertEquals(1999,cancion.getannoGrabacion());
		} catch (TituloNoValido e) {
			Assert.assertEquals("Error al insertar la canci�n. El t�tulo no es v�lido",e.getMessage());
		} catch (AutorNoValidoException e) {
			Assert.assertEquals("Error al insertar la canci�n: El autor indicado no es v�lido",e.getMessage());
		} catch (FechaNoValidaException e) {
			Assert.assertEquals("Error al insertar la canci�n. La fecha no es v�lida.",e.getMessage());
		}catch (CancionNoValidaException e) {
			Assert.assertEquals("La canci�n no es v�lida.",e.getMessage());
		}
	}

}