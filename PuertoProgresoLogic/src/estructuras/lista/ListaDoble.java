package estructuras.lista;

import estructuras.nodo.NodoDoble;

public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;

    public ListaDoble() {
        cabeza = cola = null;
    }

    public void insertarFinal(Object dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    public void recorrerAdelante() {
        NodoDoble aux = cabeza;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    public void recorrerAtras() {
        NodoDoble aux = cola;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.anterior;
        }
    }
}
