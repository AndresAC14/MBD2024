package indices;

import java.util.*;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public abstract class Indice {
    protected List<String> texto;

    /**
     * Crea un nuevo índice.
     */
    public Indice(){
        texto = new ArrayList<>();
    }

    /**
     * Añade la línea `texto` a la lista de índices.
     * @param texto Nueva línea.
     */
    public void agregarLinea(String texto){
        this.texto.add(texto);
    }

    /**
     * Construye el índice contando las apariciones de cada palabra.
     * @param delimitadores Delimitadores de palabras.
     * @param noSignificativas Conjunto de palabras que no deben incluirse en el índice.
     */
    public abstract void resolver(String delimitadores, Collection<String> noSignificativas);

    /**
     * Representación textual del índice, mostrando cada palabra y sus apariciones correspondientes.
     */
    public abstract void presentarIndiceConsola();
}
