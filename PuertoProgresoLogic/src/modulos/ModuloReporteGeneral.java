package modulos;

import modelos.Camion;
import modelos.Parada;
import utils.Entrada;

/**
 * Módulo para generar el reporte general del puerto.
 */
public class ModuloReporteGeneral {
    private final ModuloRecepcion recepcion;
    private final ModuloPatio patio;
    private final ModuloRutas rutas;

    /**
     * - Parámetros de entrada: recepción, patio y rutas que representan los módulos principales del sistema.
     * - Salida: Instancia de ModuloReporteGeneral configurada con las dependencias necesarias.
     * - Propósito: Inicializar el módulo encargado de consolidar y mostrar el estado global del puerto.
     */
    public ModuloReporteGeneral(ModuloRecepcion recepcion, ModuloPatio patio, ModuloRutas rutas) {
        this.recepcion = recepcion;
        this.patio = patio;
        this.rutas = rutas;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ninguna (void); se imprime el reporte general y se espera confirmación por consola.
     * - Propósito: Presentar un resumen integral del estado de recepción, patio e itinerario de rutas.
     */
    public void mostrar() {
        System.out.println("\nREPORTE GENERAL DEL PUERTO");

        System.out.println("\n[ESTADO DE RECEPCION]");
        System.out.println("Camiones en espera: " + recepcion.getEnEspera());
        Camion proximo = recepcion.getProximo();
        System.out.println("Proximo en turno: " + (proximo == null ? "N/A" : proximo.getPlaca()));

        System.out.println("\n[ESTADO DE INVENTARIO]");
        System.out.println(patio.resumenInventario());

        System.out.println("\n[ESTADO DE LOGISTICA]");
        int totalParadas = rutas.getTotalParadas();
        System.out.println("Rutas activas: " + (totalParadas > 0 ? 1 : 0));
        Parada proxima = rutas.getProximaParada();
        System.out.println("Proximo destino: " + (proxima == null ? "N/A" : proxima.getNombre()));
        System.out.println("Total de paradas programadas: " + totalParadas);

        System.out.println("\nPresione ENTER para volver al menu principal...");
        Entrada.leerTexto();
    }
}
