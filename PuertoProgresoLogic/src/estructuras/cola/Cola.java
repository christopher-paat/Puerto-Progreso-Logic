package estructuras.cola;

import estructuras.nodo.NodoSimple;

/**
 * Cola FIFO basada en nodos simples.
 */
public class Cola {
    private NodoSimple frente;
    private NodoSimple fin;
    private int tamaño;

    /**
     * Crea una cola vacia.
     */
    public Cola() {
        frente = fin = null;
        tamaño = 0;
    }

    /**
     * Indica si la cola no tiene elementos.
     *
     * @return true si esta vacia; false en caso contrario.
     */
    public boolean estaVacia() {
        return frente == null;
    }

    /**
     * Inserta un elemento al final de la cola.
     * Salida: estructura actualizada.
     *
     * @param dato elemento a encolar.
     */
    public void enqueue(Object dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamaño++;
    }

    /**
     * Elimina y devuelve el elemento del frente.
     *
     * @return dato en el frente o null si esta vacia.
     */
    public Object dequeue() {
        if (estaVacia()) {
            System.out.println("Cola vacía");
            return null;
        }
        Object dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null)
            fin = null;
        tamaño--;
        return dato;
    }

    /**
     * Devuelve el elemento del frente sin eliminarlo.
     *
     * @return dato en el frente o null si esta vacia.
     */
    public Object peek() {
        return estaVacia() ? null : frente.dato;
    }

    /**
     * Obtiene el total de elementos en la cola.
     *
     * @return cantidad de elementos.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Imprime todos los elementos en orden de llegada.
     * Salida: impresion en consola.
     */
    public void listar() {
        if (estaVacia()) {
            System.out.println("Sin camiones en espera");
            return;
        }
        NodoSimple aux = frente;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }
}
