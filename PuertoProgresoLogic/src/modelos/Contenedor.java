package modelos;

import estructuras.lista.ListaSimple;

/**
 * Representa un contenedor con lista de productos.
 */
public class Contenedor {
    private String codigo;
    private ListaSimple productos;

    /**
     * - Parámetros de entrada: código identificador único del contenedor.
     * - Salida: Objeto Contenedor con su lista interna de productos vacía.
     * - Propósito: Representar un contenedor físico que almacena productos dentro del puerto.
     */
    public Contenedor(String codigo) {
        this.codigo = codigo;
        productos = new ListaSimple();
    }

    /**
     * - Parámetros de entrada: p como producto que se desea registrar en el contenedor.
     * - Salida: Ninguna (void); la lista simplemente ligada de productos se actualiza.
     * - Propósito: Añadir un producto al manifiesto interno del contenedor.
     */
    public void agregarProducto(Producto p) {
        productos.insertar(p);
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Peso total de todos los productos almacenados en el contenedor.
     * - Propósito: Conocer el peso total que representa el contenedor para la operación logística.
     */
    public double pesoTotal() {
        return productos.calcularPeso();
    }

    /**
     * - Parámetros de entrada: id numérico del producto a buscar.
     * - Salida: Producto encontrado en la lista interna o null si no existe.
     * - Propósito: Localizar un producto específico dentro del contenedor usando su identificador.
     */
    public Producto buscarProductoPorId(int id) {
        return productos.buscarProductoPorId(id);
    }

    /**
     * - Parámetros de entrada: nombre del producto a localizar.
     * - Salida: Producto que coincide por nombre o null si no se encuentra.
     * - Propósito: Permitir la búsqueda de productos en el contenedor por su nombre comercial.
     */
    public Producto buscarProductoPorNombre(String nombre) {
        return productos.buscarProductoPorNombre(nombre);
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Código identificador actual del contenedor.
     * - Propósito: Consultar el código con el que se rastrea el contenedor en el puerto.
     */
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Contenedor " + codigo + " Peso: " + pesoTotal() + " kg";
    }
}
