package com.krakedev.entidades;

public class Carta {
	private int numero;
	private String palo;
	private String estado="N";
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Carta(int numero, String palo) {

		this.numero = numero;
		this.palo = palo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		this.palo = palo;
	}
	public void mostrarInformacion() {
		System.out.println(numero+"-"+palo);
	}
}
