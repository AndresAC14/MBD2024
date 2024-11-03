package rectas;

public record Recta(Vector director, Punto punto) {

    public Recta(Punto p1, Punto p2){
        this(new Vector(p1, p2));
    }
}
