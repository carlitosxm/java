package com.krakedev.excepciones;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("inicio");
		String a = "dddd";
		try {
			a.substring(3);
			System.out.println("fin");
			System.out.println("abre la conexion bdd");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("entra al catch"+e);
		}finally {
			System.out.println("ingresa a finally");
			System.out.println("cierra la conexion bdd");
		}
		System.out.println("fuera del catch");
	}
}
