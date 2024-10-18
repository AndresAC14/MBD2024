package hospital;

import java.util.List;
import java.util.Optional;

public class Departamento {

    private List<Medico> medicos;
    private String nombre;

    public Departamento(String nombre, List<Medico> medicos){
        this.nombre = nombre;
        this.medicos = medicos;
    }

    public String getNombre(){return nombre;}

    public int getNumMedicos(){
        return medicos.size();
    }

    public Optional<Medico> getMedico(String dni){
        return medicos
                .stream()
                .filter(m -> m.getDni().equalsIgnoreCase(dni))
                .findFirst();
    }

    public int numMedicos(Categoria c){
        return (int) medicos
                .stream()
                .filter(m -> m.getCategoriaProfesional() == c)
                .count();
    }

    public boolean trabajaEnDepartamento(Medico med){
        return medicos.stream()
                .anyMatch(m -> m.getDni().equalsIgnoreCase(med.getDni()));
    }
}
