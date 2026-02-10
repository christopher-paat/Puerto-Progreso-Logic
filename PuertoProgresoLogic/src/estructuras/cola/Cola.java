package estructuras.cola;

import estructuras.nodo.NodoSimple;

public class Cola {
    private NodoSimple frente;
    private NodoSimple fin;

    public Cola() {
        frente = fin = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void enqueue(Object dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public Object dequeue() {
        if (estaVacia()) {
            System.out.println("Cola vacía");
            return null;
        }
        Object dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null)
            fin = null;
        return dato;
    }

    public Object peek() {
        return estaVacia() ? null : frente.dato;
    }
}
