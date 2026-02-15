package estructuras.nodo;

/**
 * Nodo simple con enlace al siguiente.
 */
public class NodoSimple {
    public Object dato;
    public NodoSimple siguiente;

    /**
     * Crea un nodo con dato y siguiente nulo.
     *
     * @param dato valor a almacenar.
     */
    public NodoSimple(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
