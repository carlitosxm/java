package arraymio.entidades;

import java.util.ArrayList;

public class Materia {
	private String materia;
	private ArrayList<Notas> notass;
	public Materia(String materia) {
		super();
		this.materia = materia;
		this.notass= new ArrayList<Notas>();
	}
	public Materia(String materia,ArrayList<Notas> notass) {
		super();
		this.materia = materia;
		this.notass= notass;
	}
	public ArrayList<Notas> getNotas() {
		return notass;
	}
	public void setNotas(ArrayList<Notas> notas) {
		this.notass = notas;
	}
	public String getMateria() {
		return materia;
	}
	@Override
	public String toString() {
		return "Materia [materia=" + materia + ", notass=" + notass + "]";
	}
	
}
