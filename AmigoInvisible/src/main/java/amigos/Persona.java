package amigos;

public class Persona implements Comparable<Persona>{
    private String nombre;
    private Persona amigo;

    public Persona(String nombre){
        this.nombre = nombre;
    }

    public Persona getAmigo(){
        return amigo;
    }

    public void setAmigo(Persona am){
        this.amigo = am;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o){
        return (o instanceof Persona p)
                && (this.nombre.equalsIgnoreCase(p.getNombre()));
    }

    @Override
    public int compareTo(Persona p) {
        return this.nombre.compareToIgnoreCase(p.getNombre());
    }

    @Override
    public String toString(){
        return String.format("%10s: le regala a: %-10s", nombre, (amigo != null ? amigo.getNombre() : "sin amigo"));
        //return nombre + ": le regala a: " + (amigo != null ? amigo : "sin amigo");
    }
}
