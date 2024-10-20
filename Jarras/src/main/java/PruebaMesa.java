import jarras.*;
import static jarras.Mesa.*;
import static jarras.Mesa.Posicion.*;

public class PruebaMesa {
    public static void main(String[] args) {

        Mesa m = new Mesa(7, 5);

        int i = 1;

        while(m.getContenido(Izquierda) != 1 && m.getContenido(Derecha) != 1){

            System.out.println("Iteracion: " + i);

            m.llena(Izquierda);

            System.out.println(m);
            System.out.println("######################");

            m.llenaDesde(Izquierda);

            System.out.println(m);
            System.out.println("######################");

            m.vacia(Derecha);

            System.out.println(m);
            System.out.println("######################");

            m.llenaDesde(Izquierda);

            System.out.println(m);
            System.out.println("######################");

            i++;
        }
    }
}
