package libreria;

public class LibreriaOfertaFlexible extends Libreria{

    private OfertaFlex ofertaFlex;

    public LibreriaOfertaFlexible(OfertaFlex oferta){
        this.ofertaFlex = oferta;
    }

    @Override
    public void addLibro(String autor, String titulo, double precio){
        Libro libro = new Libro(autor, titulo, precio);

        double descuento = ofertaFlex.getDescuento(libro);

        if(descuento > 0){
            libro = new LibroEnOferta(autor, titulo, precio, descuento);
        }

        addLibro(libro);
    }

    public void setOfertaFlexible(OfertaFlex oferta){
        this.ofertaFlex = oferta;
    }

    public OfertaFlex getOfertaFlexible(){
        return ofertaFlex;
    }

    @Override
    public String toString(){
        return ofertaFlex + super.toString();
    }
}
