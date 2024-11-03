package wordle;

public sealed interface Respuesta permits Fallo, Movimiento {}
