package colecciones.pila;

public class mainPilaArreglos {
  public static void main(String[] args) {
    System.out.println("");
    Pila<String> pila1 = new PilaArreglos<String>();
    
    for (int i = 0; i < args.length; i++){
      if (args[i].equals("(") || args[i].equals("{") || args[i].equals("[")) {
        pila1.push(args[i]);
      }
      //Si viene un paréntesis de cierre me fijo que en el tope haya un paréntesis de apertura para desapilar
      if (args[i].equals(")") && pila1.tope().equals("(")){
        pila1.pop();
      }
      //Si viene llave de cierre me fijo que en el tope haya una llave de apertura para desapilar
      if (args[i].equals("}") && pila1.tope().equals("{")){
        pila1.pop();
      }
      //Si viene un corchete de cierre me fijo si en el tope hay un corchete de apertura para desapilar
      if (args[i].equals("]") && pila1.tope().equals("[")){
        pila1.pop();
      }
    }
    //[()][()()]() return true
    //[(]) return false

    //Si la cadena ingresada es balanceada la pila debe quedar vacía
    System.out.println("Balanceado: " + pila1.esVacia());
  }
}
