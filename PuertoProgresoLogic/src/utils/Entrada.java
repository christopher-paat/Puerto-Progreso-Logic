package utils;

import java.util.Scanner;

/**
 * Utilidad para lectura de entradas de consola con validacion basica.
 */
public class Entrada {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Lee un entero desde la entrada estandar.
     * Salida: valor entero valido.
     *
     * @return entero leido.
     */
    public static int leerInt() {
        while (true) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.print("Entrada invalida. Intente de nuevo: ");
            }
        }
    }

    /**
     * Lee un texto no vacio desde la entrada estandar.
     * Salida: cadena no vacia.
     *
     * @return texto leido.
     */
    public static String leerTexto() {
        while (true) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.print("Entrada vacia. Intente de nuevo: ");
        }
    }

    /**
     * Lee un numero decimal desde la entrada estandar.
     * Salida: valor double valido.
     *
     * @return numero double leido.
     */
    public static double leerDouble() {
        while (true) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException ex) {
                System.out.print("Entrada invalida. Intente de nuevo: ");
            }
        }
    }
}
