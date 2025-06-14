package com.krakedev.test;

import com.krakedev.Mensajeria;

public class TestMensaje {
	public static void main(String[] args) {
		Mensajeria m=new Mensajeria();
		m.saludar();
		m.saludarAmigo("Pepe", "Chavez");
	}
}
