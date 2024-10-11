package jarras;

public class Jarra {

    private final int capacidad;
    private int contenido;

    public Jarra(int capacidad){
        if(capacidad < 0 ) throw new IllegalArgumentException("Capacidad no admitida");
        this.capacidad = capacidad;
        this.contenido = 0;
    }

    public int capacidad(){
        return capacidad;
    }

    public int contenido(){
        return contenido;
    }

    public void vacia(){
        contenido = 0;
    }

    public void llena(){
        contenido = capacidad;
    }

    public void llenaDesde(Jarra j){
        int aux = capacidad - contenido;
        contenido = j.contenido;
        j.contenido = j.contenido - aux;
    }

    @Override
    public String toString(){
        return "J(" + contenido() + ", " + capacidad() + ")";
    }

}
