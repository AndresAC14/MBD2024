package indices;

import java.util.*;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class IndicePosicionesEnLineas extends Indice{

    Map<String, Map<Integer, Set<Integer>>> palabras;

    /**
     * Crea un nuevo índice de todas las lineas y posiciones de aparición.
     */
    public IndicePosicionesEnLineas(){
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
     * Construye el índice contando las lineas y las posiciones en las que aparece cada palabra.
     * @param delimitadores Delimitadores de palabras.
     * @param noSignificativas Conjunto de palabras que no deben incluirse en el índice.
     */
    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Set<String> noSignificativasSet = new HashSet<>();

        for (String palabra : noSignificativas) {
            noSignificativasSet.add(palabra.toLowerCase());
        }

        int posL = 1;
        for(String linea: texto){
            try(Scanner sc = new Scanner(linea)){
                sc.useDelimiter(delimitadores);
                int posP = 1;
                while(sc.hasNext()){
                    String p = sc.next().toLowerCase();
                    if(!noSignificativasSet.contains(p)) {
                        palabras.putIfAbsent(p, new TreeMap<>());
                        palabras.get(p).putIfAbsent(posL, new TreeSet<>());
                        palabras.get(p).get(posL).add(posP);
                    }
                    posP++;
                }
            }
            posL++;
        }
    }

    /**
     * Representación textual del índice, mostrando cada palabra, las líneas y las posiciones en las que aparece.
     */
    @Override
    public void presentarIndiceConsola() {
        for (Map.Entry<String, Map<Integer, Set<Integer>>> entry : palabras.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<Integer, Set<Integer>> lineEntry : entry.getValue().entrySet()) {
                System.out.print(lineEntry.getKey() + " ");
                for (Integer posicion : lineEntry.getValue()) {
                    System.out.print(posicion + ".");
                }
                System.out.println();
            }
        }
    }
}
