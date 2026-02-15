package estructuras.pila;

import estructuras.nodo.NodoSimple;
import modelos.Contenedor;

/**
 * Pila LIFO basada en nodos simples con limite de capacidad.
 */
public class Pila {
    private NodoSimple cima;
    private int tamaño;
    private int max;

    /**
     * Crea una pila con capacidad maxima.
     *
     * @param max capacidad maxima permitida.
     */
    public Pila(int max) {
        this.cima = null;
        this.tamaño = 0;
        this.max = max;
    }

    /**
     * Indica si la pila esta vacia.
     *
     * @return true si esta vacia; false en caso contrario.
     */
    public boolean estaVacia() {
        return cima == null;
    }

    /**
     * Indica si la pila alcanzó su capacidad maxima.
     *
     * @return true si esta llena; false en caso contrario.
     */
    public boolean estaLlena() {
        return tamaño == max;
    }

    /**
     * Inserta un elemento en la cima.
     * Salida: estructura actualizada.
     *
     * @param dato elemento a apilar.
     */
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

    /**
     * Elimina y devuelve el elemento de la cima.
     *
     * @return dato de la cima o null si esta vacia.
     */
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

    /**
     * Devuelve el elemento de la cima sin eliminarlo.
     *
     * @return dato de la cima o null si esta vacia.
     */
    public Object peek() {
        return estaVacia() ? null : cima.dato;
    }

    /**
     * Obtiene la cantidad actual de elementos.
     *
     * @return tamanio de la pila.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Obtiene la capacidad maxima de la pila.
     *
     * @return limite maximo.
     */
    public int getMax() {
        return max;
    }

    /**
     * Calcula el peso total de los contenedores apilados.
     *
     * @return peso total acumulado.
     */
    public double calcularPesoTotal() {
        double total = 0;
        NodoSimple aux = cima;
        while (aux != null) {
            if (aux.dato instanceof Contenedor) {
                Contenedor c = (Contenedor) aux.dato;
                total += c.pesoTotal();
            }
            aux = aux.siguiente;
        }
        return total;
    }

    /**
     * Genera un resumen textual de la pila.
     *
     * @param nombre etiqueta de la pila.
     * @return resumen con estado y peso.
     */
    public String resumen(String nombre) {
        StringBuilder barra = new StringBuilder();
        for (int i = 0; i < tamaño; i++) {
            barra.append("|");
        }
        StringBuilder linea = new StringBuilder();
        linea.append("Pila ").append(nombre).append(": [").append(barra).append("] ");
        linea.append("(").append(tamaño).append("/").append(max).append(")");
        linea.append(" - Peso Total: ").append(calcularPesoTotal()).append(" kg");
        if (estaLlena()) {
            linea.append(" - CRITICO: LLENA!");
        }
        return linea.toString();
    }

    /**
     * Busca un contenedor por codigo.
     *
     * @param codigo codigo del contenedor.
     * @return contenedor encontrado o null si no existe.
     */
    public Contenedor buscarContenedor(String codigo) {
        NodoSimple aux = cima;
        while (aux != null) {
            if (aux.dato instanceof Contenedor) {
                Contenedor c = (Contenedor) aux.dato;
                if (c.getCodigo().equalsIgnoreCase(codigo)) {
                    return c;
                }
            }
            aux = aux.siguiente;
        }
        return null;
    }
}
