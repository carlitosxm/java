package com.krakedev.test;

import com.krakedev.entidades.Carta;
import com.krakedev.entidades.Jugadores;
import com.krakedev.servicios.Juego;

import java.util.ArrayList;

public class JuegoTest {

    public static int obtenerValorCartaParaJuego(Carta carta) {
        int numero = carta.getNumero();
        if (numero >= 2 && numero <= 10) {
            return numero;
        } else if (numero >= 11 && numero <= 13) { 
            return 10;
        } else if (numero == 1) { 
            return 11;
        }
        return 0; 
    }


    public static String determinarGanador(Juego juego, ArrayList<String> nombresJugadores) {
        if (juego == null || nombresJugadores == null || nombresJugadores.isEmpty()) {
            return "No hay suficiente información para determinar un ganador.";
        }

        ArrayList<ArrayList<Carta>> cartasJugador = juego.getCartasJugador();

        if (cartasJugador == null || cartasJugador.isEmpty()) {
            return "No se han repartido cartas o no hay jugadores.";
        }

        String nombreGanador = "Nadie";
        int puntuacionMaxima = -1; 

        for (int i = 0; i < nombresJugadores.size(); i++) {
            if (i >= cartasJugador.size()) {
                System.out.println("Advertencia: Menos manos de cartas que nombres de jugadores para " + nombresJugadores.get(i));
                continue;
            }

            ArrayList<Carta> manoDelJugador = cartasJugador.get(i);
            int totalValorMano = 0;
            if (manoDelJugador != null) {
                for (Carta carta : manoDelJugador) {
                    totalValorMano += obtenerValorCartaParaJuego(carta);
                }
            }
            System.out.println(nombresJugadores.get(i) + " tiene un total de: " + totalValorMano + " puntos.");

            if (totalValorMano > puntuacionMaxima) {
                puntuacionMaxima = totalValorMano;
                nombreGanador = nombresJugadores.get(i);
            } else if (totalValorMano == puntuacionMaxima) {
               
            }
        }
        return nombreGanador + " con " + puntuacionMaxima + " puntos.";
    }


    public static void main(String[] args) {
      
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Jugador Uno");
        nombresJugadores.add("Jugador Dos");
        nombresJugadores.add("Jugador Tres");

        Juego juego = new Juego(nombresJugadores);

        juego.entregarCartas(5);

        System.out.println("\n--- RESULTADOS DEL REPARTO ---");
       ArrayList<ArrayList<Carta>> manosDeJugadores = juego.getCartasJugador();
        for (int i = 0; i < nombresJugadores.size(); i++) {
            String nombreJugador = nombresJugadores.get(i);
            ArrayList<Carta> manoActual = manosDeJugadores.get(i);
            int totalMano = 0;

            System.out.println("\nCartas de " + nombreJugador + ":");
            for (Carta carta : manoActual) {
                carta.mostrarInformacion();
                totalMano += obtenerValorCartaParaJuego(carta);
            }
            System.out.println("Total de " + nombreJugador + ": " + totalMano + " puntos.");
        }

        String ganador = determinarGanador(juego, nombresJugadores);
        System.out.println("\n--- GANADOR ---");
        System.out.println("El ganador es: " + ganador);
    }
}