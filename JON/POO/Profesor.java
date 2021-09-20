package JON.POO;

public class Profesor extends Persona {

	private int cantidadAsignaturas;
	private boolean esTutor;
	
	Profesor(String nombre, String apellido, String dni, String telefono, int cantidadAsignaturas, boolean esTutor) {
		super(nombre, apellido, dni, telefono);
		this.cantidadAsignaturas=cantidadAsignaturas;
		this.esTutor=esTutor;
	}

	public int getCantidadAsignaturas() {
		return cantidadAsignaturas;
	}

	public void setCantidadAsignaturas(int cantidadAsignaturas) {
		this.cantidadAsignaturas = cantidadAsignaturas;
	}

	public boolean isEsTutor() {
		return esTutor;
	}

	public void setEsTutor(boolean esTutor) {
		this.esTutor = esTutor;
	}

	@Override
	public String toString() {
		return super.toString()+"\nCantidad de asignaturas: "+cantidadAsignaturas+"\nEs tutor: "+esTutor;
	}
	
}
