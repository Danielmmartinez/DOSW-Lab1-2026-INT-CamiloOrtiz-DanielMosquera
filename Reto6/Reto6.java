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
			case "SALUDAR":
				System.out.println("¡Saludos, viajero del Tiempo y del código! ");
				break;
			case "DESPEDIR":
				System.out.println("Hasta la próxima compilación, viajero.");
				break;
			case "CANTAR":
				System.out.println("La la la... compilando melodías en tiempo real. ");
				break;
			case "DANZAR":
				System.out.println("Girando en modo fiesta. ");
				break;
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