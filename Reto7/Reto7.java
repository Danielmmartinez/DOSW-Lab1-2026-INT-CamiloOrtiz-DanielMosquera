package Reto7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reto7 {

    public static void main(String[] args) {

        List<Jugador> jugadores = crearJugadores();

        List<Jugador> sobrevivientes1 = primeraPrueba(jugadores);
        List<Jugador> sobrevivientes2 = segundaPrueba(sobrevivientes1);
        List<Jugador> sobrevivientes3 = terceraPrueba(sobrevivientes2);

        mostrarResultadoFinal(
                jugadores,
                sobrevivientes1,
                sobrevivientes2,
                sobrevivientes3);
    }
    private static List<Jugador> crearJugadores() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Cantidad de jugadores: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        List<Jugador> jugadores = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {

            System.out.println("\nJugador #" + (i + 1));

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Numero: ");
            int numero = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Deuda: ");
            String deudaTexto = scanner.nextLine();

            int deuda = Integer.parseInt(
                    deudaTexto.replace("M", "")
            );

            jugadores.add(new Jugador(nombre, numero, deuda));
        }

        return jugadores;
    }
    private static void mostrarResultadoFinal(
            List<Jugador> jugadores,
            List<Jugador> sobrevivientes1,
            List<Jugador> sobrevivientes2,
            List<Jugador> sobrevivientes3) {

        long premio = calcularPremio(
                jugadores,
                sobrevivientes1,
                sobrevivientes2,
                sobrevivientes3);

        System.out.println("\n=== RESULTADO FINAL ===");

        if (sobrevivientes3.size() == 1) {

            Jugador ganador = sobrevivientes3.get(0);

            System.out.println("¡Jugador "
                    + ganador.getNumero()
                    + " Eres el Ganador!");

        } else if (!sobrevivientes3.isEmpty()) {

            System.out.println("¡Tenemos varios ganadores!");

            sobrevivientes3.forEach(jugador ->
                    System.out.println("Jugador "
                            + jugador.getNumero()
                            + " - "));

        } else {

            System.out.println("No hubo ganadores.");
        }

        System.out.println("Premio: "
                + String.format("%,d", premio)
                + " wones");
    }
    private static long calcularPremio(
            List<Jugador> jugadores,
            List<Jugador> sobrevivientes1,
            List<Jugador> sobrevivientes2,
            List<Jugador> sobrevivientes3) {

        long eliminados1 = jugadores.size() - sobrevivientes1.size();
        long eliminados2 = sobrevivientes1.size() - sobrevivientes2.size();
        long eliminados3 = sobrevivientes2.size() - sobrevivientes3.size();

        long premio =
                150000000000L
                        + eliminados1 * 50000000L
                        + eliminados2 * 50000000L
                        + eliminados3 * 100000000L;

        if (!sobrevivientes3.isEmpty()) {
            premio /= sobrevivientes3.size();
        }

        return premio;
    }





    private static List<Jugador> primeraPrueba(List<Jugador> jugadores) {

        System.out.println("Prueba 1 - Luz Roja Luz Verde:");

        List<Jugador> jugadoresActualizados = jugadores.stream()
                .map(jugador -> {

                    if (jugador.getDeuda() > 170) {
                        jugador.setEstado("ELIMINADO");
                    }

                    return jugador;
                })
                .collect(Collectors.toList());

        ImprimirReto.imprimirJugadoresRonda(jugadoresActualizados);

        return jugadoresActualizados.stream()
                .filter(jugador -> jugador.getEstado().equals("ACTIVO"))
                .collect(Collectors.toList());
    }

    private static List<Jugador> segundaPrueba(List<Jugador> jugadores) {
        System.out.println("Prueba 2 - Los Dados:");

        List<Jugador> jugadoresActualizados = jugadores.stream()
            .map(jugador -> {
                if (Dado.tirar() % 2 != 0) {
                    jugador.setEstado("ELIMINADO");
                }
                return jugador;
            })
            .toList();

        ImprimirReto.imprimirJugadoresRonda(jugadoresActualizados);
        return jugadoresActualizados.stream().filter(jugador -> jugador.getEstado().equals("ACTIVO")).toList();
    }
    private static List<Jugador> terceraPrueba(List<Jugador> jugadores) {

        System.out.println("Prueba 3 - Puente de Cristal:");

        List<Jugador> jugadoresActualizados = jugadores.stream()
                .map(jugador -> {

                    if (jugador.getNombre().length() < 5) {
                        jugador.setEstado("ELIMINADO");
                    }

                    return jugador;
                })
                .toList();

        ImprimirReto.imprimirJugadoresRonda(jugadoresActualizados);

        return jugadoresActualizados.stream()
                .filter(jugador -> jugador.getEstado().equals("ACTIVO"))
                .toList();
    }
}

class Jugador {

    private String nombre;
    private String estado;
    private Integer numero;
    private Integer deuda;
    private Integer premio;

    public Jugador(String nombre, Integer numero, Integer deuda) {
        this.nombre = nombre;
        this.numero = numero;
        this.deuda = deuda;
        this.estado = "ACTIVO";
        this.premio = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getDeuda(){return deuda;}
    
}

class Dado {

    public static int tirar() {
        return 1 + (int) (Math.random() * 6);
    }
}

class ImprimirReto {

    public static void imprimirJugadoresRonda(List<Jugador> jugadores) {
        imprimirJugadoresActivos(jugadores);
        imprimirJugadoresEliminadosRonda(jugadores);
    }

    public static void imprimirJugadoresActivos(List<Jugador> jugadores) {

        String jugadoresActivos = jugadores.stream()
            .filter(jugador -> jugador.getEstado().equals("ACTIVO"))
            .map(jugador -> jugador.getNombre())
            .collect(Collectors.joining(", "));

        System.out.println(jugadoresActivos + " PASAN");
    }

    public static void imprimirJugadoresEliminadosRonda(List<Jugador> jugadores) {

        String eliminados = jugadores.stream()
            .filter(jugador -> jugador.getEstado().equals("ELIMINADO"))
            .map(jugador -> jugador.getNumero().toString())
            .collect(Collectors.joining(", "));

        System.out.println("jugador " + eliminados + " ELIMINADO");
    }
}