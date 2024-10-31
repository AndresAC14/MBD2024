package buses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Servicio {

    private List<Bus> buses;
    private String ciudad;

    public Servicio(String ciudad){
        this.ciudad = ciudad;
        buses = new ArrayList<>();
    }


    /*public List<Bus> filtra(Criterio criterio){
        List<Bus> lista =  new ArrayList<>();

        for(Bus b: buses){
            if(criterio.esSeleccionable(b)) lista.add(b);
        }
        return lista;
    }*/

    public List<Bus> filtra(Criterio criterio) {
        return buses.stream()
                .filter(criterio::esSeleccionable)
                .collect(Collectors.toList());
    }

    public void leeBuses(String file) throws IOException {
        for (String linea: Files.readAllLines(Path.of(file))){
            try(Scanner sc = new Scanner(linea)){
                sc.useDelimiter("[,]+");

                int codBus = sc.nextInt();
                String matricula = sc.next();
                int codLinea = sc.nextInt();

                Bus b = new Bus(codBus, matricula);
                b.setCodLinea(codLinea);
                buses.add(b);
            }catch (InputMismatchException e){
                System.err.println("Datos no numericos en " + linea);
            }catch (NoSuchElementException e){
                System.err.println("Faltan datos en la linea " + linea);
            }
        }
    }

    public String getCiudad(){
        return ciudad;
    }

    public List<Bus> getBuses(){
        return buses;
    }

    public void guarda(String file, Criterio criterio) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(file)){
            guarda(pw, criterio);
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }

    public void guarda(PrintWriter pw, Criterio criterio){
        List<Bus> lista = filtra(criterio);
        for(Bus b: lista){
            pw.println(b);
        }
    }
}
