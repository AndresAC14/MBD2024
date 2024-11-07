package indices;

import java.util.*;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class Indice1aLinea extends Indice{

    private Map<String, Integer> palabras;

    /**
     * Crea un nuevo índice de primera aparición.
     */
    public Indice1aLinea(){
        super();
        palabras = new TreeMap<>();
    }

    /**
     * Añade la línea `texto` a la lista de índices.
     * @param texto Nueva línea.
     */
    @Override
    public void agregarLinea(String texto) {
        super.agregarLinea(texto);
        palabras.clear();
    }

    /**
     * Construye el índice contando la primera aparición de cada palabra.
     * @param delimitadores Delimitadores de palabras.
     * @param noSignificativas Conjunto de palabras que no deben incluirse en el índice.
     */
    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Set<String> noSignificativasSet = new HashSet<>();

        for (String palabra : noSignificativas) {
            noSignificativasSet.add(palabra.toLowerCase());
        }

        int pos = 1;
        for(String linea: texto){
            try(Scanner sc = new Scanner(linea)){
                sc.useDelimiter(delimitadores);
                while(sc.hasNext()){
                    String p = sc.next();
                    if(!noSignificativasSet.contains(p.toLowerCase())
                            && !palabras.containsKey(p.toLowerCase()))
                        palabras.put(p.toLowerCase(), pos);
                }
            }
            pos++;
        }
    }

    /**
     * Representación textual del índice, mostrando cada palabra y su línea de aparición correspondiente.
     */
    @Override
    public void presentarIndiceConsola() {
        for (Map.Entry<String, Integer> entry : palabras.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
