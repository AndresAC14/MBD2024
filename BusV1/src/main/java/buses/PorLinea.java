package buses;

public class PorLinea implements Criterio{

    private int codLinea;

    public PorLinea(int cod){
        this.codLinea = cod;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        return codLinea == bus.getCodLinea();
    }

    @Override
    public String toString(){
        return "Autobuses de la linea " + codLinea;
    }
}
