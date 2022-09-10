package colecciones.lista;

public class mainListaEnlazada {
  public static void main(String[] args) {
    
    System.out.println("Creo dos listas enlazadas vacías de enteros.");
    ListaEnlazada<Integer> l = new ListaEnlazada<Integer>();
    ListaEnlazada<Integer> o = new ListaEnlazada<Integer>();
    System.out.println("l: " + l);
    System.out.println("o: " + o);
    System.out.println("");

    System.out.println("Agrego 3 elementos en cada una: ");
    l.agregar(1);
    l.agregar(2);
    l.agregar(3);
    o.agregar(9);
    o.agregar(8);
    o.agregar(7);
    System.out.println("l: " + l);
    System.out.println("o: " + o);
    System.out.println("");

    int iEliminar = 0;
    System.out.println("Eliminar en índice " + iEliminar + " de 'l': ");
    System.out.println("Elemento eliminado: " + l.eliminar(iEliminar));
    System.out.println("l: " + l);
    System.out.println("");
    
    int eInsert = 1;
    int iInsert = 0;
    System.out.println("Insertar el " + eInsert + " en índice " + iInsert + " de 'l': ");
    l.insertar(eInsert, iInsert);
    System.out.println("l: " + l);

    int iObtener = 2;
    System.out.println("Obtener de 'l' el elemento en el índice " + iObtener + ": " + l.obtener(iObtener));
    System.out.println("");
    System.out.println("Agregar lista 'o' al final de lista 'l': ");
    l.agregarTodos(o);
    System.out.println("l: " + l);
  }
}
