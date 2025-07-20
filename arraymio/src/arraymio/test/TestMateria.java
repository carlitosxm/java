package arraymio.test;

import java.util.ArrayList;

import arraymio.entidades.Materia;
import arraymio.entidades.Notas;
import arraymio.servicios.AdminEstu;
import arraymio.servicios.AdminMateria;

public class TestMateria {
	public static void main(String[] args) {
		AdminMateria am=new AdminMateria();
		
		ArrayList<Notas> notass=new ArrayList<Notas>();
		notass.add(new Notas(1, 10));
		notass.add(new Notas(2, 10));
		notass.add(new Notas(3, 10));
		
		am.agregarMateria("Mate", notass);
		ArrayList<Notas> notass2=new ArrayList<Notas>();
		notass2.add(new Notas(1, 10));
		notass2.add(new Notas(2, 10));
		notass2.add(new Notas(3, 10));
		
		am.agregarMateria("Sociales", notass2);
		
		
		ArrayList<Materia> mat=am.retMateria("Sociales", notass2);
		AdminEstu ae=new AdminEstu();
		ae.agregarEstu("Carlos", mat);
	}
}
