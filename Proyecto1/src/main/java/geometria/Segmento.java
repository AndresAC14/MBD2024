package geometria;

public class Segmento {

    private Punto origen, extremo;

    public Segmento(Punto origen, Punto extremo){
        this.origen = origen;
        this.extremo = extremo;
    }

    public void trasladar(double a, double b){
        origen.trasladar(a, b);
        extremo.trasladar(a, b);
    }

    public double longitud(){
        return origen.distancia(extremo);
    }


}
