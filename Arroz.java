public class Arroz extends Articulo {
    public Arroz() {
        super("Arroz", 35);
    }

    @Override
    public double calcularCosto(double cantidad) {
        return cantidad * precioPorKg;
    }
}