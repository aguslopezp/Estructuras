package colecciones.pila;

public class PilaArreglos<T> implements Pila<T> {

  /**
  * Atributos de una pila
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
  * Arreglo de objetos
  * Cantidad de elementos apilados ({@value #elementos})
	*/
  public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos = 0;

  /**
	* Construye una nueva pila vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public PilaArreglos() {
	  this(CAPACIDAD_POR_DEFECTO);
  }

  /**
	* Construye una nueva pila vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la pila
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
  public PilaArreglos(int capacidad) {
    if (capacidad <= 0)
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
		arreglo = new Object[capacidad];
  }

  /**
	* Inserta un elemento en el tope de la pila.
	* @param elem el elemento a apilar.
  * @throws StackOverflowError si la pila está llena
	* @return {@code true} sii el elemento pudo ser apilado
	*/
	public boolean push(T elem) throws StackOverflowError {
    if (elementos() <= arreglo.length) {
      arreglo[elementos()] = elem;
      elementos++;
      return true;
    } else {
      throw new StackOverflowError("La pila esta llena.");
    }
  }

  /**
	* Desapila el tope de la pila, y retorna el elemento desapilado, si ésta no es vacía.
	* @return el tope de la pila
	* @throws IllegalStateException si la pila está vacía
	* @see #esVacia()
	*/
  public T pop() throws IllegalStateException {
    if (esVacia()) {
      throw new IllegalStateException("No se puede hacer 'pop' de pila vacía.");
    } else {
      T tope = tope();
      elementos--;
      return tope;
    }
  }

  /**
	* Retorna el tope de la pila, si ésta no es vacía.
	* @return tope de la pila
	* @throws IllegalStateException si la pila está vacía
	* @see #esVacia()
	*/
  public T tope() {
    return elemento(elementos-1);
  }

  /**
  * Permite evaluar si la pila está llena.
  * @return {@code true} sii la pila está llena
  */
  public int elementos() {
    return elementos;
  }

  /**
	* Permite evaluar si la pila no tiene elementos.
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia() {
    return elementos == 0;
  }

  /**
	* Invariante de clase.
	* @return {@code true} sii la pila satisface su invariante de clase
	*/
	public boolean repOK() {
    return true;
  }

	@Override
  
	public String toString() {
    String pila = "\n----\n";
    for (int i = elementos-1; i >= 0; i--) {
      pila += " " + elemento(i) + "\n" + "----" + "\n";
    }
    return pila;
  }

	@Override
  @SuppressWarnings("unchecked")
	public boolean equals(Object otra) {
    if (!(otra instanceof Pila)) {
      return false;
    }
    Pila<T> otraPila = (Pila<T>) otra;
    if (otraPila.elementos() != elementos()) {
      return false;
    } else {
      Pila<T> cpPila = this;
      Pila<T> cpOtraPila = otraPila;
      while (elementos() != 1 && cpPila.tope().equals(cpOtraPila.tope())) {
        cpPila.pop();
        cpOtraPila.pop();
      }
      if (cpPila.tope().equals(cpOtraPila.tope())){
        return true;
      } else {
        return false;
      }
    }
  }

  /**
	* Permite obtener un elemento del arreglo en un indice determinado realizando el casteo necesario.
	* @param index el indice del elemento a obtener
	*/
	@SuppressWarnings("unchecked")
  private T elemento(int index) {
   return (T) arreglo[index];
 }
}
