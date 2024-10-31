package buses;

public class Coincide implements Criterio{

    private Bus bus;

    public Coincide(Bus bus){
        this.bus = bus;
    }

    @Override
    public boolean esSeleccionable(Bus b) {
        return bus.equals(b);
    }

    @Override
    public String toString(){
        return "Autobús " + bus;
    }
}
