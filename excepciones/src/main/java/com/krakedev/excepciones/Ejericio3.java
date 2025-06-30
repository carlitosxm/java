package com.krakedev.excepciones;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ejericio3 {
	private static final Logger LOGGER =LogManager.getLogger(Ejericio3.class);
	
	public void metodo1() {
		String a =null;
		try {
			a.substring(0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			LOGGER.error("error al obtener subcadena",e);
		}
	}
	public static void main(String[] args) {
		Ejericio3 ej3=new Ejericio3();
		ej3.metodo1();
	}
}
