package estructuras.lista;

import estructuras.nodo.NodoSimple;
import modelos.Producto;

/**
 * Lista simplemente ligada con operaciones básicas.
 */
public class ListaSimple {
    private NodoSimple cabeza;

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Objeto ListaSimple inicializado y vacío.
     * - Propósito: Crear la estructura que almacenará los productos de un contenedor.
     */
    public ListaSimple() {
        cabeza = null;
    }

    /**
     * - Parámetros de entrada: dato a insertar (generalmente un producto asociado al contenedor).
     * - Salida: Ninguna (void); la lista se actualiza agregando el elemento al inicio.
     * - Propósito: Registrar un nuevo producto dentro del manifiesto de carga del contenedor.
     */
    public void insertar(Object dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    /**
     * - Parámetros de entrada: dato a buscar dentro de la lista.
     * - Salida: true si se encontró un nodo con ese dato; false en caso contrario.
     * - Propósito: Verificar la existencia de un elemento específico en la lista simplemente ligada.
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
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ningún valor de retorno; se imprimen los elementos en consola.
     * - Propósito: Visualizar secuencialmente el contenido almacenado en la lista de productos.
     */
    public void recorrer() {
        NodoSimple aux = cabeza;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Peso total resultante de sumar el peso de todos los productos de la lista.
     * - Propósito: Calcular el peso total del contenedor a partir de su manifiesto de productos.
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
     * - Parámetros de entrada: id numérico del producto a buscar.
     * - Salida: Instancia de Producto encontrada o null si no existe en la lista.
     * - Propósito: Localizar un producto específico dentro del contenedor usando su identificador.
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
     * - Parámetros de entrada: nombre del producto a ubicar en la lista.
     * - Salida: Producto encontrado que coincide por nombre o null si no se encontró.
     * - Propósito: Permitir la búsqueda de un producto en el contenedor por su nombre descriptivo.
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
