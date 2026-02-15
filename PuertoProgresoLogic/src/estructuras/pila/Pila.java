package estructuras.pila;

import estructuras.nodo.NodoSimple;
import modelos.Contenedor;

/**
 * Pila LIFO basada en nodos simples con límite de capacidad.
 */
public class Pila {
    private NodoSimple cima;
    private int tamaño;
    private final int max;

    /**
     * - Parámetros de entrada: max que indica la capacidad máxima permitida de la pila.
     * - Salida: Objeto Pila inicializado y vacío con límite de capacidad.
     * - Propósito: Crear la estructura LIFO que representará una columna de contenedores en el patio.
     */
    public Pila(int max) {
        this.cima = null;
        this.tamaño = 0;
        this.max = max;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: true si no hay elementos apilados; false en caso contrario.
     * - Propósito: Verificar si la columna de contenedores no tiene ningún contenedor.
     */
    public boolean estaVacia() {
        return cima == null;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: true si el número de elementos alcanzó el límite; false en caso contrario.
     * - Propósito: Validar si la columna de contenedores ya no admite más apilamiento.
     */
    public boolean estaLlena() {
        return tamaño == max;
    }

    /**
     * - Parámetros de entrada: dato a apilar (por ejemplo, un contenedor que ingresa al patio).
     * - Salida: Ninguna (void); la pila se actualiza agregando el elemento en la cima.
     * - Propósito: Apilar un nuevo contenedor respetando la política LIFO y el límite de altura.
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
     * - Parámetros de entrada: Ninguno.
     * - Salida: Elemento ubicado en la cima de la pila o null si está vacía.
     * - Propósito: Retirar el contenedor ubicado en la parte superior de la columna.
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
     * - Parámetros de entrada: Ninguno.
     * - Salida: Elemento actualmente en la cima o null si no hay elementos.
     * - Propósito: Consultar qué contenedor está en la parte superior sin modificar la pila.
     */
    public Object peek() {
        return estaVacia() ? null : cima.dato;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Número de elementos actualmente almacenados en la pila.
     * - Propósito: Conocer cuántos contenedores hay apilados en una columna.
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Capacidad máxima permitida para la pila.
     * - Propósito: Consultar el límite de altura configurado para la columna de contenedores.
     */
    public int getMax() {
        return max;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Peso total acumulado de todos los contenedores almacenados en la pila.
     * - Propósito: Obtener el peso total que representa una columna de contenedores en el patio.
     */
    public double calcularPesoTotal() {
        double total = 0;
        NodoSimple aux = cima;
        while (aux != null) {
            if (aux.dato instanceof Contenedor c) {
                total += c.pesoTotal();
            }
            aux = aux.siguiente;
        }
        return total;
    }

    /**
     * - Parámetros de entrada: nombre identificador de la pila (por ejemplo A, B o C).
     * - Salida: Cadena con el estado de ocupación y peso total de la pila.
     * - Propósito: Construir un resumen legible del estado de una columna de contenedores.
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
     * - Parámetros de entrada: código identificador del contenedor a localizar.
     * - Salida: Referencia al contenedor encontrado o null si no se halla en la pila.
     * - Propósito: Localizar un contenedor específico dentro de la columna para inspeccionarlo.
     */
    public Contenedor buscarContenedor(String codigo) {
        NodoSimple aux = cima;
        while (aux != null) {
            if (aux.dato instanceof Contenedor c) {
                if (c.getCodigo().equalsIgnoreCase(codigo)) {
                    return c;
                }
            }
            aux = aux.siguiente;
        }
        return null;
    }
}
