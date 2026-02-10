package modelos;

public class Producto {
    private int id;
    private String nombre;
    private double peso;

    public Producto(int id, String nombre, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " (" + peso + " kg)";
    }
}
