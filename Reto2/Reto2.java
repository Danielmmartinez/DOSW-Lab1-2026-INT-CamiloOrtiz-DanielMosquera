import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reto2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Lista 1:");
		List<Integer> listaProcesada = leerDatos(scanner);

		System.out.println("Lista 2:");
		List<Integer> listaProcesada2 = leerDatos(scanner);

		Resultado resultado1 = procesarLista(listaProcesada);
		Resultado resultado2 = procesarLista(listaProcesada2);

		System.out.println("Lista 1 =>");
		System.out.println(resultado1);

		System.out.println("Lista 1 =>");
		System.out.println(resultado2);
	}

static class Resultado{
		private int maximo;
		private int minimo;
		private int cantidad;
		private boolean multiploDeDos;
		private boolean divisorDeDos;
		private boolean esPar;

		public Resultado(int maximo, int minimo, int cantidad, boolean multiploDeDos,
						 boolean divisorDeDos, boolean esPar) {
			this.maximo = maximo;
			this.minimo = minimo;
			this.cantidad = cantidad;
			this.multiploDeDos = multiploDeDos;
			this.divisorDeDos = divisorDeDos;
			this.esPar = esPar;
		}
	public String toString() {
		return "max:" + maximo +
		" min:" + minimo +
		" cant:" + cantidad +
		"\n¿" + maximo + " múltiplo de 2? " + (multiploDeDos ? "Sí" : "No") +
		"\n¿" + maximo + " divisor de 2? " + (divisorDeDos ? "Sí" : "No") +
		"\n¿Cantidad (" + cantidad + ") es par? " + (esPar ? "Sí" : "No");
	}
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

	public static Resultado procesarLista(List<Integer> lista) {

		int minimo = lista.stream()
						  .min((a,b) -> Integer.compare(a,b))
						  .get();

		int cantidad = lista.size();

		int maximo = lista.stream()
						  .max((a, b) -> Integer.compare(a, b))
						  .get();
		return new Resultado(
				maximo,
				minimo,
				cantidad,
				maximo % 2 == 0,
				2 % maximo == 0,
				cantidad % 2 == 0
		);


	}

}
