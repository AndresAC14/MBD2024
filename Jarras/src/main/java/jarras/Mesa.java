package jarras;

/// @author Andrés Amo Caballero
/// @version 1.0

public class Mesa {

    public static enum Posicion {
        Izquierda,
        Derecha
    }

    Jarra jarraIz, jarraDr;
    private static final int CAP_INCIAL = 5;

    /**
     * Crea una nueva mesa con dos jarras cuya capacida inicial
     * está dada por defecto.
     */
    public Mesa(){
        this(CAP_INCIAL, CAP_INCIAL);
    }

    /**
     * Crea una nueva mesa con dos jarras.
     * @param c1 Capacidad de la jarra izquierda
     * @param c2 Capacidad de la jarra derecha
     */
    public Mesa(int c1, int c2){
        jarraIz = new Jarra(c1);
        jarraDr = new Jarra(c2);
    }

    /**
     * Llena la jarra situada en la posición en la posición `p`
     * @param p Posición de la jarra a llenar
     */
    public void llena(Posicion p){
        if(p == Posicion.Izquierda){
            jarraIz.llena();
        }else if(p == Posicion.Derecha){
            jarraDr.llena();
        }
    }

    /**
     * Vacía la jarra situada en la posición `p`
     * @param p Posición de la jarra a vaciar
     */
    public void vacia(Posicion p){
        if(p == Posicion.Izquierda){
            jarraIz.vacia();
        }else if(p == Posicion.Derecha){
            jarraDr.vacia();
        }
    }

    /**
     * LLena el contenido de la jarra `this` desde la jarra situada
     * en la posición `p`, hasta que la jarra `this` quede llena o hasta
     * que la jarra situada en `p` se vacíe.
     * @param p Posición de la jarra con la que se llena `this`
     */
    public void llenaDesde(Posicion p){
        if(p == Posicion.Izquierda){
            jarraDr.llenaDesde(jarraIz);
        }else if(p == Posicion.Derecha){
            jarraIz.llenaDesde(jarraDr);
        }
    }

    /**
     * Devuelve la cpacidad de la jarra situada en la posición `p`
     * @param p Posición de la jarra
     * @return Capacidad de la jarra en la posicion `p`
     */
    public int getCapacidad(Posicion p){
        int c = 0;

        if(p == Posicion.Izquierda){
            c = jarraIz.getCapacidad();
        }else if(p == Posicion.Derecha){
            c= jarraDr.getCapacidad();
        }

        return c;
    }

    /**
     * Devuelve el contenido de la jarra situada en la posición `p`
     * @param p Posición de la jarra
     * @return Contenido de la jarra en la posicion `p`
     */
    public int getContenido(Posicion p){
        int c = 0;

        if(p == Posicion.Izquierda){
            c = jarraIz.getContenido();
        }else if(p == Posicion.Derecha){
            c= jarraDr.getContenido();
        }

        return c;
    }

    /**
     * Represantación textual de la mesa
     * @return Cadena que representa la mesa
     */
    @Override
    public String toString(){
        return "M(" + jarraIz + ", " + jarraDr + ")";
    }
}
