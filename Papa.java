public class Papa extends Articulo {
    public Papa() {
        super("Papa", 23);
    }

    @Override
    public double calcularCosto(double cantidad) {
        return cantidad * precioPorKg;
    }
}