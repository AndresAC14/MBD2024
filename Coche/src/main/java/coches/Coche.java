package coches;

public class Coche {

    private static double PIVA = 0.16;
    private String nombre;
    private double precio;

    public Coche(String nombre, double precio){
        if(nombre.isBlank() || precio < 0) throw new IllegalArgumentException("Valores no admitidos");

        this.nombre = nombre;
        this.precio = precio;
    }

    public static void setPiva(double iva){
        PIVA = iva;
    }

    public double precioTotal(){
        return precio + (precio * PIVA);
    }

    @Override
    public String toString(){
        return nombre + " -> " + precioTotal();
    }

}
