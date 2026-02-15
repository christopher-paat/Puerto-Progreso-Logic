package main;

import modulos.ModuloPatio;
import modulos.ModuloRecepcion;
import modulos.ModuloRutas;
import utils.Entrada;

public class App {
    public static void main(String[] args) throws Exception {
        ModuloRecepcion recepcion = new ModuloRecepcion();
        ModuloPatio patio = new ModuloPatio();
        ModuloRutas rutas = new ModuloRutas();

        int opcion;
        do {
            System.out.println("\nPUERTO PROGRESO LOGIC");
            System.out.println("[1] Recepción");
            System.out.println("[2] Patio");
            System.out.println("[3] Rutas");
            System.out.println("[4] Salir");

            opcion = Entrada.leerInt();

            switch (opcion) {
                case 1 -> recepcion.menu();
                case 2 -> patio.menu();
                case 3 -> rutas.menu();
            }
        } while (opcion != 4);
    }
}
