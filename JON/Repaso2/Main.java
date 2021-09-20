package AaD.Repaso.Repaso2;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();
		ArrayList<Profesor> profesores = new ArrayList<>();
        int operacion;
        boolean repetir=true;
        
        do{
            operacion = operaciones(sc);
            switch (operacion){
                case 0: repetir = false;
                    break;
                case 1: alumnos.add(altaAlumnos(sc,altaPersona(sc,operacion)));
                    break;
                case 2: profesores.add(altaProfesores(sc,altaPersona(sc,operacion)));
                    break;
                case 3: alumnos.remove(bajaAlumnos(sc,alumnos));
                    break;
                case 4: profesores.remove(bajaProfesores(sc,profesores));
                    break;
                case 5: mostarAlumnos(alumnos);
                    break;
                case 6: mostrarProfesores(sc, profesores);
                    break;
                case 7: matriculados(alumnos);
                    break;
                case 8: porcentajeAprobados(alumnos);
                    break;
                case 9: masAsignaturasTutor(profesores);
                    break;
                default: System.out.println("Error");
                    break;
            }
        }while(repetir);

        finPrograma();

        sc.close();
    }

    public static int operaciones(Scanner sc) {
        int operacion;

        System.out.println("\nQue operación quieres hacer?" +
        "\n1.Dar de alta Alumnos\n2.Dar de alta Profesores\n3.Dar de baja alumnos\n4.Dar de baja profesores" +
        "\n5.Mostrar alumnos\n6.Mostar profesores\n7.Matriculados\n8.Porcentaje aprobados\n9.Tutor con mas asignaturas");
        operacion = sc.nextInt();

        return operacion;
    }

    public static Persona altaPersona(Scanner sc, int operacion){
        Persona persona;
        String nombre, apellido, dni, telefono;

        sc.nextLine();
        if(operacion == 1){
            System.out.println("\nNombre del alumno");
        }else{
            System.out.println("\nNombre del profesor");
        }
        nombre = sc.nextLine();
        System.out.println("Apellido de " + nombre);
        apellido = sc.nextLine();
        System.out.println("DNI "+ nombre + " " + apellido);
        dni = sc.nextLine();
        while(!validarDNI(dni)){
            System.out.println("Introduzca un DNI valido");
			dni = sc.nextLine();
        }
        System.out.println("Telefono "+ nombre + " " + apellido);
        telefono = sc.nextLine();
        while(!isNumeric(telefono) || telefono.length()!=9){
			System.out.println("Introduzca un telefono valido");
			telefono = sc.nextLine();
		}

        persona = new Persona(nombre, apellido, telefono, dni);
        return persona;
    }

    public static Alumno altaAlumnos(Scanner sc, Persona persona) {
        Alumno alumno;
        int curso;
        float nota;

        //sc.nextLine();
        System.out.println("Curso "+ persona.getNombre() + " " + persona.getApellido());
        curso = sc.nextInt();
        while(curso != 1 && curso != 2){
			System.out.println("Introduzca un curso valido");
			curso = sc.nextInt();
		}
        System.out.println("Nota "+ persona.getNombre() + " " + persona.getApellido());
        nota = sc.nextFloat();
        while(nota < 0 || nota > 10){
			System.out.println("Introduzca una nota valida");
			nota = sc.nextInt();
		}

        alumno = new Alumno(persona.getNombre(), persona.getApellido(), persona.getDni(),persona.getTelefono(), curso, nota);
        return alumno;
    }

    public static Profesor altaProfesores(Scanner sc, Persona persona) {
        Profesor profesor;
        int cantidadAsignaturas;
		boolean esTutor=false,error=false;
        char yesNo;

        //sc.nextLine();
        System.out.println("Cuantas asignaturas imparte?");
        cantidadAsignaturas = sc.nextInt();
        sc.nextLine();
        System.out.println(persona.getNombre() + " es tutor?\nY/N");
        yesNo = sc.next().charAt(0);
        do{
            if (yesNo == 'Y' || yesNo == 'y') {
                esTutor = true;
            }else if (yesNo == 'N' || yesNo == 'n') {
                esTutor = false;
            }else {
                error = true;
            }
        }while(error == true);

        profesor = new Profesor(persona.getNombre(), persona.getApellido(), persona.getDni(),persona.getTelefono(), esTutor, cantidadAsignaturas);
        return profesor;
    }

    public static int bajaAlumnos(Scanner sc, ArrayList <Alumno> alumnos){
		int eliminador = -1;

        sc.nextLine();
		System.out.println("A que alumno desea dar de baja?");
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println((i+1) + "." + alumnos.get(i).getNombre());
		}
		eliminador=sc.nextInt()-1;
		while (eliminador<0 || eliminador+1>alumnos.size()) {
			System.out.println("Introduzca el numero correspondiente al nombre");
			for (int i = 0; i < alumnos.size(); i++) {
				System.out.println((i+1) + "." + alumnos.get(i).getNombre());
			}
			eliminador=sc.nextInt()-1;
		}
		return eliminador;
    }

    public static int bajaProfesores(Scanner sc, ArrayList <Profesor> profesores){
		int eliminador = -1;
        
        sc.nextLine();
		System.out.println("A que profesor desea dar de baja?");
		for (int i = 0; i < profesores.size(); i++) {
			System.out.println((i+1) + "." + profesores.get(i).getNombre());
		}
        eliminador=sc.nextInt()-1;
		while (eliminador<0 || eliminador+1>profesores.size()) {
			System.out.println("Introduzca el numero correspondiente al nombre");
			for (int i = 0; i < profesores.size(); i++) {
				System.out.println((i+1) + "." + profesores.get(i).getNombre());
			}
			eliminador=sc.nextInt()-1;
		}
		return eliminador;
    }

    public static void mostarAlumnos(ArrayList <Alumno> alumnos){
        System.out.println("\nHay " + alumnos.size() + " alumnos matriculados en el centro");

        for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getCurso() == 1) {
				System.out.println(alumnos.get(i).getNombre() + " " + alumnos.get(i).getApellido() + " en 1º");
			}else{
                System.out.println(alumnos.get(i).getNombre() + " " + alumnos.get(i).getApellido() + " en 2º");
            }
		}
    }

    public static void mostrarProfesores(Scanner sc, ArrayList <Profesor> profesores){
        System.out.println("\nHay " + profesores.size() + " profesores en el centro");
		for (int i = 0; i < profesores.size(); i++) {
			System.out.println(profesores.get(i).getNombre() + " " + profesores.get(i).getApellido());
		}
    }

    public static void matriculados(ArrayList<Alumno> alumnos){
        int en1=0, en2=0;

        for(int i=0; i<alumnos.size(); i++){
            if(alumnos.get(i).getCurso() == 1){
                en1++;
            }else{
                en2 ++;
            }
        }

        System.out.println("\nHay " + en1 + " alumnos en 1º y " + en2 + " alumnos en 2º");
    }

    public static void porcentajeAprobados(ArrayList<Alumno> alumnos){
        int contador=0;
        float porcentaje=0;

        for(int i=0; i<alumnos.size(); i++){
            if(alumnos.get(i).getNota() >= 5){
                contador++;
            }
        }

        porcentaje = contador*100/alumnos.size();
        System.out.println("El porcentaje de aprobados es " + porcentaje + "%");
    }

    public static void masAsignaturasTutor(ArrayList<Profesor> profesores) {
		int posicion = 0;

		for (int i = 0; i < profesores.size(); i++) {
			if (profesores.get(i).getesTutor()) {
				if(profesores.get(posicion).getCantidadAsignaturas()<profesores.get(i).getCantidadAsignaturas() || profesores.get(posicion).getesTutor() == false) {
					posicion=i;
				}
			}
		}

        System.out.println("\nEl tutor con mas asignaturas es " + profesores.get(posicion).getNombre() + " " + profesores.get(posicion).getApellido());
	}

    public static boolean validarDNI(String dni){
        boolean valido=false;
        String letraMayuscula = "";

        if(dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false) {
            valido = false;
        }

        letraMayuscula = (dni.substring(8).toUpperCase());

        if(soloNumeros(dni) == true && letraDNI(dni).equals(letraMayuscula)) {
            valido = true;
        }else {
            valido = false;
        }

        return valido;
    }

    public static boolean soloNumeros(String dni) {
        boolean valido = false;
        String numero = "";
        String miDNI = "";
        String[] rangoNumeros = {"0","1","2","3","4","5","6","7","8","9"};

        for(int i=0 ; i<dni.length()-1; i++){
            numero = dni.substring(i, i+1);
            for(int j=0; j<rangoNumeros.length; j++){
                if(numero.equals(rangoNumeros[j])){
                    miDNI += rangoNumeros[j];
                }
            }
        }

        if(miDNI.length() !=8){
            valido = false;
        }else{
            valido = true;
        }

        return valido;
    }

    public static String letraDNI(String dni){
        String letra = "";
        int miDNI = Integer.parseInt(dni.substring(0,8));
        int resto = 0;
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        resto = miDNI % 23;

        letra = asignacionLetra[resto];

        return letra;
    }

    private static boolean isNumeric(String cadena){
        boolean valido = false;

        try {
            Integer.parseInt(cadena);
            valido = true;
        } catch (NumberFormatException nfe){
            valido = false;
        }

        return valido;
    }
    
    public static void finPrograma(){
        System.out.println("\nEl programa ha finalizado");
    }
}