package JON.POO;

public class Alumno extends Persona {

	private int curso;
	private float nota;
	
	Alumno(String nombre, String apellido, String dni, String telefono, int curso, float nota) {
		super(nombre, apellido, dni, telefono);
		this.curso=curso;
		this.nota=nota;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	
}
