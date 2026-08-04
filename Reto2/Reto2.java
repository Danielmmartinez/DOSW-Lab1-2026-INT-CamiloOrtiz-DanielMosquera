import java.util.List;

public class Reto2 {
	
	public static void main(String[] args) {
		
		List<Integer> lista1 = List.of(14, 3, 27, 8, 51, 6);
		
		int maximo = lista1.stream()
						   .max((a, b) -> Integer.compare(a, b))
						   .get();
		
		System.out.println("Lista 1 => max:" + maximo);
	}
}
