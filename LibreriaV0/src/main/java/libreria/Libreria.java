package libreria;

import java.util.Arrays;

/**
 * @author Andrés Amo
 * @version 1.0
 */

public class Libreria {

    private Libro[] libros;
    private int numLibros;
    private static final int TAM_DEFECTO = 16;

    public Libreria(){
        this(TAM_DEFECTO);
    }

    public Libreria(int cap_inicial){
        if(cap_inicial < 0) throw new IllegalArgumentException("Capacidad no admitida");
        libros = new Libro[cap_inicial];
        numLibros = 0;
    }

    public void addLibro(String aut, String tit, double pBase){
        Libro libro = new Libro(aut, tit, pBase);
        addLibro(libro);
    }

    private void addLibro(Libro l){
        int pos = posicionLibro(l.getAutor(), l.getTitulo());

        if(pos < 0){
            aseguraQueCabe();
            libros[numLibros] = l;
            numLibros++;
        }else{
            libros[pos] = l;
        }
    }

    private int posicionLibro(String aut, String tit){
        int i = 0;

        while((i < numLibros)
                && !(libros[i].getAutor().equalsIgnoreCase(aut)
                || libros[i].getTitulo().equalsIgnoreCase(tit))){
            i++;
        }

        return (i == numLibros) ? -1 : i;
    }

    private void aseguraQueCabe(){
        if(numLibros == libros.length){
            libros = Arrays.copyOf(libros, numLibros*2);
        }
    }

    public double getPrecioBase(String aut, String tit){
        int pos = posicionLibro(aut, tit);

        return (pos >= 0) ? libros[pos].getPrecioBase() : 0;
    }

    public void remLibro(String autor, String titulo){
        int pos = posicionLibro(autor, titulo);

        if(pos >= 0){
            remLibro(pos);
        }
    }

    private void remLibro(int pos){
        for(int i = pos; i < numLibros - 1; i++){
            libros[i] = libros[i+1];
        }
        numLibros--;
        libros[numLibros] = null;
    }

    @Override
    public String toString(){
        String salida = "[";
        for (int i = 0; i < numLibros; i++){
            salida += libros[i] + ",\n";
            if(i == numLibros-1){
                salida += libros[numLibros-1] + "]";
            }
        }
        return salida;
    }

    public double getPrecioFinal(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);

        return (pos >= 0) ? libros[pos].getPrecioFinal() : -1;
    }
}
