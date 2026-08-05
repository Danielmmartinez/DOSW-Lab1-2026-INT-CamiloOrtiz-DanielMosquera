public class Reto3 {
	
	public static void main(String[] args) {
		
	}
	
	private String descifrar(String mensaje) {
		
		StringBuffer mensajeDescifrado = new StringBuffer(mensaje);
		return mensajeDescifrado.reverse().toString();
	}
}