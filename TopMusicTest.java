package topmusicexcepciones;

import org.junit.Test;

import topmusicexcepciones.excepciones.AutorNoValidoException;
import topmusicexcepciones.excepciones.CancionNoValidaException;
import topmusicexcepciones.excepciones.FechaNoValidaException;
import topmusicexcepciones.excepciones.PosicionNoValidaException;
import topmusicexcepciones.excepciones.TituloNoValido;

import org.junit.*;

	public class TopMusicTest {
		private TopMusic topMusic;
		
		/**
		 * INICIALIZA EL ARRAYLIST 
		 * */
		@Before
		public void initTopMusic() {
			topMusic = new TopMusic();
		}
		@After
		public void clearTopMusic(){
			topMusic = null;
		}
		
		/**
		 * ANADIR NUEVA CANCION A LA LISTA
		 * */
		@Test
		public void addCancion(){
			try {
				topMusic.annadir(1,"Don´t let me down","The B-52's, Jain",1999);
			}catch(PosicionNoValidaException e){
				Assert.assertEquals("Error al borrar la canción: posición no válida",e.getMessage());
			}catch (TituloNoValido e) {
				Assert.assertEquals("Error al insertar la canción. El título no es válido",e.getMessage());
			} catch (AutorNoValidoException e) {
				Assert.assertEquals("Error al insertar la canción: El autor indicado no es válido",e.getMessage());
			} catch (FechaNoValidaException e) {
				Assert.assertEquals("Error al insertar la canción. La fecha no es válida.",e.getMessage());
			}catch (CancionNoValidaException e) {
				Assert.assertEquals("La canción no es válida.",e.getMessage());
			}
			
		}
		
		/**
		 * ELIMINAR UNA CANCION DE LA LISTA
		 * */
		@Test
		public void removeCancion(){
			try {
				topMusic.annadir(1,"Avalancha","Héroes del Silencio",2006);
			}catch(PosicionNoValidaException e){
				Assert.assertEquals("Posición no válida.",e.getMessage());
			}catch (TituloNoValido e) {
				Assert.assertEquals("Error al insertar la canción: título no es válido.",e.getMessage());
			} catch (AutorNoValidoException e) {
				Assert.assertEquals("Error al insertar la canción: autor no es válido",e.getMessage());
			} catch (FechaNoValidaException e) {
				Assert.assertEquals("Error al insertar la canción. La fecha no es válida.",e.getMessage());
			}catch (CancionNoValidaException e) {
				Assert.assertEquals("La canción no es válida.",e.getMessage());
			}
			Assert.assertEquals(2, topMusic.size());
			try {
				topMusic.sacar(1);
			} catch (PosicionNoValidaException e) {
				Assert.assertEquals("Error al borrar la canción: posición no válida",e.getMessage());
			}
			Assert.assertEquals(1, topMusic.size());
			
			
		}
		
		/**
		 * SUBIR POSICION UNA CANCION DE LA LISTA
		 * */
		@Test
		public void subirPosicionCancion(){
			try {
				topMusic.annadir(1,"Avalancha","Héroes del Silencio",1995);
				topMusic.annadir(2,"The Trooper","Iron Maiden",1980);
			}catch(PosicionNoValidaException e){
				Assert.assertEquals("Posición no válida",e.getMessage());
			}catch (TituloNoValido e) {
				Assert.assertEquals("Error al insertar la canción: título no es válido.",e.getMessage());
			} catch (AutorNoValidoException e) {
				Assert.assertEquals("Error al insertar la canción: El autor indicado no es válido",e.getMessage());
			} catch (FechaNoValidaException e) {
				Assert.assertEquals("Error al insertar la canción. La fecha no es válida.",e.getMessage());
			}catch (CancionNoValidaException e) {
				Assert.assertEquals("La canción no es válida.",e.getMessage());
			}
			try {
				topMusic.subir(2);
			} catch (PosicionNoValidaException e) {
				Assert.assertEquals("Error al subir la canción: la canción está la primera.",e.getMessage());
			}
			Assert.assertEquals("TOP TEN\n(1)THE TROOPER , IRON MAIDEN (1980)\n(2)AVALANCHA , HÉROES DEL SILENCIO (1995)\n",topMusic.mostrarTopMusic().toString());
			
			
		}
		
		/**
		 * QUE ESTE VACIA LA LISTA
		 * */
		@Test
		public void isEmpty(){
			try {
				topMusic.annadir(0,"Avalancha","Héroes del Silencio",1995);
				topMusic.annadir(1,"The Trooper","Iron Maiden",1980);
			}catch(PosicionNoValidaException e){
				Assert.assertEquals("Posición no válida.",e.getMessage());
			}catch (TituloNoValido e) {
				Assert.assertEquals("Error al insertar la canción: título no es válido.",e.getMessage());
			} catch (AutorNoValidoException e) {
				Assert.assertEquals("Error al insertar la canción: autor no es válido",e.getMessage());
			} catch (FechaNoValidaException e) {
				Assert.assertEquals("Error al insertar la canción. La fecha no es válida.",e.getMessage());
			}catch (CancionNoValidaException e) {
				Assert.assertEquals("La canción no es válida.",e.getMessage());
			}
			Assert.assertEquals(1,topMusic.size());
			try {
				topMusic.sacar(0);
				topMusic.sacar(1);
			} catch (PosicionNoValidaException e) {
				Assert.assertEquals("Error al borrar la canción: posición no válida",e.getMessage());
			}
			Assert.assertTrue(topMusic.isEmpty());
			
		}
		
		/**
		 * TOP10
		 * */
		@Test
		public void top10(){
			try {
				topMusic.annadir(1,"Avalancha","Héroes del Silencio",1995);
				topMusic.annadir(2,"The Trooper","Iron Maiden",1980);
				topMusic.annadir(3,"Fade to black","Metallica",1987);
				topMusic.annadir(4,"Dystopia","Megadeth",2016);
				topMusic.annadir(5,"Paranoid","Black Sabbath",1980);
				topMusic.annadir(6,"Lady Blue","Enrique Bunbury",2006);
				topMusic.annadir(7,"Ievan Polkka","Korpiklaani",2014);
				topMusic.annadir(8,"The Arsonist","Puscifer",2015);
				topMusic.annadir(9,"Holy Diver","DIO",1980);
				topMusic.annadir(10,"Cartas de Amor","Duncan Dhu y Enrique Bunbury",2006);
				
			}catch(PosicionNoValidaException e){
				Assert.assertEquals("Error al borrar la canción: posición no válida",e.getMessage());
			}catch (TituloNoValido e) {
				Assert.assertEquals("Error al insertar la canción: título no es válido.",e.getMessage());
			} catch (AutorNoValidoException e) {
				Assert.assertEquals("Error al insertar la canción: El autor indicado no es válido",e.getMessage());
			} catch (FechaNoValidaException e) {
				Assert.assertEquals("Error al insertar la canción. La fecha no es válida.",e.getMessage());
			}catch (CancionNoValidaException e) {
				Assert.assertEquals("La canción no es válida.",e.getMessage());
			}
			Assert.assertEquals("TOP TEN\n(1)AVALANCHA , HÉROES DEL SILENCIO (1995)\n(2)THE TROOPER , IRON MAIDEN (1980)\n(3)FADE TO BLACK , METALLICA (1987)\n(4)DYSTOPIA , MEGADETH (2016)\n(5)PARANOID , BLACK SABBATH (1980)\n(6)LADY BLUE , ENRIQUE BUNBURY (2006)\n(7)IEVAN POLKKA , KORPIKLAANI (2014)\n(8)THE ARSONIST , PUSCIFER (2015)\n(9)HOLY DIVER , DIO (1980)\n(10)CARTAS DE AMOR , DUNCAN DHU Y ENRIQUE BUNBURY (2006)\n",topMusic.mostrarTopMusic());
			
		}
		
		/**
		 * TO STRING
		 * */
		@Test
		public void toStringLista(){
			try {
				topMusic.annadir(1,"Avalancha","Héroes del Silencio",1995);
				topMusic.annadir(2,"The Trooper","Iron Maiden",1980);
				topMusic.annadir(3,"Fade to black","Metallica",1987);
				topMusic.annadir(4,"Dystopia","Megadeth",2016);
				
			}catch(PosicionNoValidaException e){
				Assert.assertEquals("Error al borrar la canción: posición no válida",e.getMessage());
			}catch (TituloNoValido e) {
				Assert.assertEquals("Error al insertar la canción: título no es válido.",e.getMessage());
			} catch (AutorNoValidoException e) {
				Assert.assertEquals("Error al insertar la canción: autor no es válido",e.getMessage());
			} catch (FechaNoValidaException e) {
				Assert.assertEquals("Error al insertar la canción. La fecha no es válida.",e.getMessage());
			}catch (CancionNoValidaException e) {
				Assert.assertEquals("La canción no es válida.",e.getMessage());
			}
			Assert.assertEquals("TOP TEN\n(1)AVALANCHA , HÉROES DEL SILENCIO (1995)\n(2)THE TROOPER , IRON MAIDEN (1980)\n(3)FADE TO BLACK , METALLICA (1987)\n(4)DYSTOPIA , MEGADETH (2016)\n",topMusic.mostrarTopMusic());
						
		}

	}