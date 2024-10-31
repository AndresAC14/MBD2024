package wordle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Wordle {

    private Set<String> validas;
    private static Random alea = new Random();
    private String secreta;

    public Wordle(){
        validas = new HashSet<>();
        this.secreta = comienza();
    }

    public Respuesta intento(String movimiento){

    }

    public void leePalabras(String fichero) throws IOException {

        for(String linea: Files.readAllLines(Path.of(fichero))){
            try(Scanner sc = new Scanner(linea)){
                while (sc.hasNext()){
                    validas.add(sc.next());
                }
            }catch (InputMismatchException e){
                System.err.println("Palabra no valida " + linea);
            }catch (NoSuchElementException e){
                System.err.println("No hay elementos " + linea);
            }
        }

    }

    private String comienza(){
        int pos = alea.nextInt(0, validas.size());
        int i = 0;
        Iterator<String> it = validas.iterator();

        while(it.hasNext() && i < pos){
            it.next();
            i++;
        }

        return it.next();
    }

    private String getSecreta(){
        return secreta;
    }

}
