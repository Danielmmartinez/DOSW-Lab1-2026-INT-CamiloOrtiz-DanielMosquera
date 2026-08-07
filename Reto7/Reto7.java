package Reto7;

import java.util.List;
import java.util.stream.Collectors;

public class Reto7 {

    public static void main(String[] args) {

        List<Jugador> jugadores = List.of(new Jugador("Seong Gi-hun", 456, 160),
            new Jugador("Kang Sae-byeok", 067, 80),
            new Jugador("Cho Sang-woo", 218, 250));

        segundaPrueba(jugadores);
        
    }

    private static List<Jugador> segundaPrueba(List<Jugador> jugadores) {
        System.out.println("Prueba 2 - Los Dados:");

        List<Jugador> jugadoresActualizados = jugadores.stream()
            .map(jugador -> {
                if (Dado.tirar() % 2 == 0) {
                    jugador.setEstado("ELIMINADO");
                }
                return jugador;
            })
            .toList();

        ImprimirReto.imprimirJugadoresRonda(jugadoresActualizados);
        return jugadoresActualizados.stream().filter(jugador -> jugador.getEstado() == "ACTIVO").toList();
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
            .filter(jugador -> jugador.getEstado() == "ACTIVO")
            .map(jugador -> jugador.getNombre())
            .collect(Collectors.joining(", "));

        System.out.println(jugadoresActivos + " PASAN");
    }

    public static void imprimirJugadoresEliminadosRonda(List<Jugador> jugadores) {

        String eliminados = jugadores.stream()
            .filter(jugador -> jugador.getEstado() == "ELIMINADO")
            .map(jugador -> jugador.getNumero().toString())
            .collect(Collectors.joining(", "));

        System.out.println("jugador " + eliminados + " ELIMINADO");
    }
}