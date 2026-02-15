package modulos;

import estructuras.lista.ListaDoble;
import modelos.Parada;
import utils.Entrada;

public class ModuloRutas {
    private ListaDoble ruta = new ListaDoble();

    public void menu() {
        int op;
        do {
            System.out.println("\nRUTAS");
            System.out.println("[1] Agregar parada");
            System.out.println("[2] Recorrer adelante");
            System.out.println("[3] Recorrer atrás");
            System.out.println("[4] Volver");

            op = Entrada.leerInt();

            switch (op) {
                case 1 -> agregar();
                case 2 -> ruta.recorrerAdelante();
                case 3 -> ruta.recorrerAtras();
            }
        } while (op != 4);
    }

    private void agregar() {
        System.out.print("Nombre parada: ");
        ruta.insertarFinal(new Parada(Entrada.leerTexto()));
    }
}
