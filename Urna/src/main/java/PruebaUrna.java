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

            //System.out.println("Extracción: " + urna);

            if(bola1 == bola2){
                urna.ponerBlanca();
            }else{
                urna.ponerNegra();
            }

            //System.out.println("Adición: " + urna);
        }

        Urna.ColorBola ultimaBola = urna.extraerBola();
        System.out.println("La última bola es: " + ultimaBola);

        /**
         * Cuando hay más bolas negras que blancas, la última bola suele ser blanca.
         *
         * Cuando hay más bolas blancas que negras, la útlima bola suele ser negra.
         *
         * Cuando hay mismo número de bolas, si el número de cada una es
         *  par (ej. 4 blancas y 4 negras), la última bola suele ser blanca.
         *  Y en caso de que el número sea impar (ej. 5 blancas y 5 negras),
         *  la última bola suele ser negra.
         */

    }
}
