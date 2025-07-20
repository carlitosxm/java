package arraymio.servicios;

import java.util.ArrayList;

import arraymio.entidades.Estu;
import arraymio.entidades.Materia;

public class AdminEstu {

		public void agregarEstu(String nombre,ArrayList<Materia> materia) {
			Estu e=new Estu(nombre);
			e.setMaterias(materia);
			System.out.println(e);
		}
		public void promedio(Estu estu) {
			int promedio=0;
			int contador=0;
			for (int i=0; i<estu.getMaterias().size();i++) {
				promedio=estu.getMaterias().getNota();
				
			}
		}
}
