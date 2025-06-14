package com.krakedev;

public class Rectangulo {
	private int base;
	private int altura;
	
	public Rectangulo(int base, int altura) {
		this.altura=altura;
		this.base=base;
	}
	
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int calcularArea() {
		int area = base*altura; 
		return area;
	}
	public double calcularParametro() {
		double parametro=(base*2)+(altura*2);
		return parametro;
	}
}
