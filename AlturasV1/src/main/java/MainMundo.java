import alturas.*;

import java.io.IOException;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class MainMundo {
    public static void main(String args[]) throws IOException {
        Mundo paises = new Mundo();
        paises.leePaises("data/alturas.txt");

        for (Pais pais : paises.selecciona(new MayoresQue(1.77))) {
            System.out.println(pais);
        }
        System.out.println("************************");
        for (Pais pais : paises.selecciona(new MenoresQue(1.77))) {
            System.out.println(pais);
        }
        System.out.println("************************");

        for (Pais pais : paises.selecciona(new EnContinente("Europe"))) {
            System.out.println(pais);
        }

    }
}
