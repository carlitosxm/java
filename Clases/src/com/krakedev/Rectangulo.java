package com.krakedev;

public class Rectangulo {
	public int base;
	public int altura;
	
	public int calcularArea() {
		int area = base*altura; 
		return area;
	}
	public double calcularParametro() {
		double parametro=(base*2)+(altura*2);
		return parametro;
	}
}
