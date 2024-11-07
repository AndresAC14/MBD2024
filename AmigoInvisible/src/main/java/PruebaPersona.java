import amigos.Persona;

public class PruebaPersona {
    public static void main(String[] args) {
        Persona p1 = new Persona("awa");
        p1.setAmigo(new Persona("mondongo"));
        System.out.println(p1);
    }
}
