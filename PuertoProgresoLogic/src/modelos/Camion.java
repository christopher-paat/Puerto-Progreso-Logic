package modelos;

/**
 * Representa un camión que llega al puerto.
 */
public class Camion {
    private String placa;
    private String empresa;

    /**
     * - Parámetros de entrada: placa que identifica al camión y empresa transportista propietaria.
     * - Salida: Objeto Camion configurado con sus datos básicos.
     * - Propósito: Representar un vehículo de transporte que llega al puerto para dejar carga.
     */
    public Camion(String placa, String empresa) {
        this.placa = placa;
        this.empresa = empresa;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Cadena con la placa registrada del camión.
     * - Propósito: Consultar el identificador del vehículo que participa en la logística del puerto.
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * - Parámetros de entrada: placa con el nuevo identificador del camión.
     * - Salida: Ninguna (void); el estado interno del objeto se actualiza.
     * - Propósito: Modificar la placa asociada al camión cuando sea necesario.
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Nombre de la empresa transportista asociada al camión.
     * - Propósito: Consultar qué empresa opera el vehículo.
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * - Parámetros de entrada: empresa con el nuevo nombre de la transportista.
     * - Salida: Ninguna (void); el estado interno del camión se actualiza.
     * - Propósito: Cambiar la empresa asociada al camión cuando se requiera.
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Camion [Placa=" + placa + ", Empresa=" + empresa + "]";
    }
}
