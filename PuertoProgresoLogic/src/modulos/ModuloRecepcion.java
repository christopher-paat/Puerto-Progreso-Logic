package modulos;

import estructuras.cola.Cola;
import modelos.Camion;
import utils.Entrada;

/**
 * Módulo de recepción de camiones (colas).
 */
public class ModuloRecepcion {
    private Cola colaCamiones = new Cola();

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ninguna (void); se gestiona un flujo interactivo por consola.
     * - Propósito: Presentar y controlar el menú de recepción de camiones usando la cola FIFO.
     */
    public void menu() {
        int opcion;
        do {
            System.out.println("\nZONA DE RECEPCIÓN");
            System.out.println("[1] Registrar llegada de camión");
            System.out.println("[2] Dar ingreso a patio");
            System.out.println("[3] Ver próximo camión a atender");
            System.out.println("[4] Listar todos los camiones en espera");
            System.out.println("[5] Volver al Menú Principal");

            opcion = Entrada.leerInt();

            switch (opcion) {
                case 1 -> registrar();
                case 2 -> ingresar();
                case 3 -> verProximo();
                case 4 -> listar();
                case 5 -> {}
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }

    /**
     * - Parámetros de entrada: Ninguno; los datos del camión se leen desde consola.
     * - Salida: Ninguna (void); la cola de camiones queda actualizada.
     * - Propósito: Registrar un nuevo camión que llega al puerto y colocarlo en la cola de espera.
     */
    private void registrar() {
        System.out.print("Placa: ");
        String placa = Entrada.leerTexto();
        System.out.print("Empresa: ");
        String emp = Entrada.leerTexto();

        colaCamiones.enqueue(new Camion(placa, emp));
        System.out.println("Camión registrado");
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ninguna (void); se muestra por consola el camión atendido si existe.
     * - Propósito: Dar ingreso al siguiente camión en turno retirándolo de la cola de recepción.
     */
    private void ingresar() {
        Camion c = despacharCamion();
        if (c != null)
            System.out.println("Ingresó: " + c);
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ninguna (void); se imprime el camión que está en el frente de la cola.
     * - Propósito: Consultar cuál es el próximo camión que será atendido sin retirarlo de la cola.
     */
    private void verProximo() {
        System.out.println("Próximo: " + colaCamiones.peek());
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ninguna (void); se listan en consola todos los camiones en espera.
     * - Propósito: Visualizar el estado completo de la cola de recepción de camiones.
     */
    private void listar() {
        colaCamiones.listar();
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Número total de camiones actualmente en la cola.
     * - Propósito: Consultar la cantidad de transporte pendiente de ser atendido en recepción.
     */
    public int getEnEspera() {
        return colaCamiones.getTamaño();
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Camión ubicado en el frente de la cola o null si no hay camiones.
     * - Propósito: Saber qué camión será atendido a continuación sin modificar la cola.
     */
    public Camion getProximo() {
        return (Camion) colaCamiones.peek();
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Camión retirado de la cola o null si no hay camiones.
     * - Propósito: Despachar el siguiente camión en espera para que pueda ingresar al patio.
     */
    public Camion despacharCamion() {
        return (Camion) colaCamiones.dequeue();
    }
}
