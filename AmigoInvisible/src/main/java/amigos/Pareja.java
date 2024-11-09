package amigos;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public record Pareja(Persona uno, Persona otro) {

    /**
     * Comprueba si dos parejas son iguales, según su si sus integrantes son los mismos.
     * @param p Pareja con la que se compara.
     * @return `True` si las parejas son iguales. 'False' en otro caso.
     */
    @Override
    public boolean equals(Object p){
        return (p instanceof Pareja pareja)
                && (uno.equals(pareja.uno())
                    || (otro.equals(pareja.otro())));
    }

    /**
     * Devuelve el hash code de una pareja.
     * @return Hashcode de una pareja.
     */
    @Override
    public int hashCode(){
        return uno.hashCode() + otro.hashCode();
    }

}
