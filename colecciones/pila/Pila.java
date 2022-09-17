package colecciones.pila;

/**
* Esta clase representa una pila de objetos <b>last in first out (LIFO)</b> donde el último elemento insertado es le primero que se accede.
* Las operaciones disponibles para esta estructura son:
* <ul>
*  <li> push      : inserta un nuevo elemento en el tope de la pila y evalúa si fue apilado con éxito</li>
*  <li> pop       : desapila el elemento en el tope y retorna el elemento desapilado</li>
*  <li> tope      : retorna el tope de la pila</li> 
*  <li> esVacia   : Permite consultar si la pila está vacía</li>
*  <li> estaLlena : Permite consultar si la pila está llena</li>
*  <li> repOK		  : Permite validar si una instancia satisface el invariante de representación</li>
*  <li> toString	: Retorna una representación en forma de cadena</li>
*  <li> equals		: Permite evaluar si otra instancia de pila es igual a esta</li>
* </ul>
*/

public interface Pila<T> {
  /**
	* Inserta un elemento en el tope de la pila.
	* @param elem el elemento a apilar.
	* @return {@code true} sii el elemento pudo ser apilado
	*/
	public boolean push(T elem);

  /**
	* Desapila el tope de la pila, y retorna el elemento desapilado, si ésta no es vacía.
	* @return el tope de la pila
	* @throws IllegalStateException si la pila está vacía
	* @see #esVacia()
	*/
  public T pop();

  /**
	* Retorna el tope de la pila, si ésta no es vacía.
	* @return tope de la pila
	* @throws IllegalStateException si la pila está vacía
	* @see #esVacia()
	*/
  public T tope();

  /**
  * Permite evaluar si la pila está llena.
  * @return {@code true} sii la pila está llena
  */
  public boolean estaLlena();

  /**
	* Permite evaluar si la pila no tiene elementos.
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia();

  /**
	* Invariante de clase.
	* @return {@code true} sii la pila satisface su invariante de clase
	*/
	public boolean repOK();

	@Override
	public String toString();

	@Override
	public boolean equals(Object otra);
}
