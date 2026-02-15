package modelos;

/**
 * Representa un producto con id, nombre y peso.
 */
public class Producto {
    private int id;
    private String nombre;
    private double peso;

    /**
     * Crea un producto con datos basicos.
     *
     * @param id identificador del producto.
     * @param nombre nombre del producto.
     * @param peso peso en kg.
     */
    public Producto(int id, String nombre, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
    }

    /**
     * Obtiene el id del producto.
     *
     * @return id actual.
     */
    public int getId() {
        return id;
    }

    /**
     * Actualiza el id del producto.
     * Salida: estado actualizado.
     *
     * @param id nuevo id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return nombre actual.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre del producto.
     * Salida: estado actualizado.
     *
     * @param nombre nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Actualiza el peso del producto.
     * Salida: estado actualizado.
     *
     * @param peso nuevo peso.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene el peso del producto.
     *
     * @return peso actual.
     */
    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " (" + peso + " kg)";
    }
}
