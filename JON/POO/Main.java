package JON.POO;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static Alumno anadirAlumno(Scanner sc) {
		sc.nextLine();
		String nombre, apellido, dni, telefono;
		int curso;
		float nota;
		Alumno alumno;
		System.out.println("Cual es el nombre del alumno?");
		nombre = sc.nextLine();
		System.out.println("Cual es el apellido de "+nombre+"?");
		apellido = sc.nextLine();
		System.out.println("Cual es el DNI de "+nombre);
		dni = sc.nextLine();
		System.out.println("Cual es el numero de telefono de "+nombre+" (itroduzcalo todo seguido)?");
		telefono = sc.next();
		while(telefono.length()!=9){
			System.out.println("Introduzca el numero en el formato adecuado (123456789)");
			sc.next();
		}
		System.out.println("En que curso esta "+nombre+"?");
		curso = sc.nextInt();
		while(curso!=1 && curso!=2) {
			System.out.println("El curso debe de ser entre 1 y 2");
			curso = sc.nextInt();
		}
		System.out.println("Cual es la nota de "+nombre+"?");
		nota = sc.nextFloat();
		alumno = new Alumno(nombre, apellido, dni, telefono, curso, nota);
		return alumno;
	}

	public static Profesor anadirProfesor(Scanner sc) {
		sc.nextLine();
		String nombre, apellido, dni, telefono;
		int cantidadAsignaturas;
		boolean esTutor;
		char comprobador;
		Profesor profesor;
		System.out.println("Cual es el nombre del Profesor?");
		nombre = sc.nextLine();
		System.out.println("Cual es el apellido de "+nombre+"?");
		apellido = sc.nextLine();
		System.out.println("Cual es el DNI de "+nombre);
		dni = sc.nextLine();
		System.out.println("Cual es el numero de telefono de "+nombre+" (itroduzcalo todo seguido)?");
		telefono = sc.next();
		while(telefono.length()!=9){
			System.out.println("Introduzca el numero en el formato adecuado (123456789)");
			sc.next();
		}
		System.out.println("Cuantas asignaturas imparte "+nombre+"?");
		cantidadAsignaturas = sc.nextInt();
		System.out.println("El profesor "+nombre+" es tutor? s=si n=no");
		comprobador = sc.next().charAt(0);
		while(comprobador != 's' && comprobador != 'n') {
			System.out.println("Las respuestas validas son s=si n=no");
			comprobador = sc.next().charAt(0);
		}
		if(comprobador == 's') {
			esTutor = true;
		}else { 
			esTutor = false;
		}
		profesor = new Profesor(nombre, apellido, dni, telefono, cantidadAsignaturas, esTutor);
		return profesor;
	}

	public static int eliminarAlumno(Scanner sc, ArrayList<Alumno> alumnos){
		sc.nextLine();
		int eliminador = -1;
		String mostrador;
		System.out.println("A que alumno desea eliminar?");
		for (int i = 0; i < alumnos.size(); i++) {
			mostrador = alumnos.get(i).getNombre();
			System.out.println((i+1)+"-"+mostrador);
		}
		eliminador=sc.nextInt()-1;
		while (eliminador+1>alumnos.size() || eliminador<0) {
			System.out.println("Porfavor introduzca el numero correspondiente al nombre");
			for (int i = 0; i < alumnos.size(); i++) {
				mostrador = alumnos.get(i).getNombre();
				System.out.println((i+1)+"-"+mostrador);
			}
			eliminador=sc.nextInt()-1;
		}
		return eliminador;
	}

	public static int eliminarProfesor(Scanner sc, ArrayList<Profesor> profesores){
		sc.nextLine();
		int eliminador = -1;
		String mostrador;
		System.out.println("A que profesor desea eliminar?");
		for (int i = 0; i < profesores.size(); i++) {
			mostrador = profesores.get(i).getNombre();
			System.out.println((i+1)+"-"+mostrador);
		}
		while (eliminador+1>profesores.size() || eliminador<0) {
			System.out.println("Porfavor introduzca el numero correspondiente al nombre");
			for (int i = 0; i < profesores.size(); i++) {
				mostrador = profesores.get(i).getNombre();
				System.out.println((i+1)+"-"+mostrador);
			}
			eliminador=sc.nextInt()-1;
		}
		eliminador=sc.nextInt()-1;
		return eliminador;
	}

	public static int aprobados(ArrayList<Alumno> alumnos) {
		int contador = 0, total = 0;
		for (int i = 0; i < alumnos.size(); i++) {
			if(alumnos.get(i).getNota()>=5) {
				contador++;
			}
		}
		total = contador*100/alumnos.size();
		return total;
	}

	public static int maximoAsignaturas(ArrayList<Profesor> profesores) {
		int posicion = 0;
		for (int i = 0; i < profesores.size(); i++) {
			if (profesores.get(i).isEsTutor()) {
				if(profesores.get(posicion).getCantidadAsignaturas()<profesores.get(i).getCantidadAsignaturas() || profesores.get(posicion).isEsTutor() == false) {
					posicion=i;
				}
			}
		}
		return posicion;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char opcion;
		boolean repetir = true;
		ArrayList<Alumno> alumnos = new ArrayList<>();
		ArrayList<Profesor> profesores = new ArrayList<>();

		while(repetir) {

			System.out.println("\nEliga una opcion:\n1-Añadir Alumno\n2-Añadir Profesor\n3-Eliminar Alumno\n4-Eliminar Profesor\n5-Cantidad de alumnos en primero y segundo\n6-Porcentaje de alumnos aprobados por curso\n7-Obtener profesor con mas asignaturas y ademas de ser profesor\n8-Salir");
			opcion = sc.next().charAt(0);
			switch (opcion) {
			case '1':
				alumnos.add(anadirAlumno(sc));
				break;
			case '2':
				profesores.add(anadirProfesor(sc));
				break;
			case '3':
				alumnos.remove(eliminarAlumno(sc, alumnos));
				break;
			case '4':
				profesores.remove(eliminarProfesor(sc,profesores));
				break;
			case '5':
				System.out.println("Hay un total de "+alumnos.size()+" en primero y segundo");
				break;
			case '6':
				System.out.println("Hay un total de "+aprobados(alumnos)+"% de aprobados");
				break;
			case '7':
				System.out.println("El profesor que es tutor y con mas asignaturas es\n"+profesores.get(maximoAsignaturas(profesores)).getNombre()+" con un total de "+profesores.get(maximoAsignaturas(profesores)).getCantidadAsignaturas()+" asignaturas");
				break;
			case '8':
				repetir = false;
				break;
			default:
				for(int i = 0; i<profesores.size(); i++) {
					System.out.println(profesores.get(i).toString());
				}

				break;
			}
			sc.nextLine();
		}
		sc.close();
	}

}
