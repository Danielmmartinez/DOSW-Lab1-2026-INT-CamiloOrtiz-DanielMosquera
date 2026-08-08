import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reto6 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String comando = "a";

		Map<String, Runnable> comandos = new HashMap<>();

		comandos.put("SALUDAR", () -> System.out.println("¡Saludos, viajero del Tiempo y del código! "));
		comandos.put("DESPEDIR", () -> System.out.println("Hasta la próxima compilación, viajero."));
		comandos.put("CANTAR", () -> System.out.println("La la la... compilando melodías en tiempo real. "));
		comandos.put("DANZAR", () -> System.out.println("Girando en modo fiesta. "));
		comandos.put("BROMEAR", () -> System.out.println("¿Por qué la RAM rompió con la CPU? Porque necesitaba espacio..."));
		comandos.put("GRITAR", () -> System.out.println("AAAAAAAAAAAAAAAHH"));
		comandos.put("SUSURRAR", () -> System.out.println("Shhhh, es un secreto :v"));
		comandos.put("ANALIZAR", () -> System.out.println("Analizando datos... ¡Eres increíble!"));

		while (comando != null) {
			System.out.print("Comando (ENTER para salir): ");
			comando = scanner.next();
			ejecutarComando(comando, comandos);
		}
	}
	
	private static void ejecutarComando(String comando, Map<String, Runnable> comandos) {
		
		if (comandos.get(comando) != null) {
			comandos.get(comando).run();
		}
	}
}