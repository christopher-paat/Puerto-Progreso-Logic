package estructuras.nodo;

/**
 * Nodo simple con enlace al siguiente.
 */
public class NodoSimple {
    public Object dato;
    public NodoSimple siguiente;

    /**
     * - Parámetros de entrada: dato que se desea almacenar en el nodo.
     * - Salida: NodoSimple con el campo dato asignado y el enlace siguiente en null.
     * - Propósito: Servir como unidad básica para estructuras lineales simples (cola, pila, lista simple).
     */
    public NodoSimple(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
