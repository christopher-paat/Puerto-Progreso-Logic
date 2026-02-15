package estructuras.cola;

import estructuras.nodo.NodoSimple;

/**
 * Cola FIFO basada en nodos simples.
 */
public class Cola {
    private NodoSimple frente;
    private NodoSimple fin;
    private int tamaño;

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Objeto Cola inicializado y vacío.
     * - Propósito: Crear la estructura FIFO que administrará la cola de camiones en recepción.
     */
    public Cola() {
        frente = fin = null;
        tamaño = 0;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: true si la cola está vacía; false en caso contrario.
     * - Propósito: Verificar si hay o no camiones esperando en la cola de recepción.
     */
    public boolean estaVacia() {
        return frente == null;
    }

    /**
     * - Parámetros de entrada: dato a encolar (por ejemplo, un camión que llega al puerto).
     * - Salida: Ninguna (void); la estructura interna de la cola queda actualizada.
     * - Propósito: Registrar la llegada de un nuevo camión agregándolo al final de la cola FIFO.
     */
    public void enqueue(Object dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamaño++;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Elemento del frente de la cola o null si no hay elementos.
     * - Propósito: Atender al siguiente camión permitiendo su ingreso y retirándolo de la cola.
     */
    public Object dequeue() {
        if (estaVacia()) {
            System.out.println("Cola vacía");
            return null;
        }
        Object dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null)
            fin = null;
        tamaño--;
        return dato;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Elemento ubicado en el frente de la cola o null si está vacía.
     * - Propósito: Consultar qué camión será atendido a continuación sin modificar la cola.
     */
    public Object peek() {
        return estaVacia() ? null : frente.dato;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Cantidad total de elementos actualmente en la cola.
     * - Propósito: Conocer cuántos camiones se encuentran esperando en recepción.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ningún valor de retorno; se imprime el contenido de la cola en consola.
     * - Propósito: Listar los camiones en espera respetando el orden de llegada (FIFO).
     */
    public void listar() {
        if (estaVacia()) {
            System.out.println("Sin camiones en espera");
            return;
        }
        NodoSimple aux = frente;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }
}
