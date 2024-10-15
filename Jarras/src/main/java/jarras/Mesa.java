package jarras;

/// @author Andrés Amo Caballero

public class Mesa {

    static enum Posicion {Izquierda, Derecha};

    Jarra jarraIz, jarraDr;

    /**
     * Crea una nueva mesa con dos jarras
     * @param c1 Capacidad de la jarra izquierda
     * @param c2 Capacidad de la jarra derecha
     */
    public Mesa(int c1, int c2){
        jarraIz = new Jarra(c1);
        jarraDr = new Jarra(c2);
    }

    /**
     * Llena la jarra de la posición en la posición `p`
     * @param p Posición de la jarra a llenar
     */
    public void llena(Posicion p){
        if(p == Posicion.Izquierda){
            jarraIz.llena();
        }else{
            jarraDr.llena();
        }
    }

    /**
     * Vacía la jarra de la posición `p`
     * @param p Posición de la jarra a vaciar
     */
    public void vacia(Posicion p){
        if(p == Posicion.Izquierda){
            jarraIz.vacia();
        }else{
            jarraDr.vacia();
        }
    }

    public void llenaDesde(Posicion p){
        if(p == Posicion.Izquierda){
            jarraIz.llenaDesde(jarraDr);
        }else{
            jarraDr.llenaDesde(jarraIz);
        }
    }

    public int getCapacidad(Posicion p){
        int c = 0;

        if(p == Posicion.Izquierda){
            c = jarraIz.getCapacidad();
        }else{
            c= jarraDr.getCapacidad();
        }

        return c;
    }

    public int getContenido(Posicion p){
        int c = 0;

        if(p == Posicion.Izquierda){
            c = jarraIz.getContenido();
        }else{
            c= jarraDr.getContenido();
        }

        return c;
    }

    @Override
    public String toString(){
        return "M(" + jarraIz + ", " + jarraDr + ")";
    }

}
