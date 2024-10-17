import jarras.*;

public class PruebaMesa {
    public static void main(String[] args) {

        Mesa m = new Mesa(7, 5);

        int i = 1;

        while(m.getContenido(Mesa.Posicion.Izquierda) != 1 && m.getContenido(Mesa.Posicion.Derecha) != 1){

            System.out.println("Iteracion: " + i);

            m.llena(Mesa.Posicion.Izquierda);

            System.out.println(m);
            System.out.println("######################");

            m.llenaDesde(Mesa.Posicion.Izquierda);

            System.out.println(m);
            System.out.println("######################");

            m.vacia(Mesa.Posicion.Derecha);

            System.out.println(m);
            System.out.println("######################");

            m.llenaDesde(Mesa.Posicion.Izquierda);

            System.out.println(m);
            System.out.println("######################");

            i++;
        }
    }
}
