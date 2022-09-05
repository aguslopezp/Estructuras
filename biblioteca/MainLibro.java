
import datos.Libro;

/**
* La clase {@code MainLibro} implementa una aplicación simple para mostrar el uso de {@code Libro}.
* Esta clase no usa parámetros, el comportamiento está completamente "hardcodeado" requiriendo modificiar y recompilar para hacer pruebas.
* @see datos.Libro
* @version 1.0
*/
public class MainLibro {

	/**
	* Experimenta con libros, sus métodos y la diferencia entre usar {@code equals()} y {@code ==}.
	* @param args : arguments for this main method, not used in this implementation.
	* @see Object#equals(Object)
	*/
	public static void main(String[] args) {
		Libro libro1 = new Libro("Isaac Asimov", "The Caves of Steel", 42);
		Libro libro2 = new Libro("Isaac Asimov", "The Caves of Steel", 42);
		Libro libro3 = new Libro("Isaac Asimov", "The Naked Sun", 47);
		Libro libro4 = new Libro ("Antoine", "El principito", 96);
		Libro libro5 = new Libro ("Antoine", "El principito", 96);
		
		System.out.println(libro1 + " \ny \n" + libro2 + "\n\nSon iguales usando equals? " + (libro1.equals(libro2)));
		System.out.println(libro1 + " \ny \n" + libro2 + "\n\nSon iguales usando ==? " + (libro1 == libro2));
		System.out.println(libro1 + " \ny \n" + libro3 + "\n\nSon iguales usando equals? " + (libro1.equals(libro3)));
		System.out.println(libro1 + " \ny \n" + libro3 + "\n\nSon iguales usando ==? " + (libro1 == libro3));
		System.out.println(libro4 + " \ny \n" + libro5 + "\n\nSon iguales usando equals? " + (libro4.equals(libro5)));
		System.out.println(libro4 + " \ny \n" + libro5 + "\n\nSon iguales usando ==? " + (libro4 == libro5));

		System.out.println("\nCambio de autor en \n" + libro5);
		libro5.autor("Pepe");
		System.out.println("\nLibro con nuevo autor\n" + libro5);
	} 

}
