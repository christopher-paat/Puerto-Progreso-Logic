package utils;

import java.util.Scanner;

public class Entrada {
    private static Scanner sc = new Scanner(System.in);

    public static int leerInt() {
        return sc.nextInt();
    }

    public static String leerTexto() {
        sc.nextLine();
        return sc.nextLine();
    }

    public static double leerDouble() {
        return sc.nextDouble();
    }
}
