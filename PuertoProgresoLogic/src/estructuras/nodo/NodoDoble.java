package estructuras.nodo;

/**
 * Nodo doble con enlaces anterior y siguiente.
 */
public class NodoDoble {
    public Object dato;
    public NodoDoble siguiente;
    public NodoDoble anterior;

    /**
     * - Parámetros de entrada: dato que se almacenará en el nodo doble.
     * - Salida: NodoDoble con el dato asignado y enlaces anterior y siguiente en null.
     * - Propósito: Actuar como unidad básica para la lista doblemente ligada de paradas de ruta.
     */
    public NodoDoble(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
