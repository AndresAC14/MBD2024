package alturas;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class MayoresQue implements Seleccion{

    private double alturaMin;

    /**
     * Crea una nueva selección de paises con altura mayor o igual que 'altura'
     * @param altura Altura de referencia.
     */
    public MayoresQue(double altura){
        this.alturaMin = altura;
    }

    /**
     * Comprueba que la altura de 'pais' es mayor o igual a la altura de referencia.
     * @param pais País que queremos comprobar.
     * @return 'True' en caso afirmativo. 'False' en otro caso.
     */
    @Override
    public boolean test(Pais pais) {
        return pais.altura() >= alturaMin;
    }
}
