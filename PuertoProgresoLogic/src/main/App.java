package main;

import modulos.ModuloPatio;
import modulos.ModuloRecepcion;
import modulos.ModuloReporteGeneral;
import modulos.ModuloRutas;
import utils.Entrada;

/**
 * Punto de entrada de la aplicación.
 */
public class App {
    /**
     * - Parámetros de entrada: args de la línea de comandos (no utilizados en este sistema).
     * - Salida: Ninguna (void); se mantiene la ejecución hasta que el usuario elija salir.
     * - Propósito: Iniciar el menú principal de PUERTO PROGRESO LOGIC y coordinar los módulos de recepción, patio, rutas y reporte.
     */
    public static void main(String[] args) throws Exception {
        ModuloRecepcion recepcion = new ModuloRecepcion();
        ModuloPatio patio = new ModuloPatio(recepcion);
        ModuloRutas rutas = new ModuloRutas();
        ModuloReporteGeneral reporte = new ModuloReporteGeneral(recepcion, patio, rutas);

        int opcion;
        do {
            System.out.println("\nPUERTO PROGRESO LOGIC");
            System.out.println("[1] Zona de Recepción");
            System.out.println("[2] Patio de Contenedores");
            System.out.println("[3] Rutas de Distribución");
            System.out.println("[4] Reporte General");
            System.out.println("[5] Salir");

            opcion = Entrada.leerInt();

            switch (opcion) {
                case 1 -> recepcion.menu();
                case 2 -> patio.menu();
                case 3 -> rutas.menu();
                case 4 -> reporte.mostrar();
                case 5 -> {}
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }
}
