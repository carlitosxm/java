package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Estudiante;

public class TestEstudiante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estudiante e1=new Estudiante("Carlos");
		e1.calificar(7);
		System.out.println("Nombre: "+e1.getNota());
		System.out.println("Resultado: "+e1.getResultado());
		
	}

}
