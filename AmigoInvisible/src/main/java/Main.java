import amigos.*;
import java.io.IOException;

/**
 * @author Andrés Amo Caballero
 * @version 1.0
 */

public class Main {
	public static void main(String [] args)  {
		//ClubManager clubM = new ClubManager(new Club());
		ClubManager clubM = new ClubManager(new ClubParejas());
		try {
			clubM
				//.setEntrada("data/socios.txt", "[ ,\\-;]+")
				.setEntrada("data/socios.txt", "[ ,;]+")
				.setConsola(true)
// 				.setSalida("data/salida.txt")
				.build();
		} catch (IOException e) {
			System.out.println("Error en la entrada/salida de datos");
		} catch (AmigoException e) {
			System.out.println("Error: " + e.getMessage());			
		}
	}
}
