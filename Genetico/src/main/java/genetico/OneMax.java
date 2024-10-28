package genetico;

import java.util.Arrays;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class OneMax implements Problema{

    /**
     * Calcula el número de genes 1 que tiene el cromosoma 'c'.
     * @param c Cromosoma evaluado.
     * @return Número de genes 1 del cromosoma 'c'.
     */
    @Override
    public int evalua(Cromosoma c) {
        return Arrays.stream(c.datos).sum();
    }
}
