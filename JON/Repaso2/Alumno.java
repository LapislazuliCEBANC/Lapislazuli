package AaD.Repaso.Repaso2;

public class Alumno extends Persona{
    private int curso;
    private float nota;


    //Constructores
    public Alumno(String nombre,String apellido,String telefono,String dni,int curso,float nota){
        super(nombre, apellido, telefono, dni);
        this.curso = curso;
        this.nota = nota;
    }


    //Getters
    public int getCurso() {
        return curso;
    }

    public float getNota() {
        return nota;
    }

    //Setters
    public void setCurso(int curso) {
        this.curso = curso;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    //Metodos


}