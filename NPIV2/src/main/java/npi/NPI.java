package npi;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public class NPI {

    private double x, y, z, t;

    public static DoubleUnaryOperator raiz = x -> Math.sqrt(x);
    public static DoubleBinaryOperator suma = (x, y) -> x + y;
    public static DoubleBinaryOperator resta = (x, y) -> x- y;
    public static DoubleBinaryOperator producto = (x, y) -> x * y;
    public static DoubleBinaryOperator division = (x, y) -> x / y;

    public void entra(double valor){
        t = z;
        z = y;
        y = x;
        x = valor;
    }

    public double getResultado(){
        return x;
    }

    public void opera1(DoubleUnaryOperator operador){
        x = operador.applyAsDouble(x);
    }

    public void opera2(DoubleBinaryOperator operador){
        x = operador.applyAsDouble(y, x);
        y = z;
        z = t;
    }

    @Override
    public String toString(){
        return "x=" + x + ", y=" + y + ", z=" + z + ", t=" + t;
    }
}
