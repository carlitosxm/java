package com.krakedev.entidades;

import java.util.ArrayList;

public class Naipe {
	private ArrayList<Numero> numerosPosibles;
	private ArrayList<Carta> cartas;
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	public Naipe () {
		numerosPosibles =new ArrayList<Numero>();
		cartas= new ArrayList<Carta>();
		numerosPosibles.add(new Numero("A", 11));
		numerosPosibles.add(new Numero("2", 2));
		numerosPosibles.add(new Numero("3", 3));
		numerosPosibles.add(new Numero("4", 4));
		numerosPosibles.add(new Numero("5", 5));
		numerosPosibles.add(new Numero("6", 6));
		numerosPosibles.add(new Numero("7", 7));
		numerosPosibles.add(new Numero("8", 8));
		numerosPosibles.add(new Numero("9", 9));
		numerosPosibles.add(new Numero("10", 10));
		numerosPosibles.add(new Numero("J", 12));
		numerosPosibles.add(new Numero("Q", 13));
		numerosPosibles.add(new Numero("K", 14));
		ArrayList<String> palos = new ArrayList<>();
		palos.add("CR");
		palos.add("CN");
		palos.add("DI");
		palos.add("TR");
		for (Numero numero : numerosPosibles) {
            for (String palo : palos) {
                cartas.add(new Carta(numero.getValor(), palo));
            }
        }
	}
	
	public ArrayList<Carta> barajar(){
		ArrayList<Carta> auxiliar=new ArrayList<Carta>();
		for(int i=0;i<99;i++) {
			int posicion=Random.obtenerPosicion();
			if(cartas.get(posicion).getEstado().equals("N")) {
				auxiliar.add(cartas.get(posicion));
				cartas.get(posicion).setEstado("C");
			}
		}
		for(int j=0;j<cartas.size();j++) {
			if(cartas.get(j).getEstado().equals("N")) {
				auxiliar.add(cartas.get(j));
			}
		}
		return auxiliar;
	}
}
