import npi.NPI;

public class PruebaNPIV1 {
    public static void main(String[] args) {
        NPI npi = new NPI();

        System.out.println(npi);

        npi.entra(3);

        System.out.println(npi);

        npi.entra(6);

        System.out.println(npi);

        npi.entra(4);

        System.out.println(npi);

        npi.resta();

        System.out.println(npi);

        npi.multiplica();

        System.out.println(npi);

        npi.entra(5);

        System.out.println(npi);

        npi.suma();

        System.out.println(npi);

        System.out.println("Resultado = " + npi.getResultado());
    }
}
