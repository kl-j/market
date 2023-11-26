public abstract class Articulo {
    protected String nombre;
    protected int precioPorKg;

    public Articulo(String nombre, int precioPorKg) {
        this.nombre = nombre;
        this.precioPorKg = precioPorKg;
    }

    public abstract double calcularCosto(double cantidad);

    @Override
    public String toString() {
        return nombre + " ($" + precioPorKg + "/kg)";
    }
}