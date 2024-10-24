package libreria;

public class OfertaPrecio implements OfertaFlex{

    private double umbralPrecio;
    private double porDescuento;

    public OfertaPrecio(double desc, double umbral){
        this.umbralPrecio = umbral;
        this.porDescuento = desc;
    }

    @Override
    public double getDescuento(Libro libro) {
        return libro.getPrecioBase() >= umbralPrecio ? porDescuento : 0;
    }

    @Override
    public String toString(){
        return porDescuento + "%(" + umbralPrecio + ")";
    }
}
