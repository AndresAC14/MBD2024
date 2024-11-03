package alturas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class Mundo {
    private List<Pais> paises;

    /**
     * Crea un nuevo Mundo con la lista de paises vacía.
     */
    public Mundo(){
        paises = new ArrayList<>();
    }

    public List<Pais> getPaises(){ return paises; }

    /**
     * Extrae los paises del fichero 'file' y los almacena en la lista 'paises'.
     * @param file Fichero del que se leen los países.
     * @throws IOException En caso de haber algún problema en la lectura de 'file'.
     */
    public void leePaises(String file) throws IOException{
        for(String linea: Files.readAllLines(Path.of(file))){
            try(Scanner sc = new Scanner(linea)){
                sc.useDelimiter(",");
                sc.useLocale(Locale.ENGLISH);

                String nombre = sc.next();
                String cont = sc.next();
                double alt = sc.nextDouble();

                paises.add(new Pais(nombre, cont, alt));

            }catch (InputMismatchException e){
                System.err.println("Pais no valido: " + linea);
            }catch (NoSuchElementException e){
                System.err.println("No hay elementos en: " + linea);
            }
        }
    }

    /**
     * Selecciona los paises de la lista 'paises' que cumplan el criterio de selección 'sel'.
     * @param sel Selección o criterio usado para filtrar los paises de la lista.
     * @return Lista de paises que cumplen el criterio de selección.
     */
    public List<Pais> selecciona(Seleccion sel){
        return paises.stream().filter(p-> sel.test(p)).toList();
    }
}
