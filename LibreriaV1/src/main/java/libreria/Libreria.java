package libreria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Andrés Amo
 * @version 2.0
 */

public class Libreria {

    private List<Libro> libros;

    public Libreria(){
        libros = new ArrayList<>();
    }

    public void addLibro(String aut, String tit, double pBase){
        Libro libro = new Libro(aut, tit, pBase);
        addLibro(libro);
    }

    private void addLibro(Libro l){
        int pos = posicionLibro(l.getAutor(), l.getTitulo());

        if(pos < 0){
            libros.add(l);
        }else{
            libros.set(pos, l);
        }
    }

    private int posicionLibro(String aut, String tit){
        int i = 0;

        while((i < libros.size())
                && !(libros.get(i).getAutor().equalsIgnoreCase(aut)
                || libros.get(i).getTitulo().equalsIgnoreCase(tit))){
            i++;
        }

        return (i == libros.size()) ? -1 : i;
    }

    public double getPrecioBase(String aut, String tit){
        int pos = posicionLibro(aut, tit);

        return (pos >= 0) ? libros.get(pos).getPrecioBase() : 0;
    }

    public void remLibro(String autor, String titulo){
        int pos = posicionLibro(autor, titulo);

        if(pos >= 0){
            libros.remove(pos);
        }
    }

    @Override
    public String toString(){
        return libros.toString();
    }

    public double getPrecioFinal(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);

        return (pos >= 0) ? libros.get(pos).getPrecioFinal() : 0;
    }
}
