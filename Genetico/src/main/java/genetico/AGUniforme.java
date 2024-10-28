package genetico;

import java.util.Random;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class AGUniforme extends AlgoritmoGenetico{

    /**
     * Crea un algoritmo genético con recombinación uniforme.
     * @param tam Tamaño de la población.
     * @param longitud Longitud de los cromosomas.
     * @param generaciones Iteraciones del algoritmo.
     * @param probMutacion Probabilidad de mutación.
     * @param problema Problema en los genes.
     */
    public AGUniforme(int tam, int longitud, int generaciones, double probMutacion, Problema problema){
        super(tam, longitud, generaciones, probMutacion, problema);
    }

    /**
     * Recombina los cromosomas de los individuos.
     * Esta recombinación uniforme elige de forma aleatoria
     * el valor de cada gen de uno de los padres.
     * @param c1 Cromosoma 1.
     * @param c2 Cromosoma 2.
     * @return Cromosoma recombinado de forma aleatoria.
     */
    @Override
    protected Cromosoma recombinar(Cromosoma c1, Cromosoma c2) {
        Random rnd = new Random();
        Cromosoma c = new Cromosoma(c2);

        for (int pos = 0; pos < c1.getLongitud(); pos++){
            int z = rnd.nextInt(2);
            c.setGen(pos, c1.getGen(pos));
        }

        return c;
    }
}
