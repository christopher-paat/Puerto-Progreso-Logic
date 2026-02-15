package modulos;

import modelos.Camion;
import modelos.Parada;
import utils.Entrada;

/**
 * Modulo para generar el reporte general del puerto.
 */
public class ModuloReporteGeneral {
    private final ModuloRecepcion recepcion;
    private final ModuloPatio patio;
    private final ModuloRutas rutas;

    /**
     * Crea el modulo con referencias a otros modulos.
     *
     * @param recepcion modulo de recepcion.
     * @param patio modulo de patio.
     * @param rutas modulo de rutas.
     */
    public ModuloReporteGeneral(ModuloRecepcion recepcion, ModuloPatio patio, ModuloRutas rutas) {
        this.recepcion = recepcion;
        this.patio = patio;
        this.rutas = rutas;
    }

    /**
     * Imprime el reporte general y espera confirmacion.
     * Salida: impresion en consola.
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
