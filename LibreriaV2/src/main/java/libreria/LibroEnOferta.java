package libreria;

public class LibroEnOferta extends Libro{
    private double porDescuento;

    public LibroEnOferta(String autor, String titulo, double precio, double desc){
        super(autor, titulo, precio);
        if(desc < 0) throw new IllegalArgumentException("No se puede hacer ese descuento");
        this.porDescuento = desc;
    }

    public double getDescuento(){ return porDescuento; }

    @Override
    public double getPrecioFinal(){
        double pf = super.getPrecioFinal();
        return  pf - pf*porDescuento/100;
    }

    @Override
    public String toString(){
        return "(" + getAutor() + ";"
                + getTitulo() + ";"
                + getPrecioBase() + ";"
                + getDescuento() + "%;"
                + (getPrecioBase()*porDescuento/100) + ";"
                + IVA + "%;"
                + getPrecioFinal() + ")";
    }
}
