import geometria.Punto;
import geometria.Segmento;

public class PruebaPunto {
    public static void main(String[] args) {

        Punto p1 = new Punto(3.5, 8.8);

        System.out.println(p1);

        p1.trasladar(3.0, -10.0);

        System.out.println(p1);

        Punto p2 = new Punto();

        System.out.println(p2);

        p2.trasladar(2,9);

        System.out.println(p2);

        System.out.println("Distancia de p1 a p2: " + p1.distancia(p2));

        Segmento s1 = new Segmento(p1, p2);

        System.out.println(s1.longitud());
    }
}
