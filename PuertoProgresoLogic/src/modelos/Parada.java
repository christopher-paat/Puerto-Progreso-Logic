package modelos;

/**
 * Representa una parada de ruta.
 */
public class Parada {
    private String nombre;

    /**
     * - Parámetros de entrada: nombre de la parada de distribución.
     * - Salida: Objeto Parada inicializado con su nombre.
     * - Propósito: Representar un destino dentro de la ruta de distribución de contenedores.
     */
    public Parada(String nombre) {
        this.nombre = nombre;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Nombre actual asociado a la parada.
     * - Propósito: Consultar el identificador del destino dentro de la ruta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * - Parámetros de entrada: nombre con la nueva denominación de la parada.
     * - Salida: Ninguna (void); se actualiza el nombre almacenado.
     * - Propósito: Cambiar el nombre de una parada cuando se ajusta la ruta de distribución.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
