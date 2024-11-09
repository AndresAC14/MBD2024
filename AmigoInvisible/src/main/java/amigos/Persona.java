package amigos;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class Persona implements Comparable<Persona>{
    private String nombre;
    private Persona amigo;

    /**
     * Crea una nueva Persona.
     * @param nombre Nombre de la persona.
     */
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

    /**
     * Comprueba si dos personas son iguales, según su nombre.
     * @param o Persona con la que se compara.
     * @return `True` si las personas son la misma. 'False' en otro caso.
     */
    @Override
    public boolean equals(Object o){
        return (o instanceof Persona p)
                && (this.nombre.equalsIgnoreCase(p.getNombre()));
    }

    /**
     * Compara dos personas lexicográficamente.
     * @param p Persona con la que se compara.
     * @return 0 si son iguales, <0 si es mayor y >0 si es menor.
     */
    @Override
    public int compareTo(Persona p) {
        return this.nombre.compareToIgnoreCase(p.getNombre());
    }

    /**
     * Devuelve el hash code de una persona.
     * @return Hashcode de una persona.
     */
    @Override
    public int hashCode(){
        return nombre.toLowerCase().hashCode();
    }

    /**
     * Representación de una persona que le regala a otra.
     * @return Cadena de caracteres con la representación de una persona.
     */
    @Override
    public String toString(){
        return String.format("%10s: le regala a: %-10s", nombre, (amigo != null ? amigo.getNombre() : "sin amigo"));
    }
}
