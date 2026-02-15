package modelos;

/**
 * Representa una parada de ruta.
 */
public class Parada {
    private String nombre;

    /**
     * Crea una parada con nombre.
     *
     * @param nombre nombre de la parada.
     */
    public Parada(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la parada.
     *
     * @return nombre actual.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre de la parada.
     * Salida: estado actualizado.
     *
     * @param nombre nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
