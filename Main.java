package AaD;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String nombres[];
		int edades[];
		
		int dim,mayedad,minedad,nomlargo;
		float media;
		
		
		dim=CantidadAlumnos(sc);
		
		sc.nextLine();	
		
		nombres = new String[dim];
		nombres=NombresAlumnos(dim,sc);
		
		edades = new int[dim];
		edades=EdadesAlumnos(dim,sc);
		
		media=Media(edades,dim);
		
		mayedad=MayorEdad(edades);
		minedad=MinimoEdad(edades);
		
		nomlargo=LongitudNombre(nombres,dim);
		
		Imprimir(nombres,edades,media,mayedad,minedad,nomlargo,dim);

		sc.close();
	}

	public static int CantidadAlumnos(Scanner sc) {
		int Num;
		
			System.out.println("Cuantos alumnos quieras dar de alta");
			Num = sc.nextInt();
		
		return Num;
	}
	
	public static String[] NombresAlumnos(int dim,Scanner sc) {
		String Nombres[] = new String[dim];
		
		for(int i=0; i<Nombres.length; i++) {
			System.out.println("Introduce el nombre del alumno "+(i+1));
			Nombres[i] = sc.nextLine();
		}
		
		return Nombres;
	}
	
	public static int[] EdadesAlumnos(int dim,Scanner sc) {
		int Edades[] = new int[dim];
		
		for(int i=0; i<Edades.length; i++) {
			System.out.println("Introduce la edad del alumno "+(i+1));
			Edades[i] = sc.nextInt();
		}
		
		return Edades;
	}
	
	public static float Media(int[] edades,int dim) {
		float Media=0;
		int Sum=0;
		
		for(int i=0; i<dim; i++) {
			Sum+=edades[i];
		}
		
		Media=(float)Sum/dim;
		
		return Media;
	}
	
	public static int MayorEdad(int[] edades) {
		int MaxEdad=0;
		
		for(int i=1; i<edades.length; i++) {
			if(edades[i]>edades[i-1]) {
				MaxEdad=i;
			}
		}
		
		return MaxEdad;
	}
	
	public static int MinimoEdad(int[] edades) {
		int MinEdad=0;
		
		for(int i=edades.length-2; i>=0; i--) {
			if(edades[i]<edades[i+1]) {
				MinEdad=i;
			}
		}
		
		return MinEdad;
	}
	
	public static int LongitudNombre(String[] nombres,int dim) {
		int NombreLargo=0;
		
		for(int i=1; i<nombres.length; i++) {
			if(nombres[i].length()>nombres[NombreLargo].length()) {
				NombreLargo=i;
			}
		}
		
		return NombreLargo;
	}
	
	public static void Imprimir(String[] nombres,int[] edades,float media,int mayedad,int minedad,int nomlargo,int dim) {
		
		for(int i=0; i<dim; i++) {
			System.out.println("Alumno "+nombres[i]+" Edad "+edades[i]);
		}
		
		System.out.println("La media de edades es "+media);
		System.out.println("El alumno "+nombres[mayedad]+" es el mas boomer con "+edades[mayedad]);
		System.out.println("El alumno "+nombres[minedad]+" es el mas milenial con "+edades[minedad]);
		System.out.println("El alumno con el nombre mas largo es "+nombres[nomlargo]);
	
	}
		
	public static void FinPrograma() {
		System.out.println("\nEl programa ha finalizado");
	}
	
}
