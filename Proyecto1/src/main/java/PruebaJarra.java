import jarras.Jarra;

public class PruebaJarra {
    public static void main(String[] args) {
        Jarra j1 = new Jarra(4);
        Jarra j2 = new Jarra(6);

        System.out.println(j1);
        System.out.println(j2);

        j2.llena();

        System.out.println(j1);
        System.out.println(j2);

        j1.llenaDesde(j2);

        System.out.println(j1);
        System.out.println(j2);

    }
}
