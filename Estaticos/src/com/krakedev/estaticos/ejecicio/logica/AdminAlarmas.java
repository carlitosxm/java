package com.krakedev.estaticos.ejecicio.logica;

import java.util.ArrayList;

import com.krakedev.estaticos.ejecicio.entidades.Alarma;

public class AdminAlarmas {
	private ArrayList<Alarma> alarmas;
	
	public AdminAlarmas() {
		alarmas = new ArrayList<Alarma>();
	}
	
	public void agregarAlarma(Alarma  alarma) {
		alarmas.add(alarma);
	}
	
	public ArrayList<Alarma> getAlarmas() {
		return alarmas;
	}

	public void setAlarmas(ArrayList<Alarma> alarma) {
		this.alarmas = alarma;
	}
	
}
