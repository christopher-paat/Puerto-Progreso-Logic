package estructuras.pila;

import estructuras.nodo.NodoSimple;

public class Pila {
    private NodoSimple cima;
    private int tamaño;
    private int max;

    public Pila(int max) {
        this.cima = null;
        this.tamaño = 0;
        this.max = max;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public boolean estaLlena() {
        return tamaño == max;
    }

    public void push(Object dato) {
        if (estaLlena()) {
            System.out.println("Pila llena");
            return;
        }
        NodoSimple nuevo = new NodoSimple(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamaño++;
    }

    public Object pop() {
        if (estaVacia()) {
            System.out.println("Pila vacía");
            return null;
        }
        Object dato = cima.dato;
        cima = cima.siguiente;
        tamaño--;
        return dato;
    }

    public Object peek() {
        return estaVacia() ? null : cima.dato;
    }

    public int getTamaño() {
        return tamaño;
    }
}
