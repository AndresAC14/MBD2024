package urna;

import java.util.NoSuchElementException;
import java.util.Random;

public class Urna {

    public enum ColorBola{
        Blanca,
        Negra
    }

    private int blancas;
    private int negras;
    private Random alea;

    public Urna(int b, int n){
        if (b < 0 || n < 0) {
            throw new IllegalArgumentException("El número de bolas no puede ser negativo");
        }
        this.blancas = b;
        this.negras = n;
        this.alea = new Random();
    }

    public void ponerBlanca(){
        blancas++;
    }

    public void ponerNegra(){
        negras++;
    }

    public int totalBolas(){
       return blancas + negras;
    }

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

    @Override
    public String toString(){
        return "U(" + blancas + ", " + negras + ")";
    }

}
