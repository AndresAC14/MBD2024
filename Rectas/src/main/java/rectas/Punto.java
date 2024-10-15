package rectas;

public record Punto(double x, double y) {
    public Punto(){
        this(0,0);
    }

    /**
     *
     * @param pto
     * @return
     */
    public double distancia(Punto pto){
        return 0.0;
    }
}
