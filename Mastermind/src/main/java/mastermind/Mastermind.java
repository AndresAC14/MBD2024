package mastermind;

import java.util.Random;

public class Mastermind {
    public static final int TAMANO_POR_DEFECTO = 4;
    protected String combinacionSecreta;
    private static Random alea = new Random();


    public Mastermind(){
        this(TAMANO_POR_DEFECTO);
    }

    public Mastermind(int tam){
        if(tam < 1 || tam > 10) throw new MastermindException("Tamaño no admitido");
        generaCombinacionSecreta(tam);
    }

    private void generaCombinacionSecreta(int tam){
        combinacionSecreta = "";

        while(combinacionSecreta.length() < tam){
            String n = Integer.toString(alea.nextInt(10));

            if(!combinacionSecreta.contains(n)) combinacionSecreta += n;

        }

    }

    public int getLongitud(){
        return combinacionSecreta.length();
    }

    private boolean validaCombinacion(String cifras){
        return cifras.matches("[0-9]{"+ getLongitud() + "}")
                && noCifrasRepetidas(cifras);
    }

    private boolean noCifrasRepetidas(String cifras) {
        boolean res = true;
        int pos = 0;

        while (res && pos < cifras.length() - 1) {
            res = cifras
                    .substring(pos + 1)
                    .indexOf(cifras.charAt(pos)) < 0;
            pos++;
        }

        return res;
    }

    /*
    private boolean noCifrasRepetidas(String cifras){

    char[] caracteres = cifras.toCharArray();

    for (int i = 0; i < caracteres.length; i++) {
        for (int j = i + 1; j < caracteres.length; j++) {
            if (caracteres[i] == caracteres[j]) {
                res = false;
            }
        }
    }
    return res;
    }*/

    public Movimiento intento(String cifras){
        if(!validaCombinacion(cifras)) throw new MastermindException("Intento no valido");

        int colocadas = 0;
        int descolocadas = 0;

        for(int i = 0; i < cifras.length(); i++){
            if(combinacionSecreta.charAt(i) == cifras.charAt(i)) colocadas++;
            else if(combinacionSecreta.indexOf(cifras.charAt(i)) >= 0) descolocadas++;
        }

        return new Movimiento(cifras, colocadas, descolocadas);
    }

    public String getSecreto() {
        return combinacionSecreta;
    }
}
