import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reto5 {
	
	public static void main(String[] args) {
		Set<Integer> hashSet = almacenarEnHashSet();
		Set<Integer> treeSet = almacenarEnTreeSet();
		Set<Integer> arena = unirSets(hashSet, treeSet);

		arena.forEach(n ->
				System.out.println("Numero en arena: " + n));
	}
	
	private static Set<Integer> almacenarEnHashSet() {

		Set<Integer> hashSet = new HashSet<>();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese la cantidad de datos a almacenar en el HashSet: ");
		int cantidad = scanner.nextInt();

		for (int i = 0; i < cantidad; i++) {

			System.out.print("Valor: ");
			Integer valor = scanner.nextInt();
			hashSet.add(valor);
		}

		return hashSet.stream()
				.filter(numero -> numero % 3 != 0)
				.collect(Collectors.toSet());
	}

	private static Set<Integer> almacenarEnTreeSet() {
		
		Set<Integer> treeSet = new TreeSet<>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Ingrese la cantidad de datos a almacenar en el TreeSet: ");
		int cantidad = scanner.nextInt();
		
		for (int i = 0; i < cantidad; i++) {
			
			System.out.print("Valor: ");
			Integer valor = Integer.valueOf(scanner.nextInt());
			treeSet.add(valor);
		}
		
		return treeSet.stream()
				      .filter(numero -> numero % 5 != 0)
				      .collect(Collectors.toCollection(TreeSet::new));
	}

	private static Set<Integer> unirSets (Set<Integer> hashSet,
										  Set<Integer> treeSet){
		return Stream.concat(hashSet.stream(),treeSet.stream())
				.collect(Collectors.toCollection(TreeSet::new));
	}

}