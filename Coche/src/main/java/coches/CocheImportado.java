package coches;

public class CocheImportado extends Coche{

    private double homologacion;

    public CocheImportado(String nombre, double precio, double impuesto) {
        super(nombre, precio);
        if(impuesto < 0) throw new IllegalArgumentException("Impuesto de homologación no válido");
        homologacion = impuesto;
    }

    @Override
    public double precioTotal(){
        return super.precioTotal() + homologacion;
    }

}
