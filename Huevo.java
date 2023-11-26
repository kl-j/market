public class Huevo extends Articulo {
    public Huevo() {
        super("Huevo", 40);
    }

    @Override
    public double calcularCosto(double cantidad) {
        return cantidad * precioPorKg;
    }
}