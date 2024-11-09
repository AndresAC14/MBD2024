package amigos;

import java.util.*;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class ClubParejas extends Club{

    private Set<Pareja> parejas;

    /**
     * Crea un nuevo club de parejas.
     */
    public ClubParejas(){
        parejas = new HashSet<>();
    }

    /**
     * Crea un nuevo socio con el nombre dado.
     * @param nombre Nombre del nuevo socio.
     */
    @Override
    protected void creaSocioDesdeString(String nombre){
        String[] familia = nombre.split("-");
        Persona p = new Persona(familia[0]);
        socios.add(p);

        for(int i = 1; i < familia.length; i++){
            Persona otraPersona = new Persona(familia[i]);
            socios.add(otraPersona);
            parejas.add(new Pareja(p, otraPersona));
        }
    }

    /**
     * Asigna a cada persona un amigo invisible.
     */
    @Override
    protected void hacerAmigos() {
        List<Integer> posAmigos;
        List<Persona> listaSocios = new ArrayList<>(socios);

        do {
            posAmigos = super.generaListaMezclada();
        } while (hayParejasIncompatibles(listaSocios, posAmigos));

        for (int i = 0; i < listaSocios.size(); i++) {
            listaSocios.get(i).setAmigo(listaSocios.get(posAmigos.get(i)));
        }
    }

    /**
     * Comprueba si hay parejas incompatibles.
     * @param listaSocios Lista de socios actual.
     * @param posAmigos Lista de posiciones de amigos.
     * @return `True` en caso de haber incompatibilidades. `False` en caso de no haber problemas.
     */
    private boolean hayParejasIncompatibles(List<Persona> listaSocios, List<Integer> posAmigos) {
        boolean res = false;
        for (int i = 0; i < listaSocios.size(); i++) {
            Persona socio = listaSocios.get(i);
            Persona amigoAsignado = listaSocios.get(posAmigos.get(i));

            if (parejas.contains(new Pareja(socio, amigoAsignado))) res = true;

        }
        return res;
    }
}
