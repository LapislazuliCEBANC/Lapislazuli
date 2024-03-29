package JON.POO;

public class Persona {
	private String nombre, apellido, dni, telefono;
	
	Persona(String nombre, String apellido, String dni, String telefono){
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.telefono=telefono;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Nombre: "+nombre+"\nApellido: "+apellido+"\nDNI: "+dni+"\nTelefono: "+telefono;
	}
}
