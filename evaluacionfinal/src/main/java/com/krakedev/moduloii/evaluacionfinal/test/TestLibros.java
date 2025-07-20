package com.krakedev.moduloii.evaluacionfinal.test;

import java.util.ArrayList;

import com.krakedev.moduloii.evaluacionfinal.entidades.Libro;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosLibros;

public class TestLibros {
	public static void main(String[] args) {
		try {
			ArrayList<Libro> libros= ServiciosLibros.recuperarTodo();
			System.out.println(libros);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
