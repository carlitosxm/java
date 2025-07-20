package arraymio.servicios;

import java.util.ArrayList;

import arraymio.entidades.Materia;
import arraymio.entidades.Notas;

public class AdminMateria {
	public void agregarMateria(String materia, ArrayList<Notas> notass) {
		Materia m=new Materia(materia);
		m.setNotas(notass);
		System.out.println(m);
	}
	
	public ArrayList<Materia> retMateria(String materia, ArrayList<Notas> notass) {
		ArrayList<Materia> m=new ArrayList<Materia>();
		Materia ma=new Materia(materia, notass);
		m.add(ma);
		return m;
	}
}
