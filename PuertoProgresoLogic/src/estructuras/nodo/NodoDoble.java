package estructuras.nodo;

/**
 * Nodo doble con enlaces anterior y siguiente.
 */
public class NodoDoble {
    public Object dato;
    public NodoDoble siguiente;
    public NodoDoble anterior;

    /**
     * Crea un nodo con dato y enlaces nulos.
     *
     * @param dato valor a almacenar.
     */
    public NodoDoble(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
