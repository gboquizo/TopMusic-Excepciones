package topmusicexcepciones.excepciones;

public class CancionNoValidaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CancionNoValidaException(String mensaje) {
		super(mensaje);
	}

}
