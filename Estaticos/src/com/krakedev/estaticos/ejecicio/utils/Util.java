package com.krakedev.estaticos.ejecicio.utils;

public class Util {
	public static String formatoHora(int numero) {
		String valor = numero + "";
		if (valor.length() == 1) {
			valor = "0" + numero;
		}
		return valor;
	}
	public static String formatoDia(int dia) {
		switch (dia) {
		case 0: {
			return "Lunes";
		}
		case 1: {
			return "Martes";
		}
		case 2: {
			return "Miercoles";
		}
		case 3: {
			return "Jueves";
		}
		case 4: {
			return "Viernes";
		}
		case 5: {
			return "Sabado";
		}
		case 6: {
			return "Domingo";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + dia);
		}
	}
}
