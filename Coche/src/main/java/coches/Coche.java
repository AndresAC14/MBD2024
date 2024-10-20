package coches;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */
public class Coche {

    private static double PIVA = 0.16;
    private String nombre;
    private double precio;

    /**
     * Crea un nuevo coche con nombre y precio dados.
     * En caso de que uno de estos parámetros no sea válido, se lanzará una IlegalArgumentException.
     * @param nombre Nombre del coche.
     * @param precio Precio del coche.
     */
    public Coche(String nombre, double precio){
        if(nombre.isBlank() || precio < 0) throw new IllegalArgumentException("Valores no admitidos");

        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Actualiza el IVA del coche.
     * @param iva Nuevo iva.
     */
    public static void setPiva(double iva){
        PIVA = iva;
    }

    /**
     * Calcula el precio total del coche.
     * @return Precio final con el IVA aplicado sobre el precio base.
     */
    public double precioTotal(){
        return precio + (precio * PIVA);
    }

    /**
     * Representación textual del coche y su precio final.
     * @return Cadena de caracteres
     */
    @Override
    public String toString(){
        return nombre + " -> " + precioTotal();
    }
}
