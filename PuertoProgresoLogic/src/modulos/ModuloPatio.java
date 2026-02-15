package modulos;

import estructuras.pila.Pila;
import modelos.Contenedor;
import utils.Entrada;

public class ModuloPatio {
    private Pila pilaA = new Pila(5);
    private Pila pilaB = new Pila(5);
    private Pila pilaC = new Pila(5);

    public void menu() {
        int op;
        do {
            System.out.println("\nPATIO");
            System.out.println("[1] Ingresar contenedor");
            System.out.println("[2] Retirar contenedor");
            System.out.println("[3] Ver topes");
            System.out.println("[4] Volver");

            op = Entrada.leerInt();

            switch (op) {
                case 1 -> ingresar();
                case 2 -> retirar();
                case 3 -> verTopes();
            }
        } while (op != 4);
    }

    private Pila elegirPila() {
        System.out.println("Seleccione pila A/B/C:");
        String opc = Entrada.leerTexto().toUpperCase();

        return switch (opc) {
            case "A" -> pilaA;
            case "B" -> pilaB;
            case "C" -> pilaC;
            default -> null;
        };
    }

    private void ingresar() {
        Pila p = elegirPila();
        if (p == null)
            return;

        System.out.print("Código: ");
        String cod = Entrada.leerTexto();

        p.push(new Contenedor(cod));
    }

    private void retirar() {
        Pila p = elegirPila();
        if (p == null)
            return;

        System.out.println("Retirado: " + p.pop());
    }

    private void verTopes() {
        System.out.println("A: " + pilaA.peek());
        System.out.println("B: " + pilaB.peek());
        System.out.println("C: " + pilaC.peek());
    }

    public int totalContenedores() {
        return pilaA.getTamaño() + pilaB.getTamaño() + pilaC.getTamaño();
    }
}
