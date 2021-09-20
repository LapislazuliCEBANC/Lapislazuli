package AaD.Repaso.Repaso2;

public class Persona{
    private String nombre;
    private String apellido;
    private String telefono;
    private String dni;


    //Constructores
    public Persona(String nombre,String apellido,String telefono,String dni){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
    }


    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDni() {
        return dni;
    }


    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    //Metodos
    

}