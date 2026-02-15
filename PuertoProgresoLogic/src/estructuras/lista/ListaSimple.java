package estructuras.lista;

import estructuras.nodo.NodoSimple;
import modelos.Producto;

/**
 * Lista simplemente ligada con operaciones basicas.
 */
public class ListaSimple {
    private NodoSimple cabeza;

    /**
     * Crea una lista vacia.
     */
    public ListaSimple() {
        cabeza = null;
    }

    /**
     * Inserta un dato al inicio de la lista.
     * Salida: lista actualizada.
     *
     * @param dato elemento a insertar.
     */
    public void insertar(Object dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    /**
     * Busca un dato por igualdad.
     *
     * @param dato valor a buscar.
     * @return true si existe; false en caso contrario.
     */
    public boolean buscar(Object dato) {
        NodoSimple aux = cabeza;
        while (aux != null) {
            if (aux.dato.equals(dato))
                return true;
            aux = aux.siguiente;
        }
        return false;
    }

    /**
     * Recorre la lista e imprime cada elemento.
     * Salida: impresion en consola.
     */
    public void recorrer() {
        NodoSimple aux = cabeza;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    /**
     * Suma los pesos de los productos almacenados.
     *
     * @return peso total.
     */
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

    /**
     * Busca un producto por id.
     *
     * @param id identificador del producto.
     * @return producto encontrado o null.
     */
    public Producto buscarProductoPorId(int id) {
        NodoSimple aux = cabeza;
        while (aux != null) {
            Producto p = (Producto) aux.dato;
            if (p.getId() == id) {
                return p;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    /**
     * Busca un producto por nombre.
     *
     * @param nombre nombre del producto.
     * @return producto encontrado o null.
     */
    public Producto buscarProductoPorNombre(String nombre) {
        NodoSimple aux = cabeza;
        while (aux != null) {
            Producto p = (Producto) aux.dato;
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
            aux = aux.siguiente;
        }
        return null;
    }
}
