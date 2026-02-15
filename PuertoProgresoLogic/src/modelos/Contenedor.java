package modelos;

import estructuras.lista.ListaSimple;

/**
 * Representa un contenedor con lista de productos.
 */
public class Contenedor {
    private String codigo;
    private ListaSimple productos;

    /**
     * Crea un contenedor con codigo.
     *
     * @param codigo identificador del contenedor.
     */
    public Contenedor(String codigo) {
        this.codigo = codigo;
        productos = new ListaSimple();
    }

    /**
     * Agrega un producto al contenedor.
     * Salida: lista de productos actualizada.
     *
     * @param p producto a agregar.
     */
    public void agregarProducto(Producto p) {
        productos.insertar(p);
    }

    /**
     * Calcula el peso total de productos.
     *
     * @return peso total.
     */
    public double pesoTotal() {
        return productos.calcularPeso();
    }

    /**
     * Busca un producto por id.
     *
     * @param id identificador del producto.
     * @return producto encontrado o null.
     */
    public Producto buscarProductoPorId(int id) {
        return productos.buscarProductoPorId(id);
    }

    /**
     * Busca un producto por nombre.
     *
     * @param nombre nombre del producto.
     * @return producto encontrado o null.
     */
    public Producto buscarProductoPorNombre(String nombre) {
        return productos.buscarProductoPorNombre(nombre);
    }

    /**
     * Obtiene el codigo del contenedor.
     *
     * @return codigo actual.
     */
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Contenedor " + codigo + " Peso: " + pesoTotal() + " kg";
    }
}
