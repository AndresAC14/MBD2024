package libreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex{

    private String[] autores;
    private double porDescuento;

    public OfertaAutor(double desc, String[] au){
        this.porDescuento = desc;
        this.autores = au;
    }

    @Override
    public double getDescuento(Libro libro) {
        return estaEnDescuento(libro.getAutor()) ? porDescuento : 0;
    }

    private boolean estaEnDescuento(String autor){
        int pos = 0;

        while(pos < autores.length &&
            !autores[pos].equalsIgnoreCase(autor)){
            pos++;
        }

        return pos < autores.length;
    }

    @Override
    public String toString(){
        String salida = porDescuento + "%[";

        for(int i = 0; i < autores.length - 1; i++){
            salida += autores[i] + ";";
        }

        return salida + autores[autores.length - 1] + "]";
    }
}
