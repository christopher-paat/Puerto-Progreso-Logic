package main;

import modulos.ModuloPatio;
import modulos.ModuloRecepcion;
import modulos.ModuloReporteGeneral;
import modulos.ModuloRutas;
import utils.Entrada;

/**
 * Punto de entrada de la aplicacion.
 */
public class App {
    /**
     * Inicia el menu principal y coordina los modulos.
     *
     * @param args argumentos de linea de comandos (no usados).
     * @throws Exception si ocurre un error inesperado.
     */
    public static void main(String[] args) throws Exception {
        ModuloRecepcion recepcion = new ModuloRecepcion();
        ModuloPatio patio = new ModuloPatio(recepcion);
        ModuloRutas rutas = new ModuloRutas();
        ModuloReporteGeneral reporte = new ModuloReporteGeneral(recepcion, patio, rutas);

        int opcion;
        do {
            System.out.println("\nPUERTO PROGRESO LOGIC");
            System.out.println("[1] Zona de Recepcion");
            System.out.println("[2] Patio de Contenedores");
            System.out.println("[3] Rutas de Distribucion");
            System.out.println("[4] Reporte General");
            System.out.println("[5] Salir");

            opcion = Entrada.leerInt();

            switch (opcion) {
                case 1 -> recepcion.menu();
                case 2 -> patio.menu();
                case 3 -> rutas.menu();
                case 4 -> reporte.mostrar();
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 5);
    }
}
