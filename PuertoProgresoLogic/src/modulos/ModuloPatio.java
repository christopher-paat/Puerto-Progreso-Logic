package modulos;

import estructuras.pila.Pila;
import modelos.Contenedor;
import utils.Entrada;

public class ModuloPatio {
    private Pila pilaA = new Pila(5);

    public void menu() {
        int op;
        do {
            System.out.println("\nPATIO DE CONTENEDORES");
            System.out.println("[1] Ingresar contenedor");
            System.out.println("[2] Retirar contenedor");
            System.out.println("[3] Ver tope");
            System.out.println("[4] Volver");

            op = Entrada.leerInt();

            switch (op) {
                case 1 -> ingresar();
                case 2 -> retirar();
                case 3 -> verTope();
            }
        } while (op != 4);
    }

    private void ingresar() {
        System.out.print("Código contenedor: ");
        String cod = Entrada.leerTexto();
        pilaA.push(new Contenedor(cod));
    }

    private void retirar() {
        System.out.println("Retirado: " + pilaA.pop());
    }

    private void verTope() {
        System.out.println("Tope: " + pilaA.peek());
    }
}
