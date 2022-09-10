package colecciones.lista;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class mainListaEnlazada {
  public static void main(String[] args) {
    
    System.out.println("Creo dos listas enlazadas vacías de enteros.");
    ListaEnlazada<Integer> l = new ListaEnlazada<Integer>();
    ListaEnlazada<Integer> o = new ListaEnlazada<Integer>();
    System.out.println("Head de l: " + l.head());
    System.out.println("Size de l: " + l.elementos());

    System.out.println("Agrego un elemento: ");
    l.agregar(6);
    o.agregar(9);
    System.out.println(l);
    System.out.println(o);
    System.out.println("Agrego otro elemento: ");    
    l.agregar(2);
    o.agregar(8);
    System.out.println(l);
    System.out.println(o);
    System.out.println("Agrego el tercero: ");
    l.agregar(3);
    o.agregar(7);
    System.out.println(l);
    System.out.println(o);
    System.out.println("Head de l: " + l.head());
    System.out.println("Head de o: " + o.head());
    System.out.println("Size de l: " + l.elementos());
    System.out.println("Size de o: " + o.elementos());
    System.out.println("\n");

    l.insertar(22, 1);
    System.out.println(l);
  }
}
