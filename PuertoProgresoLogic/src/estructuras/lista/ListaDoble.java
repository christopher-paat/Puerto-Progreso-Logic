package estructuras.lista;

import estructuras.nodo.NodoDoble;
import modelos.Parada;

/**
 * Lista doblemente ligada para rutas de distribución.
 */
public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;
    private int tamaño;
    private NodoDoble actual;

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Objeto ListaDoble inicializado y vacío.
     * - Propósito: Crear la estructura que representará la ruta de distribución con sus paradas.
     */
    public ListaDoble() {
        cabeza = cola = null;
        tamaño = 0;
        actual = null;
    }

    /**
     * - Parámetros de entrada: dato a insertar (normalmente una instancia de Parada).
     * - Salida: Ninguna (void); la lista se actualiza agregando el nodo al final.
     * - Propósito: Registrar una nueva parada al final de la ruta de distribución.
     */
    public void insertarFinal(Object dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        tamaño++;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ningún valor de retorno; se imprimen los elementos de la lista en consola.
     * - Propósito: Mostrar la ruta completa recorriendo las paradas de inicio a fin.
     */
    public void recorrerAdelante() {
        NodoDoble aux = cabeza;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ningún valor de retorno; se imprimen las paradas desde el final hacia el inicio.
     * - Propósito: Mostrar la ruta invertida recorriendo las paradas de fin a inicio.
     */
    public void recorrerAtras() {
        NodoDoble aux = cola;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.anterior;
        }
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Número total de elementos almacenados en la lista doble.
     * - Propósito: Conocer cuántas paradas componen actualmente la ruta de distribución.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Dato almacenado en la cabeza de la lista o null si está vacía.
     * - Propósito: Obtener la primera parada programada en la ruta.
     */
    public Object getPrimero() {
        return cabeza == null ? null : cabeza.dato;
    }

    /**
     * - Parámetros de entrada: nombreRef de la parada de referencia y dato a insertar después de ella.
     * - Salida: true si se logró insertar la nueva parada; false si la referencia no existe.
     * - Propósito: Permitir insertar una parada de emergencia o adicional entre dos paradas existentes.
     */
    public boolean insertarDespuesDeNombre(String nombreRef, Object dato) {
        NodoDoble aux = cabeza;
        while (aux != null) {
            if (aux.dato instanceof Parada) {
                Parada p = (Parada) aux.dato;
                if (p.getNombre().equalsIgnoreCase(nombreRef)) {
                    NodoDoble nuevo = new NodoDoble(dato);
                    NodoDoble siguiente = aux.siguiente;
                    aux.siguiente = nuevo;
                    nuevo.anterior = aux;
                    nuevo.siguiente = siguiente;
                    if (siguiente != null) {
                        siguiente.anterior = nuevo;
                    } else {
                        cola = nuevo;
                    }
                    tamaño++;
                    return true;
                }
            }
            aux = aux.siguiente;
        }
        return false;
    }

    /**
     * - Parámetros de entrada: nombre de la parada que se desea eliminar de la ruta.
     * - Salida: true si se encontró y eliminó la parada; false en caso contrario.
     * - Propósito: Cancelar una parada específica de la ruta de distribución.
     */
    public boolean eliminarPorNombre(String nombre) {
        NodoDoble aux = cabeza;
        while (aux != null) {
            if (aux.dato instanceof Parada) {
                Parada p = (Parada) aux.dato;
                if (p.getNombre().equalsIgnoreCase(nombre)) {
                    NodoDoble anterior = aux.anterior;
                    NodoDoble siguiente = aux.siguiente;
                    if (anterior != null) {
                        anterior.siguiente = siguiente;
                    } else {
                        cabeza = siguiente;
                    }
                    if (siguiente != null) {
                        siguiente.anterior = anterior;
                    } else {
                        cola = anterior;
                    }
                    if (actual == aux) {
                        actual = siguiente != null ? siguiente : anterior;
                    }
                    tamaño--;
                    return true;
                }
            }
            aux = aux.siguiente;
        }
        return false;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ninguna (void); se posiciona el puntero interno en la cabeza de la lista.
     * - Propósito: Preparar la lista para simular el recorrido de la ruta desde la primera parada.
     */
    public void iniciarRecorrido() {
        actual = cabeza;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Dato asociado al nodo actual o null si no hay recorrido iniciado.
     * - Propósito: Conocer la parada en la que se encuentra actualmente el recorrido de la ruta.
     */
    public Object getActual() {
        return actual == null ? null : actual.dato;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Dato del nodo en el que queda el puntero tras avanzar, o null si no hay recorrido.
     * - Propósito: Moverse a la siguiente parada de la ruta durante la simulación de recorrido.
     */
    public Object avanzar() {
        if (actual == null) {
            return null;
        }
        if (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Dato del nodo en el que queda el puntero tras retroceder, o null si no hay recorrido.
     * - Propósito: Moverse a la parada anterior de la ruta durante la simulación de recorrido.
     */
    public Object retroceder() {
        if (actual == null) {
            return null;
        }
        if (actual.anterior != null) {
            actual = actual.anterior;
        }
        return actual.dato;
    }
}
