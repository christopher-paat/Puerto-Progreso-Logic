package estructuras.nodo;

public class NodoDoble {
    public Object dato;
    public NodoDoble siguiente;
    public NodoDoble anterior;

    public NodoDoble(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
