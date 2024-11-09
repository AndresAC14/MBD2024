package amigos;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class ClubManager extends Club{

    private String fEntrada;
    private String delimitadores;
    private String fSalida;
    private boolean consola;
    private Club club;

    /**
     * Crea un nuevo club manager.
     */
    public ClubManager(Club club){
        this.club = club;
    }

    /**
     * Establece los parámetros de entrada.
     * @param fEntrada Fichero de entrada.
     * @param delim Delimitadores del fichero.
     * @return ClubManager actualizado.
     */
    public ClubManager setEntrada(String fEntrada, String delim){
        this.fEntrada = fEntrada;
        this.delimitadores = delim;
        return this;
    }

    /**
     * Establece el fichero de salida.
     * @param fSalida Fichero de salida.
     * @return ClubManager actualizado.
     */
    public ClubManager setSalida(String fSalida){
        this.fSalida = fSalida;
        return this;
    }

    /**
     * Establece si se mostrarán los resultado en consola o en fichero.
     * @param consola `True` en caso de mostrar por consola. `False` mostrar en fichero.
     * @return ClubManager actualizado.
     */
    public ClubManager setConsola(boolean consola){
        this.consola = consola;
        return this;
    }

    /**
     * Verifica si los ficheros de entrada, salida y el parámetro de consola son válidos.
     * En otro caso lanza AmigoException.
     */
    private void verify(){
        if (fEntrada == null) throw new AmigoException("Fichero de entrada no especificado.");
        if (fSalida == null && !consola) throw new AmigoException("No hay salida especificada.");
    }

    /**
     * Construye el ClubManager con los parámetros correctos.
     * @throws IOException En caso de que algún fichero no sea válido.
     */
    public void build() throws IOException {
        verify();
        club.lee(fEntrada, delimitadores);
        club.hacerAmigos();

        if(fSalida != null){
            club.presentaAmigos(fSalida);
        }

        if(consola) {
            club.presentaAmigos(new PrintWriter(System.out, true));
        }
    }

}
