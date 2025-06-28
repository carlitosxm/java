package com.krakedev.estaticos;

public class Calculos {
	// final genera constantes conviente variable en constantes
	private final double IVA=12;
	
	public double calculoIva(double monto) {
		return monto*IVA/100;
	}
}
