package modulos;

import estructuras.pila.Pila;
import modelos.Camion;
import modelos.Contenedor;
import modelos.Producto;
import utils.Entrada;

/**
 * Módulo de patio de contenedores (pilas).
 */
public class ModuloPatio {
    private final ModuloRecepcion recepcion;
    private final Pila pilaA = new Pila(5);
    private final Pila pilaB = new Pila(5);
    private final Pila pilaC = new Pila(5);

    /**
     * - Parámetros de entrada: recepción que provee los camiones atendidos en la cola.
     * - Salida: Instancia de ModuloPatio inicializada con sus pilas de contenedores.
     * - Propósito: Configurar el módulo de patio enlazado al módulo de recepción de camiones.
     */
    public ModuloPatio(ModuloRecepcion recepcion) {
        this.recepcion = recepcion;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ninguna (void); se gestiona un flujo interactivo por consola.
     * - Propósito: Presentar y controlar el menú del patio de contenedores basado en pilas.
     */
    public void menu() {
        int op;
        do {
            System.out.println("\nPATIO");
            System.out.println("[1] Ingresar contenedor desde Recepción");
            System.out.println("[2] Ingresar contenedor manual");
            System.out.println("[3] Retirar contenedor para Ruta");
            System.out.println("[4] Ver tope de las pilas");
            System.out.println("[5] Inspeccionar contenedor");
            System.out.println("[6] Volver");

            op = Entrada.leerInt();

            switch (op) {
                case 1 -> ingresarDesdeRecepcion();
                case 2 -> ingresarManual();
                case 3 -> retirar();
                case 4 -> verTopes();
                case 5 -> inspeccionar();
                case 6 -> {}
                default -> System.out.println("Opción inválida");
            }
        } while (op != 6);
    }

    /**
     * - Parámetros de entrada: Ninguno; la opción se lee desde consola.
     * - Salida: Referencia a la pila seleccionada (A, B o C) o null si la opción es inválida.
     * - Propósito: Elegir sobre qué columna de contenedores se realizará la operación.
     */
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

    /**
     * - Parámetros de entrada: Ninguno; los datos se obtienen de la recepción y de consola.
     * - Salida: Ninguna (void); la pila elegida se actualiza con un nuevo contenedor.
     * - Propósito: Ingresar al patio un contenedor proveniente del siguiente camión atendido en recepción.
     */
    private void ingresarDesdeRecepcion() {
        Camion camion = recepcion.despacharCamion();
        if (camion == null) {
            System.out.println("No hay camiones en espera");
            return;
        }
        System.out.println("Atendiendo camión: " + camion);

        Pila p = elegirPila();
        if (p == null)
            return;

        System.out.print("Codigo del contenedor: ");
        String cod = Entrada.leerTexto();

        if (p.estaLlena()) {
            p.push(new Contenedor(cod));
        } else {
            p.push(new Contenedor(cod));
            System.out.println("Contenedor ingresado al patio");
        }
    }

    /**
     * - Parámetros de entrada: Ninguno; los datos del contenedor se leen desde consola.
     * - Salida: Ninguna (void); la pila seleccionada se actualiza con el nuevo contenedor.
     * - Propósito: Registrar manualmente un contenedor en el patio sin depender de la cola de recepción.
     */
    private void ingresarManual() {
        Pila p = elegirPila();
        if (p == null)
            return;

        System.out.print("Código: ");
        String cod = Entrada.leerTexto();

        if (p.estaLlena()) {
            p.push(new Contenedor(cod));
        } else {
            p.push(new Contenedor(cod));
            System.out.println("Contenedor ingresado al patio");
        }
    }

    /**
     * - Parámetros de entrada: Ninguno; el código del contenedor se lee desde consola.
     * - Salida: Ninguna (void); se informa por consola el contenedor retirado si se encontró.
     * - Propósito: Retirar del patio un contenedor específico utilizando una pila auxiliar para respetar LIFO.
     */
    private void retirar() {
        Pila p = elegirPila();
        if (p == null)
            return;
        if (p.estaVacia()) {
            System.out.println("Pila vacia");
            return;
        }

        System.out.print("Codigo del contenedor a retirar: ");
        String cod = Entrada.leerTexto();
        Contenedor retirado = retirarPorCodigo(p, cod);
        if (retirado == null) {
            System.out.println("Contenedor no encontrado");
            return;
        }
        System.out.println("Retirado: " + retirado);
    }

    /**
     * - Parámetros de entrada: p como pila objetivo y cod como código del contenedor a retirar.
     * - Salida: Contenedor encontrado y retirado o null si no existe en la pila.
     * - Propósito: Ubicar y extraer un contenedor concreto respetando la lógica de pilas mediante una auxiliar.
     */
    private Contenedor retirarPorCodigo(Pila p, String cod) {
        Pila aux = new Pila(p.getMax());
        Contenedor encontrado = null;

        while (!p.estaVacia()) {
            Contenedor actual = (Contenedor) p.pop();
            if (actual.getCodigo().equalsIgnoreCase(cod)) {
                encontrado = actual;
                break;
            }
            aux.push(actual);
        }

        while (!aux.estaVacia()) {
            p.push(aux.pop());
        }

        return encontrado;
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ninguna (void); se imprime el elemento en la cima de cada pila.
     * - Propósito: Consultar rápidamente qué contenedor se encuentra en el tope de cada columna del patio.
     */
    private void verTopes() {
        System.out.println("A: " + pilaA.peek());
        System.out.println("B: " + pilaB.peek());
        System.out.println("C: " + pilaC.peek());
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Ninguna (void); se maneja un submenú interactivo para trabajar sobre un contenedor.
     * - Propósito: Permitir la inspección detallada de un contenedor (productos, peso, búsquedas).
     */
    private void inspeccionar() {
        Pila p = elegirPila();
        if (p == null)
            return;

        System.out.print("Codigo del contenedor: ");
        String cod = Entrada.leerTexto();
        Contenedor c = p.buscarContenedor(cod);
        if (c == null) {
            System.out.println("Contenedor no encontrado");
            return;
        }

        int op;
        do {
            System.out.println("\nINSPECCIÓN CONTENEDOR " + c.getCodigo());
            System.out.println("[1] Agregar producto");
            System.out.println("[2] Calcular peso total");
            System.out.println("[3] Buscar producto");
            System.out.println("[4] Volver");

            op = Entrada.leerInt();

            switch (op) {
                case 1 -> agregarProducto(c);
                case 2 -> System.out.println("Peso total: " + c.pesoTotal() + " kg");
                case 3 -> buscarProducto(c);
                case 4 -> {}
                default -> System.out.println("Opción inválida");
            }
        } while (op != 4);
    }

    /**
     * - Parámetros de entrada: c como contenedor sobre el cual se agregará el producto.
     * - Salida: Ninguna (void); la lista interna de productos del contenedor queda actualizada.
     * - Propósito: Registrar un nuevo producto en el manifiesto de carga de un contenedor.
     */
    private void agregarProducto(Contenedor c) {
        System.out.print("Id: ");
        int id = Entrada.leerInt();
        System.out.print("Nombre: ");
        String nombre = Entrada.leerTexto();
        System.out.print("Peso (kg): ");
        double peso = Entrada.leerDouble();

        c.agregarProducto(new Producto(id, nombre, peso));
        System.out.println("Producto agregado");
    }

    /**
     * - Parámetros de entrada: c como contenedor en el que se realizará la búsqueda.
     * - Salida: Ninguna (void); se muestra por consola el resultado de la búsqueda.
     * - Propósito: Localizar un producto dentro de un contenedor por id o por nombre.
     */
    private void buscarProducto(Contenedor c) {
        System.out.println("Buscar por: [1] Id [2] Nombre");
        int tipo = Entrada.leerInt();

        if (tipo == 1) {
            System.out.print("Id: ");
            int id = Entrada.leerInt();
            Producto p = c.buscarProductoPorId(id);
            System.out.println(p == null ? "No encontrado" : p);
            return;
        }

        if (tipo == 2) {
            System.out.print("Nombre: ");
            String nombre = Entrada.leerTexto();
            Producto p = c.buscarProductoPorNombre(nombre);
            System.out.println(p == null ? "No encontrado" : p);
            return;
        }

        System.out.println("Opción inválida");
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Número total de contenedores distribuidos entre las pilas A, B y C.
     * - Propósito: Conocer el volumen de contenedores almacenados actualmente en el patio.
     */
    public int totalContenedores() {
        return pilaA.getTamaño() + pilaB.getTamaño() + pilaC.getTamaño();
    }

    /**
     * - Parámetros de entrada: Ninguno.
     * - Salida: Cadena de texto con el estado y peso de cada pila del patio.
     * - Propósito: Resumir el inventario de contenedores por columna para el reporte general.
     */
    public String resumenInventario() {
        StringBuilder sb = new StringBuilder();
        sb.append(pilaA.resumen("A")).append("\n");
        sb.append(pilaB.resumen("B")).append("\n");
        sb.append(pilaC.resumen("C"));
        return sb.toString();
    }

    public Pila getPilaA() {
        return pilaA;
    }

    public Pila getPilaC() {
        return pilaC;
    }
}
