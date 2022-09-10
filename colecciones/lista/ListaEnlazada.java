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
   * Devuelve el nodo que está en la cabeza de la lista
	 * @return {@code head} de la {@code ListaEnlazada}
   */
  public Nodo<T> head() {
    return head;
  }
  
  /**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/
	@Override
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
	@Override
	public boolean agregarTodos(Lista<T> otraLista){
		for (int i = 0; i < otraLista.elementos(); i++) {
			agregar(otraLista.obtener(i));
		}
    return true;
  }

	/**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento. Comenzando desde el 0 como primer elemento.
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
	@Override
	public boolean insertar(T elem, int indice) {
		if (indice >= 0 && indice <= elementos()) {
			//Crea nuevo nodo con el elemento a insertar
			Nodo<T> nodoNuevo = new Nodo<T>(elem);
			//nodoTemp le asigno head para recorrer la lista
			Nodo<T> nodoTemp = head;

			//2 casos: insertar a la cabeza o inserción normal
			if (indice == 0) {
				//Caso insertar a la cabeza
				nodoNuevo.next(nodoTemp);
				head = nodoNuevo;
				size++;
			} else {
				//Caso inserción normal
				//contador auxiliar para llegar a la posicion a insertar
				int counter = 0;
				//Después del while nodoTemp apunta a la posición anterior al indice
				while (counter != (indice-1)) {
					nodoTemp = nodoTemp.next();
					counter++;
				}
				//nodoNuevo apunta al siguiente de nodoTemp
				nodoNuevo.next(nodoTemp.next());
				//nodoTemp apunta a nodoNuevo para así quedar en la posición indicada 
				nodoTemp.next(nodoNuevo);
				size++;
			}
			return true;
		} else {
			throw new IndexOutOfBoundsException("Índice fuera de rango.\nÍndice ingresado: " + indice + "\nÍndice mayor posible: " + elementos());
		}
	}

	/**
	* Elimina un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a eliminar
	* @return el elemento eliminado
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	@Override
	public T eliminar(int indice) {
		if (!esVacia()){
			if (indice >= 0 && indice < elementos()) {
				//Caso eliminar a la cabeza
				if (indice == 0){
					T eliminado = head.info();
					head = head.next();
					size--;
					return eliminado;
				} else {
				//Caso eliminación normal
				Nodo<T> nodoTemp = head;
				int cont = 0;
				//nodoTemp apunta al anterior a eliminar
				while (cont != (indice - 1)){
					nodoTemp = nodoTemp.next();
					cont++;
				}
				//Guardo la info del nodo siguiente (nodo a eliminar) para poder retornarlo.
				T eliminado = (nodoTemp.next()).info();

				//nodoTemp apunta al siguiente del siguiente.
				//Asi el nodo a eliminar queda sin posible acceso y lo elimina el garbage collector.
				nodoTemp.next((nodoTemp.next()).next());
				size--;
				return eliminado;
				}
			} else {
				throw new IndexOutOfBoundsException("El índice está fuera de rango en 'eliminar'.");
			}
		} else {
			throw new Error("La lista está vacía. No se puede eliminar.");
		}
	}

	/**
	* Obtiene un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a obtener
	* @return el elemento en la posición {@code indice}
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	@Override
	public T obtener(int indice) {
		if (indice >= 0 && indice < elementos()) {
			Nodo<T> nodo = head;
			for (int i = 0; i < indice; i++) {
				nodo = nodo.next();
			}
			return nodo.info();
		} else {
			throw new IndexOutOfBoundsException("Índice fuera de rango en 'obtener'");
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
	//@Override
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
	@Override
	public void vaciar() {
		head = null;
	}
	
	/**
	* Retorna la cantidad de elementos agregados a la lista.
	* @return cantidad de elementos en la lista
	*/
	@Override
	public int elementos() {
		return size;
	}

	/**
	* Permite evaluar si la lista no tiene elementos.
	* Este método es equivalente a:
	* <pre>lista.elementos() == 0</pre>
	* @return {@code true} sii la pila no tiene elementos
	*/
	@Override
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
