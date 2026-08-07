import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reto2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Lista 1:");
		List<Integer> listaProcesada = leerDatos(scanner);
		mostrarDatos(listaProcesada, "Lista 1");

		System.out.println("Lista 2:");
		List<Integer> listaProcesada2 = leerDatos(scanner);
		mostrarDatos(listaProcesada2, "Lista 2");


	}
	public static List<Integer> leerDatos(Scanner scanner){
		String lista = scanner.nextLine();
		String[] datos = lista.split(",");
		List<Integer> listaProcesada = Arrays.stream(datos)
				.map(d -> d.strip())
				.map(d -> Integer.parseInt(d))
				.toList();
		return listaProcesada;

	}

	public static void mostrarDatos(List<Integer> lista, String nombre) {

		int minimo = lista.stream()
						  .min((a,b) -> Integer.compare(a,b))
						  .get();

		int cantidad = lista.size();

		int maximo = lista.stream()
						  .max((a, b) -> Integer.compare(a, b))
						  .get();

		System.out.println(
				nombre + " => max:" + maximo +
						" min:" + minimo +
						" cant:" + cantidad
		);

		System.out.println("  ¿" + maximo + " múltiplo de 2? " + multiploDeDos(maximo));
		System.out.println("  ¿" + minimo + " divisor de 2? " + divisorDeDos(minimo));
		System.out.println("  ¿Cantidad (" + cantidad + ") " + "es par? " + esPar(cantidad));
	}

	private static String multiploDeDos(Integer numero) { return numero % 2 == 0 ? "Sí" : "No"; }
	private static String divisorDeDos(Integer numero) { return 2 % numero == 0 ? "Sí" : "No"; }
	private static String esPar(Integer numero) {return numero % 2 == 0 ? "Sí" : "No"; }
}
