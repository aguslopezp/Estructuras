package colecciones.lista;

public class Nodo <T> {
  private T info;
  private Nodo <T> siguiente;

  public Nodo () {
    info = null;
    siguiente = null;
  }

  public Nodo (T info, Nodo <T> siguiente) {
    this.info = info;
    this.siguiente = siguiente;
  }

  public void info (T info) {
    this.info = info;
  }

  public T info () {
    return info;
  }

  public void siguiente (Nodo <T> siguiente) {
    this.siguiente = siguiente;
  }

  public Nodo <T> siguiente () {
    return siguiente;
  }

}
