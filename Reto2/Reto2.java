import java.util.List;

public class Reto2 {
	
	public static void main(String[] args) {

		List<Integer> lista1 = List.of(14, 3, 27, 8, 51, 6);
		List<Integer> lista2 = List.of(100, 45, 72, 13, 88);

		mostrarDatos(lista1, "Lista 1");
		mostrarDatos(lista2, "Lista 2");
	}

	public static void mostrarDatos(List<Integer> lista, String nombre) {

		int minimo = lista.stream()
						  .min((a,b) -> Integer.compare(a,b))
						  .get();

		long cantidad = lista.stream().count();
		
		int maximo = lista.stream()
						  .max((a, b) -> Integer.compare(a, b))
						  .get();

		System.out.println(
				nombre + " => max:" + maximo +
						" min:" + minimo +
						" cant:" + cantidad
		);

		System.out.println("  ¿" + maximo + " múltiplo de 2? " + multiploDeDos(maximo));
	}

	private static String multiploDeDos(Integer numero) { return numero % 2 == 0 ? "Sí" : "No"; }
}
