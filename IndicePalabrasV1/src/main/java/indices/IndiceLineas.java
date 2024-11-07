package indices;

import java.util.*;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class IndiceLineas extends Indice{

    private Map<String, Set<Integer>> palabras;

    /**
     * Crea un nuevo índice de todas las lineas de aparición.
     */
    public IndiceLineas(){
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
     * Construye el índice contando las lineas en las que aparece cada palabra.
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
                    if(!noSignificativasSet.contains(p.toLowerCase())) {
                        palabras.putIfAbsent(p.toLowerCase(), new TreeSet<>());
                        palabras.get(p.toLowerCase()).add(pos);
                    }
                }
            }
            pos++;
        }
    }

    /**
     * Representación textual del índice, mostrando cada palabra y las líneas en las que aparece.
     */
    @Override
    public void presentarIndiceConsola() {
        for (Map.Entry<String, Set<Integer>> entry : palabras.entrySet()) {
            System.out.print(entry.getKey() + " ");
            for (Integer linea : entry.getValue()) {
                System.out.print(linea + ".");
            }
            System.out.println();
        }
    }
}
