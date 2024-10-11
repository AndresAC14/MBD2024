import jarras.Jarra;

public class PruebaJarra {
    public static void main(String[] args) {
        Jarra j1 = new Jarra(7);
        Jarra j2 = new Jarra(5);

        int i = 1;

        while(j1.getContenido() != 1 && j2.getContenido() != 1){

            System.out.println("Iteracion: " + i);

            j1.llena();

            System.out.println(j1);
            System.out.println(j2);
            System.out.println("######################");

            j2.llenaDesde(j1);

            System.out.println(j1);
            System.out.println(j2);
            System.out.println("######################");

            j2.vacia();

            System.out.println(j1);
            System.out.println(j2);
            System.out.println("######################");

            j2.llenaDesde(j1);

            System.out.println(j1);
            System.out.println(j2);
            System.out.println("######################");

            i++;
        }
    }
}
