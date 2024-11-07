import alturas.Mundo;

import java.io.IOException;
import java.util.List;

public class MainMundo {
    public static void main(String args[]) throws IOException {
        Mundo mundo = new Mundo();
        mundo.leePaises("data/alturas.txt");

        System.out.println(mundo.getNombrePaisesS());
        System.out.println(mundo.getPaisesDelContinenteS("Europe"));
        List<String> lc = List.of("Africa", "Asia");
        System.out.println(mundo.paisesDeS(lc));
        // System.out.println(mundo.getYMuestraPaisesDelContinente("Africa"));
        // System.out.println(mundo.getContinentes());
        // System.out.println(mundo.getListContinentes());
        // System.out.println(mundo.extraeMenoresDeContinente("Europe", 1.75));
        // mundo.muestraNombrePaises();
        // System.out.println(mundo.todosMayores(1.67));
        // System.out.println(mundo.masBajoDelContinente("Europe"));
        // System.out.println(mundo.paisDeMayorAltura());
        // System.out.println(mundo.numPaisesQueVerifican(p->p.altura() > 1.79));
        // System.out.println(Arrays.toString(mundo.arrayDePaises("Europe")));
        // System.out.println(mundo.sumaAlturas());
        // System.out.println(mundo.paisesOrdDelContinente("Africa"));
        // System.out.println(mundo.continentesOrd());
        // System.out.println(mundo.alturasDelContinente("Europe"));
        // System.out.println(mundo.numPaisesMenoresQue(1.67));
        // System.out.println(mundo.numIntPaisesMenoresQue(1.67));
        // System.out.println(mundo.separaPor(p -> p.altura() > 1.70));
        // System.out.println(mundo.paisesPorContinente());
        // System.out.println(mundo.numPaisesPorContinente());
        // System.out.println(mundo.alturasPorContinente());
        // System.out.println(mundo.continentesPorAltura());
        // System.out.println(mundo.continentesPorAlturaOrd());
        // System.out.println(mundo.stringDeContinentes());
    }
}
