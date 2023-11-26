public class Jitomate extends Articulo {
    public Jitomate() {
        super("Jitomate", 30);
    }

    @Override
    public double calcularCosto(double cantidad) {
        return cantidad * precioPorKg;
    }
}