package genetico;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class Individuo {

    private double fitness;
    private Cromosoma cromosoma;

    /**
     * Creación de un inviduo dada la longitud de sus cromosomas y su problema.
     * @param longitud Longitud del cromosoma.
     * @param problema Problema en los genes del cromosoma.
     */
    public Individuo(int longitud, Problema problema){
        cromosoma = new Cromosoma(longitud, true);
        fitness = problema.evalua(cromosoma);
    }

    /**
     * Creación de un individuo dado otro cromosoma y su problema.
     * @param c Cromosoma del que partimos.
     * @param problema Problema en los genes del cromosoma.
     */
    public Individuo(Cromosoma c, Problema problema){
        cromosoma = c;
        fitness = problema.evalua(cromosoma);
    }

    /**
     * Devuelve el cromosoma del individuo
     * @return Cromosoma del individuo
     */
    public Cromosoma getCromosoma(){
        return cromosoma;
    }

    /**
     * Devuelve cómo de bien se encuetra el individuo.
     * @return Valor de bienestar.
     */
    public double getFitness(){
        return fitness;
    }

    /**
     * Representación textual del individuo con la información del individuo, su fitness y su cromosoma.
     * @return Cadena de caracteres.
     */
    @Override
    public String toString(){
        return "Individuo(Fitness: " + fitness + "; Cromosoma: " + cromosoma + ")";
    }
}
