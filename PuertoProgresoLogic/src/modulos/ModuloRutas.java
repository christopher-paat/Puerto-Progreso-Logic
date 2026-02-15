package modulos;

import estructuras.lista.ListaDoble;
import modelos.Parada;
import utils.Entrada;

/**
 * Módulo de rutas de distribución (lista doble).
 */
public class ModuloRutas {
    private ListaDoble ruta = new ListaDoble();

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ninguna (void); se gestiona un flujo interactivo por consola.
     * - Propósito: Presentar y controlar el menú de rutas de distribución basado en lista doble.
     */
    public void menu() {
        int op;
        do {
            System.out.println("\nRUTAS");
            System.out.println("[1] Agregar nueva parada al final");
            System.out.println("[2] Insertar parada entre destinos");
            System.out.println("[3] Cancelar parada");
            System.out.println("[4] Simular recorrido");
            System.out.println("[5] Volver al Menú Principal");

            op = Entrada.leerInt();

            switch (op) {
                case 1 -> agregar();
                case 2 -> insertarEntre();
                case 3 -> cancelar();
                case 4 -> simular();
                case 5 -> {}
                default -> System.out.println("Opción inválida");
            }
        } while (op != 5);
    }

    /**
     * - Parámetros de entrada: Ninguno; el nombre de la parada se lee desde consola.
     * - Salida: Ninguna (void); la lista de paradas se actualiza.
     * - Propósito: Añadir una nueva parada al final de la ruta de distribución.
     */
    private void agregar() {
        System.out.print("Nombre parada: ");
        ruta.insertarFinal(new Parada(Entrada.leerTexto()));
    }

    /**
     * - Parámetros de entrada: Ninguno; se leen desde consola la parada de referencia y la nueva parada.
     * - Salida: Ninguna (void); se informa por consola si la inserción fue exitosa.
     * - Propósito: Insertar una parada intermedia (por ejemplo, de emergencia) entre destinos existentes.
     */
    private void insertarEntre() {
        System.out.print("Insertar despues de: ");
        String ref = Entrada.leerTexto();
        System.out.print("Nombre nueva parada: ");
        String nombre = Entrada.leerTexto();

        boolean ok = ruta.insertarDespuesDeNombre(ref, new Parada(nombre));
        System.out.println(ok ? "Parada insertada" : "Parada de referencia no encontrada");
    }

    /**
     * - Parámetros de entrada: Ninguno; el nombre de la parada a cancelar se lee desde consola.
     * - Salida: Ninguna (void); se indica por consola si la parada fue encontrada y eliminada.
     * - Propósito: Cancelar una parada de la ruta cuando ya no es necesaria.
     */
    private void cancelar() {
        System.out.print("Nombre de parada a cancelar: ");
        String nombre = Entrada.leerTexto();
        boolean ok = ruta.eliminarPorNombre(nombre);
        System.out.println(ok ? "Parada cancelada" : "Parada no encontrada");
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ninguna (void); se ejecuta una simulación interactiva del recorrido.
     * - Propósito: Navegar hacia adelante y hacia atrás por la ruta de distribución usando la lista doble.
     */
    private void simular() {
        if (ruta.getTamaño() == 0) {
            System.out.println("Ruta vacía");
            return;
        }
        ruta.iniciarRecorrido();
        int op;
        do {
            System.out.println("\nRECORRIDO");
            System.out.println("Actual: " + ruta.getActual());
            System.out.println("[1] Anterior");
            System.out.println("[2] Siguiente");
            System.out.println("[3] Salir");

            op = Entrada.leerInt();

            switch (op) {
                case 1 -> ruta.retroceder();
                case 2 -> ruta.avanzar();
                case 3 -> {}
                default -> System.out.println("Opción inválida");
            }
        } while (op != 3);
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Cantidad total de paradas registradas en la ruta.
     * - Propósito: Conocer el tamaño actual de la ruta de distribución.
     */
    public int getTotalParadas() {
        return ruta.getTamaño();
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Primera parada de la ruta o null si no hay paradas.
     * - Propósito: Obtener el próximo destino inicial en la ruta de distribución.
     */
    public Parada getProximaParada() {
        return (Parada) ruta.getPrimero();
    }
}
