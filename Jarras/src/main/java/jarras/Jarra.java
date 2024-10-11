package jarras;

/// @author Andrés Amo Caballero

public class Jarra {
    private final int capacidad;
    private int contenido;

    public Jarra(int capacidad){
        if(capacidad < 0) throw new IllegalArgumentException("Capacidad no admitida");
        this.capacidad = capacidad;
        this.contenido = 0;
    }

    public int getContenido(){
        return contenido;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public void llena(){
        contenido = capacidad;
    }

    public void vacia(){
        contenido = 0;
    }

    public void llenaDesde(Jarra j){
        int dif = capacidad - contenido;
        int cont = Math.min(dif, j.contenido);
        contenido += cont;
        j.contenido -= cont;
    }

    public String toString(){
        return "J(" + contenido + ", " + capacidad + ")";
    }



}
