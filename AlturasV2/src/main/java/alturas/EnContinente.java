package alturas;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class EnContinente implements Seleccion{

    private String texto;

    /**
     * Crea una nueva selección de paises que contengan la cadena especificada
     * en el continente al que pertenecen.
     * @param txt Cadena de caracteres que queremos que coincida.
     */
    public EnContinente(String txt){
        this.texto = txt;
    }

    /**
     * Comprueba que el contienente al que pertenece 'pais' contiene la cadena 'texto' en su nombre.
     * @param pais País que comprobamos.
     * @return 'True' en caso afirmativo. 'False' en otro caso.
     */
    @Override
    public boolean test(Pais pais) {
        return pais.continente().matches(".*" + texto + ".*");
    }
}
