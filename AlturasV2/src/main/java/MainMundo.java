import alturas.*;

import java.io.IOException;
import java.util.*;

/**
 * @author Andrés Amo Caballero
 * @version 2.0
 */

public class MainMundo {
    public static void main(String args[]) throws IOException {
        Mundo mundo = new Mundo();
        mundo.leePaises("data/alturas.txt");
        List<Pais> paises = mundo.getPaises();

        Set<Pais> conjunto;

        // A) Paises ordenados por altura.
        Comparator<Pais> compAltura = Comparator.comparingDouble(Pais::altura);
        ordena(paises, compAltura);

        // B) Paises ordenados alfabeticamente.
        Comparator<Pais> compAlf = Comparator.comparing(Pais::nombre);
        ordena(paises, compAlf);

        // C) Paises ordenados por continente y alfabeticamente.
        Comparator<Pais> compConti = Comparator.comparing(Pais::continente);
        ordena(paises, compConti.thenComparing(compAlf));

        // D) Paises ordenados por continente y orden inverso alfabeticamente
        Comparator<Pais> compContiAlf = compConti.thenComparing(compAlf.reversed());
        ordena(paises, compContiAlf);

        // E) Paises ordenados naturalmente
        Comparator<Pais> compNatural = Comparator.naturalOrder();
        ordena(paises, compNatural);

        // F) Paises ordenados por continente y orden natural
        Comparator<Pais> compContiNatural = compConti.thenComparing(compNatural);
        ordena(paises, compContiNatural);
    }

    /**
     * Ordena los paises según el criterio comparador que se especifique.
     * @param paises Lista de paises.
     * @param comparator Criterio con el que se ordenarán los paises.
     */
    public static void ordena(List<Pais> paises, Comparator<Pais> comparator){
        Set<Pais> conjunto = new TreeSet<>(comparator);
        conjunto.addAll(paises);
        System.out.println(conjunto);
    }
}
