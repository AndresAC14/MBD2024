package coches;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */
public class CocheImportado extends Coche{

    private double homologacion;

    /**
     * Crea un nuevo coche importado.
     * @param nombre Nombre y modelo del coche.
     * @param precio Precio base del coche.
     * @param impuesto Impuesto de homologación.
     */
    public CocheImportado(String nombre, double precio, double impuesto) {
        super(nombre, precio);
        if(impuesto < 0) throw new IllegalArgumentException("Impuesto de homologación no válido");
        homologacion = impuesto;
    }

    /**
     * Recalcula el precio total del coche añadiéndole el impuesto de homologación-
     * @return Precio total del coche.
     */
    @Override
    public double precioTotal(){
        return super.precioTotal() + homologacion;
    }
}
