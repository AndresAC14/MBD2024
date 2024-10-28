package genetico;

import java.util.Random;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public abstract class AlgoritmoGenetico {

    private Problema problema;
    private double probMutacion;
    private Poblacion poblacion;
    private int pasos;

    /**
     * Crea un nuevo algoritmo genético.
     * @param tam Tamaño de la población.
     * @param longitud Longitud de los cromosomas.
     * @param generaciones Iteraciones del algoritmo.
     * @param probMutacion Probabilidad de mutación.
     * @param problema Problema en los genes.
     */
    public AlgoritmoGenetico(int tam, int longitud, int generaciones, double probMutacion, Problema problema){
         if(probMutacion < 0 || probMutacion > 1) throw new IllegalArgumentException("Probabilidad de mutación no admitida");
         this.poblacion = new Poblacion(tam, longitud, problema);
         this.probMutacion = probMutacion;
         this.problema = problema;
         this.pasos = generaciones;
    }

    /**
     * Aplica el algoritmo genético correspondiente.
     * Para ello se itera 'pasos' veces, se seleccionan 2 individuos de forma aleatoria de la población.
     * Seguidamente, se recombinan los cromosomas de ambos individuos y se muta ese cromosoma resultante.
     * Creamos un nuevo individuo con ese cromosoma y en caso de que sea mejor que el peor existente en la población,
     * este se sustituye.
     * @return Mejor individuo de la población después de ejecutar el algoritmo.
     */
    public Individuo ejecuta(){
        Random rnd = new Random();

        for(int i = 0; i < pasos; i++){

            Individuo i1 = poblacion.getIndividuo(rnd.nextInt(poblacion.getNumindividuos()));
            Individuo i2 = poblacion.getIndividuo(rnd.nextInt(poblacion.getNumindividuos()));

            Cromosoma c = recombinar(i1.getCromosoma(), i2.getCromosoma());

            c.mutar(probMutacion);

            Individuo nuevo = new Individuo(c, problema);

            poblacion.reemplaza(nuevo);
        }
        return poblacion.mejorIndividuo();
    }

    /**
     * Recombina los cromosomas de los individuos.
     * @param c1 Cromosoma 1.
     * @param c2 Cromosoma 2.
     * @return Cromosoma recombinado según el algoritmo seleccionado.
     */
    protected abstract Cromosoma recombinar(Cromosoma c1, Cromosoma c2);
}
