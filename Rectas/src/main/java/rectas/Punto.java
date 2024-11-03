package rectas;

public record Punto(double x, double y) {

    public Punto(){
        this(0.0, 0.0);
    }

    public double distancia(Punto p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
