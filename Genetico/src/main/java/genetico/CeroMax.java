package genetico;

import java.util.Arrays;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class CeroMax implements Problema{

    /**
     * Calcula el número de genes 0 que tiene el cromosoma 'c'.
     * @param c Cromosoma evaluado.
     * @return Número de genes 0 del cromosoma 'c'.
     */
    @Override
    public int evalua(Cromosoma c) {
        return c.getLongitud() - Arrays.stream(c.datos).sum();
    }
}
