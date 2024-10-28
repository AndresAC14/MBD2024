package genetico;

import java.util.Random;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class AGUnPunto extends AlgoritmoGenetico{

    /**
     * Crea un algoritmo genético con recombinación en un punto.
     * @param tam Tamaño de la población.
     * @param longitud Longitud de los cromosomas.
     * @param generaciones Iteraciones del algoritmo.
     * @param probMutacion Probabilidad de mutación.
     * @param problema Problema en los genes.
     */
    public AGUnPunto(int tam, int longitud, int generaciones, double probMutacion, Problema problema){
        super(tam, longitud, generaciones, probMutacion, problema);
    }

    /**
     * Recombina los cromosomas de los individuos.
     * En essta recombinación se eligen un número aleatorio 'z' entre 0
     * y la longitud de los cromosomas. De tal forma que los primeros 'z'
     * genes se toman del primer cromosoma, y el resto del segundo cromosoma.
     * @param c1 Cromosoma 1.
     * @param c2 Cromosoma 2.
     * @return Cromosoma recombinado.
     */
    @Override
    protected Cromosoma recombinar(Cromosoma c1, Cromosoma c2) {
        Random rnd = new Random();
        Cromosoma c = new Cromosoma(c2);

        int z = rnd.nextInt(c1.getLongitud());

        for (int pos = 0; pos < z; pos++){
            c.setGen(pos, c1.getGen(pos));
        }

        return c;
    }
}
