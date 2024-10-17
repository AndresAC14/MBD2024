package libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria{

    private String[] autores;
    private double porDescuento;

    public LibreriaOferta(double pd, String[] au){
        //super(); es opcional
        porDescuento = pd;
        autores = au;
    }

    public void setOferta(double pd, String[] au){
        porDescuento = pd;
        autores = au;
    }

    public String[] getOferta(){
        return autores;
    }

    public double getDescuento(){ return porDescuento; }

    @Override
    public void addLibro(String autor, String titulo, double pb){
        addLibro(esAutorEnOferta(autor) ? new LibroEnOferta(autor, titulo, pb, porDescuento) : new Libro(autor, titulo, pb));
    }

    private boolean esAutorEnOferta(String autor){
        int pos = 0;

        while(pos < autores.length && !autores[pos].equalsIgnoreCase(autor)){
            pos++;
        }
        return pos < autores.length;
    }

    @Override
    public String toString(){
        // solo cuando el array esta completo funciona este Arrays.toString(autores)
        return porDescuento  + "% " + Arrays.toString(autores) + super.toString();
    }
}
