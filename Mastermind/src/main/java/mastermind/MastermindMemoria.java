package mastermind;

import java.util.ArrayList;
import java.util.List;

public class MastermindMemoria extends Mastermind{

    private List<Movimiento> movimientos;

    public MastermindMemoria(){
        this(TAMANO_POR_DEFECTO);
    }

    public MastermindMemoria(int tam){
        super(tam);
        movimientos = new ArrayList<>();
    }

    @Override
    public Movimiento intento(String cifras){
        Movimiento movimiento = super.intento(cifras);

        if(movimientos.contains(movimiento)) throw new MastermindException("Intento ya realizado");
        else movimientos.add(movimiento);

        return movimiento;
    }
}
