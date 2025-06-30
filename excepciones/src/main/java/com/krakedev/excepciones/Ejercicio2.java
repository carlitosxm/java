package com.krakedev.excepciones;

import java.io.File;
import java.io.IOException;
import java.io.IOException;

public class Ejercicio2 {

		// TODO Auto-generated method stub
		public void metodo1() {
			String a=null;
			a.substring(0);
			///NPE UNCHEKED
		}
		
		public void metodo2() {
			File f=new File("archivo1.txt");
			try {
				f.createNewFile();///IOException CHEKED	
			} catch (IOException io) {
				// TODO: handle exception
				System.out.println("error");
			}
			
		}
		
		public void metodo3() throws IOException{
			File f=new File("archivo1.txt");
			f.createNewFile();///IOEXECTION CHEKED
			
		}
		
		public void metodo4() {
			//metodo3();
		}

}
