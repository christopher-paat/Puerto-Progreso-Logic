package modelos;

public class Camion {
    private String placa;
    private String empresa;

    public Camion(String placa, String empresa) {
        this.placa = placa;
        this.empresa = empresa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Camion [Placa=" + placa + ", Empresa=" + empresa + "]";
    }
}
