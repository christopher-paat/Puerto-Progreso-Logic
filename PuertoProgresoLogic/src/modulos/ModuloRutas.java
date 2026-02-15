package modulos;

import estructuras.lista.ListaDoble;
import modelos.Parada;
import utils.Entrada;

/**
 * Modulo de rutas de distribucion (lista doble).
 */
public class ModuloRutas {
    private ListaDoble ruta = new ListaDoble();

    /**
     * Muestra el menu de rutas y procesa opciones.
     * Salida: flujo interactivo por consola.
     */
    public void menu() {
        int op;
        do {
            System.out.println("\nRUTAS");
            System.out.println("[1] Agregar parada");
            System.out.println("[2] Insertar parada entre destinos");
            System.out.println("[3] Cancelar parada");
            System.out.println("[4] Simular recorrido");
            System.out.println("[5] Volver");

            op = Entrada.leerInt();

            switch (op) {
                case 1 -> agregar();
                case 2 -> insertarEntre();
                case 3 -> cancelar();
                case 4 -> simular();
                default -> System.out.println("Opcion invalida");
            }
        } while (op != 5);
    }

    /**
     * Agrega una parada al final de la ruta.
     * Salida: lista actualizada.
     */
    private void agregar() {
        System.out.print("Nombre parada: ");
        ruta.insertarFinal(new Parada(Entrada.leerTexto()));
    }

    /**
     * Inserta una parada despues de otra existente.
     * Salida: lista actualizada si se encontro referencia.
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
     * Elimina una parada por nombre.
     * Salida: lista actualizada si existe.
     */
    private void cancelar() {
        System.out.print("Nombre de parada a cancelar: ");
        String nombre = Entrada.leerTexto();
        boolean ok = ruta.eliminarPorNombre(nombre);
        System.out.println(ok ? "Parada cancelada" : "Parada no encontrada");
    }

    /**
     * Simula el recorrido con navegacion anterior/siguiente.
     * Salida: flujo interactivo por consola.
     */
    private void simular() {
        if (ruta.getTamaño() == 0) {
            System.out.println("Ruta vacia");
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
                default -> System.out.println("Opcion invalida");
            }
        } while (op != 3);
    }

    /**
     * Obtiene el total de paradas registradas.
     *
     * @return cantidad de paradas.
     */
    public int getTotalParadas() {
        return ruta.getTamaño();
    }

    /**
     * Obtiene la primera parada programada.
     *
     * @return parada inicial o null.
     */
    public Parada getProximaParada() {
        return (Parada) ruta.getPrimero();
    }
}
