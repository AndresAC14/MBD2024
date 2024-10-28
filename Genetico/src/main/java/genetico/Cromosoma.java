package genetico;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class Cromosoma {

    protected int[] datos;
    protected static int GEN_POR_DEFECTO = 0;
    protected static Random gna = new Random();

    /**
     * Creación de un cromosoma dada una longitud y si sus genes se crearán de forma aleatoria o no.
     * @param longitud Longitud del cromosoma.
     * @param aleatorio Aleatoriedad de cada gen al crearse.
     */
    public Cromosoma(int longitud, boolean aleatorio){
        if(longitud <= 0) throw new IllegalArgumentException("Atributos de Cromosoma no válidos");
        datos = inicializarCromosoma(longitud, aleatorio);
    }

    /**
     * Creación de un cromosoma a partir de otro dado.
     * @param c Cromosoma que se pretende copiar.
     */
    public Cromosoma(Cromosoma c){
        datos = Arrays.copyOf(c.datos, c.getLongitud());
    }

    /**
     * Inicialización de los genes del cromosoma.
     * @param longitud Longitud del cromosoma.
     * @param alea Aleatoriedad de cada gen al crearse.
     * @return Array con los genes del cromosoma.
     */
    private int[] inicializarCromosoma(int longitud, boolean alea){
        datos = new int[longitud];
        if(alea){
            for(int i = 0; i < datos.length; i++){
                datos[i] = gna.nextInt(2);
            }
        } else Arrays.fill(datos, GEN_POR_DEFECTO);
        return datos;
    }

    /**
     * Devuelve el gen que se encuentra en las posicion 'pos'.
     * @param pos Posición del gen que buscamos.
     * @return Valor del gen.
     */
    public int getGen(int pos) {
        return datos[pos];
    }

    /**
     * Establece el valor 'gen' en la posición 'pos'
     * @param pos Posición del gen que buscamos modificar.
     * @param gen Nuevo valor del gen.
     */
    public void setGen(int pos, int gen) {
        datos[pos] = gen;
    }

    /**
     * Devuelve la longitud del cromosoma
     * @return Longitud del cromosoma.
     */
    public int getLongitud(){
        return datos.length;
    }

    /**
     * Invierte el valor de cada gen del cromosoma según la probabilidad.
     * @param prob Probabilidad con la que puede ser mutado el cromosoma.
     */
    public void mutar(double prob){
        for(int i = 0; i < datos.length; i++){
            datos[i] = (gna.nextDouble(1) < prob) ? Math.abs(datos[i] - 1) : datos[i];
        }
    }

    /**
     * Representación textual del cromosoma.
     * @return Cadena de caracteres correspondiente a los genes del cromosoma.
     */
    @Override
    public String toString(){
        return Arrays.toString(datos);
    }
}
