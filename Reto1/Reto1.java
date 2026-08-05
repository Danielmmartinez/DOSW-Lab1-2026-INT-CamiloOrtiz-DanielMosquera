import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reto1 {

	public static void main(String[] args) {
		
		System.out.println("Ingrese los datos del primer estudiante: ");
		Estudiante estudiante1 = generarEstudiante();

		System.out.println("\nIngrese los datos del segundo estudiante: ");
		Estudiante estudiante2 = generarEstudiante();

		List<Estudiante> estudiantes = List.of(estudiante1, estudiante2);
		
		MensajeBienvenida.imprimirMensajeBienvenida(estudiantes);
	}

	private static Estudiante generarEstudiante() {

		Scanner scanner = new Scanner(System.in);

		System.out.print("\nIngresar el nombre: ");
		String nombre = scanner.nextLine();

		System.out.print("Ingresar la edad: ");
		int edad = scanner.nextInt();

		System.out.print("Ingresar el correo: ");
		String correo = scanner.next();

		System.out.print("Ingresar el semestre: ");
		int semestre = scanner.nextInt();

		return new Estudiante(nombre, edad, correo, semestre);
	}
}

class Estudiante {
	
	private String nombre;
	private int edad;
	private String correo;
	private int semestre;
	
	public Estudiante(String nombre, int edad, String correo, int semestre) {
		this.nombre = nombre;
		this.edad = edad;
		this.correo = correo;
		this.semestre = semestre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getCorreo() {
		return correo;
	}

	public int getSemestre() {
		return semestre;
	}
	
}

class MensajeBienvenida {
	
	public static void imprimirMensajeBienvenida(List<Estudiante> estudiantes) {
		
		System.out.println("\n¡Hola, bienvenidos! Somos la pareja conformada por");
		
		System.out.print(
			estudiantes.stream()
				   	   .map(estudiante -> estudiante.getNombre() + ", estudiante de " + estudiante.getSemestre()
						   + "° semestre de " + estudiante.getEdad() + " años")
				       .collect(Collectors.joining(", y ")));
		
		System.out.println(". Nuestros correos son:");
		
		System.out.print(
				estudiantes.stream()
					   	   .map(estudiante -> estudiante.getCorreo())
					       .collect(Collectors.joining(" y ")));
	}
}