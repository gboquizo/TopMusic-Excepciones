package utiles;

 /**
 * Crea la clase Menu. Mételo en el paquete utiles. Implementa al menos los
 * siguientes métodos y atributos: a. titulo b. opciones c. numOpciones d.
 * gestionar() e. mostrar() f. recogerOpcion() 
 * 
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 */
public class TestMenu {
	public static void main(String[] args) {

		Menu menu = new Menu("Mi primer menú",
				new String[] { " Primera opcion", "segunda opcion", "tercera opcion", "cuarta opcion" });

		int opcion;

		do {

			opcion = menu.recogerOpcion();

			gestionarOpciones(opcion);

		} while (opcion >= 0);
	}

	private static void gestionarOpciones(int opcion) {

		switch (opcion) {
		case 0:
			System.out.println("Salgo del programa, adios");
			System.exit(0);
		case 1:
			System.out.println("Muestro la opción "+ opcion);
			break;
		case 2:
			System.out.println("Muestro la opción "+ opcion);
			break;
		case 3:
			System.out.println("Muestro la opción "+ opcion);
			break;
		case 4:
			System.out.println("Muestro la opción "+ opcion);
			break;
		}
	
	}
}
