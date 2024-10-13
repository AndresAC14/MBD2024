package jarras;

public class Mesa {
    Jarra jarraIz, jarraDr;

    public Mesa(int c1, int c2){
        jarraIz = new Jarra(c1);
        jarraDr = new Jarra(c2);
    }

    public void llena(Posicion p){
        if(p == Posicion.Izquierda){
            jarraIz.llena();
        }else{
            jarraDr.llena();
        }
    }

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
