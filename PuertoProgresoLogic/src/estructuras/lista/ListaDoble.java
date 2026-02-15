package estructuras.lista;

import estructuras.nodo.NodoDoble;
import modelos.Parada;

/**
 * Lista doblemente ligada para rutas de distribucion.
 */
public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;
    private int tamaño;
    private NodoDoble actual;

    /**
     * Crea una lista doble vacia.
     */
    public ListaDoble() {
        cabeza = cola = null;
        tamaño = 0;
        actual = null;
    }

    /**
     * Inserta un dato al final de la lista.
     * Salida: lista actualizada.
     *
     * @param dato elemento a insertar.
     */
    public void insertarFinal(Object dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        tamaño++;
    }

    /**
     * Recorre la lista de inicio a fin e imprime elementos.
     * Salida: impresion en consola.
     */
    public void recorrerAdelante() {
        NodoDoble aux = cabeza;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    /**
     * Recorre la lista de fin a inicio e imprime elementos.
     * Salida: impresion en consola.
     */
    public void recorrerAtras() {
        NodoDoble aux = cola;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.anterior;
        }
    }

    /**
     * Obtiene la cantidad total de elementos.
     *
     * @return tamanio de la lista.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Obtiene el primer elemento de la lista.
     *
     * @return dato en la cabeza o null si esta vacia.
     */
    public Object getPrimero() {
        return cabeza == null ? null : cabeza.dato;
    }

    /**
     * Inserta un dato despues de una parada con nombre indicado.
     *
     * @param nombreRef nombre de referencia.
     * @param dato dato a insertar.
     * @return true si se inserto; false si no se encontro la referencia.
     */
    public boolean insertarDespuesDeNombre(String nombreRef, Object dato) {
        NodoDoble aux = cabeza;
        while (aux != null) {
            if (aux.dato instanceof Parada) {
                Parada p = (Parada) aux.dato;
                if (p.getNombre().equalsIgnoreCase(nombreRef)) {
                    NodoDoble nuevo = new NodoDoble(dato);
                    NodoDoble siguiente = aux.siguiente;
                    aux.siguiente = nuevo;
                    nuevo.anterior = aux;
                    nuevo.siguiente = siguiente;
                    if (siguiente != null) {
                        siguiente.anterior = nuevo;
                    } else {
                        cola = nuevo;
                    }
                    tamaño++;
                    return true;
                }
            }
            aux = aux.siguiente;
        }
        return false;
    }

    /**
     * Elimina la primera parada que coincida con el nombre.
     *
     * @param nombre nombre de la parada a eliminar.
     * @return true si se elimino; false si no se encontro.
     */
    public boolean eliminarPorNombre(String nombre) {
        NodoDoble aux = cabeza;
        while (aux != null) {
            if (aux.dato instanceof Parada) {
                Parada p = (Parada) aux.dato;
                if (p.getNombre().equalsIgnoreCase(nombre)) {
                    NodoDoble anterior = aux.anterior;
                    NodoDoble siguiente = aux.siguiente;
                    if (anterior != null) {
                        anterior.siguiente = siguiente;
                    } else {
                        cabeza = siguiente;
                    }
                    if (siguiente != null) {
                        siguiente.anterior = anterior;
                    } else {
                        cola = anterior;
                    }
                    if (actual == aux) {
                        actual = siguiente != null ? siguiente : anterior;
                    }
                    tamaño--;
                    return true;
                }
            }
            aux = aux.siguiente;
        }
        return false;
    }

    /**
     * Inicializa el puntero de recorrido en la cabeza.
     * Salida: estado interno actualizado.
     */
    public void iniciarRecorrido() {
        actual = cabeza;
    }

    /**
     * Devuelve el elemento actual del recorrido.
     *
     * @return dato actual o null si no hay recorrido.
     */
    public Object getActual() {
        return actual == null ? null : actual.dato;
    }

    /**
     * Avanza el puntero al siguiente elemento.
     *
     * @return dato actual despues de avanzar o null si no hay recorrido.
     */
    public Object avanzar() {
        if (actual == null) {
            return null;
        }
        if (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    /**
     * Retrocede el puntero al elemento anterior.
     *
     * @return dato actual despues de retroceder o null si no hay recorrido.
     */
    public Object retroceder() {
        if (actual == null) {
            return null;
        }
        if (actual.anterior != null) {
            actual = actual.anterior;
        }
        return actual.dato;
    }
}
