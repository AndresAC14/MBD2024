package genetico;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class Poblacion {

    private Individuo[] individuos;

    /**
     * Crea una nueva población.
     * @param tam Tamaño de la nueva población.
     * @param longitud Longitud de los cromosomas de cada individuo.
     * @param problema Problema en los genes.
     */
    public Poblacion(int tam, int longitud, Problema problema){
        if(tam < 2) throw new IllegalArgumentException("No se pudo crear la poblacion");
        individuos = new Individuo[tam];
        for(int i = 0; i < tam; i++){
            individuos[i] = new Individuo(longitud, problema);
        }
    }

    /**
     * @param pos Posición del individuo que buscamos en el array.
     * @return Individuo correspondiente a la población 'pos'
     */
    public Individuo getIndividuo(int pos){
        return individuos[pos];
    }

    /**
     * @return Devuelve el número de individuos que contiene la población.
     */
    public int getNumindividuos(){
        return individuos.length;
    }

    /**
     * Encuentra al individuo con mejor 'fitness' de la población.
     * @return Mejor individuo.
     */
    public Individuo mejorIndividuo(){
        return individuos[busca(true)];
    }

    /**
     * Encuentra al individuo con peor 'fitness' de la población.
     * @return Peor individuo.
     */
    private Individuo peorIndividuo(){
        return individuos[busca(false)];
    }

    /**
     * Busca dentro de la población al mejor o al peor individuo según se indique.
     * @param estado True: Mejor individuo. False: Peor Individuo.
     * @return Posición del individuo buscado.
     */
    private int busca(boolean estado){
        int pos = 0;
        Individuo individuo = individuos[0];
        for(int i = 1; i < individuos.length; i++){
           if(estado && individuo.getFitness() < individuos[i].getFitness()){
               individuo = individuos[i];
               pos = i;
           }else if(!estado && individuo.getFitness() > individuos[i].getFitness()){
               individuo = individuos[i];
               pos = i;
           }
        }
        return pos;
    }

    /**
     * Sustituye al peor individuo por 'ind' en caso de que este sea mejor.
     * @param ind Nuevo individuo.
     */
    public void reemplaza(Individuo ind){
        if(peorIndividuo().getFitness() < ind.getFitness()){
            individuos[busca(false)] = ind;
        }
    }
}
