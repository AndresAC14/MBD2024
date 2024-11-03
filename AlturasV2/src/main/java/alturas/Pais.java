package alturas;

/**
 * @author Andrés Amo Caballero
 * @version 2.0
 */

public record Pais(String nombre, String continente, double altura) implements Comparable<Pais>{

    /**
     * Redefinición del orden natural, primero según la altura del país
     * y a igualdad, comparado alfabéticamente por su nombre.
     * @param pais Pais comparado con el 'this'.
     * @return Negativo si 'this' es menor que 'pais'.
     * 0 si 'this' es igual que 'pais'.
     * Positivo si 'this' es mayor que 'pais'.
     */
    @Override
    public int compareTo(Pais pais) {
        int res = Double.compare(this.altura, pais.altura());
        if(res == 0) res = this.nombre.compareToIgnoreCase(pais.nombre());
        return res;
    }
}
