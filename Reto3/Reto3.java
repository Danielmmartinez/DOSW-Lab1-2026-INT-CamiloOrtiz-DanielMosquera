import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Reto3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mensaje interceptado: ");
		String mensaje = amplificador(scanner);
		descifrar(mensaje);

		
	}
	public static String amplificador(Scanner scanner){
		String mensaje = scanner.nextLine();
		StringBuilder mensajeAmplificado = new StringBuilder();
		Collections.nCopies(3, mensaje)
				.stream()
				.forEach(palabra ->
						mensajeAmplificado.append(palabra).append(" "));
		String amplificado = mensajeAmplificado.toString().trim();
		System.out.println("Canal A: " + amplificado);
		return amplificado;
	}
	
	private static void descifrar(String mensaje) {
		
		StringBuffer mensajeDescifrado = new StringBuffer(mensaje);
		System.out.println("\nDescifrado final:\n" +
				mensajeDescifrado.reverse().toString());
	}
}