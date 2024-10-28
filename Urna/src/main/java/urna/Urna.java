package urna;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class Urna {

    /**
     * Color de las bolas
     */
    public static enum ColorBola{
        Blanca,
        Negra

    }

    private static Random alea;

    private int blancas;
    private int negras;

    /**
     * Construye una nueva Urna con el número de bolas que se le indican por parámetro.
     * En caso de que se introduzca un número de bolas no válido se arroja IlegarArgumentException.
     * @param b Número de bolas blancas que tiene la urna.
     * @param n Número de bolas negras que tiene la urna.
     */
    public Urna(int b, int n){
        if (b < 0 || n < 0) {
            throw new IllegalArgumentException("El número de bolas no puede ser negativo");
        }
        this.blancas = b;
        this.negras = n;
        this.alea = new Random();
    }

    /**
     * Añade una bola blanca a al urna.
     */
    public void ponerBlanca(){
        blancas++;
    }

    /**
     * Añade una bola negra a la urna.
     */
    public void ponerNegra(){
        negras++;
    }

    /**
     * Calcula la cantidad total de bolas que contiene la urna.
     * @return Cantidad de bolas
     */
    public int totalBolas(){
       return blancas + negras;
    }

    /**
     * Saca una bola de la urna de forma aleatoria.
     * @return Color de la bola extraída
     */
    public ColorBola extraerBola(){
        int numBolas = totalBolas();

        if(numBolas <= 0) throw new NoSuchElementException("No hay bolas");

        ColorBola bola;

        int valor = alea.nextInt(1, numBolas + 1);

        if(valor <= blancas){
            bola = ColorBola.Blanca;
            blancas--;
        }else{
            bola = ColorBola.Negra;
            negras--;
        }

        return bola;
    }

    /**
     * Representación textual de la urna.
     * @return Cadena que muestra la urna junto al número de bolas de cada color que hay en su interior.
     */
    @Override
    public String toString(){
        return "U(" + blancas + ", " + negras + ")";
    }

}
