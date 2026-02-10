package estructuras.lista;

import estructuras.nodo.NodoSimple;
import modelos.Producto;

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

    public double calcularPeso() {
    double total = 0;
    NodoSimple aux = cabeza;
    while (aux != null) {
        Producto p = (Producto) aux.dato;
        total += p.getPeso();
        aux = aux.siguiente;
    }
    return total;
}
