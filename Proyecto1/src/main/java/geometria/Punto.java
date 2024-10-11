package geometria;

public class Punto {

    private double x, y;

    public Punto() {
        x = 0; y = 0;
    }

    public Punto(double x, double y) {
        this.x = x; this.y = y;
    }

    public double abscisa() {
        return x;
    }

    public double ordenada() {
        return y;
    }

    public void abscisa(double a){
        x = a;
    }

    public void ordenada(double b){
        y = b;
    }

    public void trasladar(double a, double b){
        x += a;
        y += b;
    }

    public double distancia(Punto pto){
        return Math.sqrt(Math.pow(x - pto.x, 2) + Math.pow(y - pto.y, 2));
    }

    @Override
    public String toString(){
        return "P(" + abscisa() + ", " + ordenada() + ")";
    }
}
