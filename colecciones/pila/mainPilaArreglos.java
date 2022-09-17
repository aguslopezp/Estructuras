package colecciones.pila;

public class mainPilaArreglos {
  public static void main(String[] args) {
    System.out.println("");
    Pila<Integer> pila1 = new PilaArreglos<Integer>(10);
    pila1.push(1);
    pila1.push(2);
    pila1.push(3);
    pila1.push(4);
    pila1.push(5);
    System.out.println("Pila: " + pila1);
    System.out.println("Tope de la pila: " + pila1.tope());
    pila1.pop();
    System.out.println("Desapilo: " + pila1);
  }
}
