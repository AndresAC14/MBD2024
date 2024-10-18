package hospital;

abstract public class Persona {

    private int edad;
    private Genero sexo;
    private String apellidos;
    private String dni;
    private String nombre;

    public Persona(String dni, String nombre, String apellidos, int edad, Genero sexo) {
        this.edad = edad;
        this.sexo = sexo;
        this.apellidos = apellidos;
        this.dni = dni;
        this.nombre = nombre;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public String getApellidos() {
        return apellidos;
    }

    @Override
    public String toString(){
        return "P(" + getDni() + "," + getNombre() + ", "
                + getApellidos() + ", " + getEdad() + ", "
                + getSexo() + ")";
    }
}
