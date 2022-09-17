package colecciones.cola;

import java.nio.channels.IllegalSelectorException;
import java.util.Collection;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

/**
* Implementación basada en arreglos de tamaño fijo de la interfaz {@code Cola}.
* @see colecciones.cola.Cola
*/
public class ColaArregloFijo<T> implements Cola<T> {

	/**
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos = 0;

	/**
	* Construye una nueva cola vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public ColaArregloFijo() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	/**
	* Construye una nueva cola vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la cola
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	public ColaArregloFijo(int capacidad) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
		arreglo = new Object[capacidad];
	}

	/**
	* Construye una cola a partir de elementos en una colección.
	* Los elementos en la colección se encolan de izquierda a derecha.
	* La capacidad de la cola va a ser suficiente para por lo menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la cola
	*/
	public ColaArregloFijo(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		arreglo = new Object[Math.max(elems.size(), CAPACIDAD_POR_DEFECTO)];
		for (T e : elems) {
			encolar(e);	
		}
	}

	@Override
	public boolean esVacia() {
		return elementos == 0;	
	}

	@Override
	public int elementos() {
		return elementos;
	}
	/**
	* Encola un elemento en el comienzo de la cola.
	* @param elem el elemento a encolar
	* @return {@code true} sii el elemento pudo ser encolado
	*/
	@Override
	public boolean encolar(T elem) {
		if (elementos() == arreglo.length) {
			return false;
		} else {
			for (int i = elementos()-1; i >= 0; i++) {
				arreglo[i+1] = arreglo[i];
			}
			arreglo[0] = elem;
			elementos++;
			return true;
		}
	}
	/**
	* Desencola el primer elemento de la cola, y retorna el elemento desencolado, si ésta no es vacía.
	* @return el primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	@Override
	public T desencolar() throws IllegalStateException {
		if (elementos() == 0) {
			throw new IllegalStateException("Intenta desencolar en una cola vacía.");
		} else {
			T elementoSacado = elemento(elementos()-1); //Por FIFO el primer elemento que sale es el que entró primero, el que se encuentra al final del arreglo
			elementos--;
			return elementoSacado;
		}
	}
	/**
	* Retorna el primero de la cola, si ésta no es vacía.
	* @return primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	@Override
	public T primero() throws IllegalStateException {
		if (!esVacia()) {
			return elemento(elementos-1);
		} else {
			throw new IllegalStateException("Cola vacía.");
		}
	}

	@Override
	public void vaciar() {
		elementos = 0;
	}

	@Override
	public boolean repOK() {
		//estructura cola cumple con dinámica FIFO
		throw new IllegalStateException("falta implementar repOK.");
	}

	@Override
	public String toString() {
		String c = "[ ";
		for (int i = 0; i < elementos(); i++) {
			c += elemento(i) + " ";
		}	
		c += "]";
		return c;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object other) {
		if (!(other instanceof Cola))
			return false;
		ColaArregloFijo<T> otraCola = (ColaArregloFijo<T>) other;
		if (otraCola.elementos() != elementos())
			return false;
		int i = 0;
		while(elementos() != (arreglo.length)-1 && elemento(i).equals(otraCola.elemento(i))){
			i++;
		}
		if(elemento(i).equals(otraCola.elemento(i))){
			return true;
		} else {
			return false;
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
