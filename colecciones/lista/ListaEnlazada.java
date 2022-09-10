package colecciones.lista;


public class ListaEnlazada<T> implements Lista<T> {
  
  private Nodo<T> head;
  private int size;
  
  /**
  * Constructor básico de una lista enlazada 
  */
  public ListaEnlazada() {
    head = null;
    size = 0;
  }

  /**
   * Devuelve la cabeza de la lista
   */
  public Nodo<T> head() {
    return head;
  }
  
  /**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/
	public boolean agregar(T elem) {
		//Creo nuevo nodo con el elemento a agregar
		Nodo<T> nodoNuevo = new Nodo<T>(elem);
		//Si la lista esta vacía inserto en el primer lugar
		if (esVacia()) {
			head = nodoNuevo;
			size++;
		} else {
			Nodo<T> nodoTemp = head;
			while (nodoTemp.next() != null) {
				nodoTemp = nodoTemp.next();
			}
			nodoTemp.next(nodoNuevo);
			size++;
		}
		return true;
  }
	
	/**
	* Agrega todos los elementos de otra lista, al final de esta lista.
	* @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
	* @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
	*/
	public boolean agregarTodos(Lista<T> otraLista){
		Nodo<T> nodoTemp = head;
		int counter = 0;
		while (nodoTemp.next() != null) {
			nodoTemp = nodoTemp.next();
			counter++;
		}
		for (int i = 0; i < otraLista.elementos(); i++) {
			this.insertar(otraLista.obtener(i), counter);
			counter++;
		}
		this.size += otraLista.elementos();
    return true;
  }

	/**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
	public boolean insertar(T elem, int indice) {
		
		if (indice >= 0 && indice <= elementos()) {
			//Crea nuevo nodo con el elemento a insertar
			Nodo<T> nodoNuevo = new Nodo<T>(elem);
			//nodoTemp le asigno head para recorrer la lista
			Nodo<T> nodoTemp = head;
			//3 casos: insertar a la cabeza, al final(metodo agregar) y en el medio.
			if (indice == 0) {
				nodoNuevo.next(nodoTemp);
				head = nodoNuevo;
				size++;
			} else if (indice == elementos()) {
				this.agregar(elem);
			} else {
				//contador auxiliar para llegar a la posicion a insertar
				int counter = 0;
				//Después del while nodoTemp queda en la posición anterior al indice
				while (counter != (indice-1)) {
					nodoTemp = nodoTemp.next();
					counter++;
				}
				nodoNuevo.next(nodoTemp.next());
				nodoTemp.next(nodoNuevo);
				size++;
			}
			return true;
		} else {
			throw new IndexOutOfBoundsException("Fuera de rango en el insertar.");
		}
	}

	/**
	* Elimina un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a eliminar
	* @return el elemento eliminado
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	//public T eliminar(int indice);

	/**
	* Obtiene un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a obtener
	* @return el elemento en la posición {@code indice}
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T obtener(int indice) {
		if (indice >= 0 && indice < elementos()) {
			Nodo<T> nodo = head;
			for (int i = 0; i < indice; i++) {
				nodo = nodo.next();
			}
			return nodo.info();
		} else {
			throw new IndexOutOfBoundsException();
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
		head = null;
	}
	
	/**
	* Retorna la cantidad de elementos agregados a la lista.
	* @return cantidad de elementos en la lista
	*/
	public int elementos() {
		return size;
	}

	/**
	* Permite evaluar si la lista no tiene elementos.
	* Este método es equivalente a:
	* <pre>lista.elementos() == 0</pre>
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia() {
	  return head == null;
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
	public String toString() {
		String list = "[ ";
		for (int i = 0; i < elementos(); i++) {
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
