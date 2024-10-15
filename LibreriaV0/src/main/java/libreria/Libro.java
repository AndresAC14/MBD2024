package libreria;

/**
 * @author Andrés Amo
 * @version 1.0
 */

public class Libro {

    private double precioBase;
    private static double IVA = 10;
    private String autor;
    private String titulo;

    /**
     * Crea un libro
     * @param autor Autor del libro
     * @param titulo Título del libro
     * @param pBase Precio base del libro
     */
    public Libro(String autor, String titulo, double pBase){
        this.autor = autor;
        this.titulo = titulo;
        this.precioBase = pBase;
    }

    /**
     * Calcula el precio final
     * @return
     */
    public double getPrecioFinal(){
        return precioBase + (precioBase * IVA / 100);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public double getPrecioBase(){
        return precioBase;
    }

    public void setIVA(double iva){
        IVA = iva;
    }

    public double getIVA(){
        return IVA;
    }

    @Override
    public String toString(){
        return "(" + autor + ";" + titulo + ";" + IVA + ";" + getPrecioFinal() + ")";
    }
}
