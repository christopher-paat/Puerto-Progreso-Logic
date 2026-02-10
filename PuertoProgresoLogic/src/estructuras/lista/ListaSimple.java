package estructuras.lista;

import estructuras.nodo.NodoSimple;

public class ListaSimple {
    private NodoSimple cabeza;

    public ListaSimple() {
        cabeza = null;
    }

    public void insertar(Object dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public boolean buscar(Object dato) {
        NodoSimple aux = cabeza;
        while (aux != null) {
            if (aux.dato.equals(dato)) return true;
            aux = aux.siguiente;
        }
        return false;
    }

    public void recorrer() {
        NodoSimple aux = cabeza;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }
}
