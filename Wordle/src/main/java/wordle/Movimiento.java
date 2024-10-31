package wordle;

public record Movimiento(String intento, String respuesta) implements Respuesta{

    /**
     * V -> letra correcta en posicion correcta
     * A -> letra correcta en posicion incorrecta
     * N -> letra incorrecta
     */

}
