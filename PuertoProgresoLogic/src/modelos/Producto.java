package modelos;

/**
 * Representa un producto con id, nombre y peso.
 */
public class Producto {
    private int id;
    private String nombre;
    private double peso;

    /**
     * - Parámetros de entrada: id único del producto, nombre descriptivo y peso en kilogramos.
     * - Salida: Objeto Producto inicializado con sus datos básicos.
     * - Propósito: Representar un ítem de carga individual dentro de un contenedor.
     */
    public Producto(int id, String nombre, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Identificador numérico actual del producto.
     * - Propósito: Consultar el id usado para referenciar el producto en búsquedas.
     */
    public int getId() {
        return id;
    }

    /**
     * - Parámetros de entrada: id con el nuevo identificador del producto.
     * - Salida: Ninguna (void); el estado interno del objeto se actualiza.
     * - Propósito: Cambiar el identificador asociado al producto cuando se requiera.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Nombre actual del producto.
     * - Propósito: Consultar la descripción textual del ítem de carga.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * - Parámetros de entrada: nombre con la nueva descripción del producto.
     * - Salida: Ninguna (void); se actualiza el campo nombre.
     * - Propósito: Modificar el nombre con el que se identifica al producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * - Parámetros de entrada: peso con el nuevo valor en kilogramos.
     * - Salida: Ninguna (void); se actualiza el peso del producto.
     * - Propósito: Ajustar el peso registrado del ítem cuando cambian los datos de la carga.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Peso actual del producto en kilogramos.
     * - Propósito: Consultar el peso individual que aporta el producto al contenedor.
     */
    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " (" + peso + " kg)";
    }
}
