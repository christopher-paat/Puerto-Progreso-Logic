package modelos;

/**
 * Representa un camion que llega al puerto.
 */
public class Camion {
    private String placa;
    private String empresa;

    /**
     * Crea un camion con placa y empresa.
     *
     * @param placa identificador del camion.
     * @param empresa empresa transportista.
     */
    public Camion(String placa, String empresa) {
        this.placa = placa;
        this.empresa = empresa;
    }

    /**
     * Obtiene la placa.
     *
     * @return placa actual.
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Actualiza la placa.
     * Salida: estado actualizado.
     *
     * @param placa nueva placa.
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Obtiene la empresa.
     *
     * @return empresa actual.
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Actualiza la empresa.
     * Salida: estado actualizado.
     *
     * @param empresa nueva empresa.
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Camion [Placa=" + placa + ", Empresa=" + empresa + "]";
    }
}
