package modelos;

import estructuras.lista.ListaSimple;

public class Contenedor {
    private String codigo;
    private ListaSimple productos;

    public Contenedor(String codigo) {
        this.codigo = codigo;
        productos = new ListaSimple();
    }

    public void agregarProducto(Producto p) {
        productos.insertar(p);
    }

    public double pesoTotal() {
        return productos.calcularPeso();
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Contenedor " + codigo + " Peso: " + pesoTotal() + " kg";
    }
}
