package modelos;

import estructuras.lista.ListaSimple;

public class Contenedor {
    private String codigo;
    private ListaSimple productos;

    public Contenedor(String codigo) {
        this.codigo = codigo;
        this.productos = new ListaSimple();
    }

    public void agregarProducto(Producto p) {
        productos.insertar(p);
    }

    public double calcularPesoTotal() {
        return productos.calcularPeso();
    }

    @Override
    public String toString() {
        return "Contenedor [" + codigo + "]";
    }
}
