import java.util.Scanner;

public class Reto6 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String comando = "a";
		while (comando != null) {
			System.out.print("Comando (ENTER para salir): ");
			comando = scanner.next();
			ejecutarComando(comando);
		}
	}
	
	private static void ejecutarComando(String comando) {
		
		switch (comando) {
			case "BROMEAR":
				System.out.println("¿Por qué la RAM rompió con la CPU? Porque necesitaba espacio...");
				break;
			case "GRITAR":
				System.out.println("AAAAAAAAAAAAAAAHH");
				break;
			case "SUSURRAR":
				System.out.println("Shhhh, es un secreto :v");
				break;
			case "ANALIZAR":
				System.out.println("Analizando datos... ¡Eres increíble!");
				break;
		}
	}
}