package modulos;

import estructuras.pila.Pila;
import modelos.Camion;
import modelos.Contenedor;
import modelos.Producto;
import utils.Entrada;

/**
 * Modulo de patio de contenedores (pilas).
 */
public class ModuloPatio {
    private ModuloRecepcion recepcion;
    private Pila pilaA = new Pila(5);
    private Pila pilaB = new Pila(5);
    private Pila pilaC = new Pila(5);

    /**
     * Crea el modulo con referencia a recepcion.
     *
     * @param recepcion modulo de recepcion para despachar camiones.
     */
    public ModuloPatio(ModuloRecepcion recepcion) {
        this.recepcion = recepcion;
    }

    /**
     * Muestra el menu del patio y procesa opciones.
     * Salida: flujo interactivo por consola.
     */
    public void menu() {
        int op;
        do {
            System.out.println("\nPATIO");
            System.out.println("[1] Ingresar contenedor desde Recepcion");
            System.out.println("[2] Ingresar contenedor manual");
            System.out.println("[3] Retirar contenedor");
            System.out.println("[4] Ver topes");
            System.out.println("[5] Inspeccionar contenedor");
            System.out.println("[6] Volver");

            op = Entrada.leerInt();

            switch (op) {
                case 1 -> ingresarDesdeRecepcion();
                case 2 -> ingresarManual();
                case 3 -> retirar();
                case 4 -> verTopes();
                case 5 -> inspeccionar();
                default -> System.out.println("Opcion invalida");
            }
        } while (op != 6);
    }

    /**
     * Solicita la pila objetivo para operar.
     *
     * @return pila seleccionada o null si es invalida.
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
     * Ingresa un contenedor atendiendo el siguiente camion.
     * Salida: pila actualizada.
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

        p.push(new Contenedor(cod));
        System.out.println("Contenedor ingresado al patio");
    }

    /**
     * Ingresa un contenedor sin pasar por recepcion.
     * Salida: pila actualizada.
     */
    private void ingresarManual() {
        Pila p = elegirPila();
        if (p == null)
            return;

        System.out.print("Código: ");
        String cod = Entrada.leerTexto();

        p.push(new Contenedor(cod));
    }

    /**
     * Retira un contenedor por codigo usando pila auxiliar.
     * Salida: impresion del contenedor retirado.
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
     * Busca y retira un contenedor en una pila dada.
     *
     * @param p pila objetivo.
     * @param cod codigo del contenedor.
     * @return contenedor retirado o null si no existe.
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
     * Muestra los topes de cada pila.
     * Salida: impresion en consola.
     */
    private void verTopes() {
        System.out.println("A: " + pilaA.peek());
        System.out.println("B: " + pilaB.peek());
        System.out.println("C: " + pilaC.peek());
    }

    /**
     * Abre el submenu de inspeccion de contenedor.
     * Salida: flujo interactivo por consola.
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
            System.out.println("\nINSPECCION CONTENEDOR " + c.getCodigo());
            System.out.println("[1] Agregar producto");
            System.out.println("[2] Calcular peso total");
            System.out.println("[3] Buscar producto");
            System.out.println("[4] Volver");

            op = Entrada.leerInt();

            switch (op) {
                case 1 -> agregarProducto(c);
                case 2 -> System.out.println("Peso total: " + c.pesoTotal() + " kg");
                case 3 -> buscarProducto(c);
                default -> System.out.println("Opcion invalida");
            }
        } while (op != 4);
    }

    /**
     * Agrega un producto a un contenedor.
     *
     * @param c contenedor objetivo.
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
     * Busca un producto en un contenedor por id o nombre.
     * Salida: impresion del resultado.
     *
     * @param c contenedor objetivo.
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

        System.out.println("Opcion invalida");
    }

    /**
     * Obtiene el total de contenedores del patio.
     *
     * @return cantidad total.
     */
    public int totalContenedores() {
        return pilaA.getTamaño() + pilaB.getTamaño() + pilaC.getTamaño();
    }

    /**
     * Genera un resumen del inventario por pila.
     *
     * @return texto con el estado de cada pila.
     */
    public String resumenInventario() {
        StringBuilder sb = new StringBuilder();
        sb.append(pilaA.resumen("A")).append("\n");
        sb.append(pilaB.resumen("B")).append("\n");
        sb.append(pilaC.resumen("C"));
        return sb.toString();
    }
}
