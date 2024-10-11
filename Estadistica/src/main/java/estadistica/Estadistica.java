package estadistica;

/**
 * @author Andrés Amo Caballero
 *
 * Clase con la que calcular algunas funciones estadísticas
 */

public class Estadistica {
    // Cantidad de elementos de la serie estadística
    private int numElementos;

    // Suma de los valores
    private double sumaX;

    // Suma de los valores al cuadrado
    private double sumaX2;

    // Inicialización de las variables
    public Estadistica(){
        numElementos = 0;
        sumaX = 0;
        sumaX2 = 0;
    }

    /**
     * Añade el elemento "d" a la serie, por lo que incrementa
     * el número de elementos de la serie, lo suma a la variable sumaX y
     * suma a su vez el cuadrado de "d" a sumaX2.
     *
     * @param d Nuevo valor de la serie
     */
    public void agrega(double d){
        numElementos++;
        sumaX += d;
        sumaX2 += Math.pow(d, 2);
    }

    /**
     * Añade el elemento "d" a la serie, pero lo añade "n" veces
     *
     * @param d Nuevo valor de la serie
     * @param n Número de veces que debe ser añadido "d"
     */
    public void agrega(double d, int n){
        for(int i = 1; i <= n; i++){
            agrega(d);
        }
    }

    /**
     *
     * @return Media de los valores de la serie
     */
    public double media(){
        return sumaX/numElementos;
    }

    /**
     *
     * @return Varianza de los valores de la serie
     */
    public double varianza(){
        return (sumaX2/numElementos - Math.pow(media(), 2));
    }

    /**
     *
     * @return Desviación típica de los valores de la serie
     */
    public double desviacionTipica(){
        return Math.sqrt(varianza());
    }
}
