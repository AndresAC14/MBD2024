package buses;

import java.util.Objects;

public class Bus {

    private int codBus;
    private int codLinea;
    private String matricula;

    public Bus(int codBus, String matricula){
        this.codBus = codBus;
        this.matricula = matricula;
    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }

    public int getCodBus() {
        return codBus;
    }

    public int getCodLinea() {
        return codLinea;
    }

    public String getMatricula(){
        return matricula;
    }

    @Override
    public boolean equals(Object o){
        return (o instanceof Bus bus)
                && (this.codBus == bus.getCodBus())
                && (this.matricula.equalsIgnoreCase(bus.getMatricula()));
    }

    @Override
    public int hashCode(){
        return Objects.hash(codBus, matricula.toLowerCase());
    }

    @Override
    public String toString(){
        return "Bus(" + codBus + "," + matricula + "," + codLinea + ")";
    }

}
