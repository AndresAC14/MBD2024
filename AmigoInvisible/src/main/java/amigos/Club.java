package amigos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class Club {

    protected Set<Persona> socios;

    /**
     * Crea un nuevo club.
     */
    public Club(){
        socios = new TreeSet<>();
    }

    /**
     * Guarda la información de los socios en un flujo de salida.
     * @param pw Flujo de salida elegido.
     */
    public void presentaAmigos(PrintWriter pw) {
        for(Persona amigo: socios){
            pw.println(amigo);
        }
    }

    /**
     * Guarda la información de los socios en un fichero.
     * @param fSalida Fichero de salida.
     * @throws FileNotFoundException En caso de no existir el fichero se lanzará la excepción.
     */
    public void presentaAmigos(String fSalida) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(new File(fSalida))){
            presentaAmigos(pw);
        }
    }

    /**
     * Asigna a cada persona un amigo invisible.
     */
    protected void hacerAmigos(){
        List<Integer> posAmigos = generaListaMezclada();
        List<Persona> listaSocios = new ArrayList<>(socios);

        for(int i = 0; i < socios.size(); i++){
            listaSocios.get(i).setAmigo(listaSocios.get(posAmigos.get(i)));
        }
    }

    /**
     * Crea una lista con las posiciones de los amigos mezcladas.
     * @return Lista de posiciones mezcladas.
     */
    protected List<Integer> generaListaMezclada(){
        List<Integer> posAmigos = generaLista();

        do{
            Collections.shuffle(posAmigos);
        }while(hayCoincidencias(posAmigos));

        return posAmigos;
    }

    /**
     * Comprueba si hay coincidencias en las posiciones de la lista de amigos.
     * @param posAmigos Lista de amigos.
     * @return `True` en caso de haber coincidencia. `False` en caso de no haber coincidencias.
     */
    private static boolean hayCoincidencias(List<Integer> posAmigos){
        boolean res = false;
        for(int i = 0; i < posAmigos.size(); i++){
            if(posAmigos.get(i) == i) res = true;
        }
        return res;
    }

    /**
     * Genera una lista con números insertados en sus posiciones por defecto.
     * @return Lista de números ordenados, de 0 a (número de socios - 1).
     */
    private List<Integer> generaLista(){
        List<Integer> posAmigos = new ArrayList<>();

        for(int i = 0; i < socios.size(); i++){
            posAmigos.add(i);
        }
        return posAmigos;
    }

    /**
     * Lee los socios del fichero de entrada.
     * @param fEntrada Fichero de entrada.
     * @param delim Delimitadores de los nombres.
     * @throws IOException En caso de haber problema con la lectura del fichero.
     */
    public void lee(String fEntrada, String delim) throws IOException {
        for(String linea: Files.readAllLines(Path.of(fEntrada))){
            leeSocios(linea, delim);
        }
    }

    /**
     * Lee los nombres de los socios de la línea indicada.
     * @param linea Línea a leer.
     * @param delim Delimitadores de los nombres.
     */
    private void leeSocios(String linea, String delim){
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter(delim);
            while(sc.hasNext()){
                creaSocioDesdeString(sc.next());
            }
        }
    }

    /**
     * Crea un nuevo socio con el nombre dado.
     * @param nombre Nombre del nuevo socio.
     */
    protected void creaSocioDesdeString(String nombre){
        socios.add(new Persona(nombre));
    }
}
