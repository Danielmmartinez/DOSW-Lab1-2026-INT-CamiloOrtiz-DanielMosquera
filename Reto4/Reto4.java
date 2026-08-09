import java.util.*;
import java.util.stream.Collectors;

public class Reto4 {
	
	public static void main(String[] args) {

		Map<String , Integer> hashMap = almacenarEnHashMap();
		Map<String , Integer> hashTable = almacenarEnHashtable();

		combinarMaps(hashMap, hashTable);

	}
	
	private static Map<String, Integer> almacenarEnHashMap() {
		Map<String , Integer> hashMap = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese la cantidad de datos a almacenar en el HashMap: ");
		int cantidad = scanner.nextInt();
		for (int i = 0; i < cantidad; i++) {
			System.out.print("\nClave: ");
			String clave = scanner.next();

			System.out.print("Valor: ");
			int valor = scanner.nextInt();
			hashMap.putIfAbsent(clave, valor);
		}
		System.out.println(hashMap.toString());
		return hashMap;
	}

	private static Map<String, Integer> almacenarEnHashtable() {
		
		Map<String, Integer> hashtable = new Hashtable<>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Ingrese la cantidad de datos a almacenar en el Hashtable: ");
		int cantidad = scanner.nextInt();
		
		for (int i = 0; i < cantidad; i++) {
			System.out.print("\nClave: ");
			String clave = scanner.next();
			
			System.out.print("Valor: ");
			Integer valor = Integer.valueOf(scanner.nextInt());
			hashtable.put(clave, valor);
		}

		System.out.println(hashtable.toString());
		return hashtable;
	}

	private static void combinarMaps(
			Map<String , Integer> hashMap,
			Map<String , Integer> hashTable){
		Map<String, Integer> combinado = new HashMap<>(hashMap);
		combinado.putAll(hashTable);

		Map<String , Integer> resultado = combinado.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(
						entry -> entry.getKey().toUpperCase(),
						entry -> entry.getValue(),
						(v1, v2) -> v2,
						() -> new LinkedHashMap<>()
				));
		resultado.forEach((clave, valor) ->
				System.out.println("Clave: " + clave + " | Valor: " + valor));
	}
}