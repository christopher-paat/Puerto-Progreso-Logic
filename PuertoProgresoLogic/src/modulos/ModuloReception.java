package modulos;

import estructuras.cola.Cola;
import modelos.Camion;
import utils.Entrada;

public class ModuloReception {
    private Cola colaCamiones = new Cola();

    public void menu() {
        int opcion;
        do {
            System.out.println("\nZONA DE RECEPCIÓN");
            System.out.println("[1] Registrar camión");
            System.out.println("[2] Dar ingreso");
            System.out.println("[3] Ver próximo");
            System.out.println("[4] Volver");

            opcion = Entrada.leerInt();

            switch (opcion) {
                case 1 -> registrar();
                case 2 -> ingresar();
                case 3 -> verProximo();
            }
        } while (opcion != 4);
    }

    private void registrar() {
        System.out.print("Placa: ");
        String placa = Entrada.leerTexto();
        System.out.print("Empresa: ");
        String emp = Entrada.leerTexto();

        colaCamiones.enqueue(new Camion(placa, emp));
        System.out.println("Camión registrado");
    }

    private void ingresar() {
        Camion c = (Camion) colaCamiones.dequeue();
        if (c != null)
            System.out.println("Ingresó: " + c);
    }

    private void verProximo() {
        System.out.println("Próximo: " + colaCamiones.peek());
    }
}
