public class Frijol extends Articulo {
    public Frijol() {
        super("Frijol", 20);
    }

    @Override
    public double calcularCosto(double cantidad) {
        return cantidad * precioPorKg;
    }
}