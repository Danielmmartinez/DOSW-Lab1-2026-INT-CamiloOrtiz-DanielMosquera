import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Reto5 {
	
	public static void main(String[] args) {
		System.out.println(almacenarEnTreeSet().toString());
		System.out.println(almacenarEnHashSet().toString());
		
	}
	
	private static Set<Integer> almacenarEnHashSet() {
		// TODO Auto-generated method stub
		return null;
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

}