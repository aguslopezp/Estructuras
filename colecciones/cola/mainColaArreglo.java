package colecciones.cola;
import java.util.Scanner;

public class mainColaArreglo {
  public static void main(String[] args) {
    System.out.println("-----------------------");
    System.out.println("Este programa evalúa si una lista de elementos implementadas con la estructura cola es palíndromo.");
    System.out.println("-----------------------");
    //Si es palíndromo, la reversa de la lista es igual a la original
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese la cantidad de elementos que tiene su lista: ");
    int cantElem = scanner.nextInt();
    
    ColaArregloFijo<Integer> colaOriginal = new ColaArregloFijo<Integer>(cantElem);
    
    System.out.println("");
    
    //Cargo la cola original con elementos
    for (int i = 0; i < cantElem; i++) {
      System.out.println("Ingrese elemento " + (i+1) + ": ");
      Integer elem = scanner.nextInt();
      colaOriginal.encolar(elem);
    }
    scanner.close();
    System.out.println("");
    System.out.println("Cola ingresada: " + colaOriginal);

    System.out.println("Cola ingresada es palíndromo?\nRespuesta: " + colaOriginal.equals(colaOriginal.reversa()));
    colaOriginal.vaciar();

    System.out.println("-----------------------");
  }
}
