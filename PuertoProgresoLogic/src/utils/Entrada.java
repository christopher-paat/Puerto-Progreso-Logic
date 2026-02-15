package utils;

import java.util.Scanner;

/**
 * Utilidad para lectura de entradas de consola con validación básica.
 */
public class Entrada {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * - Parámetros de entrada: Ninguno; el valor se lee desde la entrada estándar.
     * - Salida: Entero válido obtenido a partir de la lectura de consola.
     * - Propósito: Leer opciones numéricas del usuario con validación básica.
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
                System.out.print("Entrada inválida. Intente de nuevo: ");
            }
        }
    }

    /**
     * - Parámetros de entrada: Ninguno; el texto se captura desde la entrada estándar.
     * - Salida: Cadena no vacía introducida por el usuario.
     * - Propósito: Obtener textos desde consola evitando entradas vacías.
     */
    public static String leerTexto() {
        while (true) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.print("Entrada vacía. Intente de nuevo: ");
        }
    }

    /**
     * - Parámetros de entrada: Ninguno; el número se ingresa por consola.
     * - Salida: Valor double válido leído desde la entrada estándar.
     * - Propósito: Capturar cantidades decimales (como pesos) con validación básica de formato.
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
                System.out.print("Entrada inválida. Intente de nuevo: ");
            }
        }
    }
}
