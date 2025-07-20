package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.utils.ConexionBDD;

public class TestConexionBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ConexionBDD.conectar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
