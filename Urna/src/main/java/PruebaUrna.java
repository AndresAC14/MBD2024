import urna.Urna;

public class PruebaUrna {
    public static void main(String[] args) {

        int blancas = Integer.parseInt(args[0]);
        int negras = Integer.parseInt(args[1]);

        Urna urna = new Urna(blancas, negras);
        System.out.println("Estado inicial: " + urna);

        while(urna.totalBolas() > 1){

            Urna.ColorBola bola1 = urna.extraerBola();
            Urna.ColorBola bola2 = urna.extraerBola();

            System.out.println("Extracción: " + urna);

            if(bola1 == bola2){
                urna.ponerBlanca();
            }else{
                urna.ponerNegra();
            }

            System.out.println("Adición: " + urna);
        }

        Urna.ColorBola ultimaBola = urna.extraerBola();
        System.out.println("La última bola es: " + ultimaBola);

    }
}
