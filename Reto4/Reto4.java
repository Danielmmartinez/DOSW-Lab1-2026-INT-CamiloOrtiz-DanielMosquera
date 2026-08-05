import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Reto4 {
	
	public static void main(String[] args) {
		almacenarEnHashtable();
		almacenarEnHashMap();
	}
	
	private static Map<String, Integer> almacenarEnHashMap() {
		// TODO Auto-generated method stub
		return null;
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
}