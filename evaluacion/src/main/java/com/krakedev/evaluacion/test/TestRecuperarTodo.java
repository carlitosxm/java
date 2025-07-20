package com.krakedev.evaluacion.test;

import java.util.ArrayList;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestRecuperarTodo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Categoria> c=ServiciosCategoria.recuperarTodo();
			System.out.println(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
