package alturas;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class MenoresQue implements Seleccion{

    private double alturaMax;

    /**
     * Crea una nueva selección de paises con altura menor que 'altura'
     * @param altura Altura de referencia.
     */
    public MenoresQue(double altura){
        this.alturaMax = altura;
    }

    /**
     * Comprueba que la altura de 'pais' es menor que la altura de referencia.
     * @param pais País que queremos comprobar.
     * @return 'True' en caso afirmativo. 'False' en otro caso.
     */
    @Override
    public boolean test(Pais pais) {
        return pais.altura() < alturaMax;
    }
}
