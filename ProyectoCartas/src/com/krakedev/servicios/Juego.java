package com.krakedev.servicios;

import java.util.ArrayList;

import com.krakedev.entidades.Carta;
import com.krakedev.entidades.Naipe;

public class Juego {
	private Naipe naipe;
	private ArrayList<Carta> naipeBarajado;
	private ArrayList<ArrayList<Carta>> cartasJugador;
	
	public Juego() {
		Naipe n= new Naipe();
		this.naipeBarajado = this.naipe.barajar();
	}
	
	public Juego (ArrayList<String> jugadores) {
		this.naipe = new Naipe();
	    this.naipeBarajado = this.naipe.barajar();
	    this.cartasJugador = new ArrayList<>();

	    for (int i = 0; i < jugadores.size(); i++) {
	        ArrayList<Carta> mano = new ArrayList<>();
	        cartasJugador.add(mano);
	    }	
	}
	public Naipe getNaipe() {
		return naipe;
	}
	public void setNaipe(Naipe naipe) {
		this.naipe = naipe;
	}
	public ArrayList<ArrayList<Carta>> getCartasJugador() {
		return cartasJugador;
	}
	public void setCartasJugador(ArrayList<ArrayList<Carta>> cartasJugador) {
		this.cartasJugador = cartasJugador;
	}
	public void entregarCartas(int cartasPorJugador) {
		int numJugadores = cartasJugador.size();
	    int cartaActualIndex = 0; 
	    for (int i = 0; i < cartasPorJugador; i++) {
	        for (int j = 0; j < numJugadores; j++) {
	            if (cartaActualIndex < naipeBarajado.size()) {
	                Carta cartaADar = naipeBarajado.get(cartaActualIndex);
	                cartasJugador.get(j).add(cartaADar); 
	                cartaActualIndex++; 
	            } else {
	                System.out.println("Se acabaron las cartas en el mazo antes de completar el reparto.");
	                return;
	            }
	        }
	    }	
	}
	


	
	
	public int devolverTotal(int idJugador) {
		if (cartasJugador == null || idJugador < 0 || idJugador >= cartasJugador.size()) {
			System.out.println("ID de jugador inválido o manos no inicializadas.");
			return 0; 
		}

		ArrayList<Carta> manoDelJugador = cartasJugador.get(idJugador);
		int total = 0;

		if (manoDelJugador != null) {
			for (Carta carta : manoDelJugador) {
				total += obtenerValorCartaParaJuego(carta);
			}
		}
		return total;
	}


    public int determinarGanador() {
        if (cartasJugador == null || cartasJugador.isEmpty()) {
            System.out.println("No hay jugadores o cartas para determinar un ganador.");
            return -1; 
        }

        int idGanador = 0; 
        int sumaGanador = devolverTotal(0); 

        for (int i = 1; i < cartasJugador.size(); i++) {
            int sumaActual = devolverTotal(i);
            if (sumaActual > sumaGanador) {
                sumaGanador = sumaActual;
            }
        }

        return idGanador+1;
    }


	private int obtenerValorCartaParaJuego(Carta carta) {
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
}
