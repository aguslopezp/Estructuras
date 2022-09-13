package colecciones.lista;

public class ListaArray<T> implements Lista<T>{
  
	//Atributos
  private Object[] list;
	//cantidad de elementos que contiene la lista
  private int cantElem;
	//capacidad máxima del arreglo
	private int capacidad;

	//Capacidad máxima de memoria
  private static final int MAX_ELEMENTS = 100;
  
  //Constructor de lista vacía
  public ListaArray(int capacidad){
		if (capacidad <= MAX_ELEMENTS) {
			list = new Object[capacidad];
			this.capacidad = capacidad;
			cantElem = 0;
		} else {
			throw new Error("Capacidad mayor a la permitida en el constructor.");
		}
  }

  @SuppressWarnings("unchecked")
	private T elemento(int indice) {
	  return (T) list[indice];
	}

  /**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/
	@Override
	public boolean agregar(T elem) {
	  if (elementos() < capacidad) {
	    list[cantElem] = elem;
	    cantElem++;
	    return true;
	  } else {
	    return false;
	  }
	}
	
	/**
	* Agrega todos los elementos de otra lista, al final de esta lista.
	* @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
	* @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
	*/
	@Override
	public boolean agregarTodos(Lista<T> otraLista) {
    if ((capacidad - cantElem) >= otraLista.elementos()){
      for (int i = 0; i < otraLista.elementos(); i++) {
        agregar(otraLista.obtener(i));
      }
      return true;
    } else {
      return false;
    }
  }

	/**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
	public boolean insertar(T elem, int indice){
		if (elementos() == capacidad){
			//Si la lista esta llena retorna false y no inserta nada
      return false;
    } else if (indice >= 0 && indice <= elementos()) {
			//Me fijo si el indice es la posición siguiente al último elemento
			//Realizo la insersión directamente
      if (indice == elementos()) {
        list[indice] = elem;
        cantElem++;
        return true;
      } else {
				//Shifteo todos los elementos a la derecha a partir de la posición del indice e inserto
				for (int i = (elementos()-1); i >= indice; i--) {
					list[i+1] = list[i];
				}
				list[indice] = elem;
				cantElem++;
				return true;
      }
	  } else {
	    throw new IndexOutOfBoundsException("Indice fuera de rango en 'insertar'");
    }
  }

	/**
	* Elimina un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a eliminar
	* @return el elemento eliminado
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T eliminar(int indice) {
		//si el indice esta dentro del rango
		if (indice >= 0 && indice < elementos()) {
			//Guardo el elemento a eliminar
			T elementoEliminado = elemento(indice);
			//Si el indice es la posicion del último elemento saco directo
			if (indice == elementos()-1) {
				cantElem--;
				return elementoEliminado;
			} else {
				for (int i = indice+1; i < elementos(); i++) {
					list[i-1] = list[i];
				}
				cantElem--;
				return elementoEliminado;
			}
		} else {
			throw new IndexOutOfBoundsException("Indice fuera de rango en 'eliminar'");
		}
	}

	/**
	* Obtiene un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a obtener
	* @return el elemento en la posición {@code indice}
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T obtener(int indice) { 
	  if (indice >= 0 && indice < elementos()) {
			return elemento(indice);
		} else {
	    throw new IndexOutOfBoundsException("Indice fuera de rango en 'obtener'");
	  }
	}
	
	/**
	* Retorna la porción de esta lista entre los índice especificados {@code desdeInd}, inclusivo, y {@code hastaInd}, exclusivo, en una nueva lista.
	* Si {@code fromInd} es igual a {@code hastaInd} se retorna un a lista vacía.
	* @param desdeInd el índice inferior, inclusivo
	* @param hastaInd el índice superior, exclusivo
	* @return una nueva lista formada con los elementos entre {@code desdeInd} hasta {@code hastaInd - 1} de esta lista
	* @throws IndexOutOfBoundsException si ({@code fromInd} &lt; {@code 0} || {@code hastaInd} &gt; {@code #elementos()} || {@code desdeInd} &gt; {@code hastaInd})
	* @see #elementos() 
	*/
	//public Lista<T> subLista(int desdeInd, int hastaInd);

	/**
	* Evalua si esta lista contiene un elemento particular, utilizando el método {@code equals(Object)}.
	* @param elem el elemento a buscar
	* @return {@code true} sii, existe un elemento {@code e} en la lista, tal que {@code e == null && elem == null || e.equals(elem)}
	*/
	//public boolean contiene(T elem);

	/**
	* Remueve todos los elementos en la lista.
	*/
	public void vaciar() {
    cantElem = 0;
  }
	
	/**
	* Retorna la cantidad de elementos agregados a la lista.
	* @return cantidad de elementos en la lista
	*/
	public int elementos() {
    return cantElem;
  }

	/**
	* Permite evaluar si la lista no tiene elementos.
	* Este método es equivalente a:
	* <pre>lista.elementos() == 0</pre>
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia() {
    return cantElem == 0;
  }

	/**
	* Invariante de clase.
	* @return {@code true} sii la lista satisface su invariante de clase
	*/
	//public boolean repOK();

	/**
	* Retorna una representación como {@code String} de esta lista. La representación como {@code String} consiste de los elementos en esta lista, en el orden correspondiente a la implementación de la misma, encerrados entre corchetes ("[]"). 
	* Elementos adyacentes están separados mediante los caractéres ", " (coma y espacio). Los elementos son convertidos mediante {@code String.valueOf(Object)}.
	* @return una representación como {@code String} de esta lista
	*/
	@Override
	public String toString(){
	  String list = "[ ";
	  for (int i = 0; i < cantElem; i++) {
	    list += obtener(i) + " ";
	  }
	  list += "]";
	  return list;
	}
	
	/**
	* Evalúa igualdad entre esta y otra lista. La igualdad considera que el tamaño de ambas listas es el mismo, y que los elementos de ambas listas son iguales considerando el orden de los mismos de acuerdo a la implementación de cada lista.
	* La igualdad entre elementos se realiza considerando si ambos son {@code null} o, en caso contrario, mediante el método {@code equals(Object)}.
	* @return {@code true} sii ambas listas tienen los mismos elementos.
	*/
	//@Override
	//public boolean equals(Object otro);
	
	
}
