package AaD.Repaso.Repaso2;

public class Profesor extends Persona{
    private boolean esTutor;
    private int cantidadAsignaturas;


    //Constructores
    public Profesor(String nombre,String apellido,String telefono,String dni,boolean esTutor,int cantidadAsignaturas){
        super(nombre, apellido, telefono, dni);
        this.esTutor = esTutor;
        this.cantidadAsignaturas = cantidadAsignaturas;
    }


    //Getters
    public boolean getesTutor(){
        return esTutor;
    }

    public int getCantidadAsignaturas() {
        return cantidadAsignaturas;
    }


    //Setters
    public void setEsTutor(boolean esTutor) {
        this.esTutor = esTutor;
    }

    public void setCantidadAsignaturas(int cantidadAsignaturas) {
        this.cantidadAsignaturas = cantidadAsignaturas;
    }


    //Metodos 


}