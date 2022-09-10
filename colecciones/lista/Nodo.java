package colecciones.lista;

public class Nodo<T> {
  private T info;
  private Nodo<T> next;
    
  /**
  * Constructor de nodo
  * @param info el elemento a agregar
  */

  public Nodo (T info) {
    this.info = info;
  }
  
  /**
  * Asigna un valor al campo info de nodo
  * @param info el valo a asignar
  */
  public void info (T info) {
    this.info = info;
  }

  /**
  * Retorna el valor que tiene el campo info
  */
  public T info () {
    return info;
  }
  
  /**
  * Asigna nodo siguiente
  * @param siguiente el nodo a apuntar
  */
  public void next (Nodo <T> next) {
    this.next = next;
  }

  public Nodo <T> next () {
    return next;
  }
  
  @Override
  public String toString () {
    if (info != null) {
      return info.toString();
    } else {
      return "Nothing";
    }
    
  }

}
