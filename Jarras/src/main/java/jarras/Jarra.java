package jarras;

/// @author Andrés Amo Caballero

public class Jarra {
    private final int capacidad;
    private int contenido;

    /**
     * Crea una nueva jarra con capacidad dada y contenido 0
     * @param capacidad maximo de contenido que cabe en la jarra
     * @throws IllegalArgumentException cuando la capacidad es menor o igual a 0
     */
    public Jarra(int capacidad){
        if(capacidad < 0) throw new IllegalArgumentException("Capacidad no admitida");
        this.capacidad = capacidad;
        this.contenido = 0;
    }

    /**
     * Obtiene el contenido de la jarra `this`
     * @return contenido
     */
    public int getContenido(){
        return contenido;
    }

    /**
     * Obtiene la capacidad de la jarra `this`
     * @return capacidad
     */
    public int getCapacidad(){
        return capacidad;
    }

    /**
     * LLena la jarra `this` con el maximo de capacidad
     */
    public void llena(){
        contenido = capacidad;
    }

    /**
     * Vacia la jarra `this` igualando el contenido a 0
     */
    public void vacia(){
        contenido = 0;
    }

    /**
     * Llena la jarra `this` con el contenido de la jarra pasada por argumento
     * bien hasta que `this` se llena o que la otra se quede sin contenido
     * @param j Jarra que se vacía en `this`
     */
    public void llenaDesde(Jarra j){
        if(this == j) throw new IllegalArgumentException("No se puede volcar una jarra en sí misma");

        int dif = capacidad - contenido;
        int cont = Math.min(dif, j.contenido);
        contenido += cont;
        j.contenido -= cont;
    }

    /**
     * Representación del contenido y la capacidad de la jarra `this`
     * @return Cadena que muestra la jarra actual
     */
    @Override
    public String toString(){
        return "J(" + contenido + ", " + capacidad + ")";
    }
}
