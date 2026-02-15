package modulos;

import estructuras.cola.Cola;
import modelos.Camion;
import utils.Entrada;

/**
 * Modulo de recepcion de camiones (colas).
 */
public class ModuloRecepcion {
    private Cola colaCamiones = new Cola();

    /**
     * Muestra el menu de recepcion y procesa opciones.
     * Salida: flujo interactivo por consola.
     */
    public void menu() {
        int opcion;
        do {
            System.out.println("\nZONA DE RECEPCIÓN");
            System.out.println("[1] Registrar camión");
            System.out.println("[2] Dar ingreso");
            System.out.println("[3] Ver próximo");
            System.out.println("[4] Listar en espera");
            System.out.println("[5] Volver");

            opcion = Entrada.leerInt();

            switch (opcion) {
                case 1 -> registrar();
                case 2 -> ingresar();
                case 3 -> verProximo();
                case 4 -> listar();
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 5);
    }

    /**
     * Registra un camion en la cola de espera.
     * Salida: cola actualizada.
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
     * Atiende al siguiente camion en la cola.
     * Salida: impresion del camion atendido.
     */
    private void ingresar() {
        Camion c = despacharCamion();
        if (c != null)
            System.out.println("Ingresó: " + c);
    }

    /**
     * Muestra el proximo camion en turno.
     * Salida: impresion en consola.
     */
    private void verProximo() {
        System.out.println("Próximo: " + colaCamiones.peek());
    }

    /**
     * Lista todos los camiones en espera.
     * Salida: impresion en consola.
     */
    private void listar() {
        colaCamiones.listar();
    }

    /**
     * Obtiene la cantidad de camiones en espera.
     *
     * @return total en cola.
     */
    public int getEnEspera() {
        return colaCamiones.getTamaño();
    }

    /**
     * Obtiene el camion en turno sin retirarlo.
     *
     * @return camion en el frente o null.
     */
    public Camion getProximo() {
        return (Camion) colaCamiones.peek();
    }

    /**
     * Retira y devuelve el proximo camion en la cola.
     *
     * @return camion despachado o null si no hay.
     */
    public Camion despacharCamion() {
        return (Camion) colaCamiones.dequeue();
    }
}
