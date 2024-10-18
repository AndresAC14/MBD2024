package hospital;

public class Medico extends Persona{

    private boolean trabajoEnPrivado;
    private Categoria categoriaProf;
    private double horasSemanales;

    public Medico(String dni,String nombre, String apellidos,  int edad, Genero sexo,
                  Categoria categoria, boolean trabajaEnPrivado, double horas){
        super(dni, nombre, apellidos, edad, sexo);
        this.categoriaProf = categoria;
        this.trabajoEnPrivado = trabajaEnPrivado;
        this.horasSemanales = horas;
    }

    public void setCategoriaProfesional(Categoria categoria){
        categoriaProf = categoria;
    }

    public Categoria getCategoriaProfesional(){
        return categoriaProf;
    }

    public boolean isTrabajoEnPrivado(){
        return trabajoEnPrivado;
    }

    public double getHorasSemanales(){
        return horasSemanales;
    }

    @Override
    public String toString(){
        return "Medico{categoriaProf=" + getCategoriaProfesional()
            + "trabajaEnPrivado=" + isTrabajoEnPrivado()
            + "horasSemanales= " + getHorasSemanales();
    }
}
