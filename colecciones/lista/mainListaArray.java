package colecciones.lista;

public class mainListaArray {
  public static void main(String[] args) {
    System.out.println("Creo dos listas vacías de enteros.");
    ListaArray<Integer> a = new ListaArray<Integer>(50);
    ListaArray<Integer> b = new ListaArray<Integer>(10);
    System.out.println("a: " + a);
    System.out.println("b: " + b);

    for (int i = 0; i < 5; i++) {
      a.agregar(i);
    }

    for (int j = 5; j < 10; j++) {
      b.agregar(j);
    }

    System.out.println("");
    System.out.println("");
    System.out.println("Agrego elementos: ");
    System.out.println("a: " + a); //a: [ 0 1 2 3 4 ]
    System.out.println("b: " + b); //b: [ 5 6 7 8 9 ]
    a.agregarTodos(b); 
    System.out.println("A 'a' le agrego todo 'b': " + a); //a: [ 0 1 2 3 4 5 6 7 8 9 ]
    System.out.println("Cantidad de elementos que tiene 'a': " + a.elementos());
    a.insertar(99, 4);
    System.out.println("A 'a' le inserto el 99 en la posición 4: " + a);
    System.out.println("Cantidad de elementos que tiene 'a': " + a.elementos());
    System.out.println("");
    System.out.println("a: " + a);
    System.out.println("Eliminar la posición 2: ");
    a.eliminar(2);
    System.out.println("a: " + a);
    System.out.println("Cantidad de elementos que tiene 'a': " + a.elementos());
  }
}
